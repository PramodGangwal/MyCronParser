package com.cron.parser;

import com.cron.time.Time;
import com.cron.time.TimeFactory;
import com.cron.util.TimeUnit;
import com.cron.util.Utils;
import com.google.common.base.Preconditions;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Parser class for the cron job argument that maps individual arguments to corresponding Time units.
 */
@NoArgsConstructor
public class CronParser {

  private static final String SPACE = " ";
  private static final int ARGS_LENGTH = 5;

  public Map<TimeUnit, List<Integer>> getParsedArguments(final String expression) throws IllegalArgumentException {
    Preconditions.checkNotNull(expression ,"Cron time argument cannot be null");
    Preconditions.checkArgument(expression.length() > 0, "Cron time argument cannot be empty");

    String sanitizedExpression = Utils.sanitize(expression);
    Map<TimeUnit, List<Integer>> parsedArguments = new HashMap<>();

    String[] args = sanitizedExpression.split(SPACE);
    if (args.length != ARGS_LENGTH) {
      throw new IllegalArgumentException("Time units should be equals to " + ARGS_LENGTH);
    }
    List<TimeUnit> units = Utils.getAllTimeUnits();
    List<Time> timeJobs = new ArrayList<>();
    for (int i = 0; i < units.size(); i++) {
      timeJobs.add(TimeFactory.getInstance(units.get(i), args[i]));
    }
    try {
      timeJobs.forEach(t -> {t.parse(); parsedArguments.put(t.getType(), t.getResult());});
    } catch (IllegalArgumentException e) {
      throw e;
    }
    return parsedArguments;
  }
}
