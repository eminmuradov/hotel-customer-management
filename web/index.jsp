<%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 28.03.2020
  Time: 02:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta>
    <title>Hotel</title>
    <script type="text/javascript" src="resources/JS/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="resources/JS/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="resources/JS/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="resources/JS/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="resources/JS/jquery-ui.js"></script>
    <script type="text/javascript" src="resources/JS/index.js"></script>


    <link rel="stylesheet" href="resources/CSS/jquery.dataTables.min.css">
    <link rel="stylesheet" href="resources/CSS/jquery-ui.css">
    <link rel="stylesheet" href="resources/CSS/index.css">
</head>
<body style="margin: 0px;">
                                       <!--HEADER-->
<div class="header">
    <a href="tel:+994703040809"> <img class="telImg" id="headerTelImg" src="images/tel-icon.png"></a>
    <h3 class="h3style">(070)-304-08-09</h3>

    <a href="mailto:eminmurad97@gmail.com"><img class="mailImg" id="headerMailImg" src="images/mail-icon.png"></a>
    <h3 class="h3style">eminmurad97@gmail.com</h3>

    <a href="logout.jsp"><img id="exitImg" class="exitIcon" src="resources/image/1333_door-512.png"></a>

    <a href="https://www.facebook.com/emin.muradov.501?ref=bookmarks" target="_blank">
        <img class="facebookImg" id="headerFacebookImg" src="images/fb-icon.png"> </a>

    <a href="tel:+994703040809"><img class="whatsappImg" id="headerWhatsappImg" src="images/whatsapp.png"></a>
</div>

<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
<!--MENU-->

<div class="menu">
    <h2 id="h2styleHotel"><a style=" text-decoration:none;" href="index.jsp"> Hotel </a></h2>
    <button id="customerBtn" type="button" onclick="clickCustomerBtn()">Customer</button>
    <button id="workersBtn" type="button" onclick="clickWorkersBtn()">Workers</button>
    <button id="roomsBtn" type="button" onclick="clickRooms()">Rooms</button>

</div>
<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
<!--CONTENT-->
<div id="content" class="content"><br><br>

    <div style="display:none;margin-top: -35px;margin-left: 10px;width: 190px;" id="advancedSearchAccordion">
        <h3>Advanced Search</h3>
        <div style="width: 675px;margin-left: 2px;">
            InDate:<input id="adv-search-inDate" type="text">&nbsp;
            OutDate:<input id="adv-search-outDate" type="text">&nbsp;<br><br>
            Number of Room:<select id="adv-search-roomNumber"></select>&nbsp;
            Type of Room:<select id="adv-search-roomName"></select><br><br>
            <input style="background-color: lightgreen" id="advSearchCustomer" type="button" value="Search"
                   onclick="getAdvSearchCustomer()">
            <input style="margin-left: 50px;background-color: #007fff" id="allCustomerList" type="button"
                   value="All List" onclick="getAllList()">
        </div>
        <br><br>
    </div>

    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
    <div id="addCustomerPage"></div>
    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                                    <%--FileUplod--%>
    <form style="display: none" id="fileUploadForm" action="upload" method="post" enctype="multipart/form-data">
        <input style="width: 200px;height: 30px;color: white;" type="file" name="file"/><br>
        <input type="text" name="fileName"/>
        <input style="height: 30px; width: 100px;background-color: chartreuse;" type="submit" value="Upload"/><br>
    </form>

    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                               <!--Add Worker Button-->
    <input id="addWorkerBtn" style="display: none" type="submit" value="Add Worker"/><br><br>
    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->


    <div id="addWorkersDialog" title="Add Worker">
        <div id="addWorkerTabs">
            <ul>
                <li><a href="#tabs-1">Add Worker</a></li>

            </ul>
            <div id="tabs-1">
                Name:<input class="workerInputsStyle" style="margin-left:55px;" id="workerName"
                            type="text"/><br><br>

                Surname:<input class="workerInputsStyle" style="margin-left:33px;" id="workerSurname"
                               type="text"/><br><br>

                Address: <input class="workerInputsStyle" style="margin-left:36px;" id="workerAddress"
                                type="text"/><br><br>

                Date of Birth:<input class="workerInputsStyle" style="margin-left:10px;" id="workerDob"
                                     type="text"/><br><br>

                Email:<input class="workerInputsStyle" style="margin-left:59px;" id="workerEmail"
                             type="text"/><br><br>

                Telephone:<input class="workerInputsStyle" style="margin-left:25px;" id="workerTel"
                                 type="text"/><br><br>

                Position: <input class="workerInputsStyle" style="margin-left:37px;" id="workerPosition"
                                 type="text"/><br><br>
            </div>

        </div>

    </div>

    <div id="editCustomerDialog" title="Edit Customer"></div>
    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
    <div id="editWorkerDialog" title="Edit Worker"> </div>

    <div style="display: none" id="workersTablePanel"></div>

    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
    <br>
    <div style="display: none" id="customerPanel">
        <div id="simple-search-panel">
            <input placeholder="Search..." id="simple-search-input">
        </div>
        <br><br>
        <div style="display: none" id="customerTablePanel"></div>

    </div>


    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

    <div style="display: none" id="roomsView">
        <img style=" float:left;width: 425px; height: 250px;margin-left: 10px;" src="images/King-Room.jpg">
        <h3 style="margin-left: 30px;font-size: 25px;color: white;margin-top: 15px;float: left;">
            King-Room<br>
            400$ / Day <br>
            Size: 30 ft<br>
            Capacity:Max persion 5<br>
            Bed: King beds<br>
            Services: Wifi, television ...</h3>

        <img style=" float: left;width: 425px;height: 250px; margin-left: -739px;margin-top: 261px;"
             src="images/Sea-Room.jpg">
        <h3 style="margin-left: -281px;font-size: 25px;color: white;margin-top: 278px;float: left;">
            Sea-Room<br>
            600$ / Day <br>
            Size: 50 ft<br>
            Capacity:Max persion 3<br>
            Bed: King beds<br>
            Services: Wifi, television ...</h3>
        <img style=" float: left;width: 425px;height: 250px; margin-left: -744px;margin-top: 526px;"
             src="images/Small-Room.jpg">
        <h3 style="margin-left: -281px;font-size: 25px;color: white;margin-top: 543px;float: left;">
            Small-Room<br>
            800$ / Day <br>
            Size: 60 ft<br>
            Capacity:Max persion 2<br>
            Bed: King beds<br>
            Services: Wifi, television ...</h3>
    </div>

</div>

<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

                                    <!--FOOTER-->
<div class="footer">
    <a href="tel:+994703040809"> <img class="telImg" id="footerTelImg" src="images/tel-icon.png"></a>
    <h4 class="h3style">(070)-304-08-09</h4>

    <a href="mailto:eminmurad97@gmail.com"><img class="mailImg" id="footerMailImg" src="images/mail-icon.png"></a>
    <h4 class="h3style">eminmurad97@gmail.com</h4>

    <a href="https://www.facebook.com/emin.muradov.501?ref=bookmarks" target="_blank">
        <img class="facebookImg" id="facebookimg" src="images/fb-icon.png"> </a>

    <a href="tel:+994703040809"><img class="whatsappImg" id="footerWhatsappImg" src="images/whatsapp.png"></a>
    <h3 style="margin-top: 9px;margin-right: 407px;float: right;color: white">Copyright © Emin Muradov </h3>
</div>
</body>
</html>
