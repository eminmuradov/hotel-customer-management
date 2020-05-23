<%@ page import="java.util.List" %>
<%@ page import="az.hotel.model.Workers" %><%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 06-Mar-20
  Time: 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(function () {
        $('#workersList').DataTable();
    });

</script>



<table id="workersList" class="display" style="width:100%;background-color: #666666;">
    <thead>
    <tr>
        <th style="color: white">Id</th>
        <th style="color: white">Name</th>
        <th style="color: white">Surname</th>
        <th style="color: white">Address</th>
        <th style="color: white">Email</th>
        <th style="color: white">Telephone</th>
        <th style="color: white">Date of Birth</th>
        <th style="color: white">Position</th>
        <th style="color: white">Edit</th>
    </tr>
    </thead>
    <tbody>

<c:forEach var="worker" items="${workers}">
    <tr>
        <td>${worker.id}</td>
        <td>${worker.name}</td>
        <td>${worker.surname}</td>
        <td>${worker.address}</td>
        <td>${worker.email}</td>
        <td>${worker.telephone}</td>
        <td>${worker.dob}</td>
        <td>${worker.position}</td>
        <td><a href="javascript:getWorkersIdInfo(${worker.id})">Edit</a></td>
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
        <th style="color: white">Date of Birth</th>
        <th style="color: white">Position</th>
        <th style="color: white">Edit</th>



    </tr>
    </tfoot>
</table>

