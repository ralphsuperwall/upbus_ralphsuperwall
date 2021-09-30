		function cancelChange(){
			$("#memberInfoHead").children("tr").append('<th class="cancelColTh">취소</th>');
			$("#cancelChangeBtn").remove();
			$(".modal-footer").prepend('<button type="button" class="btn btn-info" id="normalChangeBtn" onclick="normalChange()">조회기능으로 변경</button>');
			$(".modal-footer").prepend('<button type="button" class="btn btn-primary" id="cancelSubmitBtn">저장</button>');
			//각 행에 취소 컬럼 추가 $(".memberInfoTr")
			//console.log($(".memberInfoTr")[0]);
			for(var i = 0 ; i < $(".memberInfoTr").length ; i++){
				$($(".memberInfoTr")[i]).append('<td class="cancelColTd"><input type="radio"></td>');
				
				
			}
		}
		//check Input의 관리
		$(document).on('click','.cancelColTd input', function(){
			//기본적으로 이게 취소가 되어있는지 확인해야한다. 취소가 이미되어있다면 체그 콧하도록(길이가 0이면 없는거다)
			if($(this).parent().parent().children(".canceled").length == 1){
				$(this).prop('checked',false);
			} else{				
				//체크가 안되어있으면 체크
				if($(this).is(":checked") == false){
					$(this).prop('checked',true);
					//체크가 되어있으면 체크 해제
				} else{
					$(this).prop('checked',false);
				}
			}
		});
		//check td의 관리
		$(document).on('click','.cancelColTd', function(){
			//기본적으로 이게 취소가 되어있는지 확인해야한다. 취소가 이미되어있다면 체그 콧하도록(길이가 0이면 없는거다)
			if($(this).parent().children(".canceled").length == 1){
				
			} else{				
				//체크가 안되어있으면 체크
				if($(this).children('input').is(":checked") == false){
					$(this).children('input').prop('checked',true);
					//체크가 되어있으면 체크 해제
				} else{
					$(this).children('input').prop('checked',false);
				}
				
				//console.log($(this).parent().children('.ip'));
			}
			
		});
		//취소 저장 버튼을 눌렀을떄
		$(document).on('click','#cancelSubmitBtn', function(){
		
			var memberInfoTrObj = $('.memberInfoTr');
			//체크된 코드의 배열
			var checkedCode=[];
			$.each( memberInfoTrObj, function(){
				//console.log($(this).children().eq(0).text());
				//console.log($(this).children().find('input').is(':checked'));
				if($(this).children().find('input').is(':checked')){
					checkedCode.push($(this).children().eq(0).text());
				}
				
			});
			var param = {
					"checkedCode":checkedCode
			}
			//체크 된게 0개인지 체크(유효성 검사)
			if(param.checkedCode.length == 0){
				//체크가 안되어있으면 html생성
				$(".modal-footer").prepend('<span id="cancelSpan" style="color: red " id="alertSpan">취소 체크를 해야 합니다</span>');
				
			} else{
				$("#alertSpan").remove();
				$.ajax({
					type : 'get',
					url : 'ajaxCancel',
					data : param,
					dataType : "json",
					success : function(data) {
							console.log("통신 성공");	
							alert("변경 완료");
							location.href = location.href;
					},
					error : function(error) {
						alert("통신 오류");				          
					}
				});
			}
			
			/*
			for(var i=0; i<$('.memberInfoTr').length; i++){
				console.log($('.memberInfoTr').length);
				console.log($('.memberInfoTr').children().eq(0).text());
				console.log($('.memberInfoTr td').last().children("input"));
			}
			*/
			/*
			for(var i = 0 ; i < $(".memberInfoTr").length ; i++){
				console.log($(".memberInfoTr"));
			}
			*/
		});
		//엔터 눌렀을때 검색
		$("#requestIdInfoInput").on("keyup",function(key){
	        if(key.keyCode==13) {
	            //강제로 클릭하게하기
	            $("#requestIdInfoBtn").trigger("click");
	            
	        }
	    })
		//조회로 변경
		function normalChange(){
			$(".cancelColTh").remove();
			$(".cancelSpan").remove();			
			$("#cancelChangeBtn").remove();
			$("#normalChangeBtn").remove();
			$("#cancelSubmitBtn").remove();
			for(var i = 0 ; i < $(".cancelColTd").length ; i++){
				$(".cancelColTd").remove();
			}
			$(".modal-footer").prepend('<button type="button" class="btn btn-warning" id="cancelChangeBtn" onclick="cancelChange()">취소기능으로 변경</button>');
		}
		//검색버튼을 누를시
		$("#requestIdInfoBtn").click(function(){
			var inputText = $("#requestIdInfoInput").val();
			
			console.log(inputText);
			$("#ListIdSpan1").text(inputText);
			$("#ListIdSpan2").text("");
			$("#ListIdSpan2").text("님의 검색 정보");
			//체크하기
			$('#allType').prop('checked',true);
			//console.log(requestIdInfoInput.text);
			ajaxCheckRequest();
		});
		//아이디 초기화 버튼을 누를시
		$("#requestResetIdBtn").click(function(){
			
			$("#ListIdSpan1").text("");
			$("#ListIdSpan2").text("");
			$("#ListIdSpan2").text("전체 회원");
			console.log($("#ListIdSpan1").text());
			//체크하기
			$('#allType').prop('checked',true);
			//console.log(requestIdInfoInput.text);
			ajaxCheckRequest();
		});
		
		//체크버튼을 누를시
		 $(".requestClass").click(function (){
			ajaxCheckRequest();
		});
		
		
		//서버에 마일리지 타입과 아이디를 전송시켜 통신
		function ajaxCheckRequest(){
			
			//마일리지 타입을 저장하는 변수
			var mileageType;
			for(var i = 0 ; i < $(".requestClass").length ; i++){
				if($(".requestClass")[i].checked == true){					
					mileageType = $(".requestClass")[i].value;					
					break; 					
				}
			}
			var param = {						
				MType : mileageType,
				memberId : $("#ListIdSpan1").text()					
			}
			$.ajax({
				type : 'get',
				url : 'ajaxUser',
				data : param,
				dataType : "json",
				success : function(data) {
						console.log("MType :",param.MType,", ","MemberId : ",param.memberId);
						$("#mlieageTableBody").empty();
						for(var i = 0 ; i < data.length ; i++){
			        	createMlieageTableBody(data[i]);		        	
			       		}
				},
				error : function(error) {
					alert("통신 오류");				          
				}
			});
		}
		var createMlieageTableBody = function (row){
			//console.log(row);
			//console.log(Object.keys(row)[0]);
			//console.log(row[Object.keys(row)[0]]);
			var htmlBody='<tr id="'+row["memberId"]+'" data-toggle="modal" data-target="#memberInfoModal" onclick="ajaxUserRequest(this)">';
			console.log("------------------------------");
			for(var i = 0 ; i < Object.keys(row).length ; i++){
				
				//사용자 아이디를 tr태그에 넣기위해 분기
				/*if(Object.keys(row)[i] == "memberId" ){
				
				}*/
				//취소여부(숫자) 빼고 저장
				if(Object.keys(row)[i] == "mileageUserListCancel"){
					 
				} else {
					if(Object.keys(row)[i] == "mileageUserListCancelName"){						
						if(row.mileageUserListCancelName == "취소 안 됨"){
							htmlBody += '<td class="notCanceled">'+row[Object.keys(row)[i]]+'</td>';
						} else{
							htmlBody += '<td class="canceled">'+row[Object.keys(row)[i]]+'</td>';
						}
					} else {						
						htmlBody += "<td>"+row[Object.keys(row)[i]]+"</td>";
					}
				}
			}
			htmlBody+='</tr>';
			$("#mlieageTableBody").append(htmlBody);
			
		}
		
		 function ajaxUserRequest(row){
			normalChange();
			 var param = {
					 memberId:row.id
			 }
			$.ajax({
			      type : 'get',
			      url : 'ajaxUser',
			      data : param,
			      dataType : "json",
			      success : function(data) {
			    	$("#memberInfoBody").empty();
			    	$("#memberInfoTitle").empty();
			       /* 
			        //객체 속성의 개수
			        console.log(Object.keys(data[0]).length);
			      	//객체의 첫번쨰 속성
			      	console.log(Object.keys(data[0])[0]);*/
			        for(var i = 0 ; i < data.length ; i++){
			        	createMemberInfoTitle(data[i]);	
			        	createMemberInfoBody(data[i]);			        	
			        }
			      },
			      error : function(error) {
			          alert("통신 오류");
			          
			      }
			  });
			 
		 }
		var createMemberInfoTitle = function(row){
			var titleText = "";
			for(var i = 0 ; i < Object.keys(row).length ; i++){
				 //아이디 찾기
				  if(Object.keys(row)[i] == "memberId"){
					  titleText += row[Object.keys(row)[i]]+" 님의 마일리지 이력";
					  break;
				  }
			}
			$("#memberInfoTitle").text(titleText);
		}
		var createMemberInfoBody = function(row){
			
			 var htmlBody = '<tr id="'+row["mileageUserListCode"]+'" class="memberInfoTr">';
			 for(var i = 0 ; i < Object.keys(row).length ; i++){
				 //아이디와 취소여부(숫자) 빼고 저장
				 if(Object.keys(row)[i] == "memberId" || Object.keys(row)[i] == "mileageUserListCancel"){
					 
				 } else if(Object.keys(row)[i] == "mileageUserListCancelName" ){
					 if(row.mileageUserListCancelName == "취소 안 됨"){
						 htmlBody += '<td class="notCanceled">'+row[Object.keys(row)[i]]+'</td>';
					 } else{
						 htmlBody += '<td class="canceled">'+row[Object.keys(row)[i]]+'</td>';
					 }
					 
				 } else {
					 htmlBody += '<td>'+row[Object.keys(row)[i]]+'</td>';
				 }
				
			 }
			 htmlBody += "<tr>";
			 //console.log(htmlBody);
			 $("#memberInfoBody").append(htmlBody);
		 }
		 
		 