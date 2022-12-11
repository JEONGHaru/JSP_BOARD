<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link type="text/css;" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<title>日韓アイドル</title>
<style type="text/css">
	
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light shadow-lg sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand " href="/main"><img src="/images/logo.png"
				alt="" /></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/main">ホーム</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-primary" 
						role="button" data-bs-toggle="dropdown" aria-expanded="false" disabled>
							韓アイドル </a>
						<ul class="dropdown-menu dropend">
							<li><a class="dropdown-item dropdown-toggle" role="button" >１９９０年代</a>
								<ul class="dropdown-menu submenu">
									<li><a href="/album/korea/year1990/boy" class="dropdown-item">BoyGroup</a></li>
									<li><a href="/album/korea/year1990/girl" class="dropdown-item">GirlGroup</a></li>
								</ul>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item dropdown-toggle" role="button">２０００年代</a>
								<ul class="dropdown-menu submenu">
									<li><a href="/album/korea/year2000/boy" class="dropdown-item">BoyGroup</a></li>
									<li><a href="/album/korea/year2000/girl" class="dropdown-item">GirlGroup</a></li>
								</ul>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item dropdown-toggle" role="button">２０１０年代</a>
								<ul class="dropdown-menu submenu">
									<li><a href="/album/korea/year2010/boy" class="dropdown-item">BoyGroup</a></li>
									<li><a href="/album/korea/year2010/girl" class="dropdown-item">GirlGroup</a></li>
								</ul>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item dropdown-toggle" role="button">２０２０年代</a>
								<ul class="dropdown-menu submenu">
									<li><a href="/album/korea/year2020/boy" class="dropdown-item">BoyGroup</a></li>
									<li><a href="/album/korea/year2020/girl" class="dropdown-item">GirlGroup</a></li>
								</ul>
							</li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-danger" disabled
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							日アイドル </a>
						<ul class="dropdown-menu dropend">
							<li><a class="dropdown-item dropdown-toggle" role="button">１９９０年代</a>
								<ul class="dropdown-menu submenu">
									<li><a href="/album/japan/year1990/boy" class="dropdown-item text-center">BoyGroup</a></li>
									<li><a href="/album/japan/year1990/girl" class="dropdown-item text-center">GirlGroup</a></li>
								</ul>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item dropdown-toggle" role="button">２０００年代</a>
								<ul class="dropdown-menu submenu">
									<li><a href="/album/japan/year2000/boy" class="dropdown-item">BoyGroup</a></li>
									<li><a href="/album/japan/year2000/girl" class="dropdown-item">GirlGroup</a></li>
								</ul>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item dropdown-toggle" role="button">２０１０年代</a>
								<ul class="dropdown-menu submenu">
									<li><a href="/album/japan/year2010/boy" class="dropdown-item">BoyGroup</a></li>
									<li><a href="/album/japan/year2010/girl" class="dropdown-item">GirlGroup</a></li>
								</ul>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item dropdown-toggle" role="button">２０２０年代</a>
								<ul class="dropdown-menu submenu">
									<li><a href="/album/japan/year2020/boy" class="dropdown-item">BoyGroup</a></li>
									<li><a href="/album/japan/year2020/girl" class="dropdown-item">GirlGroup</a></li>
								</ul>
							</li>
						</ul></li>
					<li class="nav-item"><a class="nav-link" href="/board/list">掲示板</a>
					</li>
				</ul>
				<c:if test="${empty principal}">
					<div class="nav-item dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">ログイン</button>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
								data-bs-target="#myModal" aria-expanded="false">ログイン</a></li>
							<li><a class="dropdown-item" href="/user/join_view">会員登録</a></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${not empty principal}">
					<div class="nav-item dropdown">
						<c:if test="${!isEmailCheck}">
							<a href="/user/emailSend" class="btn btn-danger" role="button"
								onclick="clickEvent();">E-MAIL確認</a>
						</c:if>
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">会員管理</button>
						<ul class="dropdown-menu dropdown-menu-end">
							<li class="dropdown-divider"></li>

							<li><a class="dropdown-item" href="/user/logout">ログアウト</a></li>
						</ul>
					</div>
				</c:if>
			</div>
		</div>
	</nav>
	<div class="modal fade" id="myModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">

			<div class="modal-content rounded-4 shadow">
				<div class="modal-header p-5 pb-4 border-bottom-0">
					<h1 class="fw-bold mb-0 fs-2">ログイン</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body p-5 pt-0">
					<form action="/user/login"
						onsubmit="loginFormSubmit(this); return false;" method="post">
						<div class="form-floating mb-3">
							<input type="text" autofocus
								class="form-control rounded-3 myInput" id="floatingInput"
								name="userID" placeholder="ID"> <label
								for="floatingInput">ID</label>
						</div>
						<div class="form-floating mb-3">
							<input type="password" class="form-control rounded-3"
								id="floatingPassword" name="userPassword" placeholder="Password">
							<label for="floatingPassword">PASSWORD</label>
						</div>
						<button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary"
							type="submit">LOG IN</button>
						<a class="text-primary" href="#" hidden="hidden">ID•PASSWORDを忘れた方はこちら</a>
						<hr class="my-4">

					</form>
				</div>
			</div>
		</div>
	</div>