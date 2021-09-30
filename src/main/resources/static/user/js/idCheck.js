/**
 * idCheck.js
 */
$(function (){
    $('#idCheck').click(function (){
        var userId = $('#userId').val();
        if(userId == ''){
            alert('아이디를 입력해주세요');
            userId.focus();
            return;
        }
        
        var request = $.ajax({
            url: '/user/member/idCheck',
            type: 'get',
            data: { 'userId' : userId },
            dataType: "json"
        });

        request.done(function(data) {
            console.log(data);
            if(data.result == 0){
                alert('사용할 수 있는 아이디입니다');
            }else if(data.result == 1){
                alert('사용할 수 없는 아이디입니다');
            }else{
                alert('잘못된 요청 방식입니다.');
            }
        });

        request.fail(function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        });
        
    });
})

