<%--
  Created by IntelliJ IDEA.
  User: vicky
  Date: 07/11/21
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student Registration form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First Name: <form:input path="firstName" />

        <br><br>
        Last Name: <form:input path="lastName" />
        <form:errors path="lastName" cssClass="alert-danger" />

        <br><br>
        Country:
<%--        <form:select path="country">--%>
<%--            <form:option value="india" label="India" />--%>
<%--            <form:option value="brazil" label="Brazil" />--%>
<%--            <form:option value="usa" label="USA" />--%>
<%--            <form:option value="uk" label="UK" />--%>
<%--            <form:option value="nepal" label="Nepal" />--%>
<%--        </form:select>--%>
        <form:select path="country">
            <form:options items="${student.countryOptions}" />
        </form:select>

        <br> <br>
        Favourite Language: <br>
        JAVA <form:radiobutton path="favouriteLanguage" value="JAVA" />
        PHP <form:radiobutton path="favouriteLanguage" value="PHP" />
        Python <form:radiobutton path="favouriteLanguage" value="Pyhon" />
        Ruby <form:radiobutton path="favouriteLanguage" value="Ruby" />
        Go <form:radiobutton path="favouriteLanguage" value="go" />
        <br> <br>
        Operating System
        MAC <form:checkbox path="OS" value="mac" />
        Linux <form:checkbox path="OS" value="linux" />
        Windows <form:checkbox path="OS" value="win" />
        <br><br>
        <input type="submit">
    </form:form>
</body>
</html>
