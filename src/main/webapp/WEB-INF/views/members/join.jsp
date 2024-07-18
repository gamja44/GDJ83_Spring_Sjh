<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
<div>
<c:import url="/WEB-INF/views/template/header_bar.jsp"></c:import>
</div>
<div class="container-fluid mt-5">
<div class="row justify-content-center">
<div class="col-md-6">
<form method="post" id="frm">
<div class="mb-3">
<label for="userName" class="form-label">ID</label>
<input type="text" class="form-control" id="userName" name="userName">
<div id="userNameError" class="text-danger"></div>
</div>
<div class="mb-3">
<label for="password" class="form-label">PASSWORD</label>
<input type="password" class="form-control" id="password" name="password">
<div id="passwordError" class="text-danger"></div>
</div>
<div class="mb-3">
<label for="name" class="form-label">NAME</label>
<input type="text" class="form-control" id="name" name="name">
<div id="nameError" class="text-danger"></div>
</div>
<div class="mb-3">
<label for="phone" class="form-label">PHONE</label>
<input type="text" class="form-control" id="phone" name="phone">
<div id="phoneError" class="text-danger"></div>
</div>
<div class="mb-3">
<label for="email" class="form-label">EMAIL</label>
<input type="email" class="form-control" id="email" name="email">
<div id="emailError" class="text-danger"></div>
</div>
<div class="mb-3">
<label for="address" class="form-label">Address</label>
<input type="text" class="form-control" id="address" name="address">
<div id="addressError" class="text-danger"></div>
</div>


<div class="mb-3">
<button type="button" id="btn" class="btn btn-primary">사진파일추가</button>	
</div>
<!-- <div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
  <span class="input-group-text" id="basic-addon2">@example.com</span>
</div> -->
<div class="mb-3" id="result">
	
</div>


<div class="mb-3">
<button type="button" id="btn" class="btn btn-primary">회원가입</button>
</div>
</form>	
</div>
</div>
</div>
<div>
<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
<script type="text/javascript" src="../resources/js/member/memberjoinCheck.js"></script>
</div>
</body>
</html>