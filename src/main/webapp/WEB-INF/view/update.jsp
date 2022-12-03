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

a {
	text-decoration-line: none;
	color: inherit;
}
</style>
<title>日韓アイドル</title>
</head>
<nav class="navbar navbar-expand-lg bg-light shadow-lg sticky-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="main"><img src="images/logo.png"
			alt="" /></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
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
						<li><a class="dropdown-item" href="korea1990.jsp">１９９０年代</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">２０００年代</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">２０1０年代</a></li>
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
				<li class="nav-item"><a class="nav-link" href="board">掲示板</a></li>
			</ul>
			<c:if test="${empty userID}">
				<div class="nav-item dropdown">
				<c:if test="${!emailCheck}">
						<a href="emailSend" class="btn btn-danger" role="button"
							 onclick="clickEvent();" >E-MAIL確認</a>
							</c:if>
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
						<c:if test="${!emailCheck}">
							<li><a class="dropdown-item" href="emailSend">E-mail確認</a></li>
							</c:if>
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
					<a class="text-primary" href="#">IaaD•PASSWORDを忘れた方はこちら</a>
					<hr class="my-4">

				</form>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<form action="update?bbsID=${bbs.id}" method="post"
			onsubmit="joinFormSubmit(this); return false;">
			<table class="table table-striped"
				style="text-align: center; border: #dddddd">
				<thead>
					<tr>
						<th colspan="2"
							style="background-color: #eeeeee; text-align: center;"></th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" class="form-control"
							placeholder="글 제목" name="title" maxlength="50"
							value="${bbs.title}" /></td>
					</tr>
					<tr>
						<td><textarea class="form-control" placeholder="内容"
								name="content" maxlength="2048" style="height: 350px;">${bbs.content }</textarea></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" class="btn btn-primary pull-right" value="修正" />
		</form>
	</div>
</div>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
	crossorigin="anonymous"></script>
<script>

		function clickEvent(){
			alert('メールを送信しました。メールを確認しリンクをクリックして確認してください');
		}
		let DojoinFormSubmit = false;
		function joinFormSubmit(form){
			if(DojoinFormSubmit){
				alert('処理中です。');
				return;
			}
			
			form.title.value = form.title.value.trim();
			if(form.title.value.length == 0){
				alert('タイトルを入力してください');
				form.title.focus();
				return;
			}
			form.content.value = form.content.value.trim();
			if(form.content.value.length == 0){
				alert('内容を入力してください');
				form.content.focus();
				return;
			}
			
			
			form.submit();
			DojoinFormSubmit = true;
		}
	</script>
</body>
</html>