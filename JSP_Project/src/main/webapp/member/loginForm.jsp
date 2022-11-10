<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<script>
$(function(){
	$("#loginBtn").click(function(){
		if($("#userid").val()==""){
		alert("아이디를 입력하세요");
		$("#userid").focus();
		return false;
		}
		if($("#pwd").val()==""){
			alert("비밀번호를 입력하세요");
			$("#pwd").focus();
			return false;
		} //pwd
		$.ajax({
			type:"post",
			url:"loginPro.jsp",
			data:{"userid":$("#userid").val(),"pwd":$("#pwd").val()},
			success:function(resp){
			if()
				alert("로그인 성공");
			} else if {
				alert("회원이 아닙니다")
			} else {
				alert("비밀번호가 틀렸습니다")
			}
				
			error:function(e){
				alert(e + "error")
			}
		
		}) // ajax
	}) //loginBtn
	
})
</script>
<title>Login</title>
</head>
<body>
<div class="container mt-3">
  <h2>로그인</h2>
  <form action="" method="post" id="frm">
    <div class="form-group">
      <label for="userid">UserID:</label>
      <input type="text" class="form-control" id="userid" placeholder="Enter Userid" name="userid">
    </div>
    
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter Password" name="pwd">
    </div>
    
    <button type="button" class="btn btn-primary" id="loginBtn">Submit</button>
    
</form>
</div>
</body>
</html>