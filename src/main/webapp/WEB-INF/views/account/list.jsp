<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction History</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <h1>Transaction History</h1>

        <div>
            <a href="?accountNumber=${param.accountNumber}&order=1" class="btn btn-secondary">과거순으로</a>
            <a href="?accountNumber=${param.accountNumber}&order=0" class="btn btn-secondary">최신순으로</a>
            <a href="?accountNumber=${param.accountNumber}&order=0&type=입금" class="btn btn-secondary">입금만</a>
            <a href="?accountNumber=${param.accountNumber}&order=0&type=출금" class="btn btn-secondary">출금만</a>
            <a href="?accountNumber=${param.accountNumber}&order=0&type=" class="btn btn-secondary">입금/출금</a>
        </div>

        <table class="table table-striped mt-3">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>구분</th>
                    <th>Amount</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="history" items="${historyList}">
                    <tr>
                        <td>${history.history_time}</td>
                        <td>
                            <c:choose>
                                <c:when test="${history.amount > 0}">
                                    <div style="color: green;">입금</div>
                                </c:when>
                                <c:when test="${history.amount < 0}">
                                    <div style="color: red;">출금</div>
                                </c:when>
                                <c:otherwise>
                                    <div>기타</div>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${history.amount}</td>
                        <td>${history.balance}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
