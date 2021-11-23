<%-- 
    Document   : formTraining
    Created on : Oct 11, 2021, 2:09:24 PM
    Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Training form</title>
</head>
<body>
<c:choose>
<c:when test="${training==null}">
<h2>New Training</h2>
<form action="${pageContext.request.getContextPath()}/training/insert" method="post">
    </c:when>
    <c:otherwise>
    <h2>Edit Training</h2>
    <form action="${pageContext.request.getContextPath()}/training/updateTraining" method="post">
        </c:otherwise>
        </c:choose>
        <c:if test="${training!=null}">
            TrainId : <input type="text" name="trainId" value="${training.trainId}" readonly><br/>
        </c:if>
        Date : <input type="datetime-local" name="tDateTime" value="${training.tDateTime}"><br/>
        <input type="submit" value="Submit">
    </form>


</body>
</html>
