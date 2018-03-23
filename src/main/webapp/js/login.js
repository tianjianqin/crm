$(document).ready(function () {
    $(".btn-submit").click(function () {
        login();
    });
    $('#form_login').keydown(function(event){
        if (event.keyCode == 13) {
            $('.btn-submit').click();
        }
    });
});

$(function () {
    $.supersized({
        // 功能
        slide_interval: 4000,
        transition: 1,
        transition_speed: 1000,
        performance: 1,

        // 大小和位置
        min_width: 0,
        min_height: 0,
        vertical_center: 1,
        horizontal_center: 1,
        fit_always: 0,
        fit_portrait: 1,
        fit_landscape: 0,

        // 组件
        slide_links: 'blank',
        slides: [
            {image: 'statics/images/parallax2.jpg'},
            {image: 'statics/images/parallax3.jpg'},
            {image: 'statics/images/parallax4.jpg'},
            {image: 'statics/images/slider-bg1.jpg'},
            {image: 'statics/images/slider-bg2.jpg'}
        ]
    });
    //显示隐藏验证码
    $("#hide").click(function(){
        $(".code").fadeOut("slow");
    });
    $("#captcha").focus(function(){
        $(".code").fadeIn("fast");
    });
    //跳出框架在主窗口登录
    if (top.location != this.location) top.location = this.location;
    $('#admin_name').focus();
    if ($.browser.msie && ($.browser.version == "6.0" || $.browser.version == "7.0")) {
        window.location.href = 'http://www.shopn.com/Public/Admin/ie6update.html';
    }
});
$(function(){
    $("#codeimage").attr("src","captcha.jpg?t=" + $.now());
});

function verifyimage(){
    $("#codeimage").attr("src","captcha.jpg?t=" + $.now());
}

/**
 * 定义变量
 * @type {string}
 */
var loginHandleUrl = "sys/login";
var homeUrl = "/index.jsp";

function login() {
    if ($('#admin_name').val() == '') {
        layer.msg('账号不能为空');
        $('#admin_name').focus();
        return false;
    }
    if ($('#admin_password').val() == '') {
        layer.msg('密码不能为空');
        $('#admin_password').focus();
        return false;
    }

    if($('#captcha').val() == ''){
        layer.msg('验证码不能为空');
        $('#captcha').focus();
        return false;
    }

    $.post(loginHandleUrl, {
        'username': $('#admin_name').val(),
        'password': $('#admin_password').val(),
        'captcha' : $('#captcha').val()
    }, function (data) {
        if (data == "1") {
            setTimeout(function () {
                $('.input-username,dot-left').addClass('animated fadeOutRight');
                $('.input-password-box,dot-right').addClass('animated fadeOutLeft');
                $('.btn-submit').addClass('animated fadeOutUp');
                setTimeout(function () {
                    $('.avatar').addClass('avatar-top');
                    $('.submit').hide();
                    $('.submit2').html('<div class="progress"><div class="progress-bar progress-bar-success" aria-valuetransitiongoal="100"></div></div>');
                    layer.msg("登录成功！");
                    $('.progress .progress-bar').progressbar({
                        done: function () {
                            location.href = homeUrl;
                        }
                    });
                }, 300);
            }, 300)

        } else if(data == "2"){
            layer.msg("用户名或密码错误");
        } else if(data == "3"){
            layer.msg("验证码错误");
            verifyimage();
        }else{
            layer.msg("您没有访问权限");
            verifyimage();
        }
    }, 'json')


}