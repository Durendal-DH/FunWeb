<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <script src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-migrate-3.0.1.min.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
  <script src="<c:url value='/resources/js/popper.min.js'/>"></script>
  <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/resources/js/owl.carousel.min.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery.stellar.min.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery.countdown.min.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery.magnific-popup.min.js'/>"></script>
  <script src="<c:url value='/resources/js/bootstrap-datepicker.min.js'/>"></script>
  <script src="<c:url value='/resources/js/aos.js'/>"></script>
  <script src="<c:url value='/resources/js/rangeslider.min.js'/>"></script>
  

  <script src="<c:url value='/resources/js/typed.js'/>"></script>
            <script>
            var typed = new Typed('.typed-words', {
            strings: ["Attractions"," Events"," Hotels", " Restaurants"],
            typeSpeed: 80,
            backSpeed: 80,
            backDelay: 4000,
            startDelay: 1000,
            loop: true,
            showCursor: true
            });
          	function checkPage(){
          		var keyword = document.getElementById("keyword");
          		if(keyword == null){
          			alert("키워드를 입력하세요.");
          			return false;
          		}
          		var page = document.getElementById("page");
          		if(page == null){
          			alert("페이지 수를 입력하세요.");
          			return false;
          		}
          	}
            </script>

  <script src="<c:url value='/resources/js/main.js'/>"></script>