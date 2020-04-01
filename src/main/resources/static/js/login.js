 $.ajaxSetup({contentType: "application/json; charset=utf-8"});

function getParam(){
	var loginParam={
		identity:$('input:radio[name="identity"]:checked').val(),
		userName:$("[name=userId]").val(),
		password:$("[name=password]").val()
	}
	return loginParam;
};
 $(document).on("click", "#login", function () {
	 var jsonData=getParam();
	 if (jsonData.userName==null || jsonData.userName == ''){
	    alert("用户名不能为空！");
	    return;
	}
	if (jsonData.password==null || jsonData.password == ''){
	    alert("密码不能为空！");
	    return;
	}
	$.ajax({
	        type: 'post',  //请求方式
	        url: '/login',  //发送请求的地址
	        data: JSON.stringify(jsonData),  //要向服务器传递的数据
	        contentType: "application/json; charset=utf-8",  //预期服务器返回的数据类型
	        success: function (result) {  //请求成功后的回调函数
	        	if(result=="adminIndex"){
					window.location.href = "/adminIndex"
				}else if(result=="studentIndex"){
					window.location.href = "/studentIndex"

				}else if(result=="teacherIndex"){
					window.location.href = "/teacherIndex"
				}else {
	        		alert("密码错误，登陆失败！")
				}
	        }
	    });
 });