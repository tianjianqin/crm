layui.use(['form','layer'],function(){
    var form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer;

    form.on("submit(addCustom)",function(data) {
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        if($(".id").val() != null && $(".id").val().trim() != "" ){
            $.post("/custom/update", {
                id:$(".id").val(),
                name: $(".name").val(),  //客户姓名
                education: $(".education").val(),  //教育水平
                phoneno: $(".phoneno").val(),  //手机号
                email: $(".email").val(),  //邮箱
                qq: $(".qq").val(),  //qq
                customstatu: data.field.customstatu,  //客户状态
                invitename: $(".invitename").val(),  //邀请人姓名
            }, function (res) {

            })
        }else{
            $.post("/custom/save", {
                name: $(".name").val(),  //客户姓名
                education: $(".education").val(),  //教育水平
                phoneno: $(".phoneno").val(),  //手机号
                email: $(".email").val(),  //邮箱
                qq: $(".qq").val(),  //qq
                customstatu: data.field.customstatu,  //客户状态
                invitename: $(".invitename").val(),  //邀请人姓名
            }, function (res) {

            })
        }

        setTimeout(function () {
            top.layer.close(index);
            top.layer.msg("操作成功！");
            layer.closeAll("iframe");
            //刷新父页面
            parent.location.reload();
        }, 2000);
        return false;
    })

})
