
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
// const add =document.getElementById("add");
// const result =document.getElementById("result");

btn.addEventListener("click", function() {
let fields = ['userName', 'password', 'name', 'phone', 'email', 'address'];
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
            errorElement.textContent = '필수 입력하셔야합니다';
        }
        isValid = false;
    }
}

if (isValid) {
    // 모든 필드가 유효하면 폼 제출
    frm.submit();
} else {
    alert("fail");
}

// add.addEventListener("click", function(){
//    let input =document.createElement("input");
//    input.type="file"; 
//    input.classList.add("form-control");
//    result.append(input);
// })

});