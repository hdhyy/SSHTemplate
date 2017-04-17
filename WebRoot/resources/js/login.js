function loginFormSubmit(){
	form = $("#form_login");
	username = $("#username").val();
	password = $("#password").val();
	$("#password").val($.md5(username+password+username[5]+password[5]));
	form.submit();
}