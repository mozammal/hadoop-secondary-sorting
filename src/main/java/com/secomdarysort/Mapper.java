package com.secomdarysort;

import com.secomdarysort.DayTemperaturePair;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class Mapper
    extends org.apache.hadoop.mapreduce.Mapper<
        LongWritable, Text, DayTemperaturePair, NullWritable> {

  @Override
  protected void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    String[] values = value.toString().split(";");
    int day = Integer.parseInt(values[0].split("/")[1]);
    double temperature = Double.parseDouble(values[values.length - 1]);
    context.write(new DayTemperaturePair(day, temperature), NullWritable.get());
  }
}
