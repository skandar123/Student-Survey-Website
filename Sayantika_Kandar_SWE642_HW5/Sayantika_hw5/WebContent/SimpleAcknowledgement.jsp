<!-- NAME: SAYANTIKA KANDAR -->
<!-- If the mean was less than 90, the servlet forwards request to this page using the RequestDipatcher object. The SimpleAcknowdedgementJSP simply thanks the user for filling out the form and prints mean and standard deviation on the page accessing the data from DataBean. -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.*"%>
<%@page import="java.util.HashMap"%>
<%@page import=" java.util.Iterator"%>
<%@page import=" java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">   

body
{
	background-color: lightgray;
   	color: darkred;

}

h1						
{
            border-bottom: 1px solid magenta;
            margin-bottom: 0.5em;
            padding-bottom: 0.5em;
            text-align: center;
	        text-shadow: 2px 2px 5px magenta;
	        color: blue;

}

h3
{
	    text-align: center;
        color: darkgreen;
}
       
p
{
	text-align: center;
	color: darkred;
}
        
div.relative 
{
    	position: relative;
    	width: 1250px;
    	height: 520px;
} 

div.absolute 
{
    	position: absolute;
    	top: 800px;
    	right: 0;
    	width: 200px;
    	height: 100px;
}

td span{
color: red;
}

.tooltip {
    position: relative;
    display: inline-block;
    border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
    visibility: hidden;
    width: 200px;
    background-color: #555;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 5px 0;
    position: absolute;
    z-index: 1;
    bottom: 125%;
    left: 50%;
    margin-left: -60px;
    opacity: 0;
    transition: opacity 1s;
}


.tooltip .tooltiptext::after {
    content: "";
    position: absolute;
    top: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: #555 transparent transparent transparent;
}

.tooltip:hover .tooltiptext {
    visibility: visible;
    opacity: 1;
}

</style>
	<h1>Simple Acknowledgement Page</h1>
</head>
<body>
<div class="relative">	
	<h3>Thank you for completing the Survey form.</h3>
	
	<p>Information regarding the standard deviation and mean based on the data on the survey form:</p>
	<ul>
		<li>Mean: ${data.mean}</li>
		<li>Standard Deviation: ${data.deviation}</li>
	</ul>
	
	<br />
	<br />
	
	<span style="font-style: italic">List of StudentIDs:</span>
	<br />
	<%
		ArrayList<String> arr = (ArrayList<String>) session.getAttribute("hashmap");
		
	%>
	<ol>
	<%
		for(int i=0; i<arr.size();i++)
		{
	%>
		<li><a href="Homework4/view?id=<%= arr.get(i)%>"> <%= arr.get(i)%></a></li>
	<%
		}
	%>
	</ol>

	<div class="absolute"><div class="tooltip"> <span class="tooltiptext">Please visit http://www.gmu.edu for more information.</span> <a href="https://www2.gmu.edu/"><img src="gmulogo.jpg" width="200" height="125"/></a></div></div></div>
     
</body>
</html>