<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Detail</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <h1>Account Detail</h1>
        <a href="/account/transfer?fromAccount=${account.account_number}" class="btn btn-primary">이체</a>
        <a href="/account/list?product_info_id=${account.product_info_id}" class="btn btn-secondary">내역조회</a>
        <p>Account Number: ${account.account_number}</p>
        <p>Balance: ${account.balance}</p>
        <p>Join Date: ${account.join_date}</p>
        <p>Product Type: ${account.productDTO.product_type}</p>
        <p>Product Rate: ${account.productDTO.product_rate}</p>
        <p>Product Detail: ${account.productDTO.product_detail}</p>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
