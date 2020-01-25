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
                <h1>기사 보기</h1>
              </div>
            </div>

            
          </div>
        </div>
      </div>
    </div>  
    
    <div class="site-section">
      <div class="container">
        <div class="row justify-content-center mb-5">
          <div class="col-md-7 text-center border-primary">
            <h2 class="font-weight-light text-primary">${keyword }</h2>
            <p class="color-black-opacity-5">
            	<img src="<c:url value='/resources/images/excel.jpg'/>" width = "27px;">	
            	<a  href="excelDown?board_num=${num }&file_name=${keyword }">Excel Download</a>
            </p>
          </div>
        </div>


        <div class="row justify-content-center">
          <div class="col-lg-8">
			<c:forEach var="articleList" items="${ArticleList }">
            <div class="d-block d-md-flex listing-horizontal">

<!--               <a href="#" class="img d-block" style="background-image: url('images/img_2.jpg')"> -->
<!--               </a> -->

              <div class="lh-content">
                <h3><a href="${articleList.link }">${articleList.subject }</a></h3>
                <p>${articleList.subject }</p>
                <p>
                  ${articleList.date }(${articleList.press })
                </p>

                
              </div>

            </div>
			</c:forEach>
			
            <div class="col-12 mt-5 text-center">
              <div class="custom-pagination">
                <c:if test="${pageBean.page>1 }">
	            	<a href="content?num=${num }&keyword=${keyword }&page=${pageBean.page-1 }">＜</a>
	            </c:if>
	            <c:forEach var="i" begin="${pageBean.startPage }" end="${pageBean.endPage }" step="1" varStatus="page">
	            	<c:choose>
	            		<c:when test="${pageBean.page == page.current }">
	            			<span>${page.current }</span>
	            		</c:when>
	            		<c:otherwise>
	            		<a href = "content?num=${num }&keyword=${keyword }&page=${page.current }">${page.current }</a>
	            		</c:otherwise>
	            	</c:choose>
	            </c:forEach>
				<c:if test="${pageBean.page<pageBean.maxPage }">
					<a href = "content?num=${num }&keyword=${keyword }&page=${pageBean.page+1 }">></a>
				</c:if>
              </div>
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