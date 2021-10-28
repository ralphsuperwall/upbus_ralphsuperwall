var draggedEventIsAllDay;
var activeInactiveWeekends = true;		// activeInactiveWeekends 캘린더를 처음 열었을 경우 주말까지 보이도록 설정한다. 이후 밑에서 이를 사용한다.


// 캘린더 이벤트 추가 
var calendar = $('#calendar').fullCalendar({
	
	/************************************ 1.캘린더의 OPTION 설정 ******************************/
	
	//********************************** 달력에 대한 설정  **********************************//
	locale						: 'ko',    			// 화면에 출력될 경우 한글로 나오게 설정함
	timezone                  	: 'local',			// 각 나라마다 시간대에서 현재 컴퓨터가 위치하고 있는 시간대를 표시함
	nextDayThreshold        	: "09:00:00",		// 이벤트의 종료 시간이 다른 날인 경우 최소 시간을 설정함
	//defaultDate               	: moment('2019-05'), //실제 사용시 현재 날짜로 수정
	
	//********************************** 슬롯에 대한 설정  **********************************//
	allDaySlot             	 	: true,				// 하루종일 슬롯(시간대)을 표시할 지 여부
	displayEventTime        	: true,				// 시간 표시가 있는 막대가 있는 경우 텍스트를 표시한다
	displayEventEnd				: true,				// 시간 표시가 이쓴 막대가 있는 경우 이벤트의 종료 시간을 표시할 지 설정한다.
	
	//********************************** 주에 대한 설정  **********************************//
	firstDay                	: 0,				// 월요일이 먼저 오도록하는 경우(1)
	weekNumbers             	: false,			// 달력에 첫 주마다 몇 째주인지 표시하는 지 알려줌 (W~)
	weekNumberCalculation   	: "local",			// local(현지 사용하고 있는 컴퓨터위치의 시간)에 따라 계산에 사용
	weekends                  	: true,				// 일정 관리에서 토요일 / 일요일까지 볼 지 설정
	
	//**************************** 시간출력 형식에 대한 설정  **********************************//
	timeFormat               	: 'HH:mm',			// 시간을 어떻게 형식으로 보여질지 설정한다.
	minTime                  	: '00:00:00',		// 매일 표시할 첫번째 시간대를 설정한다.
	maxTime                   	: '24:00:00',		// 매일 표시할 마지막 시간대를 설정한다.
	defaultTimedEventDuration 	: '01:00:00',		// 지정된 시간 없이 시간 초과된 이벤트 개체의 제한 기간 
	slotLabelFormat           	: 'HH:mm',			// 시간대의 시간을 어떤 형식으로 보여질지 설정한다
	dayPopoverFormat          	: 'MM/DD dddd',		// moreLinkClick 옵션에 의해 생성된 팝오버 제목 날짜 형식을 결정한다.
	
	
	//**************************** 이벤트에 관련된 설정  **********************************//
	selectable              	: true,				// 달력의 일정을 드래그하면 색상이 변경이 된다.
	navLinks                	: true,				// 해당 날짜에 대한 이벤트를 볼 수 있도록 링크를 걸어준다.
	editable                  	: true,				// 일정 관리의 이벤트를 수정할 수 있는지 여부 설정
	nowIndicator              	: true,				// 현재 시간을 표시하는 마커를 표시할 지에 대한 여부 (캘린더 시간 표시기)
	
	views : { 
		   month : { eventLimit : 12 } 				// 한 날짜에 최대 이벤트 12개, 나머지는 + 처리됨
										},
    eventLimit                	: true,				// 이벤트 개수 제한을 걸어둔다.
    eventLimitClick          	: true,				// eventLimit 옵션에 의해 만들어진 "more" 링크를 클릭할 때 취하는 액션을 결정한다 ( 머리글의 보기에 따른 주 보기로 이동 )
	
	//**************************** 대기시간(delay)에 관련된 설정  **********************************//
	longPressDelay            	: 0,				// 터치 장치의 경우 이벤트를 끄거나  날짜를 선택하기 전 사용자가 대기하는 시간
	eventLongPressDelay       	: 0,				// 터치 장치의 경우 이벤트를 끄기 전에 사용자가 대기하는 시간
	selectLongPressDelay      	: 0,				// 터치 장치의 경우 사용자가 날짜를 선택할 수 있을 때까지 기다려야 하는 시간
	
	/***************************** 2.캘린더에 Header 버튼들의 기능 추가 설정 ********************************/
	header : {
        left		: 'today, prevYear, nextYear, viewWeekends',	// Head 부분의 좌측 오늘 << >> 주말
        center		: 'prev, title, next',							// Head 부분의 중앙 < 2019년 5월 >
        right		: 'month, agendaWeek, agendaDay, listWeek'		// 월 주 일 일정목록
    },
    
    /*********************** 3.캘린더에 Header ( right ) / ( month, agendaWeek, agendaDay, listWeek ) 에 대한 설정 ********************************/
    views  : {
    	// columnFormat : 컬럼의 날짜 형식을 어떻게 할 지 설정한다.
    	// (1) 'ddd' : 일 ,	 'dddd' : 일요일 ,		'M/D ddd' : 4/28 일 
        month		: {
        				columnFormat : 'dddd'			// 일요일
        			},
        agendaWeek 	: {
                        columnFormat : 'M/D ddd',		// 4/28 일
                        titleFormat  : 'YYYY년 M월 D일',	// 타이틀 제목
                        eventLimit   : false			
                    },
        agendaDay	: {
                        columnFormat : 'dddd',			// 월, 화, 수, 목, 금, 토, 일
                        eventLimit   : false
                    },
        listWeek 	: {
                        columnFormat : ''				// 설정하지 않아도 해당 날짜에 일정이 있으면 제대로 출력 됨.
                    }
     },
     
     /*********************** 4.캘린더에 Header ( left ) / ( viewWeekends ) 버튼에 대한 설정 ********************************/
     
     // customButtons : 사용자 정의 설정의 버튼 추가
     customButtons	: {
    	 // viewWeekends 버튼에 대한 숨기기 & 보이기 버튼에 대한 기능
    	 viewWeekends :	{
              	text  : '주말',		// 버튼의 텍스트 변경
	            click : function () {
	            	// activeInactiveWekkends 가 false( 주말없애기 ), true( 주말생기기 ) 설정이 가능하도록 함
	               	activeInactiveWeekends ? activeInactiveWeekends = false : activeInactiveWeekends = true;
	               	// 위에 설정된 option 에서 클릭시에 위의 버튼에 대한 설정값에 따라 weekends : 1(주말존재), 0(주말없음)를 바꾸어주는 역할을 한다.
		            $('#calendar').fullCalendar('option', { 
		              	weekends: activeInactiveWeekends
		            });
	            }
         }
     },
   
     /*********************** 5.캘린더의 마우스 일정에 마우스를 갖다대면 세부설명의 툴팁이 나온다. (이벤트) ********************/
     eventRender: function (event, element, view) {
	
    	 // popover 기존 화면 위에 오버되어 출력하는 기능이다.
	     element.popover({
	    	 // popover 제목에 대한 설정
	    	 title: $('<div />', {
	    		 class: 'popoverTitleCalendar',
	    		 text: event.title
	    	 }).css({
	    		 	'background': event.backgroundColor,
	    		 	'color': event.textColor
	    	 }),
	    	 // popover 내용에 대한 설정
	    	 content: $('<div />', {
	    		 class: 'popoverInfoCalendar'
	    	 }).append('<p><strong>등록자:</strong> ' + event.username + '</p>')
	    	   .append('<p><strong>구분:</strong> ' + event.type + '</p>')
	    	   .append('<p><strong>시간:</strong> ' + getDisplayEventDate(event) + '</p>')
	    	   .append('<div class="popoverDescCalendar"><strong>설명:</strong> ' + event.description + '</div>'),
	    	 delay: {
	    		 show: "800",
	    		 hide: "50"
	    	 },
	    	 
	    	 trigger	: 'hover',	// 트리거 발동이유
	    	 placement	: 'bottom',	// 호버시 나타는 위치
	    	 html		: true,		// false 선택시 [ Object object ]로 나온다
	    	 container	: 'body'	 	
	     });
	    return filtering(event);
	 },

	 /** ★★★★★★★★★★★★★★★★★★★ 6.캘린더의 일정을 가져오는 역할을 한다.(데이터조작) ★★★★★★★★★★★★★★★★★★ **/
	 events: function (start, end, timezone, callback) {
		 
		 $.ajax({
			 type: "get",
			 url: "/FullCalendar/data.json",
			 data: {
		        // 화면이 바뀌면 Date 객체인 start, end 가 들어옴
		        // startDate : moment(start).format('YYYY-MM-DD'),
		        // endDate   : moment(end).format('YYYY-MM-DD')
			 },
			 // AJAX 경로인 /FullCalendar/data.json 에서 데이터를 받은 상태이다.
		     success: function (response) {
		        var fixedDate = response.map(function (array){			// [{배열객체1, 배열객체2, 배열객체3, ...}]
		        	if (array.allDay && array.start !== array.end) {	// if( allDay(true/false) && array(시작일정) !== array(종료일정) 
		        		array.end = moment(array.end).add(1, 'days'); 	// 이틀 이상 AllDay 일정인 경우 달력에 표기시 하루를 더해야 정상출력
		        		
		        		// 부가 개념 (!==) 엄격한 부등 비교 연산자는 양쪽 비교값의 타입이 다른 경우 타입 변환을 하지 않습니다. 
		        	}
		        	return array;
		        });
		        callback(fixedDate);
		     }
		 });
	 },
	 
	 // 모든 이벤트 렌더링이 완료된 후 트리거됨.
	 eventAfterAllRender: function (view) {
	    if (view.name == "month") $(".fc-content").css('height', 'auto');
	 },
	 
	 /*********************** 7.캘린더의 일정을 끌어다가 수정하면 그에 대한 데이터도 수정할 수 있게 되는 기능 (이벤트).  ********************/
	 eventResize: function (event, delta, revertFunc, jsEvent, ui, view) {
		
	    $('.popover.fade.top').remove();
	    /** 리사이즈시 수정된 날짜반영
	     * 하루를 빼야 정상적으로 반영됨. */
	    var newDates = calDateWhenResize(event);
	
	    // 리사이즈한 일정 업데이트
	    $.ajax({
	    	type	: "get",
	    	url		: "",
	    	data	: {
	    				//id: event._id,
	    				//....
	    			  },
	    	// 마우스로 일정의 크기를 조절하거나 이동할 떄에 수정 : 첫시간 ~ 마지막 시간의 알림창이 나오게 된다.
	    	success	: function (response) {
	    		alert('수정: ' + newDates.startDate + ' ~ ' + newDates.endDate);
	      }
	    });
	
	 },
	 
	 /********************** 8.일정 드래그앤 드롭 시작 이벤트  ********************/
	 eventDragStart: function (event, jsEvent, ui, view) {
		 draggedEventIsAllDay = event.allDay;
	 },
	 
	 
	 /********************** 9.일정 드래그앤 드롭 이벤트  ********************/
	 eventDrop: function (event, delta, revertFunc, jsEvent, ui, view) {
		 $('.popover.fade.top').remove();
	
		 //주,일 view일때 종일 <-> 시간 변경불가
		 if (view.type === 'agendaWeek' || view.type === 'agendaDay') {
			 if (draggedEventIsAllDay !== event.allDay) {
				 alert('드래그앤드롭으로 종일<->시간 변경은 불가합니다.');
				 location.reload();
				 return false;
			 }
		 }
		 // 드랍시 수정된 날짜반영
		 var newDates = calDateWhenDragnDrop(event);

		 // 드롭한 일정 업데이트
		 $.ajax({
			 type		: "get",
			 url		: "",
			 data		: {
				 			//...
			 			  },
			 success	: function (response) {
				 alert('수정: ' + newDates.startDate + ' ~ ' + newDates.endDate);
			 }
		 });
	  },
	  
	  /********************** 10.셀렉트 ( 선택 ) 이벤트 → 카테고리1, 카테고리2  ********************/
	  select: function (startDate, endDate, jsEvent, view) {
		    /* ****************************************************
		     * $(".fc-body") 는 일정표의 tbody 스케쥴 일정 부분 클릭 1,2,3 ~ 31
		     * ****************************************************/
	 		$(".fc-body").unbind('click');						// unbind는 jquery의 이벤트 해제 메서드이다.
	 		$(".fc-body").on('click', 'td', function (e) {		// tbody 의 td 를 클릭했을 경우 이벤트를 발생시킨다.
	 			$("#contextMenu")								// 달력의 일을 클릭할 경우 카테고리에 따른 메뉴 생성을 할 수 있는 창이 열린다.		
	 			.addClass("contextOpened")						// #contextMenu 의 해당내용이 열리도록 하는 기능을 추가시킨다.
	 			.css({											
	 				display: "block",							// #contextMenu 는 기본적으로 숨겨져 있는 상태이다.
	 				left: e.pageX,								// e.pageX : 문서의 왼쪽 가장자리를 기준으로 현재 마우스의 X 좌표 값
	 				top: e.pageY								// e.pageY : 문서의 왼쪽 가장자리를 기준으로 마우스 위치의 Y 좌표 값 offset() 좌표 찾기
	 		});
	 		
	 			return false;
	 		});
	 		
	 		
	 		/* **************************************************************
		     * moment() 를 이용해서 startDate, endDate 설정과 포맷 형식을 설정하도록 한다.
		     * ***************************************************************/
	 		var today = moment();								// moment() 날짜를 손쉽게 다룰 수 있는 객체이다.

	 		if (view.name == "month") {							// 달력 형식의 일정 기능인 경우에는
	 			startDate.set({									// startDate 객체의 날을 셋팅하도록 한다.
	 				hours: today.hours(),						// 현재시간
	 				minute: today.minutes()						// 현재분
	 			});
	 			startDate = moment(startDate).format('YYYY-MM-DD HH:mm');	// startDate 의 셋팅된 대로 시간, 분까지 출력할 수 있도록 한다.
	 			endDate = moment(endDate).subtract(1, 'days');				// endDate 는 캘린더의 일정을 가져온 상태 ( -1 )

	 			endDate.set({									// endDate 객체의 날을 셋팅한다.
	 				hours: today.hours() + 1,					// endDate 는 startDate 의 1시간 뒤에
	 				minute: today.minutes()						// 현재분으로
	 			});
	 			endDate = moment(endDate).format('YYYY-MM-DD HH:mm');		// endDate 의 셋팅의 값을 형식대로 시간 분까지 출력하도록 한다.
	 		} else {
	 			startDate = moment(startDate).format('YYYY-MM-DD HH:mm');	// month 일정의 기능이 아니여도 startDate 포맷형식을 지킨다.
	 			endDate = moment(endDate).format('YYYY-MM-DD HH:mm');		// month 일정의 기능이 아니어도 startDate 포맷형식을 지킨다. 		
	 		}

	 		/* **************************************************************
		     * 날짜를 클릭시에 카테고리 메뉴가 생겼을 경우 이를 닫아주는 이벤트 만들어주도록  한다.
		     * ***************************************************************/
	 		var $contextMenu = $("#contextMenu");
	 		$contextMenu.on("click", "a", function (e) {
	 			e.preventDefault();

	 			// 날짜를 클릭하여 나타난 메뉴의 닫기 버튼이 아닐 경우에는
	 			if ($(this).data().role !== 'close') {
	 				newEvent(startDate, endDate, $(this).html());	// $('#contextMenu') html() 에 새로운 이벤트를 추가시킨다.
	 			}
	 			
		 		$contextMenu.removeClass("contextOpened");			// $('#contextMenu') 속성의 클릭해서 추가 된 이벤트의 클래스 속성 제거
		 		$contextMenu.hide();								// 이를 다시 숨기도록 합니다.
	 		});

	 		/* **************************************************************
		     * 일정을 클릭하지 않더라도 일정표 밖에 버튼을 클릭햇을 경우에도 팝업된 카테고리 메뉴가 사라지도록 한다. 
		     * ( 바로위의 #contextMenu 이벤트의 기능의 역할과 동일하다 )
		     * ***************************************************************/
	 		$('body').on('click', function () {
	 			$contextMenu.removeClass("contextOpened");			
	 			$contextMenu.hide();
	 		});

	  },

	  /** ★★★★★★★★★★★★★★★★★★★ 11.일정을 클릭했을 경우 수정을 창을 열리게 하는 이벤트를 발생시킨다. ★★★★★★★★★★★★★★★★★★ **/
	  eventClick: function (event, jsEvent, view) {
		  editEvent(event);		// 중요 이부분을 지우고 실행하면 일정을 클릭하여도 수정하는 모달창이 생기지 않는다.
	  }
});


/********************** 12.일정을 클릭했을 경우 5번 순서의 popover 의 콘텐츠에 들어갈 getDisplayEventDate(event) 리턴값  ********************/
function getDisplayEventDate(event) {

	var displayEventDate;

	if (event.allDay == false) {												// 이벤트가 하루종일 설정이 아닌 경우에는
		var startTimeEventInfo = moment(event.start).format('HH:mm');			// 시작 시간의 포맷형식을 시간 : 분 의 형식으로 출력하도록 합니다.
		var endTimeEventInfo = moment(event.end).format('HH:mm');				// 종료 시간의 포맷형식을 시간 : 분 의 형식으로 출력하도록 합니다.
    	displayEventDate = startTimeEventInfo + " - " + endTimeEventInfo;		// 예시 06:00 - 08:00
	} else {
		displayEventDate = "하루종일";												// 이벤트가 하루종일 설정된 경우에는
	}

	return displayEventDate;													// 위에서 값이 "06:00-08:00" 형식이나 "하루종일"로 저장이 되어 있으니 이를 반환한다.
}

/********************** 13.filtering 을 하면 해당 내용만 보이도록 이벤트를 발생한다.  ********************/
function filtering(event) {
	var show_username = true;													// 유저 이름을 클릭했을 경우 체크의 값에 대한 설정
	var show_type = true;														// 구분별 타입을 클릭했을 경우 체크의 값에 대한 설정

	var username = $('input:checkbox.filter:checked').map(function () {			// 일정표의 필터 판넬의 입력체크 값이 체크가 되어 있다면 map에
		return $(this).val();													// input 태그의 체크된 값을 가져오도록 한다.
	}).get();																	// username 에 체크된 input 값들이 쌓이게 된다.
	var types = $('#type_filter').val();										// input 태그의 카테고리 중에 선택을 하게 된다면 값을 가져오도록 합니다.

	show_username = username.indexOf(event.username) >= 0;						// user 에 대한 이름이 체크되어 있는 경우에만 볼 수 있도록 한다.

	if (types && types.length > 0) {											// 타입의 값이 저장되어 있고 여러개가 설정이 되어 있다면
		if (types[0] == "all") {												// types[0] 초기상태는 전부 보여주도록 한다.
			show_type = true;													// 일정을 다 보여주도록 한다.
		} else {																// 카테고리가 하나라도 설정이 되면 그 이후부터는
			show_type = types.indexOf(event.type) >= 0;							// 카테고리가 체크된 일정의 인덱스만 보여주도록 한다.
		}
	}

	return show_username && show_type;
}


/********************** 14.캘린더의 일정을 수정하기 위한 데이터를 처음에 가져오도록 하는 함수(07 순서의 newDates 에 반환이 된다) ********************/
function calDateWhenResize(event) {

	// 07 순서의 newdate에 반환되기 떄문에 형식을 맞춰준다.
	var newDates = {
			startDate: '',
			endDate: ''
	};

	if (event.allDay) {																				// 하루종일 설정된 경우
		newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');							// 시작날짜의 형식을 2021-10-20 으로 설정함
		newDates.endDate = moment(event.end._d).subtract(1, 'days').format('YYYY-MM-DD');			// 종료날짜의 형식이 끝나는 날짜보다 앞설 수 없도록 해야 한다.
	} else {																						// 하루종일 설정이 아닌경우
		newDates.startDate = moment(event.start._d).format('YYYY-MM-DD HH:mm');						// 시작날짜의 형식을 2021-10-20 15:00 으로 설정
		newDates.endDate = moment(event.end._d).format('YYYY-MM-DD HH:mm');							// 시간에 대해서도 시작하는 날짜보다 앞설수 없다.
	}

	return newDates;
}

/********************** 15. 드랍시에 수정되는 날짜에 대한 정보가 들어있다. ( 9.일정 드래그앤 드롭 이벤트에 사용한다 ) ********************/
function calDateWhenDragnDrop(event) {
	// 09 드랍시 수정된 날짜 반영
	var newDates = {
		startDate: '',
		endDate: ''
	}
	
	if(!event.end) {				// 날짜 & 시간이 모두 같은 경우											
		event.end = event.start;	// 날짜 & 시간이 같더라도일정에 대하여 등록을 할 수 있다.
	}

	
	if (event.allDay && event.end === event.start) {							// 하루짜리 all day
		newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');		// 포맷형식에 대하여 설정한다. (2021-10-20)
		newDates.endDate = newDates.startDate;									// 시작날짜(2021-10-20) = 종료날짜(2021-1020)
	}

	else if (event.allDay && event.end !== null) {											// 2일짜리 all day 인경우
		newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');					// 포맷형식에 대하여 설정한다. (2021-10-20)
		newDates.endDate = moment(event.end._d).subtract(1, 'days').format('YYYY-MM-DD');	// 시작날짜(2021-10-20) ~ 종료날짜(2021-10-19) 불가능
	}

	else if (!event.allDay) {																// 하루종일 설정이 안된 경우에는
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD HH:mm');					// 시간과 분까지 출력하도록 한다. (2021-10-20 15:00)
    newDates.endDate = moment(event.end._d).format('YYYY-MM-DD HH:mm');						// 시작날짜의 시작시간 (15:00) 보다 종료시간은 앞설 수 없다.
  }

  return newDates;
}