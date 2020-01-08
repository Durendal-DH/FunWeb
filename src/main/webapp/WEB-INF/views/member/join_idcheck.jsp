<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 function result() {
	// join.jsp  id상자 <=  검색한 id
	opener.document.fr.id.value = document.wfr.userid.value;
	// 창닫기
	window.close();
 }
</script>
</head>
<body>
<h1>member/join_idcheck.jsp</h1>
<%
// userid 파라미터 가져오기
//String id=request.getParameter("userid");
// // 출력
// out.println(id);
// // MemberDAO 객체생성
// MemberDAO mdao=new MemberDAO();
// // int check = idcheck(id) 메서드호출
// int check=mdao.idcheck(id);
// // check==1  아이디있음 "아이디중복"
// // check==0  아이디없음 "아이디 사용가능"
// if(check==1){
// 	out.println("아이디중복");
// }else{
// 	out.println("아이디 사용가능");
	%>
	<input type="button" value="아이디사용" onclick="result()">
	<%
// }
%>
<form action="join_idcheck.jsp" method="post" name="wfr">
아이디:<input type="text" name="userid" value="">
<input type="submit" value="아이디중복확인">
</form>
</body>
</html>