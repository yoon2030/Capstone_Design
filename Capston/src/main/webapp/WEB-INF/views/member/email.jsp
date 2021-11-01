<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

<title>이메일 인증</title>
  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
</head>
<body>
 
 

<table border="1" width="300" height="300" align= "center">
<center>
<span style="color: green; font-weight: bold;">이메일 인증 (이메일을 인증 받아야 다음 단계로 넘어갈 수 있습니다.)</span> <br> <br>    
        <br> <br>
        
        
 
        
        <div style="text-align:center;">
            <tr>        
                <td>
                <center>
                    <form action="auth.do" method="post">
                    
                    <center>
                    <div id = "email_logo">
                    </div>
                        <br>
                        <div>
                            이메일 : <input type="text" name="e_mail" placeholder="학교이메일주소 입력 "><span class="step_url1"><br>@chungbuk.ac.kr</span>
                        </div>                                                    
 
                        <br> <br>
                        <button type="submit" name="submit">이메일인증 보내기)</button>
 
                        </div>
                    </td>
                </tr>
                    </center>
            </table>
        </form>
        <div>  
     
      <div id="email_img">

      </div>
</center>

  </div>
 
</body>
</html>
