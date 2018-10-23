<%-- 
    Document   : home
    Created on : Oct 1, 2018, 8:18:55 PM
    Author     : 759388
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${username}</h3>
        <p><a href="/login?action=logout" class="btn btn-primary" role="button">Logout</a></p>
    </body>
</html>
