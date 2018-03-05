//Name: Sayantika Kandar
//This page contains the business logic to calculate standard deviation and mean
package test2;
import java.io.*;    
import java.util.*;
public class info implements Serializable
{
    
	/**
	 * 
	 */
	Student st=new Student();
	private static final long serialVersionUID = 1L;
	public static final Map<String, Map<String,String>> Zip_Map = new HashMap<>();
	  public static final List<String> Zipcs = new ArrayList<>();


	private WinningResult w=new WinningResult();
	double mean=0,Sum=0;
	double sd=0;
	String[] display;
	ArrayList<Student> sdlist=new ArrayList<Student>();
	
	 
	public ArrayList<Student> getSdlist() {
		return sdlist;
	}

	public void setSdlist(ArrayList<Student> sdlist) {
		this.sdlist = sdlist;
	}

	public WinningResult Calculate_Winner(Student s) //Calculates Mean and Standard deviation 
	{
		int i = 0;
	    double sum = 0;	   
	    int[] n = new int [10];
	    String[] RafData;
      	    try{
	        
	        if(!s.getRaf().isEmpty())
	        {
	    		 RafData = s.getRaf().split(",");
	             for(String j:RafData)
	             {
	            	n[i] = Integer.parseInt(j);
	                sum = sum + n[i];
	             }	       
	             mean=sum/RafData.length;
	             w.setMean(mean);
	             for ( i=0; i<RafData.length ; i++)
				    {
		            Sum = Sum + Math.pow(n[i] - w.getMean(), 2);
				    }
		            sd=Math.sqrt(Sum/(n.length));
		            w.setSd(sd);
	            	return w;                      
	        }
            
	    }

	    catch(Exception e)
	        {
	            System.out.println(e);
	        }
      	    return w;
        
	    }
	
}
