<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validation output </title>
</head>
<body>
<h1><font color=red size=15> Registered Successfully. Output page after Validation</font></h1>

<table cellspacing ='5' border="0"> 
<tr>
<td align= "right"> First Name:</td> <td><c:out value="${pInfo.firstName}"/> </td>
</tr>

<tr>
<td align= "right"> Last Name:</td> <td><c:out value="${pInfo.lastName}"/> </td>
</tr>

<tr>
<td align= "right"> Gender:</td> <td><c:out value="${pInfo.gender}"/> </td>
</tr>

<tr>
<td align= "right"> Address:</td> <td><c:out value="${pInfo.address}"/> </td>
</tr>

<tr>
<td align= "right"> City:</td> <td><c:out value="${pInfo.city}"/> </td>
</tr>

<tr>
<td align= "right"> State:</td> <td><c:out value="${pInfo.state}"/> </td>
</tr>


<tr>
<td align= "right"> Country:</td> <td><c:out value="${pInfo.country}"/> </td>
</tr>

<tr>
<td align= "right"> Phone :</td> <td><c:out value="${pInfo.phone}"/> </td>
</tr>

<tr>
<td align= "right"> Bank Name:</td> <td><c:out value="${pInfo.bankName}"/> </td>
</tr>

<tr>
<td align= "right"> Account No:</td> <td><c:out value="${pInfo.accountNumber}"/> </td>
</tr>

<tr>
<td align= "right"> SSN :</td> <td><c:out value="${pInfo.ssn}"/> </td>
</tr>



</table>



</body>
</html>