package com.cron.util;

import com.cron.time.Time;
import com.cron.time.TimeFactory;

import java.util.List;

public class TestUtils {
  public static List<Integer> getResult(TimeUnit unit, String expression) {
    Time time = TimeFactory.getInstance(unit, expression);
    time.parse();
    return time.getResult();
  }
}
