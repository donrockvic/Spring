<%--
  Created by IntelliJ IDEA.
  User: vicky
  Date: 12/11/21
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.code.crm.util.SortUtil" %>

<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>
    <div class="container-fluid">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Home</li>
          </ol>
        </nav>
        <div class="jumbotron">
            <h2 class="display-5"> CRM- Customer Relationship Manager </h2>
            <hr>
        </div>

        <div class = "row col-3">
            <a href="addForm" class="btn btn-primary">Add a Customer</a>
        </div>
        <br>
        <div class="row">
            <table class="table table-striped table-dark">
            <thead>
                <tr>

                <!-- links for shorting -->
                <c:url var="sortLinkFirstName" value="/customer/list" >
                    <c:param name="sort" value="<%= Integer.toString(SortUtil.FIRST_NAME) %>" />
                </c:url>

                <c:url var="sortLinkLastName" value="/customer/list" >
                    <c:param name="sort" value="<%= Integer.toString(SortUtil.LAST_NAME) %>" />
                </c:url>

                <c:url var="sortLinkEmail" value="/customer/list" >
                    <c:param name="sort" value="<%= Integer.toString(SortUtil.EMAIL) %>" />
                </c:url>

                    <th> <a href="${sortLinkFirstName}"> First Name </a> </th>
                    <th> <a href="${sortLinkLastName}"> Last Name </a>  </th>
                    <th> <a href="${sortLinkEmail}"> Email  </a>  </th>
                    <th> Action <th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="tempCustomer" items="${customers}" >

                <c:url var="updateLink" value="/customer/showUpdateForm">
                    <c:param name="customerId" value="${tempCustomer.id}" />
                </c:url>

                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}" />
                </c:url>

                <tr class="table-info">
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td> <a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick=" if(!(confirm('Are you sure with this delete ?'))) return false">Delete</a> </td>

                </tr>
            </c:forEach>
             </tbody>
            </table>
        </div>

    </div>

</body>
</html>