package cron.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
  public static boolean isEndingWithComma(String str) {
    Pattern p = Pattern.compile(str);
    Matcher m = p.matcher(",$");
    return m.matches();
  }
}
