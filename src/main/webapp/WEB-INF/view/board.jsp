<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link href="https://fonts.googleapis.com/earlyaccess/kokoro.css" />
<style>
* {
	font-family: 'Kokoro', serif;
}

a {
	text-decoration-line: none;
	color: inherit;
}

.form-select {
	width: 50%;
}
.mysearch{
	width:30%;
	}
</style>
<title>JSP ウェブサイト</title>
<style type="text/css">
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-light shadow-lg sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="main"><img src="image/logo.png"
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





	<div class="container mt-4">
		<div class="row">
			<form class="col d-flex m-2 justify-content-end" role="search">
				<fieldset class="d-flex">
					<legend hidden="hidden">検索フィールド</legend>
					<label hidden="hideen">検索分類</label> <select
						class="form-select form-select-sm me-2"
						aria-label="Default select example" name="field">
						<option ${(param.field == "title")?"selected":""} value="title">タイトル</option>
						<option ${(param.field == "userID")?"selected":""} value="userID">作成者</option>
					</select> <label hidden="hidden">検索</label> <input class="form-control me-2"
						type="search" name="query" value="${param.query}" />
					<button class="btn btn-outline-primary mysearch" type="submit">検索</button>
				</fieldset>
			</form>
			<table class="table table-striped table-hover"
				style="text-align: center; border: #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">番号</th>
						<th style="background-color: #eeeeee; text-align: center;">タイトル</th>
						<th style="background-color: #eeeeee; text-align: center;">作成者</th>
						<th style="background-color: #eeeeee; text-align: center;">日付</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="n" items="${list}">
						<tr>
							<td>${n.id}</td>
							<td><a href="detail?bbsID=${n.id }"><c:out
										value="${n.title}"></c:out></a></td>
							<td>${n.userID }</td>
							<td>${n.regDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="row gx-0">

				<div class="col">
					<a href="?p=1" class="btn btn-success btn-arraw-left float-start">トップページ</a>
				</div>

				<div class="col">
					<c:set var="page" value="${(empty param.p)?1:param.p }" />
					<c:set var="startNum" value="${page-(page-1)%5}" />
					<c:set var="lastNum"
						value="${fn:substringBefore(Math.ceil(count/10),'.') }" />
					<c:set var="active" value="active"></c:set>
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:if test="${startNum > 1 }">
								<li class="page-item"><a class="page-link"
									href="?p=${startNum-1 }" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach var="i" begin="0" end="4">
								<c:if test="${startNum+i<=lastNum }">
									<li class="page-item"><a
										class="page-link ${(param.p==startNum+i)?active:''}"
										href="?p=${startNum+i }">${startNum+i }</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${startNum+4 < lastNum}">
								<li class="page-item"><a class="page-link"
									href="?p=${startNum+5}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
				<c:if test="${not empty userID}">
					<div class="col">
						<a href="write" class="btn btn-primary float-end" role="button">作成</a>
					</div>
				</c:if>
				<c:if test="${empty userID}">
					<div class="col">
						<button type="button" class="btn btn-primary float-end"
							data-bs-toggle="modal" data-bs-target="#exampleModal">作成</button>
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">ログインしてください</div>
									<div class="modal-footer">
										<button class="btn btn-primary" data-bs-toggle="modal"
											data-bs-target="#mymodal" aria-expanded="false">ログイン</button>
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">閉じる</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>