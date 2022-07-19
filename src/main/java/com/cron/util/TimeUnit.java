package com.cron.util;

public enum TimeUnit {
  MINUTE("minutes"),
  HOUR("hours"),
  DAY_OF_MONTH("days of month"),
  MONTH("months"),
  DAY_OF_WEEK("days of week");

  private final String text;

  TimeUnit(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
