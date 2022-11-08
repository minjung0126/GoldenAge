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

<!-- 버튼 -->
// cast
$("#btnModifyCast").on('click', function (){

    if(document.getElementById('pCastName').value==''){
        document.getElementById('pCastName').focus();
        return false;
    }
    if(document.getElementById('pActName').value==''){
        document.getElementById('pActName').focus();
        return false;
    }

    let msg = confirm('수정하시겠습니까?');

    if(msg == true){
        $("#form_modify").submit();
    } else{
        return false;
    }
});

// md
$("#btnModifyMd").on('click', function (){

    if(document.getElementById('mdName').value==''){
        document.getElementById('mdName').focus();
        return false;
    }
    if(document.getElementById('mdPrice').value==''){
        document.getElementById('mdPrice').focus();
        return false;
    }
    if(isNaN(document.getElementById('mdPrice').value)){
        document.getElementById('mdPrice').focus();
        return false;
    }

    let msg = confirm('수정하시겠습니까?');

    if(msg == true){
        $("#form_modify").submit();
    } else{
        return false;
    }
});

// item
$("#btnModifyItem").on('click', function (){

    // item
    if(document.getElementById('itemName').value==''){
        document.getElementById('itemName').focus();
        return false;
    }

    let msg = confirm('수정하시겠습니까?');

    if(msg == true){
        $("#form_modify").submit();
    } else{
        return false;
    }
});

$("#btnDelete").on('click', function (){

    let msg = confirm('삭제하시겠습니까?');

    if(msg == true){
        let msg2 = confirm('해당 항목을 삭제합니다.');
        if(msg2 == true){

            $("#form_delete").submit();
        }
    } else{
        return false;
    }
});