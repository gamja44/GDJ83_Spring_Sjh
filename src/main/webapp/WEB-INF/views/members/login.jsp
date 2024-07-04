<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <h1>Login</h1>
        <form method="POST" action="${pageContext.request.contextPath}/members/login">
            <div class="form-group">
                <label for="member_id">Member ID</label>
                <input type="text" id="member_id" name="member_id" value="${id}" class="form-control" />
            </div>
            <div class="form-group">
                <label for="member_pwd">Password</label>
                <input type="password" id="member_pwd" name="member_pwd" class="form-control" />
            </div>
            
             <div class="mb-3 form-check">
			    <input type="checkbox" name="remember"  class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">ID기억하기</label>
			  </div>
            
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3">
                ${error}
            </div>
        </c:if>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
