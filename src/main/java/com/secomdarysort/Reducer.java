package com.secomdarysort;

import com.secomdarysort.DayTemperaturePair;
import org.apache.hadoop.io.NullWritable;

import java.io.IOException;

public class Reducer
    extends org.apache.hadoop.mapreduce.Reducer<
        DayTemperaturePair, NullWritable, DayTemperaturePair, NullWritable> {

  @Override
  protected void reduce(DayTemperaturePair key, Iterable<NullWritable> values, Context context)
      throws IOException, InterruptedException {
    context.write(key, NullWritable.get());
  }
}
