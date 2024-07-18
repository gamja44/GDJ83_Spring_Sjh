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
    <h1>Update ${boardType}</h1>
    <form action="${pageContext.request.contextPath}/board/${boardType}/update" method="post">
        <input type="hidden" name="boardNum" value="${board.boardNum}">
        <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" name="boardTitle" value="${board.boardTitle}" required>
        </div>
        <div class="mb-3">
            <label for="contents" class="form-label">내용</label>
            <textarea class="form-control" id="contents" name="boardContents" rows="5" required>${board.boardContents}</textarea>
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">카테고리</label>
            <input type="text" class="form-control" id="category" name="boardCategory" value="${board.boardCategory}" required>
        </div>
        <button type="submit" class="btn btn-primary">수정</button>
        <a href="${pageContext.request.contextPath}/board/${boardType}/list" class="btn btn-secondary">목록</a>
    </form>
</div>
	<div>
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	</div>
	<!-- 아 -->
</body>
</html>