layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
    laytpl = layui.laytpl,
        table = layui.table;

    var ztree;
    //职位列表
    var tableIns = table.render({
        elem: '#jobinfoList',
        url : '/jobinfo/job',
        cellMinWidth : 65,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "jobinfoListTable",
        even: true, //开启隔行背景
        cols : [[
            {field:"id", title: 'ID', width: 80, fixed:"left",sort:"true", align:'center',display:'none'},
            {field: 'job', title: '职位', align:'center',minWidth:100},
            {field: 'dname', title: '部门', align:'center',minWidth:100},
            {field: 'remarks', title: '备注', align:'center',minWidth:100},
            {title: '操作', minWidth:175, templet:'#jobinfoListBar',align:"center",fixed:"right",width:300}
        ]]
    });


    //搜索
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("jobinfoListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    job: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });



    //添加职位权限
    function addJobRight(){
        var index = layui.layer.open({
            title : "添加职位权限",
            type : 2,
            content : "jobright_add.html",
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }


    //编辑职位权限
    function editJobRight(edit){
        var index = layui.layer.open({
            title : "修改职位权限",
            type : 2,
            content : "jobright_add.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".id").val(edit.id);  //ID
                    body.find(".job").val(edit.job);  //职位
                    getRight(edit.id);
                    // body.find(".departmentid").val(edit.departmentid);    //部门
                    form.render("select");
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }
    $(".add_btn").click(function(){
        addJobRight();
    })


    //根据职位id获取职位信息
    function getRight(jobinfoid) {
        $.get("/jobright/info/"+jobinfoid, function(data){

            //勾选角色所拥有的菜单
            var rightIds = data;
            ztree = $.fn.zTree.getZTreeObj("menuTree");
            for(var i=0; i<rightIds.length; i++) {
                var node = ztree.getNodeByParam("rid", rightIds[i]);
                ztree.checkNode(node, true, false);
            }
        });
    }

    //列表操作
    table.on('tool(jobinfoList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            editJobRight(data);
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                $.get("/jobinfo/delete",{
                    id : data.id  //将需要删除的Id作为参数传入
                },function(data){
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
    });
})