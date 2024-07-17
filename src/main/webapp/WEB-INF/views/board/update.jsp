<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update ${boardType}</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

