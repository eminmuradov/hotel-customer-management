$(function () {
    $("#tabs").tabs();
});


$(function () {
    $("#dob").datepicker();
    $("#anim").on("change", function () {
        $("#dob").datepicker("option", "showAnim", "clip");
    });
});

function signUp() {
    var name = $('#name').val()
    var surname = $('#surname').val()
    var dob = $('#dob').val()
    var username = $('#username').val()
    var password = $('#password').val()

    $.ajax({
        url: 'login?action=doSignUp',
        type: 'post',
        dataType: 'text',
        data: {
            name: name,
            surname: surname,
            dob: dob,
            username: username,
            password: password
        }, success: function () {
            alert("Success")
            $('#name').val(null)
            $('#surname').val(null)
            $('#dob').val(null)
            $('#username').val(null)
            $('#password').val(null)

        }
    })
}
function checkUsername() {
    var username = $('#username').val();
    $.ajax({
        url: 'login?action=checkUsername',
        type: 'get',
        dataType: 'html',
        data: {username: username},
        success: function (data) {
            $('#existsUsernameSpan').html(data)
            var exists=$('#usernameStatus').val();
            if (exists==='true'){
                alert("Username already exists!")
            }else{
                signUp();
            }
        }
    })
}







