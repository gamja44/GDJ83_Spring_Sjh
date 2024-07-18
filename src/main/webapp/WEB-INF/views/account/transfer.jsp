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
	<div>
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	</div>
</body>
</html>