package tn.sales;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;


public class IntSumReducer
extends Reducer<Text,DataWritable,Text,DataWritable> {

private DataWritable result = new DataWritable();

public void reduce(Text key, Iterable<DataWritable> values,
               Context context
) throws IOException, InterruptedException {
double sum = 0.0;
int quantity=0;

for (DataWritable val : values) {
    System.out.println("value: "+val.getNumberorder());
  

    sum += val.getSales();
    quantity+=val.getNumberorder();
}
System.out.println("--> Sum = "+sum);

result.setSales(sum);
result.setNumberorder(quantity);

context.write(key,result);
}
}
