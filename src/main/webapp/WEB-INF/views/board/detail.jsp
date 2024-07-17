<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <p class="form-control-plaintext">${boardDTO.boardNum}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">제목</label>
        <p class="form-control-plaintext">${boardDTO.boardTitle}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">작성자</label>
        <p class="form-control-plaintext">${boardDTO.boardWriter}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">작성일</label>
        <p class="form-control-plaintext">${boardDTO.createDate}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">조회수</label>
        <p class="form-control-plaintext">${boardDTO.boardHit}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">내용</label>
        <p class="form-control-plaintext">${boardDTO.boardContents}</p>
    </div>
    <div class="mb-3">
        <label class="form-label">카테고리</label>
        <p class="form-control-plaintext">${boardDTO.boardCategory}</p>
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/board/${boardType}/update?boardNum=${boardDTO.boardNum}" class="btn btn-warning">수정</a>
        <form action="${pageContext.request.contextPath}/board/${boardType}/delete" method="post" style="display:inline;">
            <input type="hidden" name="boardNum" value="${boardDTO.boardNum}">
            <button type="submit" class="btn btn-danger">삭제</button>
        </form>
        <a href="${pageContext.request.contextPath}/board/${boardType}/list" class="btn btn-secondary">목록</a>
    </div>

    <!-- QnA의 경우 답글 추가 -->
    <c:if test="${boardType == 'qna'}">
        <div>
            <h2>답글</h2>
            <form action="${pageContext.request.contextPath}/board/qna/reply" method="post">
                <input type="hidden" name="boardNum" value="${boardDTO.boardNum}">
                <input type="hidden" name="ref" value="${boardDTO.ref}">
                <input type="hidden" name="step" value="${boardDTO.step + 1}">
                <input type="hidden" name="depth" value="${boardDTO.depth + 1}">
                <table border="1">
                    <tr>
                        <td>제목</td>
                        <td><input type="text" name="boardTitle" required></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><textarea name="boardContents" rows="5" required></textarea></td>
                    </tr>
                </table>
                <button type="submit" class="btn btn-primary mt-3">답글 추가</button>
            </form>
        </div>
    </c:if>
</div>
</body>
</html>

