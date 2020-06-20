package com.secomdarysort;

import org.apache.hadoop.io.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DayTemperaturePair implements WritableComparable<DayTemperaturePair> {

  private int day;
  private double temperature;

  public DayTemperaturePair() {}

  public DayTemperaturePair(int day, double temperature) {
    this.day = day;
    this.temperature = temperature;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  @Override
  public int compareTo(DayTemperaturePair o) {

    int cmp = day - o.getDay();
    if (cmp != 0) return cmp;

    return Double.compare(o.getTemperature(), temperature);
  }

  @Override
  public void write(DataOutput dataOutput) throws IOException {
    dataOutput.writeInt(day);
    dataOutput.writeDouble(temperature);
  }

  @Override
  public void readFields(DataInput dataInput) throws IOException {
    day = dataInput.readInt();
    temperature = dataInput.readDouble();
  }

  @Override
  public int hashCode() {
    return day * 179 + (int) temperature;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof DayTemperaturePair) {
      DayTemperaturePair dayTemperaturePair = (DayTemperaturePair) o;
      return day == dayTemperaturePair.day && temperature == dayTemperaturePair.temperature;
    }
    return false;
  }

  @Override
  public String toString() {
    return "( " + day + " , " + temperature + " )";
  }
}
