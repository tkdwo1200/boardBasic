<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="height:30px;"></div>
<div align="center">
<form action="boardList.do" method="post">
	<table border="1" style="width:800px;">
		<tr>
			<td align="center">검색조건</td>
			<td align="center">
				<select style="width:98%;" name="searchKeyword">
					<option value="BOARD_TITLE">제목</option>
					<option value="BOARD_WRITER">작성자</option>
				</select>
			</td>
			<td align="center"><input type="text" style="width:98%" name="searchValue"></td>
			<td align="center"><input type="submit" value="검색" style="width:98%"></td>
		</tr>
	</table>
</form>
</div>
<div style="height:30px;"></div>
<div align="center">
	<table border="1" style="width:800px;">
		<tr>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td><a href="boardDetail.do?title=${board.boardTitle }">${board.boardTitle }</a></td>
				<td>${board.boardWriter }</td>
				<td>${board.boardDate }</td>
			</tr>
		</c:forEach>
	</table>
</div>
<div align="center">
	<a href="boardWrite.do">글쓰기</a>
	<a href="testpage.do">testpage</a>
</div>
</body>
</html>