package com.cron.time;

import com.cron.util.TestUtils;
import com.cron.util.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MonthTest {
  @Test
  public void testMonthsForEsterics() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH,"*");
    Assert.assertNotNull(months);
    Assert.assertEquals(12, months.size());
    Assert.assertTrue(months.get(0) == 1);
    Assert.assertTrue(months.get(months.size() - 1) == 12);
  }

  @Test
  public void testMonthsForRangeValues() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH,"3-10");
    Assert.assertNotNull(months);
    Assert.assertEquals(8, months.size());
    Assert.assertTrue(months.get(0) == 3);
    Assert.assertTrue(months.get(months.size()-1) == 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMonthsForReverseRangeValues() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH,"15-3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMonthsForOutOfBoundRange() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH,"10-100");
  }

  @Test
  public void testMonthsForNumericValue() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH,"10");
    Assert.assertNotNull(months);
    Assert.assertEquals(1, months.size());
    Assert.assertTrue(months.get(0) == 10);
  }

  @Test
  public void testMonthsForSingleNumericValue() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH,"4");
    Assert.assertNotNull(months);
    Assert.assertEquals(1, months.size());
    Assert.assertTrue(months.get(0) == 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMonthsForInvalidValue() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH,"65");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMonthsForInvalidValue_2() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH,"-2");
  }

  @Test
  public void testMonthsForSlashedValue() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH, "*/3");
    Assert.assertNotNull(months);
    Assert.assertEquals(5, months.size());
    Assert.assertTrue(months.get(0) == 0);
    Assert.assertTrue(months.get(months.size()-1) == 12);
  }

  @Test
  public void testMonthsForSlashedValue_2() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH, "4/4");
    Assert.assertNotNull(months);
    Assert.assertEquals(3, months.size());
    Assert.assertTrue(months.get(0) == 4);
    Assert.assertTrue(months.get(months.size()-1) == 12);
  }

  @Test
  public void testMonthsForSlashedValue_3() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH, "60/3");
    Assert.assertNotNull(months);
    Assert.assertEquals(0, months.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMonthsForInvalidSkipValue() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH, "*/0");
  }


  @Test
  public void testMonthsForStringExpressions() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH, "JAN-DEC");
    Assert.assertNotNull(months);
    Assert.assertEquals(12, months.size());
    Assert.assertTrue(months.get(0) == 1);
    Assert.assertTrue(months.get(months.size()-1) == 12);
  }

  @Test
  public void testMonthsForStringExpressions_2() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH, "MAR-APR");
    Assert.assertNotNull(months);
    Assert.assertEquals(2, months.size());
    Assert.assertTrue(months.get(0) == 3);
    Assert.assertTrue(months.get(months.size()-1) == 4);
  }

  @Test
  public void testMonthsForStringExpressionsWithComma() {
    List<Integer> months = TestUtils.getResult(TimeUnit.MONTH, "MAR,APR,MAY,DEC");
    Assert.assertNotNull(months);
    Assert.assertEquals(4, months.size());
    Assert.assertTrue(months.get(0) == 3);
    Assert.assertTrue(months.get(months.size()-1) == 12);
  }
}
