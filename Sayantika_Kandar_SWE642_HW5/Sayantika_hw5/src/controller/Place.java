/* NAME: SAYANTIKA KANDAR 
 * The Place.java checks the mean and as per that declares which .jsp file is needed to be displayed. If the mean is above 90
 * then WinnerAcknowledgement.jsp and if it is less then SimpleAcknowledgement.jsp. 
 */
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

public class Place extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware 
{
    private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext servletContext;
	
	public String execute() 
	{
		String addr;
		StudentDAO s = new StudentDAO();
		String str;
		String t[];
		ArrayList<String> ids = new ArrayList<String>();
		StudentBean stu=new StudentBean();
		try {
			s.saveForm(request);
			DataProcessor dp= new DataProcessor();
			str=dp.calculateData(request.getParameter("data"));
			t=str.split(",");

			DataBean db=new DataBean(Float.parseFloat(t[1]), Float.parseFloat(t[0]));

			HttpSession ses = request.getSession();
			ses.setAttribute("data", db);

			stu=(StudentBean) ses.getAttribute("student_data");

			ids = s.getIds();
			ses.setAttribute("hashmap", ids);
			
			if(db.getMean()>90){
				 return "WinnerACK";
			}else{
				 return "SimpleACK";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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



