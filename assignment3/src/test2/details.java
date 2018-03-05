//Name: Sayantika Kandar
//Resource class which contains zipcode,city and state details
package test2;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/zipcode")
public class details {

	Map<String,rest> zipcode;
	public details()
	{
		super();
		zipcode=new HashMap<String,rest>();
		zipcode.put("22312",new rest("VA","Alexandria","22312"));
	    zipcode.put("22030",new rest("VA","Fairfax","22030"));
		zipcode.put("22301",new rest("MD","Tysons Corner","22301"));
		zipcode.put("20148",new rest("VA","Ashburn","20148"));
	
	}
@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("{zip}")
public String LookUp(@PathParam("zip")String zip)
{
	rest matchedLocation=zipcode.get(zip);
	
	String cityState=new String(matchedLocation.getCity()+","+matchedLocation.getState());
	return cityState;
}
}
