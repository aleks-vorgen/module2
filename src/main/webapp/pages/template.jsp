<%--
  Created by IntelliJ IDEA.
  User: ALexus
  Date: 01.08.2022
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Home Page</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
    <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header">
    <div>
        <h4>Welcome, <%=request.getSession().getAttribute("username")%></h4>
        <a href="/dispatcher?action=logOut">LogOut</a>
    </div>
</div>
<div class="menu">
    <ul>
        <li><a href="/dispatcher?action=showAllStudents" class="link">Students</a></li>
    </ul>
</div>
<div class="main">
    <%String includedJspPage = (String) request.getSession().getAttribute("includedJspPage");%>
    <%if (includedJspPage != null) {%>
    <jsp:include page="<%=includedJspPage%>"/>
    <%}%>
</div>
<div class="footer">Copyrights 2002 - 2022</div>
<script defer type="text/javascript">
    let body = document.querySelector("body")
    let header = document.querySelector(".header");
    let menu = document.querySelector(".menu")
    let footer = document.querySelector(".footer")
    let main = document.querySelector(".main");

    main.style.height = (body.offsetHeight - header.offsetHeight - menu.offsetHeight - footer.offsetHeight).toString();
</script>
</body>
</html>