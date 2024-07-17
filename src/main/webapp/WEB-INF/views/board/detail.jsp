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
        <p class="form-control-plaintext">${board.boardNum}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">제목</label>
        <p class="form-control-plaintext">${board.boardTitle}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">작성자</label>
        <p class="form-control-plaintext">${board.boardWriter}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">작성일</label>
        <p class="form-control-plaintext">${board.createDate}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">조회수</label>
        <p class="form-control-plaintext">${board.boardHit}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">내용</label>
        <p class="form-control-plaintext">${board.boardContents}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">카테고리</label>
        <p class="form-control-plaintext">${board.boardCategory}</p>
    </div>
    <c:if test="${boardType == 'qna'}">
        <div>
            <a href="${pageContext.request.contextPath}/board/qna/update?boardNum=${board.boardNum}" class="btn btn-warning">수정</a>
            <form action="${pageContext.request.contextPath}/board/qna/delete" method="post" style="display:inline;">
                <input type="hidden" name="boardNum" value="${board.boardNum}">
                <button type="submit" class="btn btn-danger">삭제</button>
            </form>
            <a href="${pageContext.request.contextPath}/board/qna/list" class="btn btn-secondary">목록</a>
        </div>
        <div class="mt-3">
            <a href="${pageContext.request.contextPath}/board/qna/replyForm?boardNum=${board.boardNum}" class="btn btn-info">답글</a>
        </div>
    </c:if>
    <c:if test="${boardType == 'notice'}">
        <div>
            <a href="${pageContext.request.contextPath}/board/notice/list" class="btn btn-secondary">목록</a>
        </div>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

