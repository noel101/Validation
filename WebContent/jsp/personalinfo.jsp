<!DOCTYPE html>
<html>
<body>


	<form method="get" action="/Validation/PersonalInfoServlet">

		<%
			Object obj = request.getAttribute("errors");
			String errorMsg = "";
			if (obj != null) {
				errorMsg = (String) obj;
			}
		%>

		<font color=red size=6> <%=errorMsg%>
		</font> First name:<br> <input type="text" name="firstname" value="">
		<br> Last name:<br> <input type="text" name="lastname"
			value=""> <br>
		<br> <input type="radio" name="gender" value="male"> Male<br>
		<input type="radio" name="gender" value="female"> Female<br>
		<input type="radio" name="gender" value="other"> Other <br>
		<br> <input type='submit' value="submit"></input> <br>
	</form>

	<p>Click on submit to go to contact info".</p>

</body>
</html>