<%@page import="com.board.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<%
request.setCharacterEncoding("utf-8");
BoardDAO dao = BoardDAO.getInstance();
ArrayList<BoardDTO> arr = dao.boardList();
int count = dao.getCount();
%>
</head>

<body>
<h2>게시글 목록<%=count %></h2>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				 <td>제목</td>
				 <td>작성자</td>
				 <td>작성일</td>
				 <td>조회수</td>
		 	</tr>
 		</thead>
 
 <tbody>
 	<%
 	for(BoardDTO board: arr) {
	 %>
 <tr>
 <td><%=board.getNum() %></td>
 <td><a href="boardView.jsp?num=<%=board.getNum() %>"><%=board.getSubject() %></a></td>
 <td><%=board.getWriter() %></td>
 <td><%=board.getReg_date() %></td>
 <td><%=board.getReadcount() %></td>
 </tr>
 <%
 }
 %>
 </tbody>
</table>
</body>
</html>