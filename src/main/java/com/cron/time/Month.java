package com.cron.time;

import com.cron.util.TimeUnit;

import java.util.HashMap;
import java.util.Map;

public class Month extends Time {
  private static Map<String, String> months;
  static {
    months = new HashMap<>();
    months.put("JAN", "1");
    months.put("FEB", "2");
    months.put("MAR", "3");
    months.put("APR", "4");
    months.put("MAY", "5");
    months.put("JUN", "6");
    months.put("JUL", "7");
    months.put("AUG", "8");
    months.put("SEP", "9");
    months.put("OCT", "10");
    months.put("NOV", "11");
    months.put("DEC", "12");
  }
  public Month(String expression) {
    super(expression);
    setMinRangeValue(1);
    setMaxRangeValue(12);
    setType(TimeUnit.MONTH);
    setExpression(numericExpression(expression));
  }

  private String numericExpression(String text) {
    return months.keySet().stream().reduce(text, (str, toRem) -> str.replaceAll(toRem, months.get(toRem)));
  }
}
