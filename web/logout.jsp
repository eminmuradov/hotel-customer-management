<%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 16-Mar-20
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
request.getSession().invalidate();
request.getSession().removeAttribute("login");
response.sendRedirect("login.jsp");
%>
