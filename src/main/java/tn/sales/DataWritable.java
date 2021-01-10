package tn.sales;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
public class DataWritable implements Writable  {

	private double sales;
    private int numberorder;
	
	public DataWritable() {
		}
	
	
	public DataWritable(double sales,int numberorder,double minsales,double maxsales,int minquantity,int maxquantity ) {
		this.sales=sales;
		this.numberorder=numberorder;
			}
	
	
	

	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	public int getNumberorder() {
		return numberorder;
	}
	public void setNumberorder(int numberorder) {
		this.numberorder = numberorder;
	}
	public void write(DataOutput out) throws IOException {
		out.writeDouble(this.sales);
		out.writeInt(this.numberorder);
		
	}

	public void readFields(DataInput in) throws IOException {
		this.sales=in.readDouble();
		this.numberorder=in.readInt();
		
	}
	@Override
	public String toString() {
		return ","+sales +","+ numberorder;
	}
	

}
