package com.cron.time;


import com.cron.util.TimeUnit;

public class Hour extends Time {
  public Hour(String expression) {
    super(expression);
    setMinRangeValue(0);
    setMaxRangeValue(23);
    setType(TimeUnit.HOUR);
  }
}
