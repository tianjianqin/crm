layui.use(['laydate','form','layer'],function(){
    var form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        laydate = layui.laydate;

    laydate.render({
        elem: '.lastfollowdate',
        format: 'yyyy-MM-dd HH:mm:ss',
        type: 'datetime',
        trigger: 'click',
        done: function(value, date){
        }
    });
    laydate.render({
        elem: '.plandate',
        format: 'yyyy-MM-dd HH:mm:ss',
        type: 'datetime',
        trigger: 'click',
        done: function(value, date){
        }
    });

    form.on("submit(editCustominfo)",function(data) {
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        $.post("/custominfo/update", {
            id:$(".id").val(),
            customid:$(".customid").val(),
            statu: data.field.statu,  //客户状态
            lastfollowdate:$(".lastfollowdate").val(),
            plandate: $(".plandate").val(),
            mark: $(".mark").val()
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
