// 이미지 등록
$(function() {
    $("#input-file-regist").on('change', function(){
        readURL(this);

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $('.input-file-button-regist #View').attr('src', e.target.result);
                    $('.input-file-button-regist #View').removeClass('d-none');
                    $('.input-file-button-regist .fa').remove();
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
    });
});

// 아이템 수정, 등록
function openWindow(str, num) {

    //창 크기 지정
    var width = 700;
    var height = 650;

    //pc화면기준 가운데 정렬
    var left = (window.screen.width / 2) - (width/2);
    var top = (window.screen.height / 4);

    //윈도우 속성 지정
    var windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes';

    let url;

    //연결하고싶은url
    if(str == "cast-new"){
        url = "/marketing/detail/new/cast?mkNum=" + num;
    } else if(str == "md-new"){
        url = "/marketing/detail/new/md?mkNum=" + num;
    } else if(str == "item-new"){
        url = "/marketing/detail/new/item?mkNum=" + num;
    } else if(str == "cast"){
        url = "/marketing/detail/modify/cast?pFileNum=" + num;
    } else if(str == "md"){
        url = "/marketing/detail/modify/md?mdFileNum=" + num;
    } else if(str == "item"){
        url = "/marketing/detail/modify/item?itemFileNum=" + num;
    }

    //등록된 url 및 window 속성 기준으로 팝업창을 연다.
    window.open(url, "등록", windowStatus);
};

<!-- 게시글 수정 -->
function onClickModify(){

    if(document.getElementById('mkName').value==''){
        document.getElementById('mkName').focus();
        $('#mkName').next().css('display', 'block');
        return false;
    }
    if(document.getElementById('mkPlaceName').value==''){
        document.getElementById('mkPlaceName').focus();
        $('#mkPlaceName').next().css('display', 'block');
        return false;
    }
    if(document.getElementById('mkProduct').value==''){
        document.getElementById('mkProduct').focus();
        $('#mkProduct').next().css('display', 'block');
        return false;
    }
    if(document.getElementById('companyName').value==''){
        document.getElementById('companyName').focus();
        $('#companyName').next().css('display', 'block');
        return false;
    }

    let msg = confirm('게시물을 수정하시겠습니까?');

    if(msg == true){

        document.getElementById('frm').submit();
    } else {
        return false;
    }
}

<!-- input 입력 시 알림창  -->
function inputClick(input){

    if($('#' + input).val().trim()==''){
        $('#' + input).next().css('display', 'block');
        $('#' + input).val('');
    }
    if(!($('#' + input).val().trim()=='')){
        $('#' + input).next().css('display', 'none');
    }
}

<!-- 게시글 삭제 -->
function onClickDelete(){

    let msg = confirm('게시물을 삭제하시겠습니까?');

    if(msg == true){
        let msg2 = confirm('해당 게시물을 삭제합니다.');

        if(msg2 == true){
            document.getElementById('form_mk_d').submit();
        }
    }

}