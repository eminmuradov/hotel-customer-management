function clickCustomerBtn() {
    loadCustomerList();
    $('#customerTablePanel').show();
    $('#workersTablePanel').hide();
    $('#roomsView').hide();
    $('#addCustomerPage').hide()
    $('#saveCustomerBtn').hide();
    $('#customerPanel').show();
    $('#advancedSearchAccordion').show();
    $('#addWorkerBtn').hide();
    $('#fileUploadForm').hide();
}

function clickWorkersBtn() {
    loadWorkersList();
    $('#workersTablePanel').show();
    $('#customerTablePanel').hide();
    $('#roomsView').hide();
    $('#addCustomerPage').hide()
    $('#saveCustomerBtn').hide();
    $('#customerPanel').hide();
    $('#advancedSearchAccordion').hide();
    $('#addWorkerBtn').show();
    $('#fileUploadForm').show();

}

function clickRooms() {

    $('#roomsView').show();
    $('#customerTablePanel').hide();
    $('#workersTablePanel').hide();
    $('#addCustomerPage').hide()
    $('#saveCustomerBtn').hide();
    $('#customerPanel').hide();
    $('#advancedSearchAccordion').hide();
    $('#addWorkerBtn').hide();
    $('#fileUploadForm').hide();

}


function loadCustomerList() {
    $.ajax({
        url: 'controller?action=loadCustomerList',
        type: 'get',
        dataType: 'html',
        success: function (data) {
            $('#customerTablePanel').html(data)
        }
    })
}

function loadWorkersList() {
    $.ajax({
        url: 'controller?action=loadWorkersList',
        type: 'get',
        dataType: 'html',
        success: function (data) {
            $('#workersTablePanel').html(data)

        }
    })

}

<!--  ==========================ADD WORKER DIALOG=============================   -->
$(function () {
    $("#addWorkersDialog").dialog({
        background: true,
        autoOpen: false,
        resizable: false,
        height: "auto",
        width: 400,
        modal: true,
        buttons: {
            "Save": function () {
                addWorker();
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
    $("#addWorkerTabs").tabs();
});

$(function () {
    $("#workerDob").datepicker();
    $("#anim").on("change", function () {
        $("#workerDob").datepicker("option", "showAnim", "clip");
    });
});

<!--  ============================================================================   -->


$(function () {
    $('#addWorkerBtn').click("views/add-workers-views.jsp", function () {
        $('#addWorkersDialog').dialog('open');
    })
})

function addWorker() {
    var workerName = $('#workerName').val()
    var workerSurname = $('#workerSurname').val()
    var workerAddress = $('#workerAddress').val()
    var workerDob = $('#workerDob').val()
    var workerEmail = $('#workerEmail').val()
    var workerTel = $('#workerTel').val()
    var workerPosition = $('#workerPosition').val()

    $.ajax({
        url: 'controller?action=addWorker',
        type: 'post',
        dataType: 'text',
        data: {
            workerName: workerName,
            workerSurname: workerSurname,
            workerAddress: workerAddress,
            workerDob: workerDob,
            workerEmail: workerEmail,
            workerTel: workerTel,
            workerPosition: workerPosition,
        },
        success: function () {
            alert("Success")
        },
        error: function () {
            alert("Error")
        },
        Complete: function () {
            alert("Complete")
            loadWorkersList();
        }

    })
}





var globalWorkerId

function getWorkersIdInfo(workerId) {
    globalWorkerId = workerId;
    $.ajax({
        url: 'controller?action=getWorkersIdInfo',
        type: 'get',
        dataType: 'html',
        data: {
            workerId: workerId
        },
        success: function (data) {


            $('#editWorkerDialog').html(data);
            $('#editWorkerDialog').dialog('open')

        }

    })
}


function updateWorkerInfo() {
    var editWorkerName = $('#editWorkerName').val();
    var editWorkerSurname = $('#editWorkerSurname').val();
    var editWorkerAddress = $('#editWorkerAddress').val();
    var editWorkerDob = $('#editWorkerDob').val();
    var editWorkerEmail = $('#editWorkerEmail').val();
    var editWorkerTel = $('#editWorkerTel').val();
    var editWorkerPosition = $('#editWorkerPosition').val();
    globalWorkerId
    $.ajax({
        url: 'controller?action=updateWorkerInfo',
        type: 'post',
        dataType: 'text',
        data: {
            editWorkerName: editWorkerName,
            editWorkerSurname: editWorkerSurname,
            editWorkerAddress: editWorkerAddress,
            editWorkerDob: editWorkerDob,
            editWorkerEmail: editWorkerEmail,
            editWorkerTel: editWorkerTel,
            editWorkerPosition: editWorkerPosition,
            globalWorkerId: globalWorkerId
        }
    })
}

function deleteWorker() {
    globalWorkerId

    $.ajax({
        url: 'controller?action=deleteWorker',
        type: 'post',
        dataType: 'text',
        data: {
            globalWorkerId: globalWorkerId
        },
        success: function () {
            alert("Success")

        }

    })

}


$(function () {
    $('#addCustomerPage').load("views/add-customer-views.jsp", function () {
        getRoomNumber();
        getAdultNumber()
        getChildrenNumber();
        getRoomName();
    })
})


function saveCustomerInfo() {
    var name = $('#name').val();
    var surname = $('#surname').val();
    var customerAddress = $('#customerAddress').val();
    var email = $('#email').val();
    var telephone = $('#telephone').val();
    var inDate = $('#inDate').val();
    var outDate = $('#outDate').val();
    var numberOfRoom = $('#numberOfRoom').val();
    var numberOfAdults = $('#numberOfAdults').val()
    var numberOfChildren = $('#numberOfChildren').val();
    var roomType = $('#roomType').val();
    var price = $('#price').val();

    $.ajax({
        url: 'controller?action=saveCustomerInfo',
        type: 'post',
        dataType: 'text',
        data: {
            name: name,
            surname: surname,
            customerAddress: customerAddress,
            email: email,
            telephone: telephone,
            inDate: inDate,
            outDate: outDate,
            numberOfRoom: numberOfRoom,
            numberOfAdults: numberOfAdults,
            numberOfChildren: numberOfChildren,
            roomType: roomType,
            price: price
        },
        success: function () {
            alert("Success")

        },
        error: function () {
            alert("Error")

        }, complete: function () {
            alert("Complete")
        }

    })
}


var globalCustomerId;

function getCustomerIdInfo(customerId) {
    globalCustomerId = customerId;
    $.ajax({
        url: 'controller?action=getCustomerIdInfo',
        type: 'get',
        dataType: 'html',
        data: {
            customerId: customerId
        },
        success: function (data) {
            $('#editCustomerDialog').html(data);
            $('#editCustomerDialog').dialog('open')

        }
    })

}

function updateCustomerInfo() {
    var editName = $('#editName').val();
    var editSurname = $('#editSurname').val();
    var editAddress = $('#editCustomerAddress').val();
    var editEmail = $('#editEmail').val();
    var editTelephone = $('#editTelephone').val();
    var editInDate = $('#editInDate').val();
    var editOutDate = $('#editOutDate').val();
    var editNumberOfRoom = $('#editNumberOfRoom').val();
    var editNumberOfAdults = $('#editNumberOfAdults').val();
    var editNumberOfChildren = $('#editNumberOfChildren').val();
    var editRoomType = $('#editRoomType').val();
    var editPrice = $('#editPrice').val();
    globalCustomerId;
    $.ajax({
        url: 'controller?action=updateCustomerInfo',
        type: 'post',
        dataType: 'text',
        data: {

            editName: editName,
            editSurname: editSurname,
            editAddress: editAddress,
            editEmail: editEmail,
            editTelephone: editTelephone,
            editInDate: editInDate,
            editOutDate: editOutDate,
            editNumberOfRoom: editNumberOfRoom,
            editNumberOfAdults: editNumberOfAdults,
            editNumberOfChildren: editNumberOfChildren,
            editRoomType: editRoomType,
            editPrice: editPrice,
            globalCustomerId: globalCustomerId
        }
    })
}

function deleteCustomer() {
    globalCustomerId;
    $.ajax({
        url: 'controller?action=deleteCustomer',
        type: 'post',
        dataType: 'text',
        data: {
            globalCustomerId: globalCustomerId
        },
        success: function (data) {
            alert("Success")
        }
    })
}

$(function () {
    $('#simple-search-input').keyup(function () {
        var searchVal = $('#simple-search-input').val()
        console.log(searchVal)
        $.ajax({
            url: 'controller?action=getSimpleSearchCustomerList',
            type: 'get',
            dataType: 'html',
            data: {
                searchVal: searchVal
            }, success: function (data) {
                $('#customerTablePanel').html(data)
            }
        })
    })
})


function getRoomNumber() {
    $.ajax({
        url: 'controller?action=getRoomNumber',
        type: 'get',
        dataType: 'html',
        success: function (data) {
            $('#adv-search-roomNumber').html(data)

        }
    })
}

function getRoomName() {
    $.ajax({
        url: 'controller?action=getRoomName',
        type: 'get',
        dataType: 'html',
        success: function (data) {
            $('#adv-search-roomName').html(data);
        }
    })
}

function getAdvSearchCustomer() {

    var advSearchInDate = $('#adv-search-inDate').val();
    var advSearchOutDate = $('#adv-search-outDate').val();
    var advSearchRoomNumber = $('#adv-search-roomNumber').val()
    var advSearchRoomName = $('#adv-search-roomName').val();

    $.ajax({
        url: 'controller?action=getAdvSearchCustomer',
        type: 'get',
        dataType: 'html',
        data: {
            advSearchInDate: advSearchInDate,
            advSearchOutDate: advSearchOutDate,
            advSearchRoomName: advSearchRoomName,
            advSearchRoomNumber: advSearchRoomNumber
        },
        success: function (data) {
            $('#customerTablePanel').html(data)
        }
    })

}

$(function () {
    $("#advancedSearchAccordion").accordion({
        collapsible: true,
        heightStyle: "content"
    });
    $(function () {
        loadCustomerList();
        getRoomNumber()
        getRoomName();
        $("#adv-search-inDate").datepicker();
        $("#anim").on("change", function () {
            $("#adv-search-inDate").datepicker("option", "showAnim", "clip");
        });
        $("#adv-search-outDate").datepicker();
        $("#anim").on("change", function () {
            $("#adv-search-outDate").datepicker("option", "showAnim", "clip");
        });
    });
});


function getAllList() {
    loadCustomerList();
    $('#adv-search-inDate').val(null);
    $('#adv-search-outDate').val(null);
    $('#adv-search-roomNumber').val(null);
    $('#adv-search-roomName').val(null);

}







