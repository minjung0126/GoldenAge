<!-- 파일 이미지 -->
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

<!-- 버튼 -->
// cast
$("#btnRegistCast").on('click', function (){

    if(document.getElementById('pCastName').value==''){
        $('#pCastName').next().css('display', 'block');
        document.getElementById('pCastName').focus();
        return false;
    }
    if(document.getElementById('pActName').value==''){
        $('#pActName').next().css('display', 'block');
        document.getElementById('pActName').focus();
        return false;
    }

    let msg = confirm('등록하시겠습니까?');

    if(msg == true){
        $("#form_regist").submit();
    } else {
        return false;
    }
});

// md
$("#btnRegistMd").on('click', function (){

    if(document.getElementById('mdName').value==''){
        $('#mdName').next().css('display', 'block');
        document.getElementById('mdName').focus();
        return false;
    }
    if(document.getElementById('mdPrice').value==''){
        $('#mdPrice').next().css('display', 'block');
        document.getElementById('mdPrice').focus();
        return false;
    }
    if(isNaN(document.getElementById('mdPrice').value)){
        $('#mdPrice').next().css('display', 'block');
        document.getElementById('mdPrice').focus();
        return false;
    }

    let msg = confirm('등록하시겠습니까?');

    if(msg == true){
        $("#form_regist").submit();
    } else {
        return false;
    }
});

// item
$("#btnRegistItem").on('click', function (){

    // item
    if(document.getElementById('itemName').value==''){
        $('#itemName').next().css('display', 'block');
        document.getElementById('itemName').focus();
        return false;
    }

    let msg = confirm('등록하시겠습니까?');

    if(msg == true){
        $("#form_regist").submit();
    } else {
        return false;
    }
});

$(function(){

    const search = location.search;
    const params = new URLSearchParams(search);
    const num = params.get('mkNum');

    document.getElementById('num').value = num;
});

<!-- input 입력 시 알림창  -->
function inputClick(input){

    if($('#' + input).val().trim()==''){
        $('#' + input).next().css('display', 'block');
        $('#' + input).next().text('필수 정보입니다.');
        $('#' + input).val('');
    }
    if(!($('#' + input).val().trim()=='')){
        $('#' + input).next().css('display', 'none');
    }
    if(!(/^[0-9]*$/.test($('#mdPrice').val()))){
        $('#mdPrice').next().css('display', 'block');
        $('#mdPrice').next().text('숫자만 입력해주세요.');
    }
}

function chk_form(){

    if(document.getElementById('mkName').value==''){
        $('#mkName').next().css('display', 'block');
        document.getElementById('mkName').focus();
        return false;
    }
    if(document.getElementById('mkPlaceName').value==''){
        $('#mkPlaceName').next().css('display', 'block');
        document.getElementById('mkPlaceName').focus();
        return false;
    }
    if(document.getElementById('mkProduct').value==''){
        $('#mkProduct').next().css('display', 'block');
        document.getElementById('mkProduct').focus();
        return false;
    }
    if(document.getElementById('companyName').value==''){
        $('#companyName').next().css('display', 'block');
        document.getElementById('companyName').focus();
        return false;
    }

    let msg = confirm('게시물을 등록하시겠습니까?');

    if(msg == true){
        document.getElementById('frm').submit();
    } else {
        return false;
    }
}