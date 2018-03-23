layui.use(['form','layer'],function(){
    var form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer;

    $(function(){
        var html = "";
        $.ajax({
            url: '/department/list',
            success : function(data) {
                $(".departmentid").empty();
                $(".departmentid").append('<option value="">请选择</option>')
                //加载数据
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i].id + '">' + data[i].dname + '</option>'
                }
                $(".departmentid").append(html);
                form.render("select");
            },
            traditional: true,
            dataType: "json",
            type: "post"
        });
    });

    form.on('select(departmentid)', function(data){
        var departmentid = data.value;
        var html = "";
        $.ajax({
            url: '/jobinfo/list',
            data:{"departmentId":departmentid},
            success : function(data) {
                $(".jobinfoid").empty();
                $(".jobinfoid").append('<option value="">请选择</option>')
                //加载数据
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i].id + '">' + data[i].job + '</option>'
                }
                $(".jobinfoid").append(html);
                form.render("select");
            },
            traditional: true,
            dataType: "json",
            type: "post"
        });
    });

    form.on("submit(addEmployee)",function(data) {
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        if($(".id").val() != null && $(".id").val().trim() != "" ){
            $.post("/user/update", {
                id:$(".id").val(),
                username: $(".username").val(),  //登录名
                password: $(".password").val(),  //密码
                nickname: $(".nickname").val(),  //昵称
                realname: $(".realname").val(),  //真实姓名
                workstatu: data.field.workstatu,  //状态
                jobinfoid: data.field.jobinfoid,  //职位
                departmentid: data.field.departmentid,//部门
                phoneno: $(".phoneno").val(),  //手机号
                officetel: $(".officetel").val(),  //办公电话
            }, function (res) {

            })
        }else{
            $.post("/user/save", {
                username: $(".username").val(),  //登录名
                password: $(".password").val(),  //密码
                nickname: $(".nickname").val(),  //昵称
                realname: $(".realname").val(),  //真实姓名
                workstatu: data.field.workstatu,  //状态
                jobinfoid: data.field.jobinfoid,  //职位
                departmentid: data.field.departmentid,//部门
                phoneno: $(".phoneno").val(),  //手机号
                officetel: $(".officetel").val(),  //办公电话
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
