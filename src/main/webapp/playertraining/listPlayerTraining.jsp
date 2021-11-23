<%-- 
    Document   : listPlayerTraining
    Created on : Oct 12, 2021, 12:08:53 PM
    Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Player Trainings</title>
</head>
<body>

<%@include file="../header.jsp" %>
<!--Includes the file at translation time: when the jsp is translated into servlet-->
<div align="center">
    <h2>List of Participants</h2>
    <h2>Training of ${training.tDateTime}</h2>

    <a href="${pageContext.request.getContextPath()}/playertraining/createPlayerTraining?trainId=${training.trainId}">New
        Participant</a>
    <br></br>
    <c:if test="${message!=null}">
        <h3>${message}</h3>
    </c:if>
    <table border="1">
        <thead>

        <th>Player</th>

        <th>Performance</th>
        <th colspan="3">Actions</th>
        </thead>
        <c:forEach items="${listOfParticipants}" var="playerTraining">
            <tr>

                <td>${playerTraining.player.lName} ${playerTraining.player.fName}</td>

                <td>${playerTraining.performance}</td>
                <td>
                    <a href="javascript:confirmDelete(${playerTraining.PTCode})">Delete</a>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>
<!--Includes the file at runtime-->
<jsp:include page="../footer.jsp"/>
<script>
    function confirmDelete(PTCode) {
        if (confirm('Are you sure you want to delete the Player Training with ID:' + PTCode + '?')) {
            window.location = '${pageContext.request.getContextPath()}/playertraining/deletePlayerTraining?id=' + PTCode;
        }
    }
</script>
</body>
</html>
