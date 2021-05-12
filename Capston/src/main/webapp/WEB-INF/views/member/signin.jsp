<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<head>
  <meta charset="utf-8">
  <title>충대장터</title>
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/market.css" rel="stylesheet" type="text/css">


</head>
<body>
    <div id="login-center">
    <form role="form" method="post" action="/member/signin" autocomplete="off">
        <h2 >
            <span>로그인</span>
        </h2>
        <h1>
            <span>충대 장터</span>
        </h1>
        <h1>Login</h1>
        <div class="idForm">
         <label for="userId">아이디</label>
  		 <input type="text" id="userId" name="userId" required="required" />            
        </div>
        <div class="pwdForm">
           <label for="userPw">패스워드</label>
  		 <input type="password" id="userPw" name="userPw" required="required" />   
        </div> 
        <button type="submit" class="btn" name="btn btn-primary">Log In</button>
			<p style="color:#f00;">${msg}</p>
	</form>
        <div class="join">
           아이디가 없으신가요? <a href="/member/signup">회원 등록</a>
         </div>
  </div>
</body>
</html>