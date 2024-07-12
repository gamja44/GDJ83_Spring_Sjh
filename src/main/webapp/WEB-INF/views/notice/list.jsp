<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid mt-5">
    <h1>Notice List</h1>
    
    <!-- 검색어 입력 폼 -->
  <form action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center">
    <div class="col-12">
        <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
        <select name="kind" class="form-select" id="inlineFormSelectPref">
            <option value="title">제목</option>
            <option value="contents">내용</option>
            <option value="writer">작성자</option>
        </select>
    </div>
    <div class="col-12">
        <label class="visually-hidden" for="inlineFormInputGroupUsername">Search</label>
        <div class="input-group">
            <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="Search">
        </div>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>
  
    
    <table class="table table-hover mt-3">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${map.list}" var="notice">
                <tr>
                    <td>${notice.boardNum}</td>
                    <td><a href="./detail?boardNum=${notice.boardNum}">${notice.boardTitle}</a></td>
                    <td>${notice.boardWriter}</td>
                    <td>${notice.createDate}</td>
                    <td>${notice.boardHit}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item ${map.pre ? '' : 'disabled'}">
                <a class="page-link" href="./list?page=${map.startNum - 1}&kind=${map.kind}&search=${map.search}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="${map.startNum}" end="${map.lastNum}" var="i">
                <li class="page-item ${i == param.page ? 'active' : ''}">
                    <a class="page-link" href="./list?page=${i}&kind=${map.kind}&search=${map.search}">${i}</a>
                </li>
            </c:forEach>
            <li class="page-item ${map.next ? '' : 'disabled'}">
                <a class="page-link" href="./list?page=${map.lastNum + 1}&kind=${map.kind}&search=${map.search}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    
    <div class="row">
        <div>
            <a href="./add" class="btn btn-danger">공지사항 등록</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
