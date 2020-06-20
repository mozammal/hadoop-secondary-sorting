# Hadoop Secondary Sorting for Big Data Set

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the program locally/hadoop cluster

clone the repo with the command given below: 
```shell
git clone https://github.com/mozammal/hadoop-secondary-sorting.git
```


One way to run the hadoop program is to use maven from the command line:

```shell
start-yarn.sh

start-dfs.sh

hadoop fs -rm -r -f /user/hduser/output/

export HADOOP_CLASSPATH=/usr/lib/jvm/jdk1.7.0_80/lib/tools.jar

#upload weather file from local filesystem to hdfs

hadoop fs -copyFromLocal weather_shuf.csv /user/hduser/input

cd hadoop-secondary-sorting

sudo mvn install assembly:single

cd target

export HADOOP_CLASSPATH=hadoop-secondary-sort-1.0-SNAPSHOT-jar-with-dependencies.jar

hadoop com.secomdarysort.DriverSecondarySort /user/hduser/input/weather_shuf.csv /user/hduser/output

hadoop fs -cat /user/hduser/output/part-* | sort
```

