var getShow = function(){
	var url = "http://localhost:8086/employee/upload";
		$.ajax({
		  type: "GET",
		  url: url,
		  data: null,
		  success: function(List){
			  console.log(List);
			showInfoList =  List;
				$("#showInfoList").loadTemplate("#showInfoTemplate",showInfoList);
			},
		  datatype : "application/json",
		  contentType: "application/json"
	});
};
getShow();