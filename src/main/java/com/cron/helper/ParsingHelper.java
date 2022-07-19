package com.cron.helper;

import com.cron.parser.CronParser;
import com.cron.util.TimeUnit;
import com.cron.util.Utils;

import java.util.List;
import java.util.Map;

public class ParsingHelper {
  public static void getSchedule(String[] args) {
    String argument = Utils.sanitize(args[0]);
    String command = argument.substring(argument.lastIndexOf(" ")+1);
    String expression = argument.substring(0,argument.lastIndexOf(" "));
    CronParser parser = new CronParser();
    Map<TimeUnit, List<Integer>> schedule = parser.getParsedArguments(expression);
    Utils.displaySchedule(schedule, command);
  }
}
