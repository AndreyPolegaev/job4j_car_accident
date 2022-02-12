<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="save" method="POST">
    <table>
        <tr>
            <td>Название:</td>
            <td><input type='text' name='name' placeholder="Name of Accident?"></td>
            <br>
            <td><input type='text' name='text' placeholder="Description?"></td>
            <br>
            <td><input type='text' name='address' placeholder="Adress of Accident?"></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>