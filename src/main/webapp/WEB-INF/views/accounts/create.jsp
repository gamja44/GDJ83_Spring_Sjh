<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <h1>Create Account</h1>
        <form method="post" action="<c:url value='/account/add'/>">
            <div class="mb-3">
                <label for="product_id" class="form-label">Product ID</label>
                <input type="number" class="form-control" id="product_id" name="product_id" required>
            </div>
            <div class="mb-3">
                <label for="account_number" class="form-label">Account Number</label>
                <input type="text" class="form-control" id="account_number" name="account_number" required>
            </div>
            <div class="mb-3">
                <label for="balance" class="form-label">Initial Balance</label>
                <input type="number" class="form-control" id="balance" name="balance" required>
            </div>
            <button type="submit" class="btn btn-primary">Create Account</button>
        </form>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
