/**
 * 
 */

// 순서(1) 버튼에 대하여 검색한 결과를 가져오기
var termApproveBnt = $('.Term-approval-action');

// 순서(2) 검색한 버튼들의 개수만큼 반복하도록 하기
for( var i=0; i < termApproveBnt.length; i++ ){

	
	// 순서(3) 크로저 함수를 이용해서 반복할 때마다 환경을 기억하도록 한다.
	(function(index){
		
		// 순서(4) 버튼이 클릭하였을 때 이벤트를 걸어주도록 한다.
		termApproveBnt[index].addEventListener('click', function(){
			
			// 순서(5) 버튼 상위 , 상위, 하위 중에 clasTeacherSignupCode 의 id 를 지정해 둔 상태이다.
			var teacherSignupCode = termApproveBnt.parent().parent().find('#classTeacherSignupCode');
			
			// 순서(6) td 의 textContent 테이블의 들어있는 텍스트 내용을 가져와야 한다.
			var SignupCodeText = teacherSignupCode[index].textContent;
			
			// alert(SignupCodeText + "← 나오는 지 안 나오는 지 테스트 하기");
			
			// 순서(7) 버튼 클릭시 DB에서 가져온 체크가 되었는지 안되었는지 확인한다.
			var termApproveCheckValue = Number($(this).val());
			
			// 순서(8) DB에서 가져온 값으로 버튼 클릭시 값을 변경하도록 한다. (반대로)
			var modifyTermApproveCheck = 0;
			if( termApproveCheckValue == 0 ){
				modifyTermApproveCheck = 1;
			}else{
				modifyTermApproveCheck = 0;
			}
			
			// console.log(termApproveCheckValue + "←termApproveCheckValue");
			// console.log(modifyTermApproveCheck + "←modifyTermApproveCheck");
			
			// 순서(9) AJAX 호출
			// SignupCode (키) : SignupCodeText(테이블의코드텍스트)
			// TermApproveRequestResult (키) : modifyTermApproveCheck (버튼클릭시바뀌는체크결과)
			var request = $.ajax({
				url: "/admin/class/TermApproveCheckAjax",
				method: "POST",
				data: { "SignupCode": SignupCodeText, "TermApproveRequestResult" : modifyTermApproveCheck },
				dataType: "json"
			});
			
				
			// 순서(10) 컨트롤러에 AJAX 호출시에 SQL 수정에 대하여 서비스를 실행하고 난 결과 (0, 1)을 가져와서 사용한다.
			request.done(function( data ){
				// 순서(11) 컨트롤러에서 MAP 으로 반환받은 result 키에는 0이냐 1이냐이다.
				var TermOKbutton = $('.Term-approval-action');							   // 버튼 객체화
				var TermOKDate	 = $('.termApproveDate');								   // 날짜 td 객체화
				var result = data.result;												   // 수정이 되었는지 안되었는지의 결과값

				
				
				// 순서(12) result 가 0 보다 크다면 실행하도록 한다. 
				if(result > 0){
					// TermApproveRequestResult : 취소버튼 상태라면 (0)
					if( modifyTermApproveCheck == 1){
						// addClass() : 클래스 내용 추가, removeClass : 클래스 내용 제거	
						TermOKbutton[index].classList.replace('btn-info', 'btn-danger');	// 버튼클릭시 클래스교체 (색상변경)
						TermOKbutton[index].innerText = "취소";								// 버튼클릭시 텍스트변경
						TermOKbutton[index].value = 1;										// 버튼클릭시 값을 1로 변경
					}else{
						TermOKbutton[index].classList.replace('btn-danger', 'btn-info');	// 버튼클릭시 클래스교체 (색상변경)
						TermOKbutton[index].innerText = "승인";								// 버튼클릭시 텍스트변경
						TermOKbutton[index].value = 0;										// 버튼클릭시 값을 0으로 변경
					}
				
				// 순서(13) result 가 0 이 아니라면 실패 메시지가 나오도록 합니다.
				}else{
					if( modifyTermApproveCheck == 0 ){
						alert('승인 변경에 실패 했습니다.');
					}else{
						alert('승인 취소 변경에 실패 했습니다.');
					}
				}
				location.reload();
			})
			
			 /*]]*/
			
			// 순서(14) AJAX 가 실패한 경우 실패 사유 알려주기
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});

		});
		
	})(i);
}

// 순서(1) 버튼에 대하여 검색한 결과를 가져오기
var finalApproveBnt = $('.Final-approval-action');

// 순서(2) 검색한 버튼들의 개수만큼 반복하도록 하기
for( var j=0; j < finalApproveBnt.length; j++ ){

	
	// 순서(3) 크로저 함수를 이용해서 반복할 때마다 환경을 기억하도록 한다.
	(function(index){
		
		// 순서(4) 버튼이 클릭하였을 때 이벤트를 걸어주도록 한다.
		finalApproveBnt[index].addEventListener('click', function(){
			
			// 순서(5) 버튼 상위 , 상위, 하위 중에 clasTeacherSignupCode 의 id 를 지정해 둔 상태이다.
			var teacherSignupCode = finalApproveBnt.parent().parent().find('#classTeacherSignupCode');
			
			// 순서(6) td 의 textContent 테이블의 들어있는 텍스트 내용을 가져와야 한다.
			var SignupCodeText = teacherSignupCode[index].textContent;
			
			// alert(SignupCodeText + "← 나오는 지 안 나오는 지 테스트 하기");
			
			// 순서(7) 버튼 클릭시 DB에서 가져온 체크가 되었는지 안되었는지 확인한다.
			var finalApproveCheckValue = Number($(this).val());
			
			// 순서(8) DB에서 가져온 값으로 버튼 클릭시 값을 변경하도록 한다. (반대로)
			var modifyFinalApproveCheck = 0;
			if( finalApproveCheckValue == 0 ){
				modifyFinalApproveCheck = 1;
			}else{
				modifyFinalApproveCheck = 0;
			}
			
			// 순서(9) AJAX 호출
			// SignupCode (키) : SignupCodeText(테이블의코드텍스트)
			// TermApproveRequestResult (키) : modifyTermApproveCheck (버튼클릭시바뀌는체크결과)
			var request = $.ajax({
				url: "/admin/class/FinalApproveCheckAjax",
				method: "POST",
				data: { "SignupCode": SignupCodeText, "FinalApproveRequestResult" : modifyFinalApproveCheck },
				dataType: "json"
			});
			
				
			// 순서(10) 컨트롤러에 AJAX 호출시에 SQL 수정에 대하여 서비스를 실행하고 난 결과 (0, 1)을 가져와서 사용한다.
			request.done(function( data ){
				// 순서(11) 컨트롤러에서 MAP 으로 반환받은 result 키에는 0이냐 1이냐이다.
				var FinalOKbutton = $('.Term-approval-action');							   // 버튼 객체화
				var FinalOKDate	 = $('.termApproveDate');								   // 날짜 td 객체화
				var result = data.result;												   // 수정이 되었는지 안되었는지의 결과값

				
				
				// 순서(12) result 가 0 보다 크다면 실행하도록 한다. 
				if(result > 0){
					// TermApproveRequestResult : 취소버튼 상태라면 (0)
					if( modifyFinalApproveCheck == 1){
						// addClass() : 클래스 내용 추가, removeClass : 클래스 내용 제거	
						FinalOKbutton[index].classList.replace('btn-info', 'btn-danger');	// 버튼클릭시 클래스교체 (색상변경)
						FinalOKbutton[index].innerText = "취소";								// 버튼클릭시 텍스트변경
						FinalOKbutton[index].value = 1;										// 버튼클릭시 값을 1로 변경
					}else{
						FinalOKbutton[index].classList.replace('btn-danger', 'btn-info');	// 버튼클릭시 클래스교체 (색상변경)
						FinalOKbutton[index].innerText = "승인";								// 버튼클릭시 텍스트변경
						FinalOKbutton[index].value = 0;										// 버튼클릭시 값을 0으로 변경
					}
				
				// 순서(13) result 가 0 이 아니라면 실패 메시지가 나오도록 합니다.
				}else{
					if( modifyFinalApproveCheck == 0 ){
						alert('승인 변경에 실패 했습니다.');
					}else{
						alert('승인 취소 변경에 실패 했습니다.');
					}
				}
				location.reload();
			})
			
			 /*]]*/
			
			// 순서(14) AJAX 가 실패한 경우 실패 사유 알려주기
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});

		});
		
	})(j);
}
		