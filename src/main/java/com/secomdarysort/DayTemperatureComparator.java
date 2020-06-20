package com.secomdarysort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class DayTemperatureComparator extends WritableComparator {

  protected DayTemperatureComparator() {
    super(DayTemperaturePair.class, true);
  }

  @Override
  public int compare(WritableComparable a, WritableComparable b) {
    DayTemperaturePair dayTemperaturePair1 = (DayTemperaturePair) a;
    DayTemperaturePair dayTemperaturePair2 = (DayTemperaturePair) b;
    int dayDelta = dayTemperaturePair1.getDay() - dayTemperaturePair2.getDay();
    if (dayDelta != 0) return dayDelta;

    return Double.compare(
        dayTemperaturePair2.getTemperature(), dayTemperaturePair1.getTemperature());
  }
}
