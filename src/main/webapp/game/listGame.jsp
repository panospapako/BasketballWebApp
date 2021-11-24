<%-- 
    Document   : listGame
    Created on : Oct 13, 2021, 2:03:47 PM
    Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Games</title>
</head>
<body>

<%@include file="../header.jsp" %>
<div align="center">
    <h2>List of Games</h2>
    <a href="${pageContext.request.getContextPath()}/game/insert">New Game</a>
    <br></br>
    <c:if test="${message!=null}">
        <h3>${message}</h3>
    </c:if>

    <table border="1">
        <c:forEach items="${gameList}" var="game">
            <tr>
                <td>${game.gameId}</td>
                <td>${game.stadium.sName}</td>
                <td>${game.gameDate}</td>
                <td>${game.oppTeam}</td>
                <td>${game.oppScore}</td>
                <td>${game.myScore}</td>
                <td><a href="${pageContext.request.getContextPath()}/game/updateGame?id=${game.gameId}">Update</a></td>
                <c:if test="${role==1}">
                    <td>
                        <a href="javascript:confirmDelete(${game.gameId})">Delete</a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="../footer.jsp"/>
<script>
    function confirmDelete(gameId) {
        if (confirm('Are you sure you want to delete the game with ID:' + gameId + '?')) {
            window.location = '${pageContext.request.getContextPath()}/game/delete?id=' + gameId;
        }
    }
</script>
</body>
</html>
