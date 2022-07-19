package com.cron.time;

import com.cron.util.TimeUnit;

/**
 * Factory class for creation of all Time Unit instances.
 */
public class TimeFactory {
  public static Time getInstance(final TimeUnit unit, final String expression) {
    Time time = null;
    switch (unit) {
      case MINUTE:
        time = new Minute(expression);
        break;
      case HOUR:
        time = new Hour(expression);
        break;
      case DAY_OF_MONTH:
        time = new DayOfMonth(expression);
        break;
      case MONTH:
        time = new Month(expression);
        break;
      case DAY_OF_WEEK:
        time = new DayOfWeek(expression);
        break;
    }
    return time;
  }
}
