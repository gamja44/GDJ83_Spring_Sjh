<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="flex-shrink-0">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light bg-white py-3">
        <div class="container px-5">
            <a class="navbar-brand" href="/board/notice/list"><span class="fw-bolder text-primary">공지사항</span></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0 small fw-bolder">
                    <li class="nav-item"><a class="nav-link" href="/product/list">PRODUCT</a></li>
                    <li class="nav-item"><a class="nav-link" href="/board/qna/list">Q&A</a></li>
                    <c:choose>
                        <c:when test="${not empty sessionScope.member}">
                            <li class="nav-item"><a class="nav-link" href="/members/mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="/members/logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item"><a class="nav-link" href="/members/join">회원가입</a></li>
                            <li class="nav-item"><a class="nav-link" href="/members/login">로그인</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</main>
