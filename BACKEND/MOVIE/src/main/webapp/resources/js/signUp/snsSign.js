$(document).ready(function () {
  Kakao.init("174cc17a5c65ffeefd6d3cb7c0565e0e");
  Kakao.isInitialized();
});

function loginWithKakao() {
  Kakao.Auth.authorize({
    redirectUri: "http://localhost:8080/movie/sign_Up/sns/kakao",
  });
}
