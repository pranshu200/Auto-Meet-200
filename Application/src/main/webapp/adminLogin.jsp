<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="model.Users,service.RoomDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MeetingRoom"%>
<%@page import="service.AdminService"%>

<!DOCTYPE html>
<html lang="en">
<title>Auto Meet 200 | Admin</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="shortcut icon" href="favicon.png">
<link rel="stylesheet" href="fonts/style.css">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins Regular", sans-serif}

body {
	font-size: 16px;
}
html {
  background: url(img/26.jpg) no-repeat center center fixed;
  background-size: cover;
}
</style>
<%
  		session=request.getSession(false);
   		Users u = (Users) session.getAttribute("userOb");
     	 if (u == null || session==null|| !u.getRole().equalsIgnoreCase("admin")) {
     		 session.invalidate();
    	%>
<script type="text/javascript">
	//alert('Access Denied !!');
	location = "index.jsp";
</script>

<%  
      }
    	  
      else{
       
    %>
<body>



	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding"
		style="z-index: 3; width: 300px; font-weight: bold;" id="mySidebar">
		<br> <a href="javascript:void(0)" onclick="w3_close()"
			class="w3-button w3-hide-large w3-display-topleft"
			style="width: 100%; font-size: 22px">Close Menu</a>
		<div class="w3-container">
			<h3 class="w3-padding-64">
				<b><%=u.getUserName()%>
				</b>
			</h3>
		</div>
		<div class="w3-bar-block">
			<a href="#" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
			<a href="#catalogue" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Room Catalogue</a>
			 <a
				href="#contact" onclick="w3_close()"
				class="w3-bar-item w3-button w3-hover-white">Create Room</a> 
				<a
				href="#show" onclick="w3_close()"
				class="w3-bar-item w3-button w3-hover-white">Show Users</a>
				<a
				href="#upload" onclick="w3_close()"
				class="w3-bar-item w3-button w3-hover-white">Add Users</a> <a
				href="logout.jsp" onclick="w3_close()"
				class="w3-bar-item w3-button w3-hover-white">Logout</a>
		</div>
	</nav>

	<!-- Top menu on small screens -->
	<header
		class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
		 <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">☰</a> <span><%=u.getUserName()%></span>
	</header>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large" onclick="w3_close()"
		style="cursor: pointer" title="close side menu" id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 340px; margin-right: 40px">

		<!-- Header -->
		<h1 class="w3-xxxlarge w3-text-red">
			<b>Welcome <%=u.getUserName()%></b>
		</h1>
		
		<h3 class="w3-left" style="color: grey"><%=u.getEmail()%><br>Last Login : <%=u.getLastLoggedIn()%><br>
		</h3>
		<!--  Room Table -->
		<div class="w3-container" id="catalogue" style="margin-top: 95px">
			<h1 class="w3-xxxlarge w3-text-red">
				<b>Room Catalogue</b>
			</h1>
			<hr style="width: 50px; border: 5px solid red" class="w3-round">
		</div>


		<div class="w3-row-padding">
			<%
	RoomDetails rs=new RoomDetails();
	ArrayList rl=(ArrayList)rs.getRoomList();
	
	%>
			<div class="w3-center">
				<ul class="w3-ul w3-light-grey w3-center">
					<li class="w3-red w3-xlarge w3-padding-32">List of Rooms</li>
				
						
							<div style="overflow-y: auto; max-height:400px;">
							<table class="w3-table w3-striped w3-bordered w3-border w3-hoverable">
							<tr>
							<td class="w3-grey">Room Name</td>
							<td class="w3-grey">Capacity</td>
								<td class="w3-grey">Cost Per Hour<br>(Credits)</td>
								<td class="w3-grey">Room Types Supported</td>
								</tr>
							
							<%for(int i=0;i<rl.size();i++){
	    							MeetingRoom m=(MeetingRoom)rl.get(i); %>
							<tr>
								<td><%=m.getRoomName()%></td>
								<td ><%=m.getCapacity() %></td>
								<td><%=m.getPerHourCost() %></td>
										<%ArrayList<String> types=(ArrayList)rs.typeList(m.getRoomName());
										String rtype="";
										for(String t:types){
											rtype+=t+", ";
										}
										rtype= rtype.replaceAll(", $","");
											%>
										
										<td ><%=rtype %> </td>
							</tr>  

							<%} %>
						</table>
					</div>
				</ul>
			</div>
		</div>

		<!-- Create Room -->
		<div class="w3-container" id="contact" style="margin-top: 75px">
			<h1 class="w3-xxxlarge w3-text-red">
				<b>Create Room</b>
			</h1>
			<hr style="width: 50px; border: 5px solid red" class="w3-round">
			<form action="AdminController" method="post"
				onSubmit="return checksubmit();">
				<div class="w3-section">
					<label>Room Name</label> <input class="w3-input w3-border"
						type="text" name="name" id="name" onKeyUp="checkname()" required
						autocomplete="off">
					<div id="checkname" align="center"></div>
					<br> <label>Seating Capacity</label> <input
						class="w3-input w3-border" type="text" name="seats" id="seats"
						onKeyUp="checkseats()" required autocomplete="off">
					<div id="checkseats" align="center"></div>
					<br>
				</div>
				<div class="w3-section w3-large">
					<label>Amenities - Select all that apply :</label>
					<div id="amenities">
						<input class="w3-check" type="checkbox" name="amenities"
							value="Projector" onclick="ValidateSelection();">
						Projector <br> <input class="w3-check" type="checkbox"
							name="amenities" value="Wifi Connection"
							onclick=" ValidateSelection();"> WiFi Connection<br>
						<input class="w3-check" type="checkbox" name="amenities"
							value="Whiteboard" onclick="ValidateSelection();">
						Whiteboard<br> <input class="w3-check" type="checkbox"
							name="amenities" value="Water Dispenser"
							onclick="ValidateSelection();"> Water Dispenser<br>
						<input class="w3-check" type="checkbox" name="amenities"
							value="TV" onclick="ValidateSelection();"> Television<br>
						<input class="w3-check" type="checkbox" name="amenities"
							value="Coffee Machine" onclick="ValidateSelection();">
						Coffee machine<br> <input class="w3-check" type="checkbox"
							name="amenities" value="Conference Call"
							onclick="ValidateSelection();"> Conference Call<br>
						<div id="amenitieserr" align="center"></div>
					</div>
				</div>
				<button id="submit" name="submit" type="submit" value="create room"
					class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">Create
					Room</button>
			</form>


<!-- Users Table -->

<div class="w3-container" id="show" style="margin-top: 75px">
			<h1 class="w3-xxxlarge w3-text-red">
				<b> Users List</b>
			</h1>
			<hr style="width: 50px; border: 5px solid red" class="w3-round">

		<div class="w3-row-padding">
			<%

			AdminService as=new AdminService();
			ArrayList<Users> ul=(ArrayList)as.userList();
	
			%>
			<div class="w3-center">
				<ul class="w3-ul w3-light-grey w3-center">
					<li class="w3-red w3-xlarge w3-padding-32">List of Users</li>
				
						
							<div style="overflow-y: auto; max-height:400px;">
							<table class="w3-table w3-striped w3-bordered w3-border w3-hoverable">
							<tr>
							<td class="w3-grey">User Name</td>
							<td class="w3-grey">Email Id</td>
								<td class="w3-grey">Phone Number</td>
								<td class="w3-grey">Role</td>
								</tr>
							
							<%for(Users u1:ul){
								if(!u1.getUserName().equals(u.getUserName())){
	    						%>
							<tr>
								<td><%=u1.getUserName()%></td>
								<td ><%=u1.getEmail() %></td>
								<td><%=u1.getPhone() %></td>
								<td><%= u1.getRole()%></td>		
							</tr>

							<%}} %>
						</table>
					</div>
				</ul>
			</div>
		</div>
		</div>

		<!-- Upload users -->
		<div class="w3-container" id="upload" style="margin-top: 75px">
			<h1 class="w3-xxxlarge w3-text-red">
				<b>Add Users.</b>
			</h1>
			<hr style="width: 50px; border: 5px solid red" class="w3-round">
			<p>Upload the json file containing user records to be inserted
				into database.</p>
			<form action="add_users" method="post" enctype="multipart/form-data">
				<input class="w3-input w3-border" type="file" name="myFile" accept="application/JSON" required />
				<button type="submit" name="submit" value="insert data"
					class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">Upload
					File</button>
			</form>
		</div>

		<%
  }%>

		<!-- Footer -->
		<footer class="w3-center w3-dark-grey "
			style="width: 110%; margin-left: -40px; margin-top: 40px;">
			<a href="#" class="w3-button w3-black"><i class="w3-margin-right"></i>To
				the top</a>
			<div class="w3-large w3-section">
				Automated Meeting Room Booking System
				<h4>
					<i class="w3-xlarge w3-margin-right"></i>Need Help? Contact Us :
					&nbsp&nbsp&nbsp&nbsp <i class="w3-xlarge w3-margin-right"></i>Phone:&nbsp1221-63723
					&nbsp&nbsp&nbsp&nbsp <i class="w3-xlarge w3-margin-right"></i>Email:&nbsphelpdesk@amrbs.com
				</h4>
			</div>
		</footer>
	</div>

	<script>

		// Script to open and close sidebar
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("myOverlay").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("myOverlay").style.display = "none";
		}
		

		function getValue(){
			 t=document.getElementById("pageid");
			}
		function ValidateSelection() {
			var checkboxes = document.getElementsByName("amenities");
			var numberOfCheckedItems = 0;
			for (var i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].checked)
					numberOfCheckedItems++;
			}
			if (numberOfCheckedItems < 2) {
				document.getElementById('amenitieserr').innerHTML = "<font style=\"color: red\">*Please select atleast 2 amenities !</font>";
				return false;
			} else {
				document.getElementById('amenitieserr').innerHTML = "<font style=\"color: green\"></font>";
				return true;
			}
		}
		function checkname() {
			var name = document.getElementById("name").value;
			if (name == null || name == "") {
				document.getElementById('checkname').innerHTML = "<font style=\"color: red\">*Please Fill in the Full Name</font>";
				document.getElementById('name').style.border = 'red 1px solid';
				return false;
			} else if ((name.search(/[^_-0-9A-Za-z\s]/) != -1)) {
				document.getElementById('checkname').innerHTML = "<font style=\"color: red\">*Format Invalid</font>";
				document.getElementById('name').style.border = 'red 1px solid';
				return false;
			} else {
				document.getElementById('checkname').innerHTML = "<font style=\"color: green\"></font>";
				document.getElementById('name').style.border = 'grey 1px solid';
				return true;
			}
		}

		function checkseats() {
			var seats = document.getElementById("seats").value;

			if (isNaN(seats)) {
				document.getElementById('checkseats').innerHTML = "<font style=\"color: red\">*Format Invalid</font>";
				document.getElementById('seats').style.border = 'red 1px solid';
				return false;
			} else if (seats.length == 0) {
				document.getElementById('checkseats').innerHTML = "<font style=\"color: red\">*Format Invalid(0 seats)</font>";
				document.getElementById('seats').style.border = 'red 1px solid';
				return false;
			} else {
				document.getElementById('checkseats').innerHTML = "<font style=\"color: green\"></font>";
				document.getElementById('seats').style.border = 'grey 1px solid';
				return true;
			}
		}

		function clearfields() {
			document.getElementById('checkname').innerHTML = "";
			document.getElementById('fname').style.border = 'grey 1px solid';

			document.getElementById('checkseats').innerHTML = "";
			document.getElementById('seats').style.border = 'grey 1px solid';

		}
		function checksubmit() {
			var submit = document.getElementById("submit").value;
			var a = checkname();
			var b = checkseats();
			var c = ValidateSelection();
			if (a && b && c)
				return true;
			else
				return false;
		}
	</script>

</body>
</html>
