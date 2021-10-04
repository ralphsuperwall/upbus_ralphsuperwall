// 1.세션에 셋팅 되어 있는 값을 ClasAddTeacher.html 에서 변수가 선언되어 있기 때문에 이를 처리한다.
$(function(){
	$('#memberId').val(session);
});

// 2.파일체크 중복 검사 & 유효성 검사가 필요하다 ( AJAX MIME ContentType Json 을 이용한다 )
$(function(){
	$('#yesButton').click(function(form){
		var textFormControl = $('.textForm');	// from-control 은 HTML 에서 입력폼으로 클래스로 묶여있다
		// 입력 폼은 여러개의 클래스로 묶여 있어 변수에 담기게 되면 배열 형식으로 담기게 된다.
		for(var i=1; i < textFormControl.length; i++){
			
			/*
			 * 1.[ 유효성 체크 ] 입력이 되었는지 안되었는지에 대한 유효성 검사이며 모든 입력값은 다 받도록 한다
			 */
			if(textFormControl[i].value == '' || textFormControl[i].value == null){
				alert('입력되지 않은 값이 있습니다. 입력해주십시요.');
				textFormControl[i].focus();
				return false;
			}
		}
		
		/*
		 * 2.[ 유효성 체크 ] 이메일 체크에 대한 유효성 체크가 되었는 지 확인한다.
		 * - 변수 : emailValue = $('#classTecaherEmail').val()
		 */
		var emailValue = $('#classTecaherEmail').val();
		
		// 이메일 체크 함수 호출, return 값이 true 면 정상 아니면 false
		var emailCheckResult = EmailCheck(emailValue);
		if( emailCheckResult == 0 ){
			alert('이메일 형식이 맞지 않습니다. TEST@EMAIL.COM');
			return false;
		}
		
		/*
		 * 3.[ 유효성 체크 ] 전화번호 체크에 대한 유효성 확인을 한다.
		 * - 변수 : PhoneValue = $('#classTeacherPhone').val()
		 */
		var PhoneValue = $('#classTeacherPhone').val();
		
		// 휴대폰 체크 함수 호출, return 값이 tru 면 정상 아니면 false
		
		var PhoneCheckResult = PhoneCheck(PhoneValue);
		if( PhoneCheckResult == 0 ){
			alert('핸드폰 번호가 제대로 입력되지 않았습니다 확인해 주십시요');
			return false;
		}
		
		/**
		 * AJAX 사용 ( JSON MIME ContentType )
		 * - 화면에서 화면경로에 입력된 값을 컨트롤러에 보내주도록 한다.
		 * - 컨트롤러에서 보내온 Map 자료 구조의 키인 Error1, Error2, Erro3 을 통해 유효성 검사를 하도록 한다.
		 */
		
		var TeacherSingupFileValue = $('#classTeacherSignUpFile').val();
		var TeacherScheduleFileValue = $('#classTeacherScheduleFile').val();
		var TeacherResumFileValue = $('#classTeacherResumFiel').val();
		
		
		var request = $.ajax({
		url: "/user/class/fileCheck",
		method: "POST",
		data: { "class_teacher_signup_file" : TeacherSingupFileValue
			  , "class_teacher_schedule_file" : TeacherScheduleFileValue
			  , "class_teacher_resum_file" : TeacherResumFileValue},
		dataType: "json",
		success : function(data) {
				console.log(data)
				if( data.Error1 == "signup_file_Error" ){
					alert("첨부되지 않은 신청서 파일이있습니다.");
					return false;
				}else if( data.Error2 == "schedule_file_Error"){
					alert("첨부되지 않은 스케쥴 파일이 있습니다.");
					return false;
				}else if( data.Error3 == "resum_file_Error"){
					alert("첨부되지 않은 이력서 파일이 있습니다.");
					return false;
				}
			}
		});
 
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " +jqXHR + " "+textStatus );
		});	
		
		
		// 4.[유효성체크] 파일의 값 = 총 경로 + 파일형식 까지 나온 filename()
		// 변수 위에서 가져옴 TeacherSingupFileValue = $('#classTeacherSignUpFile').val();
		var TeacherSignUpFileName = getExtensionOfFilename(TeacherSingupFileValue);
		var TeacherScheduleFileName = getExtensionOfFilename(TeacherScheduleFileValue);
		var TeacherResumFileName = getExtensionOfFilename(TeacherResumFileValue);
		
		// 각 파일의 형식이 hwp 가 아니면 오류 
		if(TeacherSignUpFileName != '.hwp'){
			alert("신청서 파일의 확장자 형식이 hwp 가 아닙니다 .확인하십시오");
			return false;
		}else if(TeacherScheduleFileName != '.hwp'){
			alert("일정표 파일의 확장자 형식이 hwp 가 아닙니다. 확인하십시요");
			return false;
		}else if(TeacherResumFileName != '.hwp'){
			alert("이력서 파일의 확장자 형식이 hwp 가 아닙니다. 확인하십시요");
			return false;
		}
		
		alert("강사 회원 신청이 완료 되었습니다.");
		return true;
	});
});


// 3.이메일 체크 정규식
function EmailCheck(asValue) {
	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	return regExp.test(asValue); // 형식에 맞는 경우 true 리턴	
}


// 4. 핸드폰 번호 정규식

function PhoneCheck(asValue) {
	var regExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	return regExp.test(asValue); // 형식에 맞는 경우 true 리턴
}


/*
 * 5.파일명 확장자명 체크하는 함수
 * fliename : 파일명
 * fileLen : 길이
 * fileExt : 확장자명
 */

function getExtensionOfFilename(filename) {
 
    var fileLen = filename.length;
 
    // lastindexof('.') : 뒤에서부터 '.' 가 온다면 검색 문자의 위치를 반환한다.
    // 파일 이름에 '.' 이 포함되는 경우가 많기 때문에 lastIndexOf() 를 사용하게 된다.
    var lastDot = filename.lastIndexOf('.');
 
    // sbustring( 시작인덱스, 종료인덱스 ) : .이후의 확장자명만 반환하게 된다.
    // toLowerCase() 메서드는 문자열을 소문자로 변환해 반환합니다
    var fileExt = filename.substring(lastDot, fileLen).toLowerCase();
 
    return fileExt;
}
