// HTML 파일에 일정추가모달에 대한 설정
var eventModal = $('#eventModal');	

// HTML 파일에서 일정추가모달에 대한 태그객체들을 가져와 변수에 담아 놓은 상태
var modalTitle = $('.modal-title');		
var editAllDay = $('#edit-allDay');		
var editTitle = $('#edit-title');
var editStart = $('#edit-start');
var editEnd = $('#edit-end');
var editType = $('#edit-type');
var editColor = $('#edit-color');
var editDesc = $('#edit-desc');

//HTML 파일에서 일정추가모달에 대한 태그객체들을 가져와 변수에 담아 놓은 상태
var addBtnContainer = $('.modalBtnContainer-addEvent');				// 추가 기능이면 modalFooter 부분의 버튼이 취소, 저장
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');		// 수정 기능이면 modalFooter 부분의 버튼이 닫기, 삭제, 저장


/*****************************************************************************
 *******************************  새로운 일정 생성 ******************************
 *************************************************************************** */

var newEvent = function (start, end, eventType) {

    $("#contextMenu").hide(); 							// 일정 클릭시 나오는 카테고리 메뉴 숨김

    modalTitle.html('새로운 일정');							// 모달 제목의 텍스트를 설정한다.
    editType.val(eventType).prop('selected', true);		// 일치하는 요소( selected, true )인 값을 가져와야 한다.
    editTitle.val('');								
    editStart.val(start);								// 수정되는 시작하는 날짜
    editEnd.val(end);									// 수정되는 끝나는 날짜
    editDesc.val('');
    
    
    addBtnContainer.show();								// 일정을 추가했을 때의 버튼을 보여주도록 한다. ( HTML)
    modifyBtnContainer.hide();							// 일정을 수정했을 때의 버튼을 숨기도록 한다.	( HTML )
    eventModal.modal('show');							// 일정추가 모달을 보여주도록 한다.
    
    /**************************************************/
    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/
    var eventId = 1 + Math.floor(Math.random() * 1000);
    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/
    /**************************************************/

   
    $('#save-event').unbind();							// 일정 추가 하는 모달의 저장 버튼의 이전에 연결된 이벤트 핸들러를 요소에서 제거합니다.
    $('#save-event').on('click', function () {			// 일정추가모달에서 저장 버튼을 클릭했을 경우에

        var eventData = {								// 일정추가모달
            _id: eventId,								// 수정자 ID
            title: editTitle.val(),						// 수정 제목의 값
            start: editStart.val(),						// 수정 시작 날짜 값
            end: editEnd.val(),							// 수정 종료 날짜 값
            description: editDesc.val(),				// 설명에 대한 내용
            type: editType.val(),						// 카테고리에 대한 설정의 값
            username: '사나',								// USERNAME 에 대한 데이터를 가져올 수 있는가
            backgroundColor: editColor.val(),			// 일정추가할 떄 일정의 색상을 어떻게 할 지 그 값에 따라 설정한다.
            textColor: '#ffffff',						// 기본적인 텍스트 색상을 검정으로 설정함
            allDay: false								
        };

        if (eventData.start > eventData.end) {			// 수정, 추가하는 종료하는 날짜까 시작하는 날짜보다 앞선 경우
            alert('끝나는 날짜가 앞설 수 없습니다.');				// 경고창	
            return false;								// false 를 반환해 추가, 수정 불가능
        }

        if (eventData.title === '') {					// 수정, 추가하는 모달창에 타이틀 없는 경우
            alert('일정명은 필수입니다.');						// 일정명 입력하도록 이야기함
            return false;								// false 를 반환해 추가, 수정 불가능
        }

        var realEndDay;									// 날짜 형식을 담기 위한 변수 선언 

        if (editAllDay.is(':checked')) {													// 일정 추가 모달 기능에서 하루종일 설정이 1인경우에는 (HTML)
            eventData.start = moment(eventData.start).format('YYYY-MM-DD');					// render시 시짝날짜에 대한 날짜표기형식
            eventData.end = moment(eventData.end).add(1, 'days').format('YYYY-MM-DD');		// redenr시 종료날짜에 대한 날짜표기형식
            realEndDay = moment(eventData.end).format('YYYY-MM-DD');						// DB에 넣을때 (날짜 형식선택)

            eventData.allDay = true;
        }

        $("#calendar").fullCalendar('renderEvent', eventData, true);	// 일정관리에 새 이벤트 렌더링, 캘린더에서 이벤트를 설정하면 사라지는데 TRUE 이벤트는 영구적으로 고정함 
        eventModal.find('input, textarea').val('');						// find() 하위 요소의 특정 요소를 찾을 때 사용한다.
        editAllDay.prop('checked', false);								// prop() 일치하는 요소 집합의 첫 번째 요소에 대한 속성 값을 가져오거나 일치하는 모든 요소에 대해 하나 이상의 속성을 설정
        eventModal.modal('hide');										// event 모달을 숨기도록 한다.

        /************************************************************/
        /******** 새로운 일정의 데이터를 저장할 수 있어야 함 (DB 연동) **********/
        $.ajax({
            type: "get",
            url: "",
            data: {
                //.....
            },
            success: function (response) {
                //DB연동시 중복이벤트 방지를 위한
                //$('#calendar').fullCalendar('removeEvents');
                //$('#calendar').fullCalendar('refetchEvents');
            }
        });
        /******** 새로운 일정의 데이터를 저장할 수 있어야 함 (DB 연동) **********/
        /***********************************************************/
    });
};