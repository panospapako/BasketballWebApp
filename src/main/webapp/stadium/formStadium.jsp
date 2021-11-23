<%--
Document   : formStadium
Created on : Sep 21, 2021, 2:51:45 PM
Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stadium form</title>
</head>
<body>
<c:choose>
<c:when test="${stadium==null}">
<h2>New Stadium</h2>
<form action="${pageContext.request.getContextPath()}/stadium/insert" method="post">
    </c:when>
    <c:otherwise>
    <h2>Edit Stadium</h2>
    <form action="${pageContext.request.getContextPath()}/stadium/updateStadium" method="post">
        </c:otherwise>
        </c:choose>
        <c:if test="${stadium!=null}">
            StadId : <input type="text" name="stadId" value="${stadium.stadId}" readonly><br/>
        </c:if>
        Name : <input type="text" name="sName" value="${stadium.sName}"><br/>
        Location : <input type="text" name="location" value="${stadium.location}"><br/>
        Capacity : <input type="text" name="capacity" value="${stadium.capacity}"><br/>
        <input type="submit" value="Submit">
    </form>


</body>
</html>
