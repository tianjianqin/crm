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
        url : '/user/consultList',
        cellMinWidth : 65,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "userListTable",
        even: true, //开启隔行背景
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field:"id", title: 'ID', width: 60, sort:"true", align:'center'},
            {field: 'username', title: '用户名', minWidth:100, align:"center"},
            {field: 'nickname', title: '昵称', minWidth:100, align:'center'},
            {field: 'realname', title: '真实姓名', align:'center'},
            {field: 'job', title: '职位', align:'center',minWidth:100},
            {field: 'dname', title: '部门', align:'center',minWidth:100},
            {field: 'phoneno', title: '手机号', align:'center',minWidth:100},
            {field: 'officetel', title: '办公电话', align:'center',minWidth:100},
            {field: 'workstatu', title: '用户状态',  align:'center',fixed:"right", width:200 ,templet:function(d){
                return d.workstatu == "1" ? '<span class="layui-btn-xs layui-btn">在职 </span>' : '<span class="layui-btn layui-btn-xs layui-btn-danger">离职 </span>';
            }},
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

    //分配客户给销售
    $(".distribute_consult").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            ids = [];
        if(data.length > 0) {
            for (var i in data) {
                ids.push(data[i].id);
            }
            layer.confirm('确定要给当前咨询员工分配客户？', {icon: 3, title: '提示信息'}, function (index) {
                $.ajax({
                    type : 'post',
                    url : '/consultrecord/distributeConsult',
                    dataType : 'json',
                    traditional: true,
                    data : {idList : ids},  //权限ID集合
                    success : function (data) { // 返回的RequestResult的json对象
                        layer.msg(data.msg);
                        tableIns.reload();
                        layer.close(index);
                    },
                });
            })
        }else{
            layer.msg("请选择需要分配的咨询员工");
        }
    })
})