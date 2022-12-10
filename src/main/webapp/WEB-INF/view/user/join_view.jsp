<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/navbar.jsp" %>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-md-6">
				<form action="/user/join" method="post"
					onsubmit="joinFormSubmit(this); return false;">
					<h3 style="text-align: center; margin: 50px">会員登録</h3>
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
								class="btn btn-outline-primary" for="btnradio1">男性</label> <input
								type="radio" class="btn-check" name="userGender" id="btnradio2"
								autocomplete="off" value="女性"> <label
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
	
		function clickEvent(){
			alert('メールを送信しました。メールを確認しリンクをクリックして確認してください');
		}
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