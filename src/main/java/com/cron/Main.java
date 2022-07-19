package com.cron;

import com.cron.helper.ParsingHelper;
import com.cron.parser.CronParser;
import com.cron.util.TimeUnit;
import com.cron.util.Utils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    if (args == null || args.length != 1) {
      System.out.println("You must provide a single argument");
    }
    ParsingHelper.getSchedule(args);
  }
}