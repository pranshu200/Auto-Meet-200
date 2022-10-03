function createRoom()
{
	var roomName=document.getElementById("roomName").value;
	var userId=document.getElementById("userId").value;
	var date=document.getElementById("date").value;
	var startTime=document.getElementById("startTime").value;
	var endTime=document.getElementById("endTime").value;
	var credit=document.getElementById("credit").value;
	var title=document.getElementById("title").value;
	var type=document.getElementById("type").value;	
	if(roomName==="")
	{
		alert("Please Enter Room Name");
		hasError=true;
	}
	if(userId==="")
	{
		alert("Please Enter User Id");
		hasError=true;
	}
	if(date==="")
	{
		alert("Please Enter Date");
		hasError=true;
	}
	if(startTime==="")
	{
		alert("Please Enter Start Time");
		hasError=true;
	}
	if(endTime==="")
	{
		alert("Please Enter End Time");
		hasError=true;
	}
	if(credit=="")
	{
		alert("Please Enter Credit");
		hasError=true;
	}
	if(title==="")
	{
		alert("Please Enter Title");
		hasError=true;
	}
	if(type==="")
	{
		alert("Please Enter Meeting Type");
		hasError=true;
	}
}