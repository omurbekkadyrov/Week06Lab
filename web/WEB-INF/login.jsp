<%-- 
    Document   : login
    Created on : Oct 1, 2018, 8:19:11 PM
    Author     : 759388
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="custom" uri="/WEB-INF/tlds/login.tld" %>
<%@taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
 
         <h1>Login</h1>
               
         <sait:debug>
                <div class="well">
                    Remote Host: ${pageContext.request.remoteHost}<br />
                    Session ID: ${pageContext.session.id}
                </div>
            </sait:debug>

            <c:if test="${message != null}">
                <div class="row">
                    <div class="col-md-12">
                        <div class="alert alert-danger" role="alert">${message}</div>
                    </div>
                </div>
            </c:if>

            <c:if test="${info != null}">
                <div class="row">
                    <div class="col-md-12">
                        <div class="alert alert-info" role="alert">${info}</div>
                    </div>
                </div>
            </c:if>

            <custom:login />
        </div>
    </body>
</html>
