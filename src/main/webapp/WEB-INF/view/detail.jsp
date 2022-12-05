<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/navbar.jsp" %>
	<div class="container">
		<div class="row">
			<table class="table table-bordered"
				style="text-align: center; border: #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;"><c:out
								value="${bbs.title}"></c:out></th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>作成者</td>
						<td colspan="2">${bbs.userID}</td>
					</tr>
					<tr>
						<td>日付</td>
						<td colspan="2">${bbs.regDate}</td>
					</tr>
					<tr>
						<td>内容</td>
						<td colspan="2" style="height: 200px; text-align: left;">${bbs.content}</td>
					</tr>
				</tbody>
			</table>
			<div class="container">
				<a href="board" class="btn btn-primary">トップページ</a>

				<c:if test="${userID != null && userID == bbs.userID}">
					<a href="update_view?bbsID=${bbs.id }" class="btn btn-primary">修正</a>
					<a onclick="return confirm('本当に 削除しますか?')"
						href="delete?bbsID=${bbs.id}" class="btn btn-primary">削除</a>
				</c:if>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
		<script src="/js/app.js"></script>
		<script src="/js/modalFocus.js"></script>
</body>
</html>