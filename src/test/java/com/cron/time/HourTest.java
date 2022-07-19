package com.cron.time;

import com.cron.util.TestUtils;
import com.cron.util.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HourTest {
  @org.junit.Test
  public void testHoursForEsterics() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR,"*");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(24, minutes.size());
    Assert.assertTrue(minutes.get(0) == 0);
    Assert.assertTrue(minutes.get(minutes.size() - 1) == 23);
  }

  @org.junit.Test
  public void testHoursForRangeValues() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR,"3-15");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(13, minutes.size());
    Assert.assertTrue(minutes.get(0) == 3);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 15);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testHoursForReverseRangeValues() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR,"15-3");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testHoursForOutOfBoundRange() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR,"10-100");
  }

  @org.junit.Test
  public void testHoursForNumericValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR,"10");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(1, minutes.size());
    Assert.assertTrue(minutes.get(0) == 10);
  }

  @org.junit.Test
  public void testHoursForSingleNumericValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR,"4");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(1, minutes.size());
    Assert.assertTrue(minutes.get(0) == 4);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testHoursForInvalidValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR,"24");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testHoursForInvalidValue_2() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR,"-2");
  }

  @org.junit.Test
  public void testHoursForSlashedValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR, "*/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(8, minutes.size());
    Assert.assertTrue(minutes.get(0) == 0);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 21);
  }

  @org.junit.Test
  public void testHoursForSlashedValue_2() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR, "20/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(2, minutes.size());
    Assert.assertTrue(minutes.get(0) == 20);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 23);
  }

  @org.junit.Test
  public void testHoursForSlashedValue_3() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR, "60/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(0, minutes.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testHoursForInvalidSkipValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.HOUR, "*/0");
  }
}
