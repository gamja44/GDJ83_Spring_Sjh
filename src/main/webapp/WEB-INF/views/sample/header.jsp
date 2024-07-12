<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
 
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/product/list">PRODUCT</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/notice/list">공지사항</a>
        </li>
       
        <c:choose>
        <c:when test="${not empty sessionScope.member}">
          <li class="nav-item">
            <a class="nav-link" href="/members/mypage">마이페이지</a>
          </li>
          <li class="nav-item">
             <a class="nav-link" href="/members/logout">로그아웃</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="nav-item">
            <a class="nav-link" href="/members/join">회원가입</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/members/login">로그인</a>
          </li>
        </c:otherwise>
      </c:choose>
       
        
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
