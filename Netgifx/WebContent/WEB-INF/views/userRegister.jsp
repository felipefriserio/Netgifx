
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Netgifx</title>
   <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/logo.ico">
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
      
        <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="name">Full name</label>
                <input class="form-control" id="name" name="name" type="text" value="${requestScope.user.name}" aria-describedby="nameHelp" placeholder="Enter full name">
              </div>
              <c:if test="${sessionScope.user.isAdmin eq true && not empty sessionScope.user}">
              	<div class="form-check col-md-4 col-md-offset-2">
				    <label class="form-check-label" style="margin-top:30px;">
				      <input type="checkbox" class="form-check-input" id="isAdmin" ${requestScope.user.isAdmin eq true ? 'checked': ''}>
				      Is admin?
				    </label>
				    
				    <input class="form-control" id="id" type="hidden" value="${requestScope.user.id}">
				 </div>
              </c:if>
            </div>
          </div>
          <div class="form-group">
            <label for="email">Email address</label>
            <input class="form-control" id="email" type="email" value="${requestScope.user.email}" aria-describedby="emailHelp" placeholder="Enter email">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="password">Password</label>
                <input class="form-control" id="password" type="password" value="${requestScope.user.password}" placeholder="Password">
              </div>
              <div class="col-md-6">
                <label for="passwordConfirm">Confirm password</label>
                <input class="form-control" id="passwordConfirm" type="password" value="${requestScope.user.password}" placeholder="Confirm password">
              </div>
            </div>
          </div>
          <button type="button" class="btn btn-primary btn-block" onclick="save()">Save</button>
          <c:if test="${sessionScope.user.isAdmin eq true && not empty sessionScope.user}">
          	<button type="button" class="btn btn-info btn-block" onclick="search()">Search</button>
          	<button type="button" class="btn btn-info btn-block" onclick="deleteUser()">Delete</button>
          </c:if>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="index">Login Page</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
  
  <script src="${pageContext.request.contextPath}/resources/vendor/netgifx.js"></script>
</body>

</html>

