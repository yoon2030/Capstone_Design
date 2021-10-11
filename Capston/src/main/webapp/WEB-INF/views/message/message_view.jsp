<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>쪽지 확인</title>
	<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">

</head>

<body>

<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">

<h1 class="mt-4 mb-3">쪽지확인</h1>
<div class="card-body">
	
	<p class="card-text"><label>받는 사람 : </label>${message.recv_Id}</p>
	<p class="card-text"><label>보낸 사람 : </label>${message.send_Id}</p>
	<p class="card-text"><label>보낸 시간 : </label><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${message.send_Time}"/></p>
	<p class="card-text"><label>내용 : </label>${message.content}</p>
</div>

<div class="inputArea">
	<button type="button" id="message_Btn" onclick ="rowClick('${message.send_Id}');" class="btn btn-danger">답장하기</button>
			<script>
				function rowClick(id){
						var url = '/message/message_Send?n='+id;
						window.open(url,'popupView','widt=500,height=500');
					}
			</script>
	<button id="close_btn"  onclick ="opener.parent.location.reload();window.close();">닫기</button>
	
</div>
</form>

</body>

</html>