//Name: Sayantika Kandar
//This page is the managed bean which controls various other classes
package test2;
import java.io.*;     

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.validator.ValidatorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@ManagedBean
public class Survey 
{
	public String pref="VeryLikely,Likely,UnLikely";
	public String[] prefarray=pref.split(","); 
	Student stu = new Student();
	WinningResult vr=new WinningResult();
	info t1=new info();
	public String valdis;
    ArrayList<Student> student_arr = new ArrayList<Student>();
    
    public void displayStateCity()
    {
    	    Client ct = ClientBuilder.newClient();
	        WebTarget tt = ct.target("http://localhost:8080/test2/webresources/rest/");
	        WebTarget resourceWebTarget;
	        resourceWebTarget = tt.path(new String(this.stu.getZip()+""));
	        
	        Invocation.Builder invocationBuilder;
	        invocationBuilder = resourceWebTarget.request(MediaType.TEXT_PLAIN);
	        System.out.println(resourceWebTarget.getUri());
	        Response response = invocationBuilder.get();
	        System.out.println(response.getStatus());
	        
	        String s = response.readEntity(String.class);
	        System.out.println("City"+s.split("-")[0]);
	        System.out.println("State"+s.split("-")[1]);
	        stu.setCity(s.split(",")[0]);
	        stu.setState(s.split(",")[1]);
	
    }

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}
	public WinningResult getWr() {
		return vr;
	}

	public void setWr(WinningResult vr) {
		this.vr = vr;
	}

	public info getS() {
		return t1;
	}

	public void setS(info t1) {
		this.t1 = t1;
	}
	

	
	
	public ArrayList<Student> getStudent_arr() {
		return student_arr;
	}

	public void setStudent_arr(ArrayList<Student> student_arr) {
		this.student_arr = student_arr;
	}

	public List<String> display(String choices)
	{
		List<String> a = new ArrayList<String>(); 
		for(String i: prefarray)
		{
		if(i.toUpperCase() .startsWith(choices.toUpperCase())) 
		{
		        a.add(i);
		}
		}
		    return(a);
	}

	//To store form information
	public void addData() throws IOException, java.io.IOException 
	{
        
		FileWriter add = new FileWriter("file5.txt",true);
	    try
	        {
	    	add.append(stu.getFirstname()+"^"+stu.getLastname()+"^"+stu.getSaddress()+"^"+stu.getCity()+"^"+stu.getState()+"^"+stu.getZip()+"^"
	             +stu.getEmail()+"^"+
	                 stu.getTphn()+"^"+stu.getRadiob()+"^"+stu.getDropd()+"^"+stu.getRaf()+"^"+stu.getComments()+"^"+System.getProperty( "line.separator" ));
	       
	         }
	        
	    finally
	        {
	    	add.close();
	        }
	    }
	
	//To calculate if semester start date is not less than the survey date
	public void dateAfter(FacesContext context, UIComponent componentToValidate, Object value) throws ValidatorException
	{
		Date Stdate = ((Date)value);
        Object surveyDateValue = componentToValidate.getAttributes().get("dateOfSurvey");
		Date dtSurveyDate = (Date) ((org.primefaces.component.calendar.Calendar)surveyDateValue).getValue();
		
		System.out.println(" semDate= " + Stdate);
		if (Stdate== null)
        		return;
		
		
		if(dtSurveyDate.after(Stdate))
		{
			FacesMessage message = new FacesMessage("Semester Start date cannot be before Survey date.");
			throw new ValidatorException(message);
		}

	}
	
	//To display city and state
	public void displayAll() 
	{
		details z=new details();
		String s=z.LookUp(stu.getZip());
		stu.setCity(s.split(",")[0]);
		stu.setState(s.split(",")[1]);
	}
	
//To output form data
	 public String readData() throws FileNotFoundException, IOException
	 {
	        
		String Info = null; 
	      
	    try {
	    	
	        BufferedReader readerData = new BufferedReader(new FileReader("file5.txt"));

	        StringBuilder buildData = new StringBuilder();
	        
	        String dataEntry = readerData.readLine();
		       
	        while (dataEntry != null) {
		    String element[]=dataEntry.split("\\^");
		    System.out.println("Inside file writer");
		    
		    Student st=new Student();
		    
		    st.setFirstname(element[0]);
		    st.setLastname(element[1]);
		    st.setSaddress(element[2]);
		    st.setCity(element[3]);
		    st.setState(element[4]);
		    st.setZip(element[5]);
		    st.setEmail(element[6]);
		    st.setTphn(element[7]);
		    st.setRadiob(element[8]);
		    st.setDropd(element[9]);
		    st.setRaf(element[10]);
		    st.setComments(element[11]);
		    
            student_arr.add(st);
		    dataEntry = readerData.readLine();
	        }  
	
	        Info = buildData.toString();

	       }
	    catch(Exception e){ 
	         System.out.println("Error");
	    }
	    
	    System.out.println("Info" + Info);
	    return Info;
	      
	    }
	
	 
		
public String listsurveyAction() throws IOException {
        try
        {
        	valdis = readData();
        }
        catch (FileNotFoundException e) {
	        e.printStackTrace();
        }
        return "ListSurvey";
    }

public String submit()throws IOException
{
	addData();		
	    vr=t1.Calculate_Winner(stu);
	if(vr.getMean()>=90)
	return "WinningResult";
	else
	{
	  	System.out.println(stu.getFirstname());
        return"SimpleAcknowledgement";	

	}	
}	
	public String cancel()
	{
		return "CancelReturn";
	}
	
	}
