/* NAME: SAYANTIKA KANDAR
 * This class calculates mean and standard deviation
*/
package controller;
public class DataProcessor 
{
        public String calculateData(String value){
		String arr[] = value.split(",");
		float mean=0;
		float stdev=0;
		float f=0;
		
		for(int i=0; i<arr.length; i++)
		{
			mean=mean+ Integer.parseInt(arr[i]);
		}
		mean = mean/arr.length;
		
		for(int i=0; i<arr.length;i++)
		{
			f=Integer.parseInt(arr[i])-mean;
			stdev=stdev+(f*f);
		}
		
		stdev =(float) Math.sqrt((stdev/(arr.length-1)));
		return (stdev + ","+ mean);		
	}
}

