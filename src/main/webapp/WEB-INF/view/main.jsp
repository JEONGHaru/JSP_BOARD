<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="https://fonts.googleapis.com/earlyaccess/kokoro.css" />
<style>
* {
	font-family: 'Kokoro', serif;
}

.carousel-item>img {
	height: 350px;
}

a {
	text-decoration-line: none;
	color: inherit;
}

.card>img {
	height: 175px;
}

.mymodal {
	position: fixed;
}
</style>
<title>日韓アイドル</title>

</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light shadow-lg sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand " href="main"><img src="image/logo.png"
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
						class="nav-link dropdown-toggle text-primary" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 韓アイドル </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">１９９０年代</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">２０００年代</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="2010korea.jsp">２０1０年代</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-danger" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 日アイドル </a>
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
								data-bs-target="#mymodal" aria-expanded="false">ログイン</a></li>
							<li><a class="dropdown-item" href="join">会員登録</a></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${not empty userID}">
					<div class="nav-item dropdown">
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
	<div class="modal fade" id="mymodal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">

			<div class="modal-content rounded-4 shadow">
				<div class="modal-header p-5 pb-4 border-bottom-0">
					<h1 class="fw-bold mb-0 fs-2">ログイン</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body p-5 pt-0">
					<form action="login" onsubmit="joinFormSubmit(this); return false;"
						method="post">
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-3"
								id="floatingInput" name="userID" placeholder="ID"> <label
								for="floatingInput">ID</label>
						</div>
						<div class="form-floating mb-3">
							<input type="password" class="form-control rounded-3"
								id="floatingPassword" name="userPassword" placeholder="Password">
							<label for="floatingPassword">PASSWORD</label>
						</div>
						<button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary"
							type="submit">LOG IN</button>
						<a class="text-primary" href="#">ID•PASSWORDを忘れた方はこちら</a>
						<hr class="my-4">

					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="container py-4">
		<div class="row mt-4">
			<div class="col-sm-5">
				<div class="fs-1">
					<img src="image/korea.png" alt="" />韓アイドル
				</div>
				<div id="carouselExampleSlidesOnly" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-inner border p-2">
						<div class="carousel-item active" data-bs-interval="2000">
							<img src="image/aespa.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="image/ive.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="image/lesserafim.jpeg" class="d-block w-100 lesse"
								alt="...">
						</div>

					</div>

				</div>
			</div>
			<div class="col-sm-5 offset-sm-2">
				<div class="fs-1">
					<img src="image/japan.png" alt="" />日アイドル
				</div>

				<div id="carouselExampleSlidesOnly" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-inner badge border p-2">
						<div class="carousel-item active" data-bs-interval="2000">
							<img src="image/nogizaka.png" class="d-block w-100 nogi"
								alt="...">
						</div>
						<div class="carousel-item">
							<img src="image/momoiro.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="image/perfume.jpeg" class="d-block w-100" alt="...">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fulid">
		<div class="row justify-content-center">
			<div class="card m-2" style="width: 18rem;">
				<img src="image/aespa.png" class="card-img-top" alt="...">
				<div class="card-body">
					<label class="card-title fs-4">aespa</label>
					<p class="card-text"></p>
					<a href="#" class="btn btn-primary">Go</a>
				</div>
			</div>
			<div class="card m-2" style="width: 18rem;">
				<img src="image/nogizaka.png" class="card-img-top" alt="...">
				<div class="card-body">
					<label class="card-title fs-4">乃木坂46</label>
					<p class="card-text"></p>
					<a href="#" class="btn btn-primary">Go</a>
				</div>
			</div>
			<div class="card m-2" style="width: 18rem;">
				<img src="image/ive.png" class="card-img-top" alt="...">
				<div class="card-body">
					<label class="card-title fs-4">IVE</label>
					<p class="card-text"></p>
					<a href="#" class="btn btn-primary">Go</a>
				</div>
			</div>
			<div class="card m-2" style="width: 18rem;">
				<img src="image/momoiro.png" class="card-img-top" alt="...">
				<div class="card-body">
					<label class="card-title fs-4">ももいろクローバーZ</label>
					<p class="card-text"></p>
					<a href="#" class="btn btn-primary">Go</a>
				</div>
			</div>
			<div class="card m-2" style="width: 18rem;">
				<img src="image/lesserafim.jpeg" class="card-img-top" alt="...">
				<div class="card-body">
					<label class="card-title fs-4">Lesserafim</label>
					<p class="card-text"></p>
					<a href="#" class="btn btn-primary">Go</a>
				</div>
			</div>
			<div class="card m-2" style="width: 18rem;">
				<img src="image/perfume.jpeg" class="card-img-top" alt="...">
				<div class="card-body">
					<label class="card-title fs-4">Perfume</label>
					<p class="card-text"></p>
					<a href="#" class="btn btn-primary">Go</a>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script>
		function joinFormSubmit(form) {
			

			form.userID.value = form.userID.value.trim();
			if (form.userID.value.length == 0) {
				alert('IDを入力してください');
				form.userID.focus();
				return;
			}
			form.userPassword.value = form.userPassword.value.trim();
			if (form.userPassword.value.length == 0) {
				alert('パスワードを入力してください');
				form.userPassword.focus();
				return;
			}

			form.submit();
			DojoinFormSubmit = true;
		};
	</script>
</body>
</html>