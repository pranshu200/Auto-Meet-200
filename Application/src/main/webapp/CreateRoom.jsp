<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.MeetingSubmit"%>
<%@page import="model.Users"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AUTO MEET 200</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js/createRoom.js"></script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: aquamarine;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
</head>
<body>
	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-theme-d2 w3-left-align ">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2"
				href="javascript:void(0);" onclick="openNav()"><i
				class="fa fa-bars"></i></a> <a href="index.html"
				class="w3-bar-item w3-hide-small w3-hover-white"><img
				src="images/homelogo.png" alt="logo" style="width: 50px;"></a> <a
				href="index.html"
				class="w3-bar-item w3-button w3-hide-small w3-hover-white">Home</a>
			<a href="MeetingRooms.jsp"
				class="w3-bar-item w3-button w3-hide-small w3-hover-white">Meeting
				Room</a>
				 <a href="logoutServlet.do"
				class="w3-bar-item w3-button w3-hide-small w3-hover-white">Logout</a> <a href="#contact"
				class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>
		</div>
		<div id="navDemo"
			class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium">
			<a href="#contact" class="w3-bar-item w3-button">Contact</a>
		</div>
	</div>

	<br>
<center>
<div style=" height: 700px;width: 700px;"> 
<form id="frm" action="CreateRoom.do" method="post">
  <div class="container">
    <h1>CREATE ROOM </h1>
    <p>Please fill in this form to Create Room</p>
    <hr>
    
    <table>
    <tr>
    <td><label for="roomName"><b>Room Name</b></td>
    <td><input type="text" placeholder="Enter Room Name" name="roomName" id="roomName" required></label></td>
    </tr>
	 <tr>
    <td><label for="userId"><b>User ID</b></td>
    <td><input type="text" placeholder="Enter User ID" name="userId" id="userId" required></label></td>
	</tr>
	 <tr>
	<td><label for="date"><b>Date</b></td>
    <td><input type="text" placeholder="DD/MM/YYYY" name="date" id="date" required></label></td>
    </tr>
     <tr>
    <td><label for="startTime"><b>Start Time</b></td>
    <td><input type="text" placeholder="00:00:00" name="startTime" id="startTime" required></label></td>
	</tr>
	  <tr>
    <td><label for="endTime"><b>End Time</b></td>
    <td><input type="text" placeholder="00:00:00" name="endTime" id="endTime" required></label></td>
	</tr>
	  <tr>
    <td><label for="credit"><b>Credit</b></td>
    <td><input type="text" placeholder="00" name="credit" id="credit" required></label></td>
	</tr>
	  <tr>
    <td><label for="title"><b>Title</b></td>
    <td><input type="text" placeholder="eg. Game Room" name="title" id="title" required></label></td>
	</tr>
	  <tr>
    <td><label for="type"><b>Type</b></td>
    <td><input type="text" placeholder="ex. Gaming" name="type" id="type" required></label></td>
	</tr>
	</table>
    <button type="submit" class="registerbtn" onclick="createRoom()">Create Room</button>
  </div>
</form>
</div>
</center>
<br><br><br><br><br>
	<br>
	<br>
	<br>
	<br> 
	<div>
		<footer style="bottom: 0;">
			<div class="w3-container w3-padding-64 w3-theme-l5" id="contact">
				<footer class="w3-container w3-padding-32 w3-theme-d1 w3-center">
					<a class="w3-button w3-large w3-teal"
						href="https://www.facebook.com/" title="Facebook"><i
						class="fa fa-facebook"></i></a> <a class="w3-button w3-large w3-teal"
						href="https://twitter.com/i/flow/login" title="Twitter"><i
						class="fa fa-twitter"></i></a> <a class="w3-button w3-large w3-teal"
						href="https://www.instagram.com/" title="Google +"><i
						class="fa fa-instagram"></i></a> <a
						class="w3-button w3-large w3-teal w3-hide-small"
						href="https://www.linkedin.com/feed/" title="Linkedin"><i
						class="fa fa-linkedin"></i></a>
			</div>
		</footer>
	</div>
</body>
</html>