<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/24/21
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
    <style>
        fieldset {
            width: 400px;
        }
    </style>
</head>
<body>
    <%
        String info = null;
        if ((Boolean) request.getAttribute("isFound")) {
            info = "Worker found";
        } else {
            info = "Employee not found. New \n employee created";
        }
    %>
    <p><%= info%></p>
    <fieldset>
        <legend>Employee №${employee.id}></legend>
        <p><b>Name: </b>${employee.name}</p>
        <p><b>Position: </b>${employee.position}</p>
        <p><b>Salary: </b>${employee.salary}</p>
    </fieldset>
    <a href="index.html">back</a>
</body>
</html>
