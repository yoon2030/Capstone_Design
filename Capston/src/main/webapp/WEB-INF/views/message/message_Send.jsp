<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>쪽지 보내기</title>
	<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">

</head>

<body>

<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">

<h1 class="mt-4 mb-3">쪽지보내기</h1>

<div class="inputArea">
	<label for="tals_Term">받는 사람 : </label>
	<input type="text" id = "recv_Id"name="recv_Id" value="${recv_Id}"/>
</div>
<div class="inputArea">
	<label for="content">내용 : </label>
	<textarea rows="5" cols="50" id="content" name="content"></textarea>
</div>

<div class="inputArea">
	<button id="register_Btn"  onclick ="rowClick()">보내기</button>
	<button id="close_btn"  onclick ="opener.parent.location.reload();window.close();">닫기</button>
	<script language="JavaScript">
	function rowClick(){
		var frmPop = document.frmPopup;
		var url = '/message/message_Send';
		frmPop.action = url;
		frmPop.submit();
	}
	</script>
</div>
</form>

</body>

</html>