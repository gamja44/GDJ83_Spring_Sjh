<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
    
    <div class="container-fluid mt-5">
        <form action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center">
            <div class="col-12">
                <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
                <select name="kind" class="form-select" id="inlineFormSelectPref">
                    <option value="product_type" <c:if test="${kind == 'product_type'}">selected</c:if>>Product Type</option>
                    <option value="product_detail" <c:if test="${kind == 'product_detail'}">selected</c:if>>Product Detail</option>
                </select>
            </div>
            <div class="col-12">
                <label class="visually-hidden" for="inlineFormInputGroupUsername">Search</label>
                <div class="input-group">
                    <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="Search" value="${search}">
                </div>
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form>
    
        <h1>Product List</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Type</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${list}">
                    <tr>
                        <td>${product.product_id}</td>
                        <td><a href="${pageContext.request.contextPath}/product/detail?product_id=${product.product_id}">${product.product_type}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/product/add" class="btn btn-primary">Add Product</a>
        <div class="mt-3">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li class="page-item <c:if test='${currentPage == 1}'>disabled</c:if>">
                        <a class="page-link" href="${pageContext.request.contextPath}/product/list?page=${currentPage - 1}&pageSize=${pageSize}&kind=${kind}&search=${search}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:set var="startPage" value="${(currentPage - 1) / 5 * 5 + 1}" />
                    <c:set var="endPage" value="${startPage + 4 < totalPages ? startPage + 4 : totalPages}" />
                    <c:forEach var="i" begin="${startPage}" end="${endPage}">
                        <li class="page-item <c:if test='${i == currentPage}'>active</c:if>">
                            <a class="page-link" href="${pageContext.request.contextPath}/product/list?page=${i}&pageSize=${pageSize}&kind=${kind}&search=${search}">${i}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item <c:if test='${currentPage == totalPages}'>disabled</c:if>">
                        <a class="page-link" href="${pageContext.request.contextPath}/product/list?page=${currentPage + 1}&pageSize=${pageSize}&kind=${kind}&search=${search}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    
    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

