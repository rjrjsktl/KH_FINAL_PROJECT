<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <%@ page session="false" %>


                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>전체영화</title>

                        <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
                        <link rel="stylesheet" href="${contextPath}/resources/css/store/store_payment.css">
                        <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>

                    </head>

                    <body>
                        <div id="wrap">

                            <!-- header -->
                            <jsp:include page="/WEB-INF/views/common/header.jsp" />


                            <main>


                                <div id="wrapper">








                                    <div>
                                        <div class="pay_wrapper">
                                            <div>
                                                <h4>상품정보</h4>
                                            </div>

                                            <div>
                                                <div>
                                                    <div>
                                                        <img src="${storeDetail.storeImage}">
                                                    </div>

                                                </div>

                                                <div>
                                                    <div>
                                                        <div class="tit">

                                                            <h4>${storeDetail.storeName}</h4>


                                                        </div>

                                                        <div class="quantity">
                                                            <h4>수량</h4>
                                                            <h4>
                                                                <span>${totalCount}</span>
                                                                <p>


                                                                </p>
                                                            </h4>
                                                            <h4>개</h4>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <div>
                                                <h4>결제수단</h4>
                                            </div>
                                            <div>
                                                <div></div>
                                                <div></div>
                                            </div>
                                        </div>
                                        <div>
                                            <div>
                                                <h4>결제하기</h4>
                                            </div>
                                            <div class="payment">

                                                <div>

                                                </div>

                                                <div>
                                                    <div>
                                                        <h4>상품금액</h4><span class="price" id="price"></span>
                                                        <fmt:formatNumber value="${totalPrice}" pattern="#,###" />
                                                        </span><em>원</em>
                                                    </div>

                                                    <div>
                                                        결제금액<span id="totalPrice">
                                                            <fmt:formatNumber value="${totalPrice}" pattern="#,###" />
                                                        </span><em>원</em>
                                                    </div>
                                                    <div>

                                                        <button>결제하기</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>



                                    </div>



                                </div>
                            </main>
                        </div>



                        <!-- footer -->
                        <jsp:include page="/WEB-INF/views/common/footer.jsp" />


                        <div id="myModal" class="modal">
                            <div class="modal-content">
                                <div class="close-button">&times;</div>
                                <iframe src="../login/login.html" frameborder="0" width="500px" height="500px"></iframe>
                            </div>
                        </div>
                        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
                            crossorigin="anonymous"></script>
                        <script src="${contextPath}/resources/js/store/store_payment.js"></script>
                        <script src="${contextPath}/resources/js/common/header.js"></script>
                    </body>

                    </html>