<%-- 
    Document   : listStadium.jsp
    Created on : Sep 21, 2021, 10:25:50 AM
    Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stadiums</title>
</head>
<body>

<%@include file="../header.jsp" %>
<div align="center">
    <h2>List of Stadiums</h2>
    <a href="${pageContext.request.getContextPath()}/stadium/insert">New Stadium</a>
    <br></br>
    <c:if test="${message!=null}">
        <h3>${message}</h3>
    </c:if>

    <table border="1">
        <c:forEach items="${stadiumList}" var="stadium">
            <tr>
                <td>${stadium.stadId}</td>
                <td>${stadium.sName}</td>
                <td>${stadium.location}</td>
                <td>${stadium.capacity}</td>
                <td>
                    <a href="${pageContext.request.getContextPath()}/stadium/updateStadium?id=${stadium.stadId}">Update</a>
                </td>
                <c:if test="${role==1}">
                    <td>
                        <a href="javascript:confirmDelete(${stadium.stadId})">Delete</a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="../footer.jsp"/>
<script>
    function confirmDelete(stadId) {
        if (confirm('Are you sure you want to delete the stadium with ID:' + stadId + '?')) {
            window.location = '${pageContext.request.getContextPath()}/stadium/delete?id=' + stadId;
        }
    }
</script>
</body>
</html>
