function addMember()
{
	var title=document.getElementById("title").value;
	var userId=document.getElementById("userId").value;
	if(userId==="")
	{
		alert("Please Enter User Id");
		hasError=true;
	}
	if(title==="")
	{
		alert("Please Enter Title");
		hasError=true;
	}
}