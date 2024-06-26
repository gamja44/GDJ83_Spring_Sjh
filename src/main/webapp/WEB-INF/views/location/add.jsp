<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Location 추가</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div>
            <h1>Location 추가 폼</h1>
        </div>
        <div class="row">
            <form action="add" method="post">
                <div class="mb-3">
                    <label for="street_address" class="form-label">도로명 주소</label>
                    <input type="text" class="form-control" id="street_address" name="street_address">
                </div>
                <div class="mb-3">
                    <label for="postal_code" class="form-label">우편번호</label>
                    <input type="text" class="form-control" id="postal_code" name="postal_code">
                </div>
                <div class="mb-3">
                    <label for="city" class="form-label">도시</label>
                    <input type="text" class="form-control" id="city" name="city">
                </div>
                <div class="mb-3">
                    <label for="state_province" class="form-label">주/도</label>
                    <input type="text" class="form-control" id="state_province" name="state_province">
                </div>
                <div class="mb-3">
                    <label for="country_id" class="form-label">국가 ID</label>
                    <input type="text" class="form-control" id="country_id" name="country_id">
                </div>
                <button type="submit" class="btn btn-primary">등록</button>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
