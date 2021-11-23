<%-- 
    Document   : listTraining
    Created on : Oct 11, 2021, 2:28:10 PM
    Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trainings</title>
</head>
<body>

<%@include file="../header.jsp" %>
<div align="center">
    <h2>List of Trainings</h2>
    <a href="${pageContext.request.getContextPath()}/training/insert">New Training</a>
    <br></br>
    <c:if test="${message!=null}">
        <h3>${message}</h3>
    </c:if>

    <table border="1">
        <c:forEach items="${trainingList}" var="training">
            <tr>
                <td>${training.trainId}</td>
                <td>${training.tDateTime}</td>
                <td><a href="${pageContext.request.getContextPath()}/training/updateTraining?id=${training.trainId}">Update</a>
                </td>
                <c:if test="${role==1}">
                    <td>
                        <a href="javascript:confirmDelete(${training.trainId})">Delete</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.getContextPath()}/listPlayerTraining?training=${training.trainId}">Participants</a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="../footer.jsp"/>
<script>
    function confirmDelete(trainId) {
        if (confirm('Are you sure you want to delete the training with ID:' + trainId + '?')) {
            window.location = '${pageContext.request.getContextPath()}/training/delete?id=' + trainId;
        }
    }
</script>
</body>
</html>
