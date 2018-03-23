
layui.use(['form','layer'],function(){
    var form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer;
    var ztree;
    $(function(){
        getMenuTree();
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

    var setting = {
        data: {
            simpleData: {
                enable: true,
                idKey: "rid",
                pIdKey: "pid"
                // rootPId: -1
            },
            key: {
                url:"nourl"
            }
        },
        check:{
            enable:true,
            nocheckInherit:true
        }
    };

    function getMenuTree(){
        //加载菜单树
        $.get("/jobright/list", function(data){
            ztree = $.fn.zTree.init($("#menuTree"), setting, data.rightsList);
            //展开所有节点
            ztree.expandAll(true);

        });
    }

    form.on("submit(addJobRight)",function(data) {
        //获取选择的菜单
        var nodes = ztree.getCheckedNodes(true);
        var rightIdList = [];
        for(var i=0; i<nodes.length; i++) {
            rightIdList[i]=nodes[i].rid;
        }
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        if($(".id").val() != null && $(".id").val().trim() != "" ){
            $.ajax({
                type : 'post',
                url : '/jobinfo/save',
                dataType : 'json',
                traditional: true,
                data : {id:$(".id").val(),
                    job: $(".job").val(),  //职位
                    departmentid: data.field.departmentid,//部门
                    rightIdList:rightIdList},  //权限ID集合
                success : function (data) { // 返回的RequestResult的json对象

                },
            });
        }else{
            $.ajax({
                type : 'post',
                url : '/jobinfo/save',
                dataType : 'json',
                traditional: true,
                data : {job: $(".job").val(),  //职位
                    departmentid: data.field.departmentid,//部门
                    rightIdList:rightIdList},  //权限ID集合
                success : function (data) { // 返回的RequestResult的json对象

                },
            });
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

