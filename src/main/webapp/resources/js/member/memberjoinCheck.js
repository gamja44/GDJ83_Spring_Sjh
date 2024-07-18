document.addEventListener("DOMContentLoaded", function() {
    const btn = document.getElementById("btn"); // 회원가입 버튼 요소를 가져옴
    const frm = document.getElementById("frm"); // 폼 요소를 가져옴
    const addPhotoBtn = document.getElementById("add"); // 사진 추가 버튼 요소를 가져옴
    const photoInput = document.getElementById("photo"); // 파일 입력 요소를 가져옴
    const photoDiv = document.getElementById("photoDiv"); // 사진 입력 필드가 있는 div 요소를 가져옴

    btn.addEventListener("click", function() { // 회원가입 버튼 클릭 시 실행되는 이벤트 리스너
        let fields = ['userName', 'password', 'name', 'memberNumber', 'phone', 'email', 'address']; // 필수 입력 필드 목록
        let isValid = true; // 유효성 검사 결과를 저장할 변수

        // 모든 오류 메시지 초기화
        fields.forEach(field => {
            const errorElement = document.getElementById(field + 'Error'); // 각 필드에 대한 오류 메시지 요소를 가져옴
            if (errorElement) {
                errorElement.textContent = ''; // 오류 메시지 초기화
            }
        });

        // 입력 필드를 순회하며 값이 비어있는지 확인
        for (let i = 0; i < fields.length; i++) {
            const fieldValue = document.getElementById(fields[i]).value; // 각 필드의 값을 가져옴
            if (!fieldValue) { // 값이 비어있으면
                const errorElement = document.getElementById(fields[i] + 'Error'); // 해당 필드의 오류 메시지 요소를 가져옴
                if (errorElement) {
                    errorElement.textContent = '여기에 필수로 입력하세요'; // 오류 메시지 표시
                }
                isValid = false; // 유효성 검사 실패
            }
        }

        if (isValid) { // 모든 필드가 유효하면
            console.log("Form is valid, submitting form..."); // 콘솔에 메시지 출력
            frm.submit(); // 폼 제출
        } else {
            console.log("Form is not valid"); // 콘솔에 메시지 출력
            alert("fail"); // 경고창 표시
        }
    });

    addPhotoBtn.addEventListener("click", function() { // 사진 추가 버튼 클릭 시 실행되는 이벤트 리스너
        photoDiv.style.display = "block"; // 사진 입력 필드를 표시
    });
});
