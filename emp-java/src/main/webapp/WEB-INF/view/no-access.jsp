<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>access</title>
</head>
<body>
    <h2> No-ACCESS Page</h2>
    <hr>
    <p>
       Sorry you are not Authorized to view this page
    </p>
    <a href="${pageContext.request.contextPath}">Back to home Page</a>
</body>
</html>