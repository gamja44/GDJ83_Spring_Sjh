<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Location 상세 정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <h1>상세 정보</h1>
    <h3>${dto.location_id}</h3>
    <h3>${dto.street_address}</h3>
    <h3>${dto.postal_code}</h3>
    <h3>${dto.city}</h3>
    <h3>${dto.state_province}</h3>
    <h3>${dto.country_id}</h3>
    <a href="./delete?location_id=${dto.location_id}" class="btn btn-danger">삭제</a>
    <a href="./update?location_id=${dto.location_id}" class="btn btn-warning">수정</a>
</body>
</html>
