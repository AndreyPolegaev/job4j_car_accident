<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Accident</title>
</head>
<body>

<form:form action="save" modelAttribute="updateAccident">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Text <form:input path="text"/>
    <br><br>
    Address <form:input path="address"/>
    <br><br>
    <input type="submit" value="Update">


</form:form>

</body>
</html>
