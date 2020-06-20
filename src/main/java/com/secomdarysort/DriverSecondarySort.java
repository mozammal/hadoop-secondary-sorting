package com.secomdarysort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class DriverSecondarySort {
  public static void main(String... args)
      throws IOException, ClassNotFoundException, InterruptedException {

    Configuration conf = new Configuration();
    final Job job = Job.getInstance(conf, "hadoopSecondarySortJob");
    Path outputPath = new Path(args[1]);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, outputPath);
    outputPath.getFileSystem(conf).delete(outputPath, true);
    job.setJarByClass(DriverSecondarySort.class);
    job.setMapperClass(Mapper.class);
    job.setOutputValueClass(NullWritable.class);
    job.setOutputKeyClass(DayTemperaturePair.class);
    job.setReducerClass(Reducer.class);
    job.setPartitionerClass(DayTemperaurePairPartitioner.class);
    job.setGroupingComparatorClass(DayTemperatureGroupComparator.class);
    job.setSortComparatorClass(DayTemperatureComparator.class);
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
