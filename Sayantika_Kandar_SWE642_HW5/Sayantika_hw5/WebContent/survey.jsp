<!-- NAME: SAYANTIKA KANDAR -->
<!-- This page asks the students to fill a survey form and then submits the data to the database-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
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
    	top: 1000px;
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
<h1>CS Department Survey Page</h1>
<link rel="stylesheet" type="text/css" href="jquery-ui.css"></link>
<script src="jquery-1.10.2.js"></script>
<script src="jquery-ui.js"></script>
<script src="jquery.alerts.js" type="text/javascript"></script>
<script type="text/javascript">

var now=new Date();
var hour=now.getHours();
var name="Paul";

if(hour<12)
	document.writeln("<h3>Good Morning, ");
else
	{
	hour=hour-12;
	if(hour<6)
	document.writeln("<h3>Good Afternoon, ");
	else
	document.writeln("<h3>Good Evening, ");
	}
if (document.cookie)
{
var myCookie=unescape(document.cookie);
var cookieTokens=myCookie.split("=");
name=cookieTokens[1];
}
else
{
name=window.prompt("Please enter your name","Paul");
document.cookie="name="+escape(name);
}
document.writeln(name+"!</h3>");
document.writeln("<center><a href='javascript:wrongPerson()'>"+"Click here if you are not "+name+"</a></center><br />");

function wrongPerson()
{
document.cookie="name=null;"+"expires=Thu, 12-Mar-17 22:04:01 GMT";
location.reload();
}

$( function() {
    $( "#dialog7" ).dialog({
      autoOpen: false,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "explode",
        duration: 1000
      }
    });
    
$( document ).ready(function() 
{
 $("#zip").blur(function() 
 {
  $.ajax({
          url: "code.json",
          dataType: "text",
          error:function(){alert();},
          success: function(code) 
           {
            var json = $.parseJSON(code);
            callback(json);
           }
          });
 });
});

function callback(code)
{
var elements=code.zipcodes, list=[], f=false, j=0, cityn, staten;
var zipn=document.getElementById("zip").value.trim();
 
while(f==false&&j!=elements.length)
{
if(zipn==elements[j].zip)
{ 
	f=true; 
	cityn=elements[j].city; 
	staten=elements[j].state;
}
j++;
}
    
if(f==true)
{
	document.getElementById("city").value=cityn;
    document.getElementById("state").value=staten;
}
else
{
    document.getElementById("city").value="";
    document.getElementById("state").value="";
    $( "#dialog7" ).dialog( "open" );   
    document.getElementById("zip").value = "";
}
}
});
       	
function calculate()
{
	var value=document.getElementById("data").value;
	var arr = value.split(",");
	var err="";
	var chk;
				
     if(arr.length >=10)
     {
		for(i=0; i<arr.length; i++)
		{						
		  chk=isNaN(arr[i]);
		  if(chk)
		  {
			err="Please enter only numeric values";
			break;
		  }
		  if(arr[i] < 1 || arr[i] > 100)
		  {
			err="Please enter numbers from 1 to 100";	
			break;
		   }
		 }
		}
		else
		 err="Please enter atleast 10 numeric values separated by comma";				
		if(err != null)
		 document.getElementById("errorData").innerHTML=err; 
	alert(err);
}
			
function chkboxValidate()
{
  var cnt = 0;
  var chkBox = document.getElementsByName("chkbox");
  for(i=0; i< chkBox.length; i++)
  {
	if(chkBox[i].checked)
	{
	  cnt =cnt + 1;
	}
  }
  if(cnt < 2)
	return false;
  else
	return true;
}
			
function validradio()
{
  var radio = document.getElementsByName("myradio");
  for(i=0; i< radio.length; i++)
  {
	if(radio[i].checked)
	{
	 return true;
	}
  }
  return false;	
}
			
function checkemail()
{
  var reg = /^[\_]*([a-z0-9]+(\.|\_*)?)+@([a-z][a-z0-9\-]+(\.|\-*\.))+[a-z]{2,6}$/; 
  if(!reg.test(document.getElementById("email").value))
  {
   return false;
  }
  else
  {
   document.getElementById("errorEmail").innerHTML="";
   return true;
  }
}
			
function checkid()
{
  if(document.getElementById("stud_id").value == '')
  {
	$(function() 
	{
	  $( "#dialog6" ).dialog();
	});
	document.getElementById("stud_id").focus();
	return false;
  }
  else
  {
	document.getElementById("errorId").innerHTML="";
  }
}
			
function ResetFn()
{
  document.getElementByName("myForm").reset();
}
			
function SubmitFn()
{
  var alphabets=/^[a-z]+$/i;
  var alphanumeric=/^[a-zA-Z0-9\s\,]*$/i; //'^[a-zA-Z0-9\s,\'-]*$';
  if(!alphabets.test(document.getElementById("name").value))
  {
	$(function() 
	{
    $( "#dialog1" ).dialog();
    });
    document.getElementById("name").value="";
    document.getElementById("name").focus();
    return false;
  }
  else if(!alphanumeric.test(document.getElementById("address").value))
  {
	$(function() 
	{
	  $( "#dialog2" ).dialog();
	});
	document.getElementById("address").focus();
	document.getElementById("address").value="";
	return false;
  }
  else if(!validcheckbox())
  {
	var chkBox = document.getElementsByName("chkbox");
	$(function() 
	{
	  $( "#dialog3" ).dialog();
	});
    for(i=0; i< chkBox.length; i++)
    {
	 chkBox[i].checked=false;
	}
	return false;
  }
  else if(!validradio())
  {
	$(function() 
	{
	 $( "#dialog4" ).dialog();
	});
	return false;
  }
  else if(!checkemail())
  {
	$(function() 
	{
	  $( "#dialog5" ).dialog();
	});
	document.getElementById("email").focus();
	document.getElementById("email").value="";
	return false;
  }
  else
  {
	document.getElementById("errorName").innerHTML="";
	return true;
  }
}
</script>
</head>
<body>
<div> 
<div id="errorData" title="Data Error"></div>
<div id="dialog1" title="Name Error" Style="display:none;">Name should have only alphabets</div>
<div id="dialog2" title="Address Error" Style="display:none;">Address can have only alphanumeric characters</div>
<div id="dialog3" title="Checkbox Error" Style="display:none;">Select at least two checkboxes</div>
<div id="dialog4" title="Radio Error" Style="display:none;">Click a radio button</div>
<div id="dialog5" title="Email Error" Style="display:none;">Enter email in proper format</div>
<div id="dialog6" title="Student ID Error" Style="display:none;">Enter student ID</div>
<div>
<div class="relative">
<form method ="post" action="survform.action" autocomplete="on" name="myform" >
<center>
	
<table>
	<tr>
	<th>Student ID:</th>
	<th>Name:</th>
	<th>Address:</th>
	
	<tr>
	<td><input type="text" size="30" id="stud_id" name="stud_id" required="required" autofocus onblur="checkid()"/></td>
	<div id="errorId" class="ID Error"></div>
	
	<td><input type="text" size="30" id="name" name="name" placeholder="enter only alphabets" required="required"  /> 
	<div id="nameError" title="Name Error" ></div>
	</td>
	
	<td><input type="text" name="address" size="30" placeholder="enter only alphanumeric values" id="address" required="required" />
	</td>
	</tr>
					
	<tr>
	<th>Zip:</th>
	<th>City:</th>
	<th>State:</th>
	</tr>
					
	<tr>
	<td><input type="text" size="30" name="zip" placeholder="5 digits" id="zip"/> 
		<div id="dialog7" title="Error"><p>Invalid Zip code</p></div></td>
	<td><input id="city" name="city"/></td>
	<td><input id="state" name="state"/></td>
	</tr>
					
	<tr>
	
	<th>Telephone:</th>
	<th>E-mail:</th>				
	<th>URL:</th>				
	</tr>
					
	<tr>
	    <td><input type="tel" size="30" name="telephone" id="telephone"  required="required" placeholder="(###) ###-####"/></td>
		<td><input  placeholder="name@domain.com" name="email" size="30" id="email" required="required"  type="text" />
		<td><input type="url" size="30" name="url" placeholder="http://www.domainname.com"  /></td>
	</tr>
	
	<tr>
	<th>Date of survey:</th>
	<th>Graduation Month:</th>
	<th>Graduation Year:</th>
	</tr>
					
	<tr>
	<td><input type="date" size="30" name="surveydate"  placeholder="mm-dd-yyyy"/></td>
	<td><input type="text" name="gradmonth" placeholder="Select a month" list="months" size="10"/>
		<datalist id="months">
							<option value="January">
							<option value="February">
							<option value="March">
							<option value="April">
							<option value="May">
							<option value="June">
							<option value="July">
							<option value="August">
							<option value="September">
							<option value="October">
							<option value="November">
							<option value="December">
		</datalist></td>
	 <td><input type="text" size="14" name="gradyear" placeholder="Enter a year (yyyy)" /></td>
	 </tr>
	
	<tr>	
	<th>Data:</th>
	<th>What do you like most about the campus?</th>
	<th>How did you become interested in the university?</th>
	</tr>
	
	<tr>
	
	<td><input type="text" size="30" id="data" name="data" placeholder="10 comma separated values"/></td>
	<td>
			<input type="checkbox" name="chkbox" value="Students" id="student"/>Students<br>
			<input type="checkbox" name="chkbox" value="Location" />Location<br>
			<input type="checkbox" name="chkbox" value="Campus" />Campus<br>
			<input type="checkbox" name="chkbox" value="Atmosphere" />Atmosphere<br>
			<input type="checkbox" name="chkbox" value="Dorm Rooms" />Dorm Rooms<br>
			<input type="checkbox" name="chkbox" value="Sports" />Sports<br>
			<label id="errorChkbox" class="error" Style="align:center"></label>
	</td>
	<td>
			<input type="radio" name="myradio" />Friends<br>
			<input type="radio" name="myradio" />Television<br>
			<input type="radio" name="myradio" />Internet<br>
			<input type="radio" name="myradio" />Other<br>
			<label id="errorRadio" class="error"></label>
	</td>
	</tr>
			
	<tr>
	<th>Will you recommend this school to other students?</th>
	<th>Additional comments</th>
	</tr>
	
	<tr>
	<td>
	<select name="recommend">
							<option>Very likely</option>
							<option>Likely</option>
							<option>Unlikely</option>
	</select>
	</td>
	<td><textarea rows="10" cols="40" name="comments" placeholder="Additional comments"></textarea></td>
	</tr>
	</table>
	
</center>
	<div style="text-align: center;">
			<input type="submit" value="Submit" onclick="return SubmitFn()"/>
			<input type="reset"  onclick="ResetFn()" value="Reset"/>
     </div>
     </form>
      <div class="absolute"><div class="tooltip"> <span class="tooltiptext">Please visit http://www.gmu.edu for more information.</span> <a href="https://www2.gmu.edu/"><img src="gmulogo.jpg" width="200" height="125"/></a></div></div></div>
     
     </div></div>
     
</body>
</html>
