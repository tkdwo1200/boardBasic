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
	<form action="boardUpdate.do" method="post">
	<input type="hidden" name="boardTitle" value="${vo.boardTitle }">
	<table border="1" style="width:800px;">
		<tr>
			<td>제목</td>
			<td><input type="text" value="${vo.boardTitle }" readonly></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" value="${vo.boardWriter }" readonly></td>
		</tr>
		<tr>
			<td>작성날짜</td>
			<td><input type="text" value="${vo.boardDate }" readonly></td>
		</tr>
		<tr>
			<td>작성내용</td>
			<td><input type="text" name="boardContent" value="${vo.boardContent }"></td>
		</tr>
	</table>
	<input type="submit" value="수정">
	</form>
</div>
</body>
</html>