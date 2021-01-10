package tn.sales;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class TokenizerMapper
    extends Mapper<Object, Text, Text, DataWritable>{

private DataWritable data = new DataWritable();
private Text country = new Text();



public void map(Object key, Text value, Mapper.Context context
) throws IOException, InterruptedException {
  String[] itr = value.toString().split(";");
 
    data.setSales(Double.parseDouble(itr[4]));
    data.setNumberorder(Integer.parseInt(itr[1]));   
    country.set(itr[17]+","+itr[14]+","+itr[9]);
         context.write(country, data);
         
   
   }


}
