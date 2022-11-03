<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>

<body>
<script>
$(document).ready(function() { // 다른 것 다 읽고 실행하기, 이름 없이 코드를 바로 괄호 안에 작성
	$("#btn").click(function() {
		if($("#name").val()=="") {
			alert("이름 입력")
			return
		}
		if($("#age").val()=="") {
			alert("나이 입력")
			return
		}
		// 관심분야 선택 안 하면 선택하라는 alert
		if($("input:checkbox[name = 'hobby']:checked").length == 0) {
			alert("관심분야 선택");
			return
		} // 속성은 대괄호로
		$("#frm").submit()
		})
	})
	</script>
		
<form action = "formResult.jsp" method="get" id = "frm">
    이름 : <input type="text" name="name" id ="name"><br>
    나이 : <input type="text" name="age" id ="age"><br>
    성별 : 
    남자 <input type="radio" id="m" name="gender" value="남자" checked> 
    여자 <input type="radio" id="f" name="gender" value="여자"><br/>
    관심분야 : 
    운동 <input type="checkbox" name="hobby" value="운동" id="h1"> 
    게임 <input type="checkbox" name="hobby" value="게임" id="h2"> 
    등산 <input type="checkbox" name="hobby" value="등산" id="h3"> 
    영화 <input type="checkbox" name="hobby" value="영화" id="h4"><br/>
    <label for="job">직업 :</label>
    <select name="job" id="job">
    <option value="학생">학생</option>
    <option value="공무원">공무원</option>
    <option value="회사원">회사원</option>
    <option value="기타">기타</option>
  </select>
  <br>
    <input type="button" value="jquery전송" id="btn">
</form>
</body>
</html>