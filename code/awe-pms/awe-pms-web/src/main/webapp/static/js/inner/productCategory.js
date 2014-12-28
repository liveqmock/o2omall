function levelFidChanges(parentResourceId){
	var level= $("#level").val();
	$("#fid").empty();
	if(level == 1){
		$("<option></option>").attr("value",0).text("根节点品类(虚拟)").appendTo("#fid");
	} else {
		loadFids(level - 1,parentResourceId);
	}
}

function loadFids(levelParam,parentResourceId){
	jQuery.ajax({
		type: "GET",
		url: basePath + "/productCategory/query",
		dataType : 'json',
		data: "level=" + levelParam,
		success: function(data){
			if(data!=null && data.code==200 && data.result!=null){
				$.each(data.result, function(i,n){
					if(n.id == parentResourceId){
						$("<option></option>").attr("value",n.id).text(n.name).appendTo("#fid").attr("selected","selected");
					} else {
						$("<option></option>").attr("value",n.id).text(n.name).appendTo("#fid");
					}
				});
			} else {
				alert("获取父资源失败");
			}
		},
		error : function(data) {alert("获取父资源出现异常");}
	});
}