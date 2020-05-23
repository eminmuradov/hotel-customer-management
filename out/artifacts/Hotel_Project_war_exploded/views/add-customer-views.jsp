<%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 01-Mar-20
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        $("#tabs").tabs();
        $(function () {
            $("#inDate").datepicker();
            $("#anim").on("change", function () {
                $("#inDate").datepicker("option", "showAnim", "clip");
            });
        });
        $(function () {
            $("#outDate").datepicker();
            $("#anim").on("change", function () {
                $("#outDate").datepicker("option", "showAnim", "clip");
            });
        });
    });
    function getRoomNumber() {
        $.ajax({
            url: 'controller?action=getRoomNumber',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                $('#numberOfRoom').html(data)

            }
        })
    }

    function getAdultNumber() {
        $.ajax({
            url: 'controller?action=getAdultNumber',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                $('#numberOfAdults').html(data);
            }
        })
    }

    function getChildrenNumber() {
        $.ajax({
            url: 'controller?action=getChildrenNumber',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                $('#numberOfChildren').html(data);
            }
        })

    }

    function getRoomName() {
        $.ajax({
            url: 'controller?action=getRoomName',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                $('#roomType').html(data);
            }
        })
    }

</script>
<div id="tabs" >
    <ul style="background: none; border: none">
        <li><a href="#tabs-1">Registration</a></li>
        <li><a href="#tabs-2">Customer Information</a></li>
    </ul>
    <div id="tabs-1">
       <label style="color: white"> InDate:</label> <input id="inDate" type="text" style="width: 190px;height: 25px;margin-left: 80px"/>&nbsp;
        <label style="color: white" class="tab1margin"> OutDate:</label><input id="outDate" type="text" style="width: 190px;height: 25px;margin-left: 72px"><br><br><br>
        <label style="color: white"> Number of Room:</label><select id="numberOfRoom" style="width: 190px;height: 25px;margin-left: 10px"></select>&nbsp;
        <label style="color: white" class="tab1margin"> Adults:</label><select id="numberOfAdults" style="width: 190px;height: 25px;margin-left: 87px"></select><br><br><br>
        <label style="color: white"> Children:</label><select id="numberOfChildren" style="width: 190px;height: 25px;margin-left: 72px"></select>&nbsp;
        <label style="color: white" class="tab1margin"> Type of Room:</label><select id="roomType" style="width: 190px;height: 25px;margin-left: 32px"></select><br><br><br>

    </div>
    <div id="tabs-2">
        <label style="color: white"> Name:</label><input id="name" type="text" style="width: 190px;height: 25px;margin-left: 41px">&nbsp;
        <label style="color: white" class="tab2margin"> Surname:</label> <input id="surname" type="text" style="width: 190px;height: 25px;margin-left: 20px"><br><br><br>
        <label style="color: white"> Address:</label><input id="customerAddress" type="text" style="width: 190px;height: 25px;margin-left: 26px">&nbsp;&nbsp;
        <label style="color: white" class="tab2margin"> Email:</label><input id="email" type="text" style="width: 190px;height: 25px;margin-left: 45px"><br><br><br>
        <label style="color: white"> Telephone:</label><input id="telephone" type="text" style="width: 190px;height: 25px;margin-left: 12px">&nbsp;&nbsp;
        <label style="color: white" class="tab2margin"> Price:</label><input id="price" type="text"style="width: 190px;height: 25px;margin-left: 50px"><br><br><br>

    </div>
<input id="reserveBtn" type="submit" onclick="saveCustomerInfo()" value="RESERVE">

</div>