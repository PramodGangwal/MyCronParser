package com.cron.time;

import com.cron.util.TestUtils;
import com.cron.util.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DayOfWeekTest {
  @Test
  public void testWeeksForEsterics() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK,"*");
    Assert.assertNotNull(weeks);
    Assert.assertEquals(7, weeks.size());
    Assert.assertTrue(weeks.get(0) == 0);
    Assert.assertTrue(weeks.get(weeks.size() - 1) == 6);
  }

  @Test
  public void testWeeksForRangeValues() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK,"2-6");
    Assert.assertNotNull(weeks);
    Assert.assertEquals(5, weeks.size());
    Assert.assertTrue(weeks.get(0) == 2);
    Assert.assertTrue(weeks.get(weeks.size()-1) == 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWeeksForReverseRangeValues() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK,"15-3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWeeksForOutOfBoundRange() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK,"10-100");
  }

  @Test
  public void testWeeksForSingleNumericValue() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK,"4");
    Assert.assertNotNull(weeks);
    Assert.assertEquals(1, weeks.size());
    Assert.assertTrue(weeks.get(0) == 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWeeksForInvalidValue() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK,"65");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWeeksForInvalidValue_2() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK,"-2");
  }

  @Test
  public void testWeeksForSlashedValue() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK, "*/3");
    Assert.assertNotNull(weeks);
    Assert.assertEquals(3, weeks.size());
    Assert.assertTrue(weeks.get(0) == 0);
    Assert.assertTrue(weeks.get(weeks.size()-1) == 6);
  }

  @Test
  public void testWeeksForSlashedValue_2() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK, "1/3");
    Assert.assertNotNull(weeks);
    Assert.assertEquals(2, weeks.size());
    Assert.assertTrue(weeks.get(0) == 1);
    Assert.assertTrue(weeks.get(weeks.size()-1) == 4);
  }

  @Test
  public void testWeeksForSlashedValue_3() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK, "60/3");
    Assert.assertNotNull(weeks);
    Assert.assertEquals(0, weeks.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWeeksForInvalidSkipValue() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK, "*/0");
  }

  @Test
  public void testWeeksForStringValue() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK, "SUN-SAT");
    Assert.assertEquals(7, weeks.size());
    Assert.assertTrue(weeks.get(0) == 0);
    Assert.assertTrue(weeks.get(weeks.size()-1) == 6);
  }

  @Test
  public void testWeeksForStringValue_2() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK, "TUE-FRI");
    Assert.assertEquals(4, weeks.size());
    Assert.assertTrue(weeks.get(0) == 2);
    Assert.assertTrue(weeks.get(weeks.size()-1) == 5);
  }

  @Test
  public void testWeeksForStringValuewithComma() {
    List<Integer> weeks = TestUtils.getResult(TimeUnit.DAY_OF_WEEK, "MON,WED,FRI");
    Assert.assertNotNull(weeks);
    Assert.assertEquals(3, weeks.size());
    Assert.assertTrue(weeks.get(0) == 1);
    Assert.assertTrue(weeks.get(weeks.size()-1) == 5);
  }
}
