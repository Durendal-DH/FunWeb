<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Browse &mdash; Free Website Template by Free-Template.co</title>
    <jsp:include page="resource/css.jsp"/>
  </head>
  <body>
  
  <div class="site-wrap">

    <div class="site-mobile-menu">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
	<!--     header -->
	<jsp:include page="inc/header.jsp"></jsp:include>
	<!-- 	header -->
  
	<!-- content -->
	<div class="site-blocks-cover overlay" style="background-image: url(<c:url value='/resources/images/news.jpg'/>;)" data-aos="fade" data-stellar-background-ratio="0.5">
      <div class="container">
        <div class="row align-items-center justify-content-center text-center">

          <div class="col-md-10" data-aos="fade-up" data-aos-delay="400">
            
            
            <div class="row justify-content-center">
              <div class="col-md-8 text-center">
                <h1>Popular Keyword</h1>
              </div>
            </div>

            
          </div>
        </div>
      </div>
    </div>  

    <div class="site-section bg-light">
      <div class="container">
        <div class="row">
        <!-- 그래프 들어갈 부분 -->
        
        <!-- 그래프 들어갈 부분 -->
        </div>
      </div>
    </div>
    <!-- content --> 

	<!--     footer -->
    <jsp:include page="inc/footer.jsp"></jsp:include>
	<!--     footer -->
	</div>
  </body>
  <jsp:include page="resource/script.jsp"/>
</html>