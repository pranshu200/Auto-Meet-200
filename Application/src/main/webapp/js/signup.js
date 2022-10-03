function adduser()
{
	var userName=document.getElementById("userName").value;
	var email=document.getElementById("email").value;
	var phone=document.getElementById("phone").value;
	var role=document.getElementById("role").value;
	var hasError=false;
	
	if(userName==="")
	{
		alert("Please Enter User Name");
		hasError=true;
	}
	if(email==="")
	{
		alert("Please Enter Email");
		hasError=true;
	}
	if(phone==="")
	{
		alert("Please Enter Phone Number");
		hasError=true;
	}
	if(role==="")
	{
		alert("Please Enter Role(Admin/ Manager/ Member");
		hasError=true;
	}
}