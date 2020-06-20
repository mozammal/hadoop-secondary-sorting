package com.secomdarysort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class DayTemperatureGroupComparator extends WritableComparator {

  protected DayTemperatureGroupComparator() {
    super(DayTemperaturePair.class, true);
  }

  @Override
  public int compare(WritableComparable a, WritableComparable b) {
    DayTemperaturePair dayTemperaturePair1 = (DayTemperaturePair) a;
    DayTemperaturePair dayTemperaturePair2 = (DayTemperaturePair) b;
    return dayTemperaturePair1.getDay() - dayTemperaturePair2.getDay();
  }
}
