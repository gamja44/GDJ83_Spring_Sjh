<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Member</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <h1>Update Member</h1>
        <form method="post" action="<c:url value='/members/update'/>">
            <div class="mb-3">
                <label for="member_name" class="form-label">Name</label>
                <input type="text" class="form-control" id="member_name" name="member_name" value="${member.member_name}">
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${member.phone}">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${member.email}">
            </div>
            <div class="mb-3">
                <label for="member_number" class="form-label">Member Number</label>
                <input type="text" class="form-control" id="member_number" name="member_number" value="${member.member_number}">
            </div>
            <div class="mb-3">
            	<input type="hidden" name="m_id" value="${member.m_id}"/>
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </form>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
