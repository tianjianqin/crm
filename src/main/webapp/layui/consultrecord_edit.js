layui.use(['laydate','form','layer'],function(){
    var form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        laydate = layui.laydate;

    form.on("submit(editConsultrecord)",function(data) {
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        $.post("/consultrecord/update", {
            id:$(".id").val(),
            customid:$(".customid").val(),
            consultstatu: data.field.consultstatu,  //客户状态
            result: $(".result").val()
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
