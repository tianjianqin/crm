layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laypage = layui.laypage //分页
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : '/user/list',
        cellMinWidth : 65,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "userListTable",
        even: true, //开启隔行背景
        cols : [[
            {field:"id", title: 'ID', width: 60, fixed:"left",sort:"true", align:'center',display:'none'},
            {field: 'username', title: '用户名', minWidth:100, align:"center"},
            {field: 'nickname', title: '昵称', minWidth:100, align:'center'},
            {field: 'realname', title: '真实姓名', align:'center'},
            {field: 'job', title: '职位', align:'center',minWidth:100},
            {field: 'dname', title: '部门', align:'center',minWidth:100},
            {field: 'phoneno', title: '手机号', align:'center',minWidth:100},
            {field: 'officetel', title: '办公电话', align:'center',minWidth:100},
            {field: 'workstatu', title: '用户状态',  align:'center',templet:function(d){
                return d.workstatu == "1" ? '<span class="layui-btn-xs layui-btn">在职 </span>' : '<span class="layui-btn layui-btn-xs layui-btn-danger">离职 </span>';
            }},
            {title: '操作', minWidth:175, templet:'#userListBar',align:"center",fixed:"right",width:150}
        ]]
    });


    //搜索
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("userListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    realname: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加用户
    function addUser(){
        var index = layui.layer.open({
            title : "添加用户",
            type : 2,
            content : "employee_add.jsp",
        });
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }

    //编辑用户
    function editUser(edit){
        var index = layui.layer.open({
            title : "修改用户",
            type : 2,
            content : "employee_add.jsp",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".id").val(edit.id);  //ID
                    body.find(".username").val(edit.username);  //登录名
                    body.find(".password").val(edit.password);  //密码
                    body.find(".nickname").val(edit.nickname);  //昵称
                    body.find(".realname").val(edit.realname);  //真实姓名
                    body.find(".workstatu input[value="+edit.workstatu+"]").prop("checked","checked");  //状态
                    body.find(".departmentid").append("<option value='"+edit.departmentid+"'>"+edit.dname+"</option>");//有bug
                    body.find(".jobinfoid").append("<option value='"+edit.jobinfoid+"'>"+edit.job+"</option>");
                    body.find(".phoneno").val(edit.phoneno);    //手机号
                    body.find(".officetel").val(edit.officetel);    //办公电话
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
        addUser();
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            editUser(data);
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                $.get("/user/del",{
                    id : data.id  //将需要删除的Id作为参数传入
                },function(data){
                tableIns.reload();
                layer.close(index);
                })
            });
        }
    });

})