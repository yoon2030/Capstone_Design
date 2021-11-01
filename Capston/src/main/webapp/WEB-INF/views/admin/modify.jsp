<%@ page session="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>중고장터 수정</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="./about2.css">
  <link rel="stylesheet" href="./about3.css">
  
  
 <style>
 
 	section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
	section#container::after { content:""; display:block; clear:both; }
	div#container_box { float:right; width:calc(100% - 200px - 20px); }
	
</style>
 
<style>
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:90px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }
.step_url {    position: absolute;    top: 16px;    right: 13px;    font-size: 15px;    color: #8e8e8e;}

.select_img img {margin:20px 0;}
.select_img img {width:418px; height:250px;}
#wrapper {
    position: relative;
    height: 100%;
}
#content {
    position: relative;
    left: 50%;
    transform: translate(-50%);
    width: 800px;
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
  

    <!-- Team Members -->
    <section id="container">
   
		<div id="wrapper"> 
<div id="content">
		
			    <h1 class="mt-4 mb-3">중고장터 수정
      <small></small>
    </h1>
			    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">중고장터</a>
      </li>
      <li class="breadcrumb-item active">중고장터 수정</li>
    </ol>
			
<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">

<input type="hidden" name="goods_Code" value="${goods.goods_Code}" />


<div class="inputArea">
 <label for="goods_Name">상품명</label>
 <input type="text" id="goods_Name" name="goods_Name" value="${goods.goods_Name}" required="required"/>
</div>
<div class="inputArea">
	<label for="goods_Cate">상품분류</label>
	<select id="goods_Cate" name="goods_Cate" >	 	
 	 	<option value="의류/액세서리" <c:if test='${goods.goods_Cate == "의류/액세서리"}'>selected</c:if>>의류/액세서리</option>
  		<option value="디지털/가전"<c:if test='${goods.goods_Cate == "디지털/가전"}'>selected</c:if>>디지털/가전</option>
 	 	<option value="도서/문구/티켓"<c:if test='${goods.goods_Cate == "도서/문구/티켓"}'>selected</c:if>>도서/문구/티켓</option>
 	 	<option value="뷰티/미용" <c:if test='${goods.goods_Cate == "뷰티/미용"}'>selected</c:if>>뷰티/미용</option>
 	 	<option value="음반/악기" <c:if test='${goods.goods_Cate == "음반/악기"}'>selected</c:if>>음반/악기</option>
 	 	<option value="생활/식품" <c:if test='${goods.goods_Cate == "생활/식품"}'>selected</c:if>>생활/식품</option>
 	 	<option value="가구/인테리어" <c:if test='${goods.goods_Cate == "가구/인테리어"}'>selected</c:if>>가구/인테리어</option>
 	 	<option value="충대나눔" <c:if test='${goods.goods_Cate == "충대나눔"}'>selected</c:if>>충대나눔</option>
 	 	<option value="기타" <c:if test='${goods.goods_Cate == "기타"}'>selected</c:if>>기타</option>
	</select>
</div>
<div class="inputArea">
 <label for="goods_Price">상품가격</label>
 <input type="number" id="goods_Price" name="goods_Price" value="${goods.goods_Price}" required="required"/>
</div>
<div class="inputArea">
 <label for="goods_Sta">상품상태</label>
	<select id="goods_Sta" name="goods_Sta" >
		<option value=1 <c:if test="${goods.goods_Sta == 1}">selected</c:if>>1(최하)</option>
  		<option value=2 <c:if test="${goods.goods_Sta == 2}">selected</c:if>>2</option>
 	 	<option value=3  <c:if test="${goods.goods_Sta == 3}">selected</c:if>>3</option>
 	 	<option value=4  <c:if test="${goods.goods_Sta == 4}">selected</c:if>>4</option>
 	 	<option value=5  <c:if test="${goods.goods_Sta == 5}">selected</c:if>>5(최상)</option>
	</select>
</div>
<div class="inputArea">
 <label for="goods_Des">상품소개</label>
 <textarea rows="5" cols="50" id="goods_Des" name="goods_Des">${goods.goods_Des}</textarea>
</div>
<div class="inputArea">
				<label for="goods_Pic">이미지</label>
				<input type="file" id="goods_Pic" name="file" />
				<div class="select_img">
					<img src="${goods.goods_Pic}" />
					<input type="hidden" name="goods_Pic" value="${goods.goods_Pic}" />
				</div>
				
				<script>
					$("#goods_Pic").change(function(){
						if(this.files && this.files[0]) {
							var reader = new FileReader;
							reader.onload = function(data) {
								$(".select_img img").attr("src", data.target.result).width(500);								
							}
							reader.readAsDataURL(this.files[0]);
						}
					});
				</script>
			</div>
<div class="inputArea">
 <button type="submit" id="update_Btn" class="btn btn-primary">완료</button>
 <button type="submit" id="back_Btn" class="btn btn-warning">취소</button>
  <script>
 $("#back_Btn").click(function(){
  //history.back();
  location.href = "/admin/trade_view?n=" + ${goods.goods_Code};
 });   
</script>
</div>   

</form>
			
		</div>
	</section>

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

</body>

</html>
