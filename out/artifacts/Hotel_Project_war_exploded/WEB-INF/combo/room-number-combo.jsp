<%@ page import="java.util.List" %>
<%@ page import="az.hotel.model.RoomNumber" %><%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 01-Mar-20
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<RoomNumber> roomNumbers = (List<RoomNumber>) request.getAttribute("roomNumbers");%>

<option value="0">Select</option>
<%for (RoomNumber roomNumber:roomNumbers){%>
<option value="<%=roomNumber.getId()%>"><%=roomNumber.getNumberofRoom()%></option>

<%}%>
