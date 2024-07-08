<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <h1>My Page</h1>
        <p>Welcome, ${member.member.member_name}!</p>
        <p>Email: ${member.member.email}</p>
        <p>Phone: ${member.member.phone}</p>
        <p>Member Number: ${member.member.member_number}</p>
        <p>ID: ${member.member.member_id}</p>

        <div>
            <h3>계좌정보</h3>
            <c:forEach var="ac" items="${member.accounts}">
                <p>계좌번호: ${ac.account_number}, 잔액: ${ac.balance}</p>
            </c:forEach>
        </div>

        <div>
            <a href="./update" class="btn btn-secondary">회원수정</a>
        </div>

        <div>
            <form method="post" action="./delete">
                <button type="submit" class="btn btn-danger">회원탈퇴</button>
            </form>
        </div>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
