<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transfer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Transfer</h1>
        <form action="/account/transfer" method="post">
            <input type="hidden" name="fromAccount" value="${param.fromAccount}">
            <div class="form-group">
                <label for="toAccount">To Account</label>
                <input type="text" class="form-control" id="toAccount" name="toAccount" required>
            </div>
            <div class="form-group">
                <label for="amount">Amount</label>
                <input type="number" step="0.01" class="form-control" id="amount" name="amount" required>
            </div>
            <button type="submit" class="btn btn-primary">Transfer</button>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3">${error}</div>
        </c:if>
    </div>
</body>
</html>
