
function clickEvent() {
	alert('メールを送信しました。メールを確認しリンクをクリックして確認してください');
}

function loginFormSubmit(form) {


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
	
};
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
	form.submit();
	DojoinFormSubmit = true;
};

let DolistFormSubmit = false;
function listFormSubmit(form) {
	
	if (DolistFormSubmit) {
		alert('処理中です。');
		return;
	}

	form.title.value = form.title.value.trim();
	if (form.title.value.length == 0) {
		alert('タイトルを入力してください');
		form.title.focus();
		return;
	}
	form.content.value = form.content.value.trim();
	if (form.content.value.length == 0) {
		alert('内容を入力してください');
		form.content.focus();
		return;
	}
	form.submit();
	DolistFormSubmit = true;
};

