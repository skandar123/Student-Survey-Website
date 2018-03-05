//Name: Sayantika Kandar
//This is the Student class which contains all the survey form fields
package test2;
import java.io.*;       
import java.util.*;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String firstname;
    private String lastname;
    private String saddress;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String tphn;
    public String[] checkbox;
    private String radiob;
    private String dropd;
    public String raf;
    public Date sdate;
    public Date semdate;
    public String comments;
       
public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getSaddress() {
		return saddress;
	}


	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}


  public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


  public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


public String getZip() {
		return zip;
	}


	public void setZip(String zip) 
	{
		this.zip = zip;
	}


public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
		public String getTphn() {
		return tphn;
	}


	public void setTphn(String tphn) {
		this.tphn = tphn;
	}
public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getSemdate() {
		return semdate;
	}
	public void setSemdate(Date semdate) {
		this.semdate = semdate;
	}
public String[] getCheckbox() {
		return checkbox;
	}


	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}


public String getRadiob() {
		return radiob;
	}


	public void setRadiob(String radiob) {
		this.radiob = radiob;
	}
	  

	

	public String getDropd() {
		return dropd;
	}


	public void setDropd(String dropd) {
		this.dropd = dropd;
	}


	public String getRaf() {
		return raf;
	}


	public void setRaf(String raf) {
		this.raf = raf;
	}
	public String getComments()
	{
		return comments;
	}
    public void setComments(String comments)
    {
    	this.comments=comments;
    }    
    
}
 