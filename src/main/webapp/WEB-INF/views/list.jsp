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
    <div class="site-blocks-cover inner-page-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
      <div class="container">
        <div class="row align-items-center justify-content-center text-center">

          <div class="col-md-10" data-aos="fade-up" data-aos-delay="400">
            
            
            <div class="row justify-content-center">
              <div class="col-md-8 text-center">
                <h1>기사 자료실</h1>
              </div>
            </div>

            
          </div>
        </div>
      </div>
    </div>  
    

    <div class="site-section bg-light">
      <div class="container">
        <div class="row">
          <div class="col-8">
			<c:forEach var="list" items="${List }">
            <div class="border p-3 rounded mb-2">
	        	<div>
	            	<a href="content?num=${list.num }&keyword=${list.keyword }(${list.date })&page=${pageBean.page}" class="accordion-item h5 d-block mb-0">${list.keyword }(${list.date })</a>
	            </div>
	            <div style="top: -25px; right: 4px; float: right; position: relative;">
	            	<a href="excelDown?board_num=${list.num }&file_name=${list.keyword }(${list.date })">
	            	<img src="<c:url value='/resources/images/excel.jpg'/>" width = "27px;">
	            	</a>
	            </div>
	            <div style="top: -25px; right: 28px;; float: right; position: relative;">
	            	${list.page }
	            </div>
            </div>
            </c:forEach>
	        <div class="col-12 mt-5 text-center">
	            <div class="custom-pagination">
	            <c:if test="${pageBean.page>1 }">
	            	<a href="list?page=${pageBean.page-1 }">＜</a>
	            </c:if>
	            <c:forEach var="i" begin="${pageBean.startPage }" end="${pageBean.endPage }" step="1" varStatus="page">
	            	<c:choose>
	            		<c:when test="${pageBean.page == page.current }">
	            			<span>${page.current }</span>
	            		</c:when>
	            		<c:otherwise>
	            		<a href = "list?page=${page.current }">${page.current }</a>
	            		</c:otherwise>
	            	</c:choose>
	            </c:forEach>
				<c:if test="${pageBean.page<pageBean.maxPage }">
					<a href = "list?page=${pageBean.page+1 }">></a>
				</c:if>
	            </div>
	        </div>
          </div>
          <div class="col-lg-3 ml-auto">

            <div class="mb-5">
              <h3 class="h5 text-black mb-3">Filters</h3>
              <form action="<c:url value="/list"/>" method="post">
                <div class="form-group">
                  <input type="text" placeholder="What are you looking for?" class="form-control" name="keyword">
                </div>
                <div class="form-group">
                  <!-- select-wrap, .wrap-icon -->
                  <div class="wrap-icon">
                    <input type="number" placeholder="Pages" class="form-control" name ="pages">
                  </div>
                </div>
                <div class="form-group">
                  <div class="select-wrap">
                      <span class="icon"><span class="icon-keyboard_arrow_down"></span></span>
                      <select class="form-control" name="" id="">
                        <option value="">All Categories</option>
                        <option value="">Appartment</option>
                        <option value="">Restaurant</option>
                        <option value="">Eat &amp; Drink</option>
                        <option value="">Events</option>
                        <option value="">Fitness</option>
                        <option value="">Others</option>
                      </select>
                    </div>
                </div>
	            <input type="submit" class="btn text-white btn-primary" value="Search">
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