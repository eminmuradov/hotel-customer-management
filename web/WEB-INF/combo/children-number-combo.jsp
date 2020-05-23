<%@ page import="java.util.List" %>
<%@ page import="az.hotel.model.ChildrenNumber" %><%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 01-Mar-20
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<ChildrenNumber> childrenNumbers= (List<ChildrenNumber>) request.getAttribute("childrenNumbers");%>
<option>Select</option>
<%for (ChildrenNumber childrenNumber:childrenNumbers){%>
<option value="<%=childrenNumber.getId()%>"><%=childrenNumber.getNumberOfChildren()%></option>

<%}%>