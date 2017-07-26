<!DOCTYPE html>
<html>
<body>

	<form method="post" action='/Validation/BankInfoServlet'>
		<%
			Object obj = request.getAttribute("errors");
			String errorMsg = "";
			if (obj != null) {
				errorMsg = (String) obj;
			}
		%>

		<font color=red size=6> <%=errorMsg%>
		</font> Bank name:<br> <input type="text" name="bankname" value="">
		<br> Account #:<br> <input type="text" name="accountname"
			value=""> <br> SSN:<br> <input type="text"
			name="ssn" value=""> <br> <br> <input type="submit"
			value="Submit">
	</form>

	<p>Click on submit".</p>

</body>
</html>