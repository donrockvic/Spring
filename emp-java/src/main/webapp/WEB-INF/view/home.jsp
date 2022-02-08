<%--
  Created by IntelliJ IDEA.
  User: vicky
  Date: 12/11/21
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>home</title>
    <link href="resources/bootstrap.css" rel="stylesheet">
</head>
<body>
    <h2>Welcome to Vicky Company page</h2>

    User: <security:authentication property="principal.username" />
    <br/>
    Role(s): <security:authentication property="principal.authorities" />
    <br/><br/>

    <hr>
    <security:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/leaders">Leadership meetings</a>
    (Only for Manager people)
    </security:authorize>
    <br>
    <security:authorize access="hasRole('MANAGER')">
    <a href="${pageContext.request.contextPath}/systems">ADMIN meetings</a>
    (Only for Admin people)
    </security:authorize>

    <hr/>


    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <button>Logout</button>
    </form:form>
</body>
</html>