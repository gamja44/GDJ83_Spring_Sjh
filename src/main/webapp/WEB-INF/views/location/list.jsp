<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Location 리스트</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <h1>Location 리스트</h1>
    <div class="row col-md-8">
        <table class="table table-dark table-hover">
            <thead>
                <tr>
                    <th>Location ID</th>
                    <th>도로명 주소</th>
                    <th>우편번호</th>
                    <th>도시</th>
                    <th>주/도</th>
                    <th>국가 ID</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="dto">
                    <tr>
                        <td>${dto.location_id}</td>
                        <td>${dto.street_address}</td>
                        <td>${dto.postal_code}</td>
                        <td><a href="detail?location_id=${dto.location_id}">${dto.city}</a></td>
                        <td>${dto.state_province}</td>
                        <td>${dto.country_id}</td>
                      
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <a href="add" class="btn btn-danger">Location 등록</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
