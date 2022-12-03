<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
	integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css"
	integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="css/services.css" />
<title>1990年代韓IDOL</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light shadow-lg sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand " href="main"><img src="images/logo.png"
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
						aria-current="page" href="main">ホーム</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-primary" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							韓アイドル </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">１９９０年代</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">２０００年代</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="2010korea.jsp">２０1０年代</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-danger" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							日アイドル </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">１９９０年代</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">２０００年代</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">２０1０年代</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link" href="board">掲示板</a>
					</li>
				</ul>
				<c:if test="${empty userID}">
					<div class="nav-item dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">ログイン</button>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
								data-bs-target="#myModal" aria-expanded="false">ログイン</a></li>
							<li><a class="dropdown-item" href="join">会員登録</a></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${not empty userID}">
					<div class="nav-item dropdown">
						<c:if test="${!emailCheck}">
							<a href="emailSend" class="btn btn-danger" role="button"
								onclick="clickEvent();">E-MAIL確認</a>
						</c:if>
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">会員管理</button>
						<ul class="dropdown-menu dropdown-menu-end">
							<li class="dropdown-divider"></li>

							<li><a class="dropdown-item" href="logout.jsp">ログアウト</a></li>
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
					<form action="login"
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
	<section id="services">
		<div class="section-content">
			<div class="container services">
				<div class="services-header text-center py-5">
					<h1 class="diplay-5">韓国アイドル（2010年代)</h1>
					<div class="divider"></div>
					<a href="#" role="button" class="btn btn-primary ">2000年代へ</a>
				</div>
				<div id="slick-slide" class="services-body">
					<div class="services-col mx-2 my-3">
						<div class="card" >
							<a href=""> <img src="images/korea/aespa.png" alt=""
								class="card-img-top" />
							</a>
							<div class="card-body">
								<h4 class="card-title">aespa</h4>
								<p class="card-text fw-light mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Placeat sit esse vel minus nulla enim incidunt voluptatum iste velit doloribus modi eligendi excepturi itaque! Laboriosam quidem ullam necessitatibus atque error!</p>
								<a href="#" class="btn btn-primary">View more</a>
							</div>
						</div>
					</div>
					<div class="services-col mx-2 my-3">
						<div class="card">
							<a href=""> <img src="images/korea/ive.png" alt=""
								class="card-img-top" />
							</a>
							<div class="card-body">
								<h4 class="card-title">IVE</h4>
								<p class="card-text fw-light mb-4">IVE</p>
								<a href="#" class="btn btn-primary">View more</a>
							</div>
						</div>
					</div>
					<div class="services-col mx-2 my-3">
						<div class="card">
							<a href=""> <img src="images/korea/lesserafim.jpeg" alt=""
								class="card-img-top" />
							</a>
							<div class="card-body">
								<h4 class="card-title">Lesserafim</h4>
								<p class="card-text fw-light mb-4">Lesserafim</p>
								<a href="#" class="btn btn-primary">View more</a>
							</div>
						</div>
					</div>
					<div class="services-col mx-2 my-3">
						<div class="card">
							<a href=""> <img src="images/japan/nogizaka.png" alt=""
								class="card-img-top" />
							</a>
							<div class="card-body">
								<h4 class="card-title">乃木坂46</h4>
								<p class="card-text fw-light mb-4">乃木坂46</p>
								<a href="#" class="btn btn-primary">View more</a>
							</div>
						</div>
					</div>
					<div class="services-col mx-2 my-3">
						<div class="card">
							<a href=""> <img src="images/japan/momoiro.png" alt=""
								class="card-img-top" />
							</a>
							<div class="card-body">
								<h4 class="card-title">ももいろクローバーZ</h4>
								<p class="card-text fw-light mb-4">ももいろクローバーZ</p>
								<a href="#" class="btn btn-primary">View more</a>
							</div>
						</div>
					</div>
					<div class="services-col mx-2 my-3">
						<div class="card">
							<a href=""> <img src="images/japan/perfume.jpeg" alt=""
								class="card-img-top" />
							</a>
							<div class="card-body">
								<h4 class="card-title">Perfume</h4>
								<p class="card-text fw-light mb-4">Perfume</p>
								<a href="#" class="btn btn-primary">View more</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="py-5 text-center container">
		<div class="row py-lg-5">
			<div class="col-lg-6 col-md-8 mx-auto">
				<h1 class="fw-light">韓国アイドル（2010年代)</h1>
				<a href="#" role="button" class="btn btn-primary my-2 mt-4">2000年代へ</a>
			</div>
		</div>
	</section>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.slim.min.js"
		integrity="sha512-yBpuflZmP5lwMzZ03hiCLzA94N0K2vgBtJgqQ2E1meJzmIBfjbb7k4Y23k2i2c/rIeSUGc7jojyIY5waK3ZxCQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
		integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script src="js/app.js"></script>
	<script src="js/slick.js"></script>

</body>
</html>