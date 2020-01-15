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
<!--   a bgfgf-->
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
    <div class="site-blocks-cover overlay" style="background-image: url(<c:url value='/resources/images/hero_1.jpg'/>;)" data-aos="fade" data-stellar-background-ratio="0.5">
      <div class="container">
        <div class="row align-items-center justify-content-center text-center">

          <div class="col-md-10">
            
            
            <div class="row justify-content-center mb-4">
              <div class="col-md-10 text-center">
                <h1 data-aos="fade-up">Find Nearby <span class="typed-words"></span></h1>
                <p data-aos="fade-up" data-aos-delay="100">Handcrafted free templates by <a href="https://free-template.co/" target="_blank">Free-Template.co</a></p>
              </div>
            </div>

            <div class="form-search-wrap p-2" data-aos="fade-up" data-aos-delay="200">
              <form action='<c:url value="/crawler"/>' method="post" onsubmit="return checkPage();">
                <div class="row align-items-center">
                  <div class="col-lg-12 col-xl-4 no-sm-border border-right">
                    <input type="text" class="form-control" name="keyword" placeholder="키워드를 입력해 주세요">
                  </div>
                  <div class="col-lg-12 col-xl-3 no-sm-border border-right">
                    <div class="wrap-icon">
                      <input type="number" class="form-control" name="page" placeholder="구글뉴스를 검색할 페이지 범위를 입력해주세요">
                    </div>
                    
                  </div>
                  <div class="col-lg-12 col-xl-3">
                    <div class="select-wrap">
                      <span class="icon"><span class="icon-keyboard_arrow_down"></span></span>
                      <select class="form-control" name="" id="">
                        <option value="">All Categories</option>
                        <option value="">Hotels</option>
                        <option value="">Restaurant</option>
                        <option value="">Eat &amp; Drink</option>
                        <option value="">Events</option>
                        <option value="">Fitness</option>
                        <option value="">Others</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-lg-12 col-xl-2 ml-auto text-right">
                    <input type="submit" class="btn text-white btn-primary" value="Search">
                  </div>
                  
                </div>
              </form>
            </div>

          </div>
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