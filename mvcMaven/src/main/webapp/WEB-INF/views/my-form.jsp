<%--
  Created by IntelliJ IDEA.
  User: vicky
  Date: 07/11/21
  Time: 7:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>
    <div class="container-fluid">
        <form action="processForm" method="GET">
            <div class="mb-3 row">
                <label for="studentName" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="name" id="studentName" name="studentName" placeholder="Type your name">
                </div>
            </div>

            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Confirm identity</button>
            </div>
        </form>
    </div>
</body>
</html>
