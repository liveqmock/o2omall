	//加载订单状态
	function OnOrderStatus(){
		jQuery.ajax({
			type: "GET",
			url: basePath + "/enums/queryOrderStauts",
			dataType : 'json',
			success: function(data){
				if(data!=null && data.code==200 && data.result!=null){
					$.each(data.result,function(i,item){
					  	 $('#orderStatus').append("<option value='" + i + "'>" + item + "</option>");
					});
				}else{
				alert("获取订单状态失败");
				} 
			},
			error : function(data) {
				alert("获取订单状态失败");
			}
		}); 
	}
	
	//加载订单类型
	function OnOrderType(){
		jQuery.ajax({
			type: "GET",
			url: basePath + "/enums/queryOrderType",
			dataType : 'json',
			success: function(data){
				if(data!=null && data.code==200 && data.result!=null){
					$.each(data.result,function(i,item){
					  	 $('#orderType').append("<option value='" + i + "'>" + item + "</option>");
					});
				}else{
				alert("获取订单类型失败");
				} 
			},
			error : function(data) {
				alert("获取订单类型失败");
			}
		}); 
	}
	
	//支付类型
	function OnPayType(){
		jQuery.ajax({
			type: "GET",
			url: basePath + "/enums/queryPayType",
			dataType : 'json',
			success: function(data){
				if(data!=null && data.code==200 && data.result!=null){
					$.each(data.result,function(i,item){
					  	 $('#payType').append("<option value='" + i + "'>" + item + "</option>");
					});
				}else{
				alert("获取支付类型失败");
				} 
			},
			error : function(data) {
				alert("获取支付类型失败");
			}
		}); 
	}
	
	//支付方式
	function OnPayWay(){
		jQuery.ajax({
			type: "GET",
			url: basePath + "/enums/queryPayWay",
			dataType : 'json',
			success: function(data){
				if(data!=null && data.code==200 && data.result!=null){
					$.each(data.result,function(i,item){
					  	 $('#payWay').append("<option value='" + i + "'>" + item + "</option>");
					});
				}else{
				alert("获取支付方式失败");
				} 
			},
			error : function(data) {
				alert("获取支付方式失败");
			}
		}); 
	}
	
	//发票类型
	function OnInvoiceType(){
		jQuery.ajax({
			type: "GET",
			url: basePath + "/enums/queryInvoiceType",
			dataType : 'json',
			success: function(data){
				if(data!=null && data.code==200 && data.result!=null){
					$.each(data.result,function(i,item){
					  	 $('#InvoiceType').append("<option value='" + i + "'>" + item + "</option>");
					});
				}else{
				alert("获取发票类型失败");
				} 
			},
			error : function(data) {
				alert("获取发票类型失败");
			}
		}); 
	}
	
	