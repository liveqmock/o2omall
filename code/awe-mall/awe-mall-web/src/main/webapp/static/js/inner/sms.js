function sendSmsCode(){
	if($("#smsCodeHasSend").val() == 1) {
		return;
	}
	$("#smsCodeHasSend").val(1);
	var mobile=$("#username").val();
	if(!ismobile(mobile)){
		alert("请输入正确的手机号");
		$("#username").focus();
		return;
	}
	$("#smsCodeCreate_btn").attr("disabled","disabled");
	
	jQuery.ajax({
		type: "POST",
		url: basePath + "/checkCode/createSms",
		dataType : 'json',
		data: "mobile=" + mobile,
		
		success: function(data){
			if(data!=null && data.code==200){
				$(".ftx-01").text(59);
				$("#sms-tips").show();
				$("#countDown").show();
				setTimeout(countDown, 1000);
				$("#smsCodeCreate_btn").removeClass().addClass("btn btn-2").attr("disabled","disabled");
				$("#smsCode").removeAttr("disabled");
				$("#smsCodeCreate_btn").removeAttr("disabled");
				$("#username").attr("readonly","readonly");
				$("#mobile_error").hide();
				$("#mobile_error").html("");
				$("#sendCode_error").hide();
				$("#sendCode_error").html("");
			} else {
				$("#mobile_error").show();
				$("#mobile_error").html(data.message);
				$("#smsCodeCreate_btn").removeAttr("disabled");
				$("#username").removeAttr("readonly");
				$("#smsCodeHasSend").val(0);
			}
		},
		
		error : function(data) {
			alert("网络连接超时，请您稍后重试");
			$("#smsCodeCreate_btn").removeAttr("disabled");
			$("#username").removeAttr("readonly");
			$("#smsCodeHasSend").val(0);
		}
	});
}


function countDown(){
	var time = $(".ftx-01").text();
	$(".ftx-01").text(time - 1);
	if (time == 1) {
		$("#sms-tips").hide();
		$("#countDown").hide();
		$("#sendCode_error").hide();
		$("#smsCodeCreate_btn").removeClass().addClass("btn btn-1").removeAttr("disabled");
		$("#username").removeAttr("readonly");
		$("#send_text").hide();
		$("#smsCodeHasSend").val(0);
	} else {
		setTimeout(countDown, 1000);
	}
}