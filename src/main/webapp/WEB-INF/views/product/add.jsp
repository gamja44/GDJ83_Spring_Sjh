<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <h1>Add Product</h1>
        <form:form modelAttribute="product" method="POST" action="${pageContext.request.contextPath}/product/add">
            <div class="form-group">
                <label for="product_type">Product Type</label>
                <form:input path="product_type" class="form-control" />
            </div>
            <div class="form-group">
                <label for="product_rate">Product Rate</label>
                <form:input path="product_rate" class="form-control" />
            </div>
            <div class="form-group">
                <label for="product_detail">Product Detail</label>
                <form:textarea path="product_detail" class="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">Add Product</button>
        </form:form>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
