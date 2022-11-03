<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

<script>
$(document).ready(function() { // 다른 것 다 읽고 실행하기, 이름 없이 코드를 바로 괄호 안에 작성
	$("#btn").click(function() {
		if($("#name").val()=="") {
			alert("이름 입력")
			return
		}
		if($("#kor").val()=="" || !$.isNumeric($("#kor").val())) {
			alert("국어 점수 입력")
	$("#kor").val("")
	return
}
		if($("#eng").val()=="" || !$.isNumeric($("#eng").val())) {
			alert("영어 점수 입력")
	$("#eng").val("")
	return
}
		if($("#math").val()=="" || !$.isNumeric($("#math").val())) {
			alert("수학 점수 입력")
	$("#math").val("")
	return
}
		$("#frm").submit()
})
})
</script>
</head>
<body>
<form action = "scoreResult.jsp" id = "frm">
이름 : <input type="text" name="name"  id ="name" placeholder=" "><br>
국어 : <input type="text" name="korean" id = "kor" placeholder=" "><br>
영어 : <input type="text" name="english" id = "eng" placeholder=" "><br>
수학 : <input type="text" name="math" id = "math" placeholder=" "><br>
<input type="button" value="jquery전송" id = "btn">
</form>
</body>
</html>