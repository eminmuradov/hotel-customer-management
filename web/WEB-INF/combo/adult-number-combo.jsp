<%@ page import="java.util.List" %>
<%@ page import="az.hotel.model.AdultNumber" %><%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 01-Mar-20
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<AdultNumber> adultNumbers= (List<AdultNumber>) request.getAttribute("adultNumbers");%>
<option>Select</option>
<%for (AdultNumber adultNumber:adultNumbers){%>
<option value="<%=adultNumber.getId()%>" ><%=adultNumber.getNumberOfAdult()%></option>
<%}%>