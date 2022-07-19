package com.cron.time;

import com.cron.util.TimeUnit;
import com.cron.util.Utils;
import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Abstract class for the all Time units that can be used in Cron Parser arguments.
 */
@Setter
@Getter
public class Time {
  // Denotes the minimum value it is allowed to have in the final result
  int minRangeValue;
  // Denotes the maximum value it is allowed to have in the final result
  int maxRangeValue;

  // Sanitized version of the expression input for this time unit
  String expression;

  TimeUnit type;
  // Maps the final result for this time unit
  List<Integer> result;

  public Time(String expression) {
    this.expression = Utils.sanitize(expression);
    result = new ArrayList<>();
  }

  public void parse() throws IllegalArgumentException, NullPointerException {
    Preconditions.checkNotNull(this.expression, "Expression cannot be null for time unit" + this.type);
    if (this.expression.contains("/")) { // For Expression like "*/3" or 2/4
      getValuesWithSlashes();
    } else if (this.expression.contains("-")) {
      getRangeValues();
    } else if (this.expression.contains(",")) {
      getValuesWithCommas();
    } else if (this.expression.equals("*")) {
      getAllValues();
    } else if (this.expression.equals("EMPTY")) {
      handleQuestionRange();
    } else {
      getPlaneValues();
    }
  }


  public void getPlaneValues() {
    int value;
    try {
      value = Integer.valueOf(this.expression);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid number for time " + this.type + ": " + this.expression, e); //
    }
    if (value < this.minRangeValue || value > this.maxRangeValue) {
      throw new IllegalArgumentException("Invalid number for time " + this.type + ": " + this.expression);
    }
    result.add(value);
  }
  public void getRangeValues() throws IllegalArgumentException {
    String[] range = this.expression.split("-");
    int startRangeValue;
    int endRangeValue;
    try {
      startRangeValue = Integer.parseInt(range[0]);
      endRangeValue = Integer.parseInt(range[1]);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Could not parse range value for time unit " + this.type);
    }
    if (startRangeValue < 0 || endRangeValue > this.maxRangeValue) {
      throw new IllegalArgumentException("Invalid range value for time unit " + this.type);
    }
    if (startRangeValue > endRangeValue) {
      throw new IllegalArgumentException("Invalid reverse  range value for time unit " + this.type + ": " + this.expression);
    }
    result = IntStream.rangeClosed(startRangeValue, endRangeValue).boxed().collect(Collectors.toList());
  }


  public void getAllValues() {
    result = IntStream.rangeClosed(this.minRangeValue, this.maxRangeValue).boxed().collect(Collectors.toList());
  }

  public void handleQuestionRange() {
    result = new ArrayList<>();
  }
  public void getValuesWithCommas() throws IllegalArgumentException {
    String[] values = this.expression.split(",");
    try {
      result = Arrays.stream(values).map(Integer::valueOf).collect(Collectors.toList());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Could not parse individual value for time unit " + this.type);
    }
  }

  public void getValuesWithSlashes() {
    String[] values = this.expression.split("/");
    try {
      int start = values[0].equals("*") ? 0 : Integer.valueOf(values[0]);
      int skip = Integer.valueOf(values[1]);
      if (skip <= 0) {
        throw new IllegalArgumentException("Step value cannot be zero or negative");
      }
      for (int i = start; i <= this.maxRangeValue; i += skip) {
        result.add(i);
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Could not parse value for time unit " + this.type);
    }
  }
}
