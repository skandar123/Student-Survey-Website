/* NAME: SAYANTIKA KANDAR
 * This code connects to the database
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class StudentDAO {
	private String name="";
	private String stud_id="";
	private String address="";
	private int zip=0;
	private String city="";
	private String state="";
	private String tel="";
	private String email="";
	private String url="";
	private String surveydate="";
	private String gradmonth="";
	private String gradyear="";
	private String recommend="";
	private String data="";
	private String[] chkbox;
	private String myradio="";
	private String comments="";
	private String t = "";
	ArrayList<String> stuarr = new ArrayList<String>();

	public void saveForm(HttpServletRequest request)
	{
		StudentBean stu = new StudentBean();
        name=request.getParameter("name");
		stud_id=request.getParameter("stud_id");
		address=request.getParameter("address");
		zip=Integer.parseInt(request.getParameter("zip"));
		city=request.getParameter("city");
		state=request.getParameter("state");
		tel=request.getParameter("telephone");
		email=request.getParameter("email");
		url=request.getParameter("url");
		surveydate=request.getParameter("surveydate");
		gradmonth=request.getParameter("gradmonth");
		gradyear=request.getParameter("gradyear");
		recommend=request.getParameter("recommend");
		data=request.getParameter("data");
		chkbox=request.getParameterValues("chkbox");
		myradio=request.getParameter("myradio");
		comments=request.getParameter("comments");

		try {
			stu.setStud_id(stud_id);
			stu.setName(name);
			stu.setAddress(address);
			stu.setZip(zip);
			stu.setCity(city);
			stu.setState(state);

			for(int i=0; i<chkbox.length; i++)
			{
				t=t+ chkbox[i]+ " ";
			}

			stu.setChkbox(t);
			stu.setMyradio(myradio);

			if(!tel.isEmpty()){stu.setTel(tel);}
			if(!email.isEmpty()){stu.setEmail(email);}
			if(!url.isEmpty()){stu.setUrl(url);}
			if(!surveydate.isEmpty()){stu.setSurveydate(surveydate);}
			if(!gradmonth.isEmpty()){stu.setGradmonth(gradmonth);}
			if(!gradyear.isEmpty()){stu.setGradyear(gradyear);}
			if(!recommend.isEmpty()){stu.setRecommend(recommend);}
			if(!comments.isEmpty()){stu.setComments(comments);}

			String driverName = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);
			String url = "jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g";
			Connection con = DriverManager.getConnection(url,"skandar","whuriv");
			Statement state = con.createStatement();  
			PreparedStatement prestate = con.prepareStatement("Insert into stud values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
			prestate.setString (1, stu.getStud_id());
			prestate.setString (2, stu.getName()); 
			prestate.setString (3, stu.getAddress()); 
			prestate.setInt (4, stu.getZip()); 
			prestate.setString (5, stu.getCity() ); 
			prestate.setString (6, stu.getState()); 
			prestate.setString (7, stu.getTel()); 
			prestate.setString (8, stu.getEmail()); 
			prestate.setString (9, stu.getUrl()); 
			prestate.setString (10, stu.getSurveydate()); 
			prestate.setString (11, stu.getGradmonth()); 
			prestate.setString (12, stu.getGradyear());
			prestate.setString (13, stu.getRecommend());
			prestate.setString (14, stu.getChkbox()); 
			prestate.setString (15, stu.getMyradio()); 
			prestate.setString (16, stu.getComments()); 
            prestate.executeUpdate();
            con.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occured here:" + e);
		}
        HttpSession ses = request.getSession();
		ses.setAttribute("student_data", stu);
}

public StudentBean retrieveForm(String id)
{
 StudentBean stu= new StudentBean();
 try 
 {
	String driverName = "oracle.jdbc.driver.OracleDriver";
	Class.forName(driverName);
	String url = "jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g";
	Connection con = DriverManager.getConnection(url,"skandar","whuriv");
	Statement state = con.createStatement();   
    ResultSet res = state.executeQuery("Select * from stud where stud_id ='" + id + "'"); 
    if (res.next()) 
	{ 
				stu.setStud_id(res.getString("STUD_ID"));
				stu.setName(res.getString("NAME"));
				stu.setAddress(res.getString("ADDRESS"));
				stu.setZip(res.getInt("ZIP"));
				stu.setCity(res.getString("CITY"));
				stu.setState(res.getString("STATE"));
				stu.setTel(res.getString("TEL"));
				stu.setEmail(res.getString("EMAIL"));
				stu.setUrl(res.getString("URL"));
				stu.setSurveydate(res.getString("SURVEYDATE"));
				stu.setGradmonth(res.getString("GRADMONTH"));
				stu.setGradyear(res.getString("GRADYEAR"));
				stu.setRecommend(res.getString("RECOMMEND"));
				stu.setChkbox(res.getString("CHKBOX"));
				stu.setMyradio(res.getString("MYRADIO"));
				stu.setComments(res.getString("COMMENTS"));
	 }
     con.close();
  } 
  catch (Exception e) 
  {
   System.out.println("Exception occured:" + e);
  }
  if(stu.getName()==null)
	return null;
  else
	return stu;
}

public ArrayList<String> getIds() throws SQLException
{
 String arr[]=null;
 ArrayList<String> stuarr = new ArrayList<String>();
 String driverName = "oracle.jdbc.driver.OracleDriver";
 try 
 {
  Class.forName(driverName);
  String url = "jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g";
  Connection con = DriverManager.getConnection(url,"skandar","whuriv");
  Statement state = con.createStatement();   
  ResultSet res = state.executeQuery ("SELECT stud_id FROM stud");  
  while (res.next())  
  {  
	String s = res.getString ("stud_id");  
	stuarr.add(s);
	System.out.println (s + " \n");  
  }
  con.close();
 } 
 catch (ClassNotFoundException e) 
 {
  e.printStackTrace();
 }
 return stuarr;
}
}	



