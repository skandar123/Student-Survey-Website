<!-- NAME: SAYANTIKA KANDAR -->
<!-- StudentJSP page displays information of students based on the survey form that they have filled -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
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
<h1>Student Information</h1>
</head>
<body>
<h3>Following are the details for the student id <span style="color:red"><%= request.getParameter("id") %></span>:</h3>

<center>
	 
	 <table>
		<tr><th>Name:</th>
		    <th>Address:</th>
		    <th>Zip:</th></tr>
		    
		<tr><td>${student_form.getName()}</td>
		    <td>${student_form.getAddress()}</td>
		    <td>${student_form.getZip()}</td></tr>
		    
		<tr><th>City:</th>
		    <th>State:</th>
		    <th>Telephone:</th></tr>
		    
		 <tr><td>${student_form.getCity()}</td> 
		     <td>${student_form.getState()}</td>
		     <td>${student_form.getTel()}</td></tr>  
		 
		<tr><th>Email:</th>
		    <th>URL:</th>
		    <th>Date of Survey:</th></tr>
		    
		<tr><td>${student_form.getEmail()}</td>   
		 <td>${student_form.getUrl()}</td>
		 <td>${student_form.getSurveydate()}</td></tr>
		 
		<tr><th>Graduation Month:</th>
		    <th>Graduation Year:</th>
		    <th>Will you recommend this school to other students?</th></tr>
		    
		<tr><td>${student_form.getGradmonth()}</td>
		    <td>${student_form.getGradyear()}</td>
		    <td>${student_form.getRecommend()}</td></tr>
		    
		<tr><th>What do you like most about the campus?</th>
		    <th>How did you become interested in the university?</th>
		    <th>Additional comments:</th></tr>
		    
		<tr><td>${student_form.getChkbox()}</td>
		    <td>${student_form.getMyradio()}</td>
		    <td>${student_form.getComments()}</td></tr>
	</table>
	
</center>
</body>
</html>