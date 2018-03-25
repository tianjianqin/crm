layui.use(['form','layer','table','util','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        util = layui.util,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#consultrecordList',
        url : '/consultrecord/list',
        cellMinWidth : 65,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "consultrecordListTable",
        even: true, //开启隔行背景
        cols : [[
            {field:"id", title: 'ID', width: 60, fixed:"left",sort:"true", align:'center',display:'none'},
            {field: 'name', title: '客户姓名', width:100, align:"center"},
            {field: 'consultman', title: '咨询师姓名', width:120, align:'center'},
            {field: 'consultstatu', title: '客户状态', align:'center',templet:function(d){
                if(d.consultstatu == "0"){
                    return '<span class="layui-btn-xs layui-btn">新增</span>' ;
                }else if(d.consultstatu == "1"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-normal">紧跟</span>' ;
                }else if(d.consultstatu == "2"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-normal">已报名</span>' ;
                }else if(d.consultstatu == "3"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-danger">死单</span>' ;
                }else if(d.consultstatu == "4"){
                    return '<span class="layui-btn layui-btn-xs layui-btn-normal">报名后退费</span>';
                }
            }},
            {field: 'consultdate', title: '咨询日期',align:'center',minWidth:100},
            {field: 'result', title: '咨询备注',  align:'center',minWidth:100},
            {title: '操作', minWidth:100, templet:'#consultrecordListBar',align:"center",fixed:"right",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("consultrecordListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    name: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });


    //编辑客户开发信息
    function editCustominfo(edit){
        var index = layui.layer.open({
            title : "修改客户开发信息",
            type : 2,
            content : "consultrecord_edit.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".id").val(edit.id);  //ID
                    body.find(".customid").val(edit.customid);  //ID
                    body.find(".name").val(edit.name);  //名字
                    body.find(".consultman").val(edit.consultman);
                    body.find(".consultstatu input[value="+edit.consultstatu+"]").prop("checked","checked");  //状态
                    body.find(".consultdate").val(edit.consultdate);
                    body.find(".result").val(edit.result);    //备注
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

    //列表操作
    table.on('tool(consultrecordList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){ //编辑
            editCustominfo(data);
        }
    });
})

