<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check() {
// 	if(document.getElementById("name").value =="") { 
// 		alert("이름을 입력하세요")
// 		return
// 		}
	if(document.querySelector("#name").value == "") {
		alert("이름을 입력하세요")
		return
	}
	if(document.getElementById("age").value =="") {
		alert("나이를 입력하세요")
	    return
	}
    var chk_obj = document.getElementsByName("hobby")
    var checked = false // false, true 대신에 0, 1로 해도 됨
    for(i=0;i<chk_obj.length;i++){
    	if(chk_obj[i].checked){
    		checked=true
    	}
    }
    if(checked == false) {
    	alert("관심분야 선택")
    	return
	}
    document.getElementById("frm").submit()
    }

</script>
</head>
<body>
<form action = "formResult.jsp" method="get" id ="frm">
    이름 : <input type="text" name="name" id="name"><br>
    나이 : <input type="text" name="age" id="age"><br>
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
    <input type="button" value="button전송" onclick="check()">
</form>

</body>
</html>