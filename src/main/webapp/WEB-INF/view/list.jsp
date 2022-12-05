<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/layout/navbar.jsp" %>
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
				<c:if test="${not empty userID && emailCheck}">
					<div class="col">
						<a href="write_view" class="btn btn-primary float-end" role="button">作成</a>
					</div>
				</c:if>
				<c:if test="${not empty userID && !emailCheck}">
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
									<div class="modal-body">
										掲示板に投稿するためにはE-MAILの確認が必要です。<br> 右上のE-MAILボタンを押して確認してください。
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">閉じる</button>
									</div>
								</div>
							</div>
						</div>
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
											data-bs-target="#myModal" aria-expanded="false">ログイン</button>
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
	<script src="/js/modalFocus.js"></script>
	<script src="/js/app.js"></script>
</body>
</html>