package com.cron.time;

import com.cron.util.TestUtils;
import com.cron.util.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DayOfMonthTest {
  @Test
  public void testDaysForEsterics() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH,"*");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(31, minutes.size());
    Assert.assertTrue(minutes.get(0) == 1);
    Assert.assertTrue(minutes.get(minutes.size() - 1) == 31);
  }

  @Test
  public void testDaysForRangeValues() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH,"3-15");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(13, minutes.size());
    Assert.assertTrue(minutes.get(0) == 3);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDaysForReverseRangeValues() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH,"15-3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDaysForOutOfBoundRange() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH,"10-100");
  }

  @Test
  public void testDaysForNumericValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH,"10");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(1, minutes.size());
    Assert.assertTrue(minutes.get(0) == 10);
  }

  @Test
  public void testDaysForSingleNumericValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH,"4");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(1, minutes.size());
    Assert.assertTrue(minutes.get(0) == 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDaysForInvalidValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH,"65");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDaysForInvalidValue_2() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH,"-2");
  }

  @Test
  public void testDaysForSlashedValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH, "*/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(11, minutes.size());
    Assert.assertTrue(minutes.get(0) == 0);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 30);
  }

  @Test
  public void testDaysForSlashedValue_2() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH, "20/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(4, minutes.size());
    Assert.assertTrue(minutes.get(0) == 20);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 29);
  }

  @Test
  public void testDaysForSlashedValue_3() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH, "60/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(0, minutes.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDaysForInvalidSkipValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.DAY_OF_MONTH, "*/0");
  }

}
