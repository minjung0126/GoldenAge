$(document).ready(function(){

    $(".blog-card img").click(function(){

        let num = $(this).closest('a').find('#num').val();

        // alert(num);
        let form = document.createElement('form');

        let mkNum = document.createElement('input');
        mkNum.setAttribute('type', 'hidden');
        mkNum.setAttribute('name', 'mkNum');
        mkNum.setAttribute('value', num);

        form.appendChild(mkNum);
        form.setAttribute('method', 'get');
        form.setAttribute('action', '/marketing/detail');
        document.body.appendChild(form);
        form.submit();

    })
})