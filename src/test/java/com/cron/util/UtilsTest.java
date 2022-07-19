package com.cron.util;


import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {

  @Test
  public void testExpressionEndingWithComma() {
    Assertions.assertTrue(Utils.isEndingWithComma("a-b,"));
  }

  @Test
  public void testExpressionEndingWithoutComma() {
    Assertions.assertFalse(Utils.isEndingWithComma("a,b,c"));
  }

  @Test
  public void testSanitizeForHappyCase() {
    String str = "* * * * *";
    Assertions.assertEquals(str, Utils.sanitize(str));
  }

  @Test
  public void testSanitizeForNonHappyCase() {
    String str = "1,2,3,4 *   *  ?  ?";
    String expected = "1,2,3,4 * * ? ?";
    Assertions.assertEquals(expected, Utils.sanitize(str));
  }
}
