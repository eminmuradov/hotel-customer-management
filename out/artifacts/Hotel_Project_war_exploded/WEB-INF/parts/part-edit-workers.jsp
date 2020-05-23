<%@ page import="az.hotel.model.Workers" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 06-Mar-20
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Workers worker = (Workers) request.getAttribute("worker");
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
%>


<script type="text/javascript">

    $(function () {
        $("#editWorkerDialog").dialog({
            autoOpen: false,
            resizable: false,
            height: "auto",
            width: 400,
            modal: true,
            buttons: {
                Delete: function () {
                    deleteWorker();
                    $(this).dialog("close");
                    loadWorkersList();
                },
                Save: function () {
                    updateWorkerInfo();
                    $(this).dialog("close");
                    loadWorkersList();
                },
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });
    });
    $(function () {
        $("#editTabs").tabs();
    });
    $(function () {
        $("#editWorkerDob").datepicker();
        $("#anim").on("change", function () {
            $("#editWorkerDob").datepicker("option", "showAnim", "clip");
        });
    });
</script>

<div id="editTabs">
    <ul>
        <li><a href="#tabs-1">Worker Information</a></li>
    </ul>
    <div id="tabs-1">


        Name:<input class="workerInputsStyle" style="margin-left:55px;" id="editWorkerName"
                    type="text" value="<%=worker.getName()%>"/><br><br>

        Surname:<input class="workerInputsStyle" style="margin-left:33px;" id="editWorkerSurname"
                       type="text" value="<%=worker.getSurname()%>"/><br><br>

        Address: <input class="workerInputsStyle" style="margin-left:36px;" id="editWorkerAddress"
                        type="text" value="<%=worker.getAddress()%>"/><br><br>

        Date of Birth:<input class="workerInputsStyle" style="margin-left:10px;" id="editWorkerDob"
                             type="text" value="<%=dateFormat.format(worker.getDob())%>"/><br><br>

        Email:<input class="workerInputsStyle" style="margin-left:59px;" id="editWorkerEmail"
                     type="text" value="<%=worker.getEmail()%>"/><br><br>

        Telephone:<input class="workerInputsStyle" style="margin-left:25px;" id="editWorkerTel"
                         type="text" value="<%=worker.getTelephone()%>"/><br><br>

        Position: <input class="workerInputsStyle" style="margin-left:37px;" id="editWorkerPosition"
                         type="text" value="<%=worker.getPosition()%>"/><br><br>

    </div>

</div>








