<!DOCTYPE html>
<html>
<body>

	<form method="post" action='/Validation/ContactInfoServlet'>

		<%
			Object obj = request.getAttribute("errors");
			String errorMsg = "";
			if (obj != null) {
				errorMsg = (String) obj;
			}
		%>
		<font color=red size=6> <%=errorMsg%> </font>
		Address:<br> <input
			type="text" name="address" value=""> <br> City:<br>
			<input type="text" name="city" value=""> <br> State:<br>
			<input type="text" name="state" value=""> <br> Country:<br>
			<input type="text" name="country" value=""> <br> Phone:<br>
			<input type="text" name="phone" value=""> <br> <br>

			<input type="submit" value="Submit">
	</form>

	<p>Click on submit to go to Bank info".</p>

</body>
</html>