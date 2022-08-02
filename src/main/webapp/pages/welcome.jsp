<%--
  Created by IntelliJ IDEA.
  User: ALexus
  Date: 01.08.2022
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
    <script type="text/javascript">
        function searchInfo() {
            let name = document.userform.username.value;
            if (name === "") {
                alert("Name is empty");
                document.userform.action = "/";
            }
            else {
                return true;
            }
        }
    </script>
    <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body style="margin: 0 auto; padding: 0; height: 100vh">
<% request.getSession(true);%>
<div class="pt-5 text-center">Welcome page of the application</div>
<div class="wrapper mt-5 text-center">
    <form name="userform" action="/dispatcher?action=mainPage" method="post" style="width: 30%; margin: 0 auto">
        <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping">@</span>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
        </div>
        <input type="submit" name="enter" class="btn btn-primary mt-2" style="width: 100%" onclick="searchInfo()">
    </form>
</div>
</body>
</html>