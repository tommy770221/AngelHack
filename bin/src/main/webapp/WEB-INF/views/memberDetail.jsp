<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form:form method="post" modelAttribute="memberUser" action="${pageContext.request.contextPath}/addMember">
<table>
		<tr>
			<th colspan="2">Add MemberUser</th>
		</tr>
		<tr>
		<form:hidden path="fbId" />
          <td><form:label path="gender">gender:</form:label></td>
          <td><form:input path="gender"></form:input></td>
        </tr>
		<tr>
			<td><form:label path="name">name:</form:label></td>
            <td><form:input path="name"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="locale">locale:</form:label></td>
			<td><form:input path="locale"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="email">email:</form:label></td>
			<td><form:input path="email"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="ageRange">ageRange:</form:label></td>
			<td><form:input path="ageRange"></form:input></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
</body>
</html>
