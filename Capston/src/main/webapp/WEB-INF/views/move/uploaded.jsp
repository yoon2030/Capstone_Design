<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE jsp>
<jsp lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>마이 페이지 - 등록한 목록</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css?after" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">

	<!--  add CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/web.css" rel="stylesheet" type="text/css">
   <style>
  
  .card-img-top{width: 220px; height: 220px;}
  
  </style> 
</head>

<body>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/move/index">충대 장터</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/move/contact">공지사항</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" href="/admin/trade_list"> 중고장터</a>
          </li>
          <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              재능장터
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="/talent/talent_S_list?n=디자인">디자인</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=번역/외국어">번역/외국어</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=문서작성">문서작성</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=음악/영상">음악/영상</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=프로그램개발">프로그램개발</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=생활서비스">생활서비스</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              마이페이지
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="/move/uploaded">등록한 중고/재능</a>
              <a class="dropdown-item" href="/move/trade">거래요청받은 중고/재능거래</a>
              <a class="dropdown-item" href="/move/wantbuy">거래요청한 중고/재능거래</a>
              <a class="dropdown-item" href="/move/trade_complete">거래완료(후기작성)</a>
              <a class="dropdown-item" href="/move/review">후기관리</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              FAQ
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPages">
              <a class="dropdown-item" href="/move/faq1">자주찾는 질문</a>
              <a class="dropdown-item" href="/move/faq2">1:1문의</a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/message/message_list">쪽지함(${num})</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/logout">로그아웃</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>



  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">마이 페이지
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">품목관리</a>
      </li>
      <li class="breadcrumb-item active">중고마켓 물건</li>
    </ol>
	<c:forEach items="${list}" var="list">
    <div class="card mb-4">
      <div class="card-body">
        <div class="row">
          <div class="col-lg-6">
            <a href="/admin/trade_view?n=${list.goods_Code}">
                        <div class="col-lg-6">
              <img src="${list.goods_Pic}" class="card-img-top"/>
              </div>
            </a>
          </div>
          <div class="view-img">
            <h2 class="card-title"><span>상품제목 :</span>${list.goods_Name}</h2>
            <p class="card-text"><span>진행상태 :</span>${list.goods_State}</p>
            <p class="card-text"><span>상품설명 :</span>${list.goods_Des}</p>
             <a style="height: 33px;position: absolute;left: 254px; bottom: -81px;width: 222px;"
              href="/admin/trade_view?n=${list.goods_Code}" class="btn btn-primary" >상세한 정보 확인하기 &rarr;</a>
          </div>
        </div>
      </div>
      <div class="card-footer text-muted">
      <fmt:formatDate pattern="yyyy/MM/dd" value="${list.goods_Date}"/>
      </div>
    </div>
	</c:forEach>
 <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">품목관리</a>
      </li>
      <li class="breadcrumb-item active">재능마켓 재능</li>
    </ol>
<c:forEach items="${list2}" var="list2">
    <div class="card mb-4">
      <div class="card-body">
        <div class="row">
          <div class="col-lg-6">
            <h2 class="card-title"><span>재능제목 :</span>${list2.tals_Title}</h2>
            <p class="card-text"><span>재능 1차분류 :</span>${list2.tals_Kinds}</p>
            <p class="card-text"><span>재능 2차분류 :</span>${list2.tals_Kinds_2}</p>
            <p class="card-text"><span>가격 :</span>${list2.tals_Price}<span>원</span></p>
            <p class="card-text"><span>제작 기간 :</span>${list2.tals_Term}<span>일</span></p>
            <a style="position: relative; left: 419px;"
            id="wantbuy_btn" href="/talent/talent_S_view?n=${list2.tals_Code}" class="btn btn-primary">상세한 정보 확인하기 &rarr;</a>
          </div>
        </div>
      </div>
      <div class="card-footer text-muted">
     	 <fmt:formatDate pattern="yyyy/MM/dd" value="${list2.tals_Date}"/>
      </div>
    </div>
	</c:forEach>

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">충대장터</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
</body>

</jsp>
