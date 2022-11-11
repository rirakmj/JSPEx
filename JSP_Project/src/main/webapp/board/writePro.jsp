<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	request.setCharacterEncoding("utf-8");
 %>
 
<jsp:useBean id="bi" class="com.board.dto.BoardDTO"></jsp:useBean>
<jsp:setProperty property="*" name="bi"/>

<%
BoardDAO dao = BoardDAO.getInstance();
String ip=request.getRemoteAddr();
bi.setIp(ip);
dao.boardInsert(bi);
response.sendRedirect("list.jsp");
%>