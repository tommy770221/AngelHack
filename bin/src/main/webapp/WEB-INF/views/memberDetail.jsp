<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-social/bootstrap-social.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<div class="container">
		<form method="post" modelAttribute="memberUser" action="${pageContext.request.contextPath}/addMember">
            <div class="form-group">
				<h2 class='col-sm-12 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-2'>Add MemberUser</h2>
			</div>
			<div class="form-group">
				<label for="gender">gender</label>
				<input type="text" class="form-control" name="gender" value="${memberUser.gender}">
			</div>	.
			<div class="form-group">
				<label for="name">name</label>
				<input type="text" class="form-control" name="name">
			</div>	
			<div class="form-group">
				<label for="locale">locale</label>
				<input type="text" class="form-control" name="locale">
			</div>	
			<div class="form-group">
				<label for="email">email</label>
				<input type="text" class="form-control" name="email">
			</div>	
			<div class="form-group">
				<label for="ageRange">ageRange</label>
				<input type="text" class="form-control" name="ageRange">
			</div>
			<div class="form-group">
				<button class="btn btn-default" type="submit">submit</button>
			</div>
		</form>
	</div>
</body>
</html>
