layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //添加验证规则
    form.verify({
        newPwd : function(value, item){
            if(value.length < 6){
                return "密码长度不能小于6位";
            }
        },
        confirmPwd : function(value, item){
            if(!new RegExp($("#newPwd").val()).test(value)){
                return "两次输入密码不一致，请重新输入！";
            }
        }
    });

    form.on("submit(changePwd)",function() {
        $.post("../user/password", {
           password:$("#oldPwd").val(),
            newPassword:$("#newPwd").val()
        }, function (result) {
            if(result == "1"){
                layer.alert('修改成功',function () {
                    parent.location.reload();
                });
            }else{
                layer.msg("旧密码输入错误，请重新输入");
            }
        });
        return false;
    });


    //控制表格编辑时文本的位置【跟随渲染时的位置】
    $("body").on("click",".layui-table-body.layui-table-main tbody tr td",function(){
        $(this).find(".layui-table-edit").addClass("layui-"+$(this).attr("align"));
    });

})

