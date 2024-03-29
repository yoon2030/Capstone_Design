<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE jsp>
<jsp lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>마이페이지 - 구매 요청 목록</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css?after" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">

  <!--  add CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/web.css" rel="stylesheet" type="text/css">
  <style>
  
	#card-img-top{width:220px; height:220px;}
	#wantbuy_btn{position: absolute; height: 35px;left: 212px;top: 190px;}
	#wantbuy_talentbtn{ position: absolute; height: 35px;left: 618px;top: 190px; width:200px;}

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
        <a href="index.html">중고마켓관리</a>
      </li>
      <li class="breadcrumb-item active">거래요청한 중고마켓품목</li>
    </ol>

    <!-- Blog Post -->
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
            <h2 class="card-title"><label>상품제목 : </label>${list.goods_Name}</h2>
            <p class="card-text"><label>판매자 : </label>${list.seller_Id}</p>
            <p class="card-text"><label>상품설명 : </label>${list.goods_Des}</p>
            <a id="wantbuy_btn" href="/admin/trade_view?n=${list.goods_Code}" class="btn btn-primary">상세한 정보 확인하기 &rarr;</a>
          </div>
        </div>
      </div>
      <div class="card-footer text-muted">
       	<p><label>판매자연락처 : </label>${list.phone_Num}</p>
        <a href="#"></a>
      </div>
    </div>
    </c:forEach>
    
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">재능마켓관리</a>
      </li>
      <li class="breadcrumb-item active">거래요청한 재능마켓품목</li>
    </ol>

    <!-- Blog Post -->
    <c:forEach items="${list2}" var="list2">
    <div class="card mb-4">
      <div class="card-body">
        <div class="row">
          <div class="col-lg-6">
            <h2 class="card-title"><label>재능제목 : </label>${list2.tals_Title}</h2>
            <p class="card-text"><label>판매자 : </label>${list2.tals_Id}</p>
            <p class="card-text"><label>재능 1차분류 : </label>${list2.tals_Kinds}</p>
            <p class="card-text"><label>재능 2차분류 : </label>${list2.tals_Kinds_2}</p>
            <p class="card-text"><label>가격 : </label>${list2.tals_Price}</p>
            <p class="card-text"><label>제작기간 : </label>${list2.tals_Term}</p>
            <a id="wantbuy_talentbtn" href="/talent/talent_S_view?n=${list2.tals_Code}" class="btn btn-primary">상세한 정보 확인하기 &rarr;</a>
          </div>
        </div>
      </div>
      <div class="card-footer text-muted">
       	<p><label>판매자연락처 : </label>${list2.phone_Num}</p>
        <a href="#"></a>
      </div>
    </div>
    </c:forEach>


  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">충대 장터</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
</body>

</jsp>
