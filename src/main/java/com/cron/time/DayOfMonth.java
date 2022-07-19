package com.cron.time;

import com.cron.util.TimeUnit;

public class DayOfMonth extends Time {
  public DayOfMonth(String expression) {
    super(expression);
    setMinRangeValue(1);
    setMaxRangeValue(31);
    setType(TimeUnit.DAY_OF_MONTH);
    if (expression.equals("?")) {
      setExpression("EMPTY");
    }
  }
}
