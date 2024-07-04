<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Join</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form method="post" action="${pageContext.request.contextPath}/members/join">
                    <div class="mb-3">
                        <label for="member_id" class="form-label">ID</label>
                        <input type="text" class="form-control" id="member_id" name="member_id">
                    </div>
                    <div class="mb-3">
                        <label for="member_pwd" class="form-label">PASSWORD</label>
                        <input type="password" class="form-control" id="member_pwd" name="member_pwd">
                    </div>
                    <div class="mb-3">
                        <label for="member_name" class="form-label">NAME</label>
                        <input type="text" class="form-control" id="member_name" name="member_name">
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">PHONE</label>
                        <input type="text" class="form-control" id="phone" name="phone">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">EMAIL</label>
                        <input type="email" class="form-control" id="email" name="email">
                    </div>
                    <div class="mb-3">
                        <label for="member_number" class="form-label">Member Number</label>
                        <input type="text" class="form-control" id="member_number" name="member_number">
                    </div>
                    <div class="mb-3">
                        <button type="submit" class="btn btn-primary">회원가입</button>
                    </div>
                </form>    
            </div>
        </div>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>
