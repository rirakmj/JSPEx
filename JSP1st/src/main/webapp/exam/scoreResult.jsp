<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String name = request.getParameter("name");
String korean = request.getParameter("korean");
String english = request.getParameter("english");
String math = request.getParameter("math");
String total = request.getParameter("total");
String average = request.getParameter("average");
int 국어 =  Integer.parseInt(korean);
int 영어 = Integer.parseInt(english);
int 수학 = Integer.parseInt(math);
int ttl = 국어 + 영어 + 수학;
float avg = (국어+영어+수학)/3.0f;
String grade = "" ;
// if문
if(avg >= 90) {
	grade = "A";
} else if(avg >= 80) {
	grade = "B";
} else if(avg >= 70) {
	grade = "C";
} else {
	grade = "F";
}
// switch case문
switch((int)avg/10) { // 90~99 / 80~89 / 70~79
case 10:
case 9: grade = "A";break;
case 8: grade = "B";break;
case 7: grade = "C";break;
default: grade = "F";break;
}
%>
이름 : <% out.println(name); %><br>
국어 : <% out.println(korean); %><br>
영어 : <% out.println(english); %><br>
수학 : <% out.println(math); %><br>
총점 : <% out.println(ttl); %><br>
평균 : <% out.println(avg); %><br>
<hr/>
이름 : <%= name%><br/>
국어 : <%= korean%><br>
영어 : <%= english%><br>
수학 : <%= math%><br>
총점 : <%= ttl %><br>
평균 : <%= avg%><br>
학점 : <%= grade%><br>
</body>
</html>