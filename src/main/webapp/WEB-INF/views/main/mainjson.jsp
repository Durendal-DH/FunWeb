<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// main/mainjson.jsp
//		// 1단계 드라이버 불러오기
// 		Class.forName("com.mysql.jdbc.Driver");
// //		// 2단계 디비연결   jspdb1   jspid    jsppass
// 		Connection con=null;
// 		String dbUrl="jdbc:mysql://localhost:3306/jspdb1";
// 		String dbUser="jspid";
// 		String dbPass="jsppass";
// 		con=DriverManager.getConnection(dbUrl, dbUser, dbPass);
// 		// 3단계 - 연결정보를 이용해서 sql구문을 만들고 실행할 객체생성 select
// 		PreparedStatement pstmt=null;
// 		ResultSet rs=null;
// 		String sql="select * from board order by num desc limit 0,5";
// 		pstmt=con.prepareStatement(sql);
// 		// 4단계 - 만든 객체 실행   select => 결과 저장 내장객체
// 		rs=pstmt.executeQuery();
// 		//5단계 rs에 저장된 내용을 => 화면에 출력
// 		JSONArray boardList=new JSONArray();				
// 		while(rs.next()){
// 			JSONObject bb=new JSONObject();
// 			bb.put("subject",rs.getString("subject"));
// 			bb.put("date",rs.getString("date"));
// 			boardList.add(bb);
// 		}
%>
<%//=boardList %>
