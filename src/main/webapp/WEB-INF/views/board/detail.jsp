<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardType} Detail</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid mt-5">
    <h1>${boardType} Detail</h1>
    <div class="mb-3">
        <label class="form-label">번호</label>
        <p class="form-control-plaintext">${notice.boardNum}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">제목</label>
        <p class="form-control-plaintext">${notice.boardTitle}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">작성자</label>
        <p class="form-control-plaintext">${notice.boardWriter}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">작성일</label>
        <p class="form-control-plaintext">${notice.createDate}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">조회수</label>
        <p class="form-control-plaintext">${notice.boardHit}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">내용</label>
        <p class="form-control-plaintext">${notice.boardContents}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">카테고리</label>
        <p class="form-control-plaintext">${notice.boardCategory}</p>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/board/${boardType}/update?boardNum=${notice.boardNum}" class="btn btn-warning">수정</a>
        <form action="${pageContext.request.contextPath}/board/${boardType}/delete" method="post" style="display:inline;">
            <input type="hidden" name="boardNum" value="${notice.boardNum}">
            <button type="submit" class="btn btn-danger">삭제</button>
        </form>
        <a href="${pageContext.request.contextPath}/board/${boardType}/list" class="btn btn-secondary">목록</a>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

