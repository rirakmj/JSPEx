<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check() {
	if(document.getElementById("name").value =="") {
	alert("이름을 입력하세요")
	return false
	}
	if(document.getElementById("kor").value =="" || isNaN(document.getElementById("kor").value)) {
	alert("숫자로 국어점수 입력하세요")
	document.getElementById("kor").value=""
	return false
	}
	if(document.getElementById("eng").value =="" || isNaN(document.getElementById("eng").value)) {
		alert("숫자로 영어점수 입력하세요")
		document.getElementById("eng").value=""
	return false
	}
	if(document.getElementById("math").value ==""|| isNaN(document.getElementById("math").value)) {
		alert("숫자로 수학점수 입력하세요")
		document.getElementById("math").value=""
	return false
	}
    return true
	}
</script>
</head>
<body>
<form action = "scoreResult.jsp" method="get" id = "frm" onsubmit = "return check()">
이름 : <input type="text" name="name"  id ="name" placeholder=" "><br>
국어 : <input type="text" name="korean" id = "kor" placeholder=" "><br>
영어 : <input type="text" name="english" id = "eng" placeholder=" "><br>
수학 : <input type="text" name="math" id = "math" placeholder=" "><br>
<input type="submit" value="submit전송">
</form>
</body>
</html>