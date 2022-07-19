package com.cron.time;

import com.cron.util.TestUtils;
import com.cron.util.TimeUnit;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MinuteTest {

  @Test
  public void testMinutesForEsterics() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE,"*");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(60, minutes.size());
    Assert.assertTrue(minutes.get(0) == 0);
    Assert.assertTrue(minutes.get(minutes.size() - 1) == 59);
  }

  @Test
  public void testMinutesForRangeValues() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE,"3-15");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(13, minutes.size());
    Assert.assertTrue(minutes.get(0) == 3);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMinutesForReverseRangeValues() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE,"15-3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMinutesForOutOfBoundRange() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE,"10-100");
  }

  @Test
  public void testMinutesForNumericValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE,"10");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(1, minutes.size());
    Assert.assertTrue(minutes.get(0) == 10);
  }

  @Test
  public void testMinutesForSingleNumericValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE,"4");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(1, minutes.size());
    Assert.assertTrue(minutes.get(0) == 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMinutesForInvalidValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE,"65");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMinutesForInvalidValue_2() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE,"-2");
  }

  @Test
  public void testMinutesForSlashedValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE, "*/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(20, minutes.size());
    Assert.assertTrue(minutes.get(0) == 0);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 57);
  }

  @Test
  public void testMinutesForSlashedValue_2() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE, "50/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(4, minutes.size());
    Assert.assertTrue(minutes.get(0) == 50);
    Assert.assertTrue(minutes.get(minutes.size()-1) == 59);
  }

  @Test
  public void testMinutesForSlashedValue_3() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE, "60/3");
    Assert.assertNotNull(minutes);
    Assert.assertEquals(0, minutes.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMinutesForInvalidSkipValue() {
    List<Integer> minutes = TestUtils.getResult(TimeUnit.MINUTE, "*/0");
  }
}
