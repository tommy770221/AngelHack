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
<form method="post"  action="${pageContext.request.contextPath}/accessCondition">
	<table>
		<tr>
			<th colspan="2">Add MemberUser</th>
		</tr>
		<tr>
			<input type="hidden" name="email" />
			<td><label path="gender">gender:</label></td>
			<select name="gender">
				<option selected="selected" value="" label="--select gender--">--select gender--</option>
				<option value="female" label="female">female</option>
				<option value="male" label="male">male</option>
			</select>
		</tr>


		<tr>
			<td><label path="locale">locale:</label></td>
			<select name="locale">
				<option selected="selected" value="" label="--select locale--">--select locale--</option>
				<option value="zh_TW" label="zh_TW">zh_TW</option>
				<option value="zh_CN" label="zh_CN">zh_CN</option>
				<option value="en_US" label="en_US">en_US</option>
				<option value="fr_FR" label="fr_FR">fr_FR</option>
				<option value="it_IT" label="it_IT">it_IT</option>
				<option value="ja_JP" label="ja_JP">ja_JP</option>
				<option value="ko_KR" label="ko_KR">ko_KR</option>
			</select>
		</tr>

			<tr>
			<td><label path="ageRange">ageRange:</label></td>
				<select name="ageRange">
					<option selected="selected" value="" label="--select ageRange--">--select ageRange--</option>
					<option value="11" label="11 to 20">11 to 20</option>
					<option value="21" label="21 to 30">21 to 30</option>
					<option value="31" label="31 to 40">31 to 40</option>
					<option value="41" label="41 to 50">41 to 50</option>
					<option value="51" label="51 to 60">51 to 60</option>
					<option value="61" label="61 to 70">61 to 70</option>
				</select>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
								   class="blue-button" /></td>
		</tr>
	</table>
</form>
</br>
</body>
</html>
