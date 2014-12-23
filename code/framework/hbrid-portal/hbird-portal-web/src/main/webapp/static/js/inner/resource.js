var formValidate ={
	errorElement:"em",
	errorClass:"red",
	rules: {
		name: {required: true, maxlength:20}
	},

	messages: {
		name: { required: "请输入资源名称", maxlength:jQuery.format("资源名称不能大于{0}个字 符")}
	}
};

function loadSystems(sysCode){
	jQuery.ajax({
		type: "GET",
		url: basePath + "/system/query",
		dataType : 'json',
		success: function(data){
			if(data!=null && data.code==200 && data.result!=null){
				$.each(data.result, function(i,n){
					if(n.code == sysCode){
						$("<option></option>").attr("value",n.code).text(n.name).appendTo("#sysCode").attr("selected","selected");
					} else {
						$("<option></option>").attr("value",n.code).text(n.name).appendTo("#sysCode");
					}
				});
			} else {
				alert("获取业务系统失败");
			}
		},
		error : function(data) {alert("获取业务系统出现异常");}
	});
}

function loadResources(levelParam,parentResourceId){
	jQuery.ajax({
		type: "GET",
		url: basePath + "/resource/query",
		dataType : 'json',
		data: "level=" + levelParam,
		success: function(data){
			if(data!=null && data.code==200 && data.result!=null){
				$.each(data.result, function(i,n){
					if(n.id == parentResourceId){
						$("<option></option>").attr("value",n.id).text(n.name).appendTo("#parentId").attr("selected","selected");
					} else {
						$("<option></option>").attr("value",n.id).text(n.name).appendTo("#parentId");
					}
				});
			} else {
				alert("获取父资源失败");
			}
		},
		error : function(data) {alert("获取父资源出现异常");}
	});
}

function levelChanged(parentResourceId){
	var level= $("#level").val();
	$("#parentId").empty();
	if(level == 1){
		$("<option></option>").attr("value",0).text("根节点资源(虚拟)").appendTo("#parentId");
		$("#isClick").val(0);
		$("#type").val(1);
		$("#div-url").css("display","none");
	} else if(level == 2){
		loadResources(1,parentResourceId);
		$("#isClick").val(1);
		$("#type").val(1);
		$("#label-url").text("资源URL");
		$("#div-url").css("display","block");
	} else if(level == 3){
		loadResources(2,parentResourceId);
		$("#isClick").val(0);
		$("#type").val(2);
		$("#label-url").text("按钮ID");
		$("#div-url").css("display","block");
	}
}

function submitAddResource(){
	var form = $("#addForm");
	if(form.valid()==false){
		return;
	}
	
	var url= $("#url").val();
	if(url==null || "" == jQuery.trim(url) ){
		var level= $("#level").val();
		if(level==2){
			alert("请输入资源URL");
			$("#url").focus();
			return;
		}
		if(level==3){
			alert("请输入按钮ID");
			$("#url").focus();
			return;
		}
	}
	
	jQuery.post(basePath + "/resource/add",
		form.serialize(),
		function(data) { MyPopWindow.SubmitCompletedCallback2(data, basePath + "/resource"); }
	);
}

function submitUpdateResource(){
	var form = $("#updateForm");
	if(form.valid()==false){
		return;
	}
	
	var url= $("#url").val();
	if(url==null || "" == jQuery.trim(url) ){
		var level= $("#level").val();
		if(level==2){
			alert("请输入资源URL");
			$("#url").focus();
			return;
		}
		if(level==3){
			alert("请输入按钮ID");
			$("#url").focus();
			return;
		}
	}
	
	jQuery.post(basePath + '/resource/update',
		form.serialize(),
		function(data) { MyPopWindow.SubmitCompletedCallback2(data, basePath + "/resource"); }
	);
}