package com.cron.parser;

import com.cron.util.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CronParserTest {

  @Test
  public void testParserArguments() {
    String expression = "*/15 0 1,15 * 1-5";
    CronParser parser = new CronParser();
    Map<TimeUnit, List<Integer>> schedule = parser.getParsedArguments(expression);
    Assert.assertEquals(5, schedule.size());
    Assert.assertEquals(12, schedule.get(TimeUnit.MONTH).size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParserInvalidArguments() {
    String expression = "? * * * *";
    CronParser parser = new CronParser();
    Map<TimeUnit, List<Integer>> schedule = parser.getParsedArguments(expression);
  }

  @Test
  public void testParserArgumentsWithQuestionMark() {
    String expression = "* * * * ?";
    CronParser parser = new CronParser();
    Map<TimeUnit, List<Integer>> schedule = parser.getParsedArguments(expression);
    Assert.assertEquals(5, schedule.size());
    Assert.assertEquals(12, schedule.get(TimeUnit.MONTH).size());
    Assert.assertEquals(0, schedule.get(TimeUnit.DAY_OF_WEEK).size());
  }

  @Test
  public void testParserArgumentsWithQuestionMark_2() {
    String expression = "* * ? * *";
    CronParser parser = new CronParser();
    Map<TimeUnit, List<Integer>> schedule = parser.getParsedArguments(expression);
    Assert.assertEquals(5, schedule.size());
    Assert.assertEquals(7, schedule.get(TimeUnit.DAY_OF_WEEK).size());
    Assert.assertEquals(0, schedule.get(TimeUnit.DAY_OF_MONTH).size());
  }

}
