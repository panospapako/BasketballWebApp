<%-- 
    Document   : fromGame
    Created on : Oct 13, 2021, 2:03:17 PM
    Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Game form</title>
</head>
<body>
<c:choose>
<c:when test="${game==null}">
<h2>New Game</h2>
<form action="${pageContext.request.getContextPath()}/game/insert" method="post">
    </c:when>
    <c:otherwise>
    <h2>Edit Game</h2>
    <form action="${pageContext.request.getContextPath()}/game/updateGame" method="post">
        </c:otherwise>
        </c:choose>
        <c:if test="${game!=null}">
            GameId : <input type="text" name="gameId" value="${game.gameId}" readonly><br/>
        </c:if>
        Stadium : <select name="stadium" style="width: 200px">
        <c:forEach items="${listOfStadium}" var="stadium">
            <c:choose>
                <c:when test="${stadium.stadId eq game.stadium.stadId}">
                    <option value="${stadium.stadId}" selected>
                </c:when>
                <c:otherwise>
                    <option value="${stadium.stadId}}">
                </c:otherwise>
            </c:choose>
            ${stadium.sName}
            </option>
        </c:forEach>
    </select>

        Date : <input type="date" name="gDate" value="${game.gDate}"><br/>
        OppTeam : <input type="text" name="oppTeam" value="${game.oppTeam}"><br/>
        OppScore : <input type="number" name="oppScore" value="${game.oppScore}"><br/>
        MyScore : <input type="number" name="myScore" value="${game.myScore}"><br/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
