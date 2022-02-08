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
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    Form
    <div>
        <form:form action="${pageContext.request.contextPath}/login/process" method="POST">
          <c:if test="${param.error != null}">
            <i> Sorry ! you entered the invalid username or password ${param.error}</i>
          </c:if>
          <c:if test="${param.logout != null}">
              <i> You have been logged out</i>
          </c:if>
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" name="username" placeholder="Enter Username">
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" name="password" placeholder="Password">
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>



    </div>


</body>
</html>