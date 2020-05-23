<%--
  Created by IntelliJ IDEA.
  User: Emin-Muradov
  Date: 07-Mar-20
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>Login</title>
    <script type="text/javascript" src="resources/JS/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="resources/JS/jquery-ui.js"></script>
    <script type="text/javascript" src="resources/JS/login.js"></script>
    <script>
        function preventBack() {
       window.history.forward()
        }
        setTimeout("preventBack()",0);
        window.onunload=function () {null}
    </script>

    <link rel="stylesheet" type="text/css" href="resources/CSS/jquery-ui.css"/>
    <link rel="stylesheet" type="text/css" href="resources/CSS/login.css"/>

</head>
<body id="body" style="margin: 0">
<div class="login-wrap">


    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">

            <form action="login?action=doSignIn" method="post">

                <div class="sign-in-htm" style="margin-top: 70px">

                    <c:if test="${not empty requestScope.get('errorMessage')}">
                        <span style="color: red">
                                ${requestScope.get("errorMessage")}
                        </span>
                    </c:if>


                    <div class="group">
                        <label class="label">Username</label>
                        <input id="loginUsername" type="text" name="loginUsername" class="input">
                    </div>

                    <div class="group">
                        <label class="label">Password</label>
                        <input id="loginPassword" type="password" class="input" name="loginPassword"
                               data-type="password">
                    </div>

                    <div class="group">
                        <input type="submit" class="button" value="Sign In">
                    </div>
                </div>
            </form>

            <div class="sign-up-htm">

                <div class="group">
                    <label class="label">Name</label>
                    <input id="name" type="text" class="input">
                </div>

                <div class="group">
                    <label class="label">Surname</label>
                    <input id="surname" type="text" class="input">
                </div>

                <div class="group">
                    <label class="label">Date of Birth</label>
                    <input id="dob" type="text" class="input">
                </div>

                <div class="group">
                    <label class="label">Username</label>
                    <input id="username" type="text" class="input">
                </div>

                <div class="group">
                    <label class="label">Password</label>
                    <input id="password" type="password" class="input" data-type="password">
                </div>


                <div class="group">
                    <input type="submit" class="button" value="Sign Up" onclick="checkUsername()">
                </div>
            </div>
        </div>
    </div>
</div>

<span id="existsUsernameSpan" style="display:none;"></span>

</body>
</html>
