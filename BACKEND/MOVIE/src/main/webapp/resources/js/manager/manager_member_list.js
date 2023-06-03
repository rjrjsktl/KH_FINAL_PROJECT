// function selectAll() {

//     $.ajax({
//         url: "manager/getUserList",
//         dataType: "json",
//         success: function (list) {
//             //console.log(list);

//             const memberList = document.getElementById("memberList");

//             memberList.innerHTML = "";

//             // 2) list를 for문을 이용해서 반복 접근
//             for (let item of list) {
//                 // item == 회원 1명의 정보가 담긴 JS 객체

//                 // 3) tr 요소 생성
//                 const tr0 = document.createElement("tr11");

//                 // 4) td 요소 생성 + 내용 추가 * 3
//                 const td1 = document.createElement("td22");
//                 td1.innerText = item.memberNo; // 회원 번호

//                 const td2 = document.createElement("td33");
//                 td2.innerText = item.memberEmail; // 회원 이메일

//                 const td3 = document.createElement("td44");
//                 td3.innerText = item.memberNickname; // 회원 닉네임

//                 // 5) tr요소에 td요소 3개 추가
//                 tr.append(td1, td2, td3);

//                 // 6) memberList에 tr 추가
//                 memberList.append(tr);
//             }


//         },
//         error: function () {
//             console.log("에러 발생");
//         }
//     });

// }