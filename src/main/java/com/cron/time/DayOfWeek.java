package com.cron.time;

import com.cron.util.TimeUnit;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DayOfWeek extends Time {
  private static Map<String, String> months;

  static {
    months = new HashMap<>();
    months.put("SUN", "0");
    months.put("MON", "1");
    months.put("TUE", "2");
    months.put("WED", "3");
    months.put("THU", "4");
    months.put("FRI", "5");
    months.put("SAT", "6");
  }

  public DayOfWeek(String expression) {
    super(expression);
    setMinRangeValue(0);
    setMaxRangeValue(6);
    setType(TimeUnit.DAY_OF_WEEK);
    if (expression.equals("?")) {
      setExpression("EMPTY");
    } else {
      setExpression(numericExpression(expression));
    }
  }

  private String numericExpression(String text) {
    return months.keySet().stream().reduce(text, (str, toRem) -> str.replaceAll(toRem, months.get(toRem)));
  }
}