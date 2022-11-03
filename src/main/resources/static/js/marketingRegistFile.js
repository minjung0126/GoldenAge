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
$("#btnRegist").on('click', function (){

    let msg = confirm('등록하시겠습니까?');

    if(msg == true){
        $("#form_regist").submit();
    } else{

    }
});

$(function(){

    const search = location.search;
    const params = new URLSearchParams(search);
    const num = params.get('mkNum');

    document.getElementById('num').value = num;
});