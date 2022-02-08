<%--
  Created by IntelliJ IDEA.
  User: vicky
  Date: 07/11/21
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

</head>
<body>

Fill out the form. Asterick(*) fields are required.
    <form:form action="processForm" modelAttribute="customer">

        First Name *:  <form:input path="firstName" />
        <form:errors path="firstName" cssClass="alert-danger" />

        <br><br>
        Last Name *: <form:input path="lastName" />
        <form:errors path="lastName" cssClass="alert-danger" />

        <br><br>
        Free Pass <form:input path="freePass" />
        <form:errors path="freePass" cssClass="alert-danger" />

        <br><br>
        Postal Code: <form:input path="postalCode" />
        <form:errors path="postalCode" cssClass="alert-danger" />


        <br><br>
        <input type="submit" name="submit" value="submit">

    </form:form>


</body>
</html>
