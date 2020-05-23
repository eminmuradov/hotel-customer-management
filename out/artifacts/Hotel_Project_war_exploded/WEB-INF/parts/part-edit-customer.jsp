<%@ page import="az.hotel.model.Customer" %>
<%@ page import="java.beans.SimpleBeanInfo" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="az.hotel.model.RoomNumber" %><%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 02-Mar-20
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
%>
<script type="text/javascript">

    $(function () {
        $("#editCustomerDialog").dialog({
            autoOpen: false,
            resizable: false,
            height: "auto",
            width: 400,
            modal: true,
            buttons: {
                Delete: function () {
                    deleteCustomer();
                    $(this).dialog("close");
                    loadCustomerList();
                },
                Save: function () {
                    updateCustomerInfo();
                    $(this).dialog("close");
                    loadCustomerList();

                },
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });
    });
    $(function () {
        $("#editTabs").tabs();
        getRoomNumber(<%=customer.getNumberOfRoom()%>);
        getChildrenNumber(<%=customer.getChildren()%>);
        getAdultNumber(<%=customer.getAdults()%>);
        getRoomName(<%=customer.getTypeofRoom()%>);

        $(function () {
            $("#editInDate").datepicker();
            $("#anim").on("change", function () {
                $("#editInDate").datepicker("option", "showAnim", "clip");
            });
        });
        $(function () {
            $("#editOutDate").datepicker();
            $("#anim").on("change", function () {
                $("#editOutDate").datepicker("option", "showAnim", "clip");
            });
        });
    });
    function getRoomNumber(numberOfRoom) {
        $.ajax({
            url: 'controller?action=getRoomNumber',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                $('#editNumberOfRoom').html(data)
                $('#editNumberOfRoom').val(numberOfRoom)
            }
        })
    }
    function getAdultNumber(numberOfAdults) {
        $.ajax({
            url: 'controller?action=getAdultNumber',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                $('#editNumberOfAdults').html(data);
                $('#editNumberOfAdults').val(numberOfAdults);
            }
        })
    }
    function getChildrenNumber(numberOfChildren) {
        $.ajax({
            url: 'controller?action=getChildrenNumber',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                $('#editNumberOfChildren').html(data);
                $('#editNumberOfChildren').val(numberOfChildren);
            }
        })
    }

    function getRoomName(roomId) {
        $.ajax({
            url: 'controller?action=getRoomName',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                $('#editRoomType').html(data);
                $('#editRoomType').val(roomId);
            }
        })
    }


</script>
<div id="editTabs">
    <ul>
        <li><a href="#tabs-1edit">Registration</a></li>
        <li><a href="#tabs-2edit">Customer Information</a></li>
    </ul>
    <div id="tabs-1edit">
        InDate: <input id="editInDate" value="<%=dateFormat.format(customer.getInDate())%>" type="text"
                       style="width: 190px;height: 25px;margin-left: 138px;margin-top: -22px"/><br><br>
        OutDate:<input id="editOutDate" value="<%=dateFormat.format(customer.getOutDate())%>" type="text"
                       style="width: 190px;height: 25px;margin-left: 138px;margin-top: -22px"><br><br>
        Number of Room:<select id="editNumberOfRoom"
                               style="width: 190px;height: 25px;margin-left: 138px;margin-top: -20px"></select><br><br>
        Adults:<select id="editNumberOfAdults"
                       style="width: 190px;height: 25px;margin-left: 138px;margin-top: -21px"></select><br><br>
        Children:<select id="editNumberOfChildren"
                         style="width: 190px;height: 25px;margin-left: 138px;margin-top: -21px"></select><br><br>
        Type of Room:<select id="editRoomType"
                             style="width: 190px;height: 25px;margin-left: 138px;margin-top: -21px"></select><br><br>

    </div>
    <div id="tabs-2edit">
        Name:<input id="editName" value="<%=customer.getName()%>" type="text"
                    style="width: 190px;height: 25px;margin-left: 41px"><br><br>
        Surname:<input id="editSurname" value="<%=customer.getSurname()%>" type="text"
                       style="width: 190px;height: 25px;margin-left: 20px"><br><br>
        Address:<input id="editCustomerAddress" value="<%=customer.getAddress()%>" type="text"
                       style="width: 190px;height: 25px;margin-left: 26px"><br><br>
        Email:<input id="editEmail" value="<%=customer.getEmail()%>" type="text"
                     style="width: 190px;height: 25px;margin-left: 45px"><br><br>
        Telephone:<input id="editTelephone" value="<%=customer.getTelephone()%>" type="text"
                         style="width: 190px;height: 25px;margin-left: 12px"><br><br>
        Price:<input id="editPrice" value="<%=customer.getPrice()%>" type="text"
                     style="width: 190px;height: 25px;margin-left: 50px"><br><br>
    </div>

</div>