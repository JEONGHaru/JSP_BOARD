
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
function loginFormSubmit(form) {
let DologinFormSubmit = false;

	if (DologinFormSubmit) {
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
	DologinFormSubmit = true;
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
let DojoinFormSubmit = false;
let DojoinIdchecking = false;
function joinFormSubmit(form) {
	if (DojoinFormSubmit) {
		alert('処理中です。');
		return;
	}
	if(DojoinIdchecking == false){
		alert('IDCHECKをしてください');
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

function userIDCheck() {
	const userID = $("#userID").val();
	console.log(userID);
	$.ajax({
		type: "POST",
		url: "/user/IDCheck",
		data: userID,
		contentType: "text/plain; charset=UTF-8",
		dataType: "text"
	}).done(function(data) {
		if (data == 'ok') {
			alert('そのIDは利用できません');
		} else if (data == 'no') {
			alert('利用可能なIDです');
			DojoinIdchecking = true;
		}
	});
}

