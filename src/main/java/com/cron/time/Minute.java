package com.cron.time;

import com.cron.util.TimeUnit;

public class Minute extends Time {

  public Minute(String expression) {
    super(expression);
    setMinRangeValue(0);
    setMaxRangeValue(59);
    setType(TimeUnit.MINUTE);
  }
}
