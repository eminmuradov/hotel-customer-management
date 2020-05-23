<%@ page import="java.util.List" %>
<%@ page import="az.hotel.model.Customer" %>
<%@ page import="az.hotel.model.RoomName" %><%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 01-Mar-20
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">
    $(function () {
        $('#customerList').DataTable();
    });

</script>


<table id="customerList" class="display" style="width:100%;background-color: #666666;">
    <thead>
    <tr>
        <th style="color: white">Id</th>
        <th style="color: white">Name</th>
        <th style="color: white">Surname</th>
        <th style="color: white">Address</th>
        <th style="color: white">Email</th>
        <th style="color: white">Telephone</th>
        <th style="color: white">InDate</th>
        <th style="color: white">OutDate</th>
        <th style="color: white">Number of Room</th>
        <th style="color: white">Adults</th>
        <th style="color: white">Children</th>
        <th style="color: white">Type of Room</th>
        <th style="color: white">Price</th>
        <th style="color: white">Edit</th>

    </tr>
    </thead>
    <tbody>


    <c:forEach var="customer" items="${customers}">
        <tr>
            <td >${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.address}</td>
            <td>${customer.email}</td>
            <td>${customer.telephone}</td>
            <td>${customer.inDate}</td>
            <td>${customer.outDate}</td>
            <td>${customer.numberOfRoom}</td>
            <td>${customer.adults}</td>
            <td>${customer.children}</td>
            <td>${customer.typeofRoom}</td>
            <td>${customer.price}</td>
            <td><a href=" javascript:getCustomerIdInfo(${customer.id})"> Edit </a></td>
        </tr>
    </c:forEach>


    </tbody>
    <tfoot>
    <tr>
        <th style="color: white">Id</th>
        <th style="color: white">Name</th>
        <th style="color: white">Surname</th>
        <th style="color: white">Address</th>
        <th style="color: white">Email</th>
        <th style="color: white">Telephone</th>
        <th style="color: white">InDate</th>
        <th style="color: white">OutDate</th>
        <th style="color: white">Number of Room</th>
        <th style="color: white">Adults</th>
        <th style="color: white">Children</th>
        <th style="color: white">Type of Room</th>
        <th style="color: white">Price</th>
        <th style="color: white">Edit</th>


    </tr>
    </tfoot>
</table>

