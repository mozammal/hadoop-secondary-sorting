package com.secomdarysort;

import com.secomdarysort.DayTemperaturePair;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class DayTemperaurePairPartitioner extends Partitioner<DayTemperaturePair, NullWritable> {
  @Override
  public int getPartition(DayTemperaturePair key, NullWritable value, int numOfPartitions) {
    return Math.abs(key.getDay() * 127) % numOfPartitions;
  }
}
