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
    <title>Add Customer Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>
    <div class="container-fluid">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="list">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">Library</li>
          </ol>
        </nav>
        <div class="jumbotron">
            <h2 class="display-5"> CRM- Customer Relationship Manager </h2>
            <hr>
        </div>
        <div class="row col-8">
            <h3>Add Customer form</h3>
            <form:form action="saveCustomer" modelAttribute="customer" method="POST">

              <form:hidden path="id" id="id" />

              <div class="form-group">
                <label for="firstName">First Name</label>
                <form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="Enter First Name" />
              </div>

              <div class="form-group">
                <label for="lastName">Last Name</label>
                <form:input path="lastName" type="text" class="form-control" id="lastName" placeholder="Enter Last Name" />
             </div>

            <div class="form-group">
              <label for="email">Email address</label>
              <form:input path="email" type="email" class="form-control" id="email"  placeholder="Enter email" />
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Save</button>

            </form:form>
        </div>
    </div>

</body>
</html>