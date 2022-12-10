<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

RequestDispatcher dis = 
request.getRequestDispatcher("WEB-INF/view/main.jsp");
dis.forward(request,response);

%>