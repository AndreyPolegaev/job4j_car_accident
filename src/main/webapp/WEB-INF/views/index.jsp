<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Accident</title>
</head>
<body>

<a href="<c:url value='/create'/>">Добавить инцидент</a>
<a href="<c:url value='/index'/>">Показать все инциденты</a>

<table width="300" border="1">
    <tr>
        <th>Name</th>
        <th>Test</th>
        <th>Address</th>
    </tr>

    <c:forEach var="temp" items="${accidents}">

<%--        <c:url var="updateButton" value="'/update'/">--%>
        <c:url var="updateButton" value="/update">
            <c:param name="id" value="${temp.id}"/>
            <c:param name="name" value="${temp.name}"/>
            <c:param name="text" value="${temp.text}"/>
            <c:param name="address" value="${temp.address}"/>
        </c:url>

        <tr>
            <td>${temp.id}</td>
            <td>${temp.name}</td>
            <td>${temp.text}</td>
            <td>${temp.address}</td>


            <td>
                    <input type="button" value="Update Accident"
                           onclick="window.location.href = '${updateButton}'"/>
            </td>


        </tr>
    </c:forEach>
</table>

</body>
</html>