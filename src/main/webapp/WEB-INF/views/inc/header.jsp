<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="site-navbar" role="banner">

	<div class="container">
		<div class="row align-items-center">

			<div class="col-11 col-xl-2">
				<h1 class="mb-0 site-logo">
					<a href="index.html" class="text-white h2 mb-0">Browse</a>
				</h1>
			</div>
			<div class="col-12 col-md-10 d-none d-xl-block">
				<nav class="site-navigation position-relative text-right"
					role="navigation">
					<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
						<li class="active"><a href="<c:url value='/'/>"><span>Home</span></a></li>
						<li><a href="<c:url value='/list'/>"><span>Articles</span></a></li>
						<li><a href="about.html"><span>About</span></a></li>
						<li><a href="blog.html"><span>Blog</span></a></li>
						<li><a href="contact.html"><span>Contact</span></a></li>
					</ul>
				</nav>
			</div>


			<div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3"
				style="position: relative; top: 3px;">
				<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
					class="icon-menu h3"></span></a>
			</div>

		</div>

	</div>
</header>