
/*****************************************************************************
 *********************** 생성된 일정에 대한 편집(수정) ******************************
 *************************************************************************** */
var editEvent = function (event, element, view) {

    $('#deleteEvent').data('id', event._id); 			// ★(데이터) 일정 수정하는 버튼 중에 삭제 버튼을 누를 경우 클릭한 ID 를 가져오는 작업  필요 ★

    $('.popover.fade.top').remove();					// popver.fade.top 위쪽으로 사라지는 기능을 제거한 상태입니다.
    $(element).popover("hide");							// 요소의 popover 를 숨겨놓은 상태입니다.

    if (event.allDay === true) {						// 일정이 하루종일 설정되어 있는 경우에는
        editAllDay.prop('checked', true);				// 수정, 추가하는 모달창의 값도 설정되어 있음으로 해줍니다.
    } else {											// 일정이 하루종이로 설정되어 있지 않은 경우
        editAllDay.prop('checked', false);				// 수정, 추가하는 모달창의 값을 설정되지 않음으로 체크 해제합니다.
    }

    if (event.end === null) {							// 만약에 event.end 에 대한 값이 없는 상태라면
        event.end = event.start;						// 종료날짜를 시작날짜와 같게 만들어 오류를 막습니다.
    }

    if (event.allDay === true && event.end !== event.start) {							// 이벤트 하루종일 설정 (1) && 이벤트가 시작날짜와 종료날짜가 다른 경우에만
        editEnd.val(moment(event.end).subtract(1, 'days').format('YYYY-MM-DD HH:mm'))	// 종료날짜는 날짜보다 시작 날짜보다 앞서 나가서는 안되며 형식을 가져옵니다.
    } else {																			// 그 이외의 경우에는
        editEnd.val(event.end.format('YYYY-MM-DD HH:mm'));								// 해당 포멧 형식을 지키며 값을 가져옵니다.
    }

    modalTitle.html('일정 수정');															// 수정 일정의 모달의 제목 설정
    editTitle.val(event.title);															// 수정 일정의 제목의 값
    editStart.val(event.start.format('YYYY-MM-DD HH:mm'));								// 수정 일정의 시작하는 날짜의 값
    editType.val(event.type);															// 수정 일정의 카테고리의 값
    editDesc.val(event.description);													// 수정 일정의 설명에 대한 값
    editColor.val(event.backgroundColor).css('color', event.backgroundColor);			// 수정 일정에 대한 색상에 대한 값

    addBtnContainer.hide();																// 추가하는 버튼들의 묶음을 사라지게 한다. (HTML)
    modifyBtnContainer.show();															// 수정하는 버튼들의 묶음을 보이게 한다. (HTML)
    eventModal.modal('show');															// 버튼들들을 클릭했을 때의 모달들을 보이게 한다.

    
    /*****************************************************************************
     *********************** 업데이트버튼( 저장 )버튼을 클릭할 경우*************************
     *****************************************************************************/
    $('#updateEvent').unbind();						// 일정 수정하는 모달의 저장 버튼의 이전에 연결된 이벤트 핸들러를 요소에서 제거합니다.
    $('#updateEvent').on('click', function () {		// 일정 수정하는 모달창이 띄워진 경우에 저장 버튼을 클릭할 경우

        if (editStart.val() > editEnd.val()) {		// 시작날짜의 값이 종료되는 날짜보다 뒤쳐진 경우
            alert('끝나는 날짜가 앞설 수 없습니다.');			// 경고창
            return false;							// FALSE 를 내보내 저장 중단
        }

        if (editTitle.val() === '') {				// 일정 수정 시에 일정에 대한 제목이 없다면
            alert('일정명은 필수입니다.')					// 필수적인 입력 유도
            return false;							// FALSE 를 내보내 저장 중단
        }

        var statusAllDay;							// 변수 선언 : 수정되는 일정의 하루종일 선택되었는지 ( 1, 0 )
        var startDate;								// 변수 선언 : 수정되는 일정의 시작날짜
        var endDate;								// 변수 선언 : 수정되는 일정의 종료날짜
        var displayDate;							// 변수 선언 : 화면에 보여질 날짜

        if (editAllDay.is(':checked')) {												// editAllday(일정이 체크되었는지 여부) 체크된 경우라면
            statusAllDay = true;														// 일정에서 가져와 수정되는 일정의 하루종일 선택 1로 보여지게 함
            startDate = moment(editStart.val()).format('YYYY-MM-DD');					// 시작날짜를 하루종일이기 떄문에 시간보다는 일로 가져오는 포맷 형식을 선택함
            endDate = moment(editEnd.val()).format('YYYY-MM-DD');						// 종료날짜를 하루종일이기 떄문에 시간보다는 일로 가져오는 포맷 형식을 선택함
            displayDate = moment(editEnd.val()).add(1, 'days').format('YYYY-MM-DD');	
        } else {																		 
            statusAllDay = false;														// 일정에서 가져와 수정되는 일정의 하루종일 선택0로 보여지게 함
            startDate = editStart.val();												// 시작 일정의 값을 그대로 가져옴 ( 시간, 분, 초 )
            endDate = editEnd.val();													// 종료 일정의 값을 그대로 가져옴 ( 시간, 분, 초 )
            displayDate = endDate;								
        }

        eventModal.modal('hide');

        event.allDay = statusAllDay;
        event.title = editTitle.val();
        event.start = startDate;
        event.end = displayDate;
        event.type = editType.val();
        event.backgroundColor = editColor.val();
        event.description = editDesc.val();

        $("#calendar").fullCalendar('updateEvent', event);

        //일정 업데이트
        $.ajax({
            type: "get",
            url: "",
            data: {
                //...
            },
            success: function (response) {
                alert('수정되었습니다.')
            }
        });

    });
    
};

// 삭제버튼
$('#deleteEvent').on('click', function () {
    
    $('#deleteEvent').unbind();
    $("#calendar").fullCalendar('removeEvents', $(this).data('id'));
    eventModal.modal('hide');

    //삭제시
    $.ajax({
        type: "get",
        url: "",
        data: {
            //...
        },
        success: function (response) {
            alert('삭제되었습니다.');
        }
    });

});