<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/default.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/front.css"/>' rel="stylesheet" type="text/css">

<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->

<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]--> 
<script src='<c:url value="/resources/script/jquery-3.4.1.js"/>'></script>
<script type="text/javascript">
	$(document).ready(function() {
// 		.getJSON() 함수사용
// 버튼 클릭시 table태그에 json데이터 가져와서 출력
// 		$('.brown').click(function(){
// 			$.getJSON('mainjson.jsp',function(data){
// 				$.each(data,function(index,item){
// 		$('table').append("<tr><td class='contxt'><a href='#'>"+item.subject+"</a></td><td>"+item.date+"</td></tr>");
// 				});
// 			});
// 		});

		$('.brown').click(function(){
			$('table').html("");
			$.getJSON('<c:url value="/board/list2"/>',function(data){
				$.each(data,function(index,item){
		$('table').append("<tr><td class='contxt'><a href='#'>"+item.subject+"</a></td><td>"+item.date+"</td></tr>");
				});
			});
		});

	});
</script>

</head>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<div class="clear"></div>
<div id="main_img"><img src='<c:url value="/resources/images/main_img.jpg"/>'
 width="971" height="282"></div>
<!-- 메인이미지 들어가는곳 -->
<!-- 메인 콘텐츠 들어가는 곳 -->
<article id="front">
<div id="solution">
<div id="hosting">
<h3>Web Hosting Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
<div id="security">
<h3>Web Security Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
<div id="payment">
<h3>Web Payment Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
</div>
<div class="clear"></div>
<div id="sec_news">
<h3><span class="orange">Security</span> News</h3>
<dl>
<dt>Vivamus id ligula....</dt>
<dd>Proin quis ante Proin quis anteProin 
quis anteProin quis anteProin quis anteProin 
quis ante......</dd>
</dl>
<dl>
<dt>Vivamus id ligula....</dt>
<dd>Proin quis ante Proin quis anteProin 
quis anteProin quis anteProin quis anteProin 
quis ante......</dd>
</dl>
</div>
<div id="news_notice">
<h3 class="brown">News &amp; Notice</h3>
<table>
<%
// //BoardDAO bdao 객체생성
// BoardDAO bdao=new BoardDAO();
// // 게시판 전체 글개수  가져오기  select count(*) 
// int count=bdao.getBoardCount();
// // 한 화면에 보여줄 글개수 설정
// int pageSize=5;
// //   pageNum="1" 설정
// String pageNum="1";
// int currentPage=Integer.parseInt(pageNum);
// // 시작하는 행번호 구하기 => 식구하기 => 알고리즘
// int startRow = (currentPage-1)*pageSize+1;
// // 날짜형태 변경 => 문자열 변경
// SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
// // List boardList = getBoardList()호출
// List boardList=bdao.getBoardList(startRow, pageSize);
// // 게시판에 글이있으면
// // for   자바빈 <= 배열한칸 정보
// if(count!=0){
// 	for(int i=0;i<boardList.size();i++){
// 		BoardBean bb=(BoardBean)boardList.get(i);
		%>
<!-- 	<tr><td class="contxt"> -->
<%-- 	    <a href="../center/content.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>"><%=bb.getSubject() %></a></td> --%>
<%--         <td><%=sdf.format(bb.getDate()) %></td></tr>	 --%>
		<%
// 	}
// }
%>
</table>
</div>
</article>
<!-- 메인 콘텐츠 들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>