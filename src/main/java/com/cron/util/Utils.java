package com.cron.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
  private static final String ESTERICS = "*";

  /**
   * Checks whether the given expression endsWith comma
   *
   * @param str
   * @return
   */
  public static boolean isEndingWithComma(String str) {
    return str != null && str.endsWith(",");
  }

  /**
   * Checks if the given expression is just ESTERICS string
   *
   * @param str
   * @return
   */
  public static boolean isEstericsString(String str) {
    return ESTERICS.equals(str);
  }

  /**
   * Sanitizes the given expression by removing extra whitespace characters
   */
  public static String sanitize(String str) {
    return str.replaceAll("\\s+", " ");
  }

  public static List<TimeUnit> getAllTimeUnits() {
    List<TimeUnit> units = new ArrayList<>();
    units.add(TimeUnit.MINUTE);
    units.add(TimeUnit.HOUR);
    units.add(TimeUnit.DAY_OF_MONTH);
    units.add(TimeUnit.MONTH);
    units.add(TimeUnit.DAY_OF_WEEK);
    return units;
  }

  public static void displaySchedule(Map<TimeUnit, List<Integer>> schedule, String command) {
    List<TimeUnit> units = getAllTimeUnits();
    for (TimeUnit unit : units) {
      System.out.print(unit.toString() + "\t");
      schedule.get(unit).stream().forEach(t -> System.out.print(t + " "));
      System.out.println();
    }
    System.out.println("command\t" + command);
  }
}