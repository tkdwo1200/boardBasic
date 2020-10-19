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
			<td><input type="text" value="${vo.boardContent }"></td>
		</tr>
	</table>
</div>
<div align="center">
	<a href="deleteBoard.do?boardTitle=${vo.boardTitle }">삭제</a> &nbsp;&nbsp;&nbsp;
	<a href="updateBoardForm.do?boardTitle=${vo.boardTitle }">수정</a>
</div>

</body>
</html>