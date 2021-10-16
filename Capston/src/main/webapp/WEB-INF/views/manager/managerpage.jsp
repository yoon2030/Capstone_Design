<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Modern Business - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
  <style>
  * {
    margin: 0;
    padding: 0;
}



body {
    font: 17px 'Nanum Gothic', sans-serif;
}



a {
    text-decoration: none;
    color: #404040;
}



li {
    list-style: none;
}



/*BODY*/

#notice {
    width: 100%;
    margin: 0 auto;
    box-sizing: border-box;
    /*outline: 1px dashed black;*/
}



#notice h1 {
    font-size: 25px;
    text-align: center;
    margin: 10px 180px;
    padding: 10px;
    color: #fff;
    background: #007AAE;
    border-radius: 30px;

}



#notice ul {
    width: 100%;
}



#notice ul li {
    line-height: 30px; /*li 세로 간격*/
    padding-left: 20px;
}



#notice ul li:first-child {
    border-top: 2px solid #6a6a6a;
    border-bottom: 2px solid #6a6a6a;
    padding-left: 150px;
}



#notice ul li:last-child {
    border-bottom: 1px solid #000;
}






#notice ul li span {
    display: inline-block;
    float: right;
    width: 150px;
    text-align: center;
}


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
            <a class="nav-link" href="/manager/contact_member">회원관리</a>
          </li>
          <li class="nav-item dropdown">
           <a class="nav-link"  href="/manager/manager">공지사항관리</a>
          </li>
          <li class="nav-item dropdown">
           <a class="nav-link" href="/manager/manager_sell">중고마켓관리</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" href="/manager/manager_talent_S">재능판매관리</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" href="/manager/manager_faq">1:1문의관리</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/logout">로그아웃</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->

    <!-- /.row -->

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


  <!-- Contact form JavaScript -->
  <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

</body>

</html>
