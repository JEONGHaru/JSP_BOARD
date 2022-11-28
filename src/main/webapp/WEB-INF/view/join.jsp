<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link href="css/custom.css" rel="stylesheet">
<title></title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="main"><img src="image/logo.png" alt="" /></a>
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
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 韓アイドル </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">１９９０年代</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">２０００年代</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="2010korea.jsp">２０1０年代</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
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
							<li><a class="dropdown-item" href="login">ログイン</a></li>
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
							<li><a class="dropdown-item" href="">ログアウト</a></li>
						</ul>
					</div>
					</c:if>
				</div>
			</div>
		</nav>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-md-6">
				<form action="join" method="post"
					onsubmit="joinFormSubmit(this); return false;">
					<h3 style="text-align: center; margin:50px">会員登録</h3>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingInput"
							placeholder="IDを入力してください" maxlength="15" name="userID"> <label
							for="floatingInput">ID</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" class="form-control" id="floatingPassword"
							placeholder="PASSWORDを入力してください" name="userPassword"> <label
							for="floatingInput">PASSWORD</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" class="form-control" id="floatingPassword"
							placeholder="PASSWORDをもう一度入力してください" name="userPassword2">
						<label for="floatingInput">PASSWORD確認</label>
					</div>
					<div class="form-floating d-flex">
					<div class="form-floating col">
						<input type="text" class="form-control" id="floatingInput"
							placeholder="名字を入力してください" name="userFirstName"> <label
							for="floatingInput mb-0">FirstName</label>
					</div>
					<div class="form-floating mb-3 col">
						<input type="text" class="form-control" id="floatingInput"
							placeholder="名前を入力してください" name="userLastName"><label
							for="floatingInput">LastName</label>
					</div>
					</div>
					<div class="form-floating mb-3">
						<div class="btn-group" role="group"
							aria-label="Basic radio toggle button group">
							<input type="radio" class="btn-check" name="userGender"
								id="btnradio1" autocomplete="off" value="男性" checked> <label
								class="btn btn-outline-primary" for="btnradio1">男性</label>

							<input type="radio" class="btn-check" name="userGender"
								id="btnradio2" autocomplete="off" value="女性"> <label
								class="btn btn-outline-primary" for="btnradio2">女性</label>
						</div>
					</div>
					<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingInput"
							placeholder="EMAILを入力してください" name="userEmail"> <label
							for="floatingInput">EMAIL</label>
					</div>
					<input type="submit" class="btn btn-primary form-control"
						value="会員登録" />
				</form>
			</div>
		</div>
	</div>
	<script>
		let DojoinFormSubmit = false;
		function joinFormSubmit(form) {
			if (DojoinFormSubmit) {
				alert('処理中です。');
				return;
			}

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

			if (form.userPassword.value != form.userPassword2.value) {
				alert('パスワードが異なります');
				form.userPassword.focus();
				return;
			}
			form.userName.value = form.userName.value.trim();
			if (form.userName.value.length == 0) {
				alert('名前を入力してください');
				form.userName.focus();
				return;
			}
			form.userEmail.value = form.userEmail.value.trim();
			if (form.userEmail.value.length == 0) {
				alert('E-Mailを入力してください');
				form.userEmail.focus();
				return;
			}

			form.submit();
			DojoinFormSubmit = true;
		};
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>