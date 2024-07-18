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
        <h1>Account Detail</h1>
        <a href="/account/transfer?fromAccount=${account.account_number}" class="btn btn-primary">이체</a>
        <a href="/account/list?accountNumber=${account.account_number}" class="btn btn-secondary">내역조회</a>
        <p>Account Number: ${account.account_number}</p>
        <p>Balance: ${account.balance}</p>
        <p>Join Date: ${account.join_date}</p>
        <p>Product Type: ${account.productDTO.product_type}</p>
        <p>Product Rate: ${account.productDTO.product_rate}</p>
        <p>Product Detail: ${account.productDTO.product_detail}</p>
    </div>
	<div>
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	</div>
</body>
</html>