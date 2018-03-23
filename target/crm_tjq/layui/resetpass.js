layui.use(['form','layer'],function(){
    var form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer;

    form.on("submit(addResetpass)",function(data) {
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        $.post("/resetpass/save", {
            id:$(".id").val(),
            username: $(".username").val(),  //登录名
            phoneno: $(".phoneno").val(),  //手机号
        }, function (res) {

        })
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
