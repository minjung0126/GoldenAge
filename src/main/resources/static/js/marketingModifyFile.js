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
$("#btnModify").on('click', function (){

    let msg = confirm('수정하시겠습니까?');

    if(msg == true){
        $("#form_modify").submit();
    } else{

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

    }
});