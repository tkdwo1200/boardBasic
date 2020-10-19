<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form action="boardWrite.do" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="boardContent"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boardWriter"></td>
			</tr>
		</table>
		<input type="submit" value="확인">
	</form>
</div>
</body>
</html>