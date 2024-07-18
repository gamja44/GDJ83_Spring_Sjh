document.addEventListener("DOMContentLoaded", function() {
    const btn = document.getElementById("btn");
    const frm = document.getElementById("frm");

    btn.addEventListener("click", function() {
        let fields = ['userName', 'password', 'name', 'memberNumber', 'phone', 'email', 'address'];
        let isValid = true;

        // 모든 오류 메시지 초기화
        fields.forEach(field => {
            const errorElement = document.getElementById(field + 'Error');
            if (errorElement) {
                errorElement.textContent = '';
            }
        });

        // 입력 필드를 순회하며 값이 비어있는지 확인
        for (let i = 0; i < fields.length; i++) {
            const fieldValue = document.getElementById(fields[i]).value;
            if (!fieldValue) {
                // 값이 비어있으면 오류 메시지 표시
                const errorElement = document.getElementById(fields[i] + 'Error');
                if (errorElement) {
                    errorElement.textContent = '여기에 필수로 입력하세요';
                }
                isValid = false;
            }
        }

        if (isValid) {
            // 모든 필드가 유효하면 폼 제출
            console.log("Form is valid, submitting form...");
            frm.submit();
        } else {
            console.log("Form is not valid");
            alert("fail");
        }
    });
});
