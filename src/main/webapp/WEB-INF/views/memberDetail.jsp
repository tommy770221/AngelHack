<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	 <script src="${pageContext.request.contextPath}/resources/jquery/dist/jquery.min.js"></script>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/bootstrap.min.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/bootstrap-theme.min.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-social/bootstrap-social.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<form method="post"  action="${pageContext.request.contextPath}/accessCondition">
		<div class="form-group">
			<h2>Add MemberUser</h2>
		</div>
		<input type="hidden" name="email" />
	    <div class="form-group">
			<label for="gender">gender</label>
			<select name="gender" class='form-control'>
				<option selected="selected" value="" label="--select gender--">--select gender--</option>
				<option value="female" label="female">female</option>
				<option value="male" label="male">male</option>
			</select>
		</div>
		<div class="form-group">
			<label for="locale">locale</label>
			<select name="locale" class='form-control'>
				<option selected="selected" value="" label="--select locale--">--select locale--</option>
				<option value="zh_TW" label="zh_TW">zh_TW</option>
				<option value="zh_CN" label="zh_CN">zh_CN</option>
				<option value="en_US" label="en_US">en_US</option>
				<option value="fr_FR" label="fr_FR">fr_FR</option>
				<option value="it_IT" label="it_IT">it_IT</option>
				<option value="ja_JP" label="ja_JP">ja_JP</option>
				<option value="ko_KR" label="ko_KR">ko_KR</option>
			</select>
		</div>
		<div class="form-control">
			<label for="ageRange">ageRange</label>
			<select name="ageRange">
				<option selected="selected" value="" label="--select ageRange--">--select ageRange--</option>
				<option value="11" label="11 to 20">11 to 20</option>
				<option value="21" label="21 to 30">21 to 30</option>
				<option value="31" label="31 to 40">31 to 40</option>
				<option value="41" label="41 to 50">41 to 50</option>
				<option value="51" label="51 to 60">51 to 60</option>
				<option value="61" label="61 to 70">61 to 70</option>
			</select>
		</div>
		<input type="submit" class="btn btn-primary form-control" value='submit'/>	
	</form>

</body>
</html>
