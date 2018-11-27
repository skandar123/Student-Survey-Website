/* NAME : SAYANTIKA KANDAR
 * The Receive.java checks if the student record exists or not in the database. If it does then StudentJSP.jsp is shown which
 * retrieves all the data entered for that particular student and if record does not exist then NoSuchStudentJSP.jsp is shown.
**/
package controller;

import java.io.File;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;

public class Receive extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware 
{
    private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext servletContext;
	
	public String execute() 
	{
	        String addr="";
		
			StudentDAO sd = new StudentDAO();
			StudentBean stu =sd.retrieveForm(request.getParameter("id"));

			HttpSession ses = request.getSession();
			ses.setAttribute("student_form", stu);

			if(stu!=null)
				return"Studentfound";
			else
				return"Studentnotfound";	
			
	}
	
	@Override
	public void setServletRequest(HttpServletRequest req) 
	{
		this.request = req;
	}
	
	@Override
	public void setServletContext(ServletContext ctx) 
	{
		this.servletContext = ctx;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse resp) 
	{
		this.response = resp;
	}
}



