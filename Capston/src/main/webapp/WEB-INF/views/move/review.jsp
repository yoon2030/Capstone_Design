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

  <title>후기 관리</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">

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
        <a href="index.html">후기관리</a>
      </li>
      <li class="breadcrumb-item active">중고거래 후기관리</li>
    </ol>
	<c:forEach items="${list}" var="list">
    <div class="card mb-4">
      <div class="card-body">
        <div class="row">
          <div class="col-lg-6">
            <p class="card-text"><span>거래한 상품 :</span>${list.review_Goods}</p>
            <p class="card-text"><span>거래자 :</span>${list.review_Trader}</p>
            <p class="card-text"><span>별점 :</span>${list.review_Sta}</p>
            <p class="card-text"><span>후기내용 :</span>${list.review_Content}</p>

			<a href="/move/review_modify?n=${list.review_Code}" class="btn btn-primary">수정 &rarr;</a>
			<a href="/move/review_delete?n=${list.review_Code}" class="btn btn-primary">삭제 &rarr;</a>

          </div>
        </div>
      </div>
      <div class="card-footer text-muted">
       <fmt:formatDate pattern="yyyy/MM/dd" value="${list.review_Date}"/>
      </div>
    </div>
	</c:forEach>
	
	<ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">후기관리</a>
      </li>
      <li class="breadcrumb-item active">재능거래 후기관리</li>
    </ol>
	<c:forEach items="${list2}" var="list2">
    <div class="card mb-4">
      <div class="card-body">
        <div class="row">
          <div class="col-lg-6">
            <p class="card-text"><span>재능 1차분류 :</span>${list2.rev_T_Kinds}</p>
            <p class="card-text"><span>재능 2차분류 :</span>${list2.rev_T_Kinds_2}</p>
            <p class="card-text"><span>거래자 :</span>${list2.rev_T_Trader}</p>
            <p class="card-text"><span>별점 :</span>${list2.rev_T_Sta}</p>
            <p class="card-text"><span>후기내용 :</span>${list2.rev_T_Content}</p>

			<a href="/move/review_modify_t?n=${list2.rev_T_Code}" class="btn btn-primary">수정 &rarr;</a>
			<a href="/move/review_delete_t?n=${list2.rev_T_Code}" class="btn btn-primary">삭제 &rarr;</a>

          </div>
        </div>
      </div>
      <div class="card-footer text-muted">
       <fmt:formatDate pattern="yyyy/MM/dd" value="${list2.rev_T_Date}"/>
      </div>
    </div>
	</c:forEach>

    <!-- Pagination -->
    <ul class="pagination justify-content-center mb-4">
      <li class="page-item">
        <a class="page-link" href="#">&larr; Older</a>
      </li>
      <li class="page-item disabled">
        <a class="page-link" href="#">Newer &rarr;</a>
      </li>
    </ul>

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
