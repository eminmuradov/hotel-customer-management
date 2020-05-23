<%@ page import="java.util.List" %>
<%@ page import="az.hotel.model.RoomName" %><%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 01-Mar-20
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<RoomName>roomNames= (List<RoomName>) request.getAttribute("roomNames");%>
<option value="0">Select</option>
<%for (RoomName roomName:roomNames){%>
<option value="<%=roomName.getId()%>"><%=roomName.getRoomName()%></option>

<%}%>