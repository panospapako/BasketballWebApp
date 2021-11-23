<%-- 
    Document   : fromPlayerTraining
    Created on : Oct 12, 2021, 11:48:14 AM
    Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Participant Form</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>

<c:choose>
<c:when test="${playerTraining==null}">
<h2>New Participant</h2>
<form action="${pageContext.request.getContextPath()}/playertraining/createPlayerTraining" method="post">
    </c:when>
    <c:otherwise>
    <h2>Edit Participant</h2>
    <form action="${pageContext.request.getContextPath()}playertraining/update" method="post">
        </c:otherwise>
        </c:choose>
        <c:if test="${playerTraining!=null}">
            PTCode : <input type="text" name="ptcode" value="${playerTraining.PTCode}" readonly><br/>
        </c:if>
        <table>
            <tr>
                <td align="right">Player :</td>
                <td>
                    <select name="player" style="width: 200px">
                        <c:forEach items="${listOfPlayerWhoNotParticipate}" var="player">
                            <c:choose>
                                <c:when test="${player.idNumber eq playerTraining.player.idNumber}">
                                    <option value="${player.idNumber}" selected>
                                </c:when>
                                <c:otherwise>
                                    <option value="${player.idNumber}">
                                </c:otherwise>
                            </c:choose>
                            ${player.lName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">Training :</td>
                <td><input type="hidden" name="training" value="${training.trainId}" size="15"
                           readonly>${training.tDateTime}</td>
            </tr>

            <tr>
                <td align="right">Performance :</td>
                <td><input type="number" name="performance" value="${playerTraining.performance}" min="50" max="100"
                           size="15"></td>
            </tr>

        </table>

        <br/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
