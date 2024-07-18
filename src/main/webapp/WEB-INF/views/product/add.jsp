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
	<div>
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	</div>
</body>
</html>