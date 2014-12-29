function loadProductCategorys(levelParam,parentResourceId,currentResourceId,idAttr){
	initSelected(idAttr);
	jQuery.ajax({
		type: "GET",
		url: basePath + "/productCategory/query",
		dataType : 'json',
		data: "level=" + levelParam + "&fid=" + parentResourceId,
		success: function(data){
			if(data!=null && data.code==200 && data.result!=null){
				$.each(data.result, function(i,n){
					if(n.id == currentResourceId){
						$("<option></option>").attr("value",n.id).text(n.name).appendTo("#" + idAttr).attr("selected","selected");
					} else {
						$("<option></option>").attr("value",n.id).text(n.name).appendTo("#" + idAttr);
					}
				});
			}
		},
		error : function(data) {alert("获取父资源出现异常");}
	});
}

function loadAreas(levelParam,parentAreaCode,currentAreaCode,idAttr){
	initSelected(idAttr);
	jQuery.ajax({
		type: "GET",
		url: basePath + "/area/query",
		dataType : 'json',
		data: "leval=" + levelParam + "&parentCode=" + parentAreaCode,
		success: function(data){
		if(data!=null && data.code==200 && data.result!=null){
			$.each(data.result, function(i,n){
				if(n.code == currentAreaCode){
					$("<option></option>").attr("value",n.code).text(n.name).appendTo("#" + idAttr).attr("selected","selected");
				} else {
					$("<option></option>").attr("value",n.code).text(n.name).appendTo("#" + idAttr);
				}
			});
		}
	},
	error : function(data) {alert("获取父资源出现异常");}
	});
}

function initSelected(idAttr) {
	$("#" + idAttr).empty();
	$("<option></option>").attr("value","").text("请选择").appendTo("#" + idAttr);
}