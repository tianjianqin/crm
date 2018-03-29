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
        url : '/consultrecord/historyList',
        cellMinWidth : 65,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "consultrecordListTable",
        even: true, //开启隔行背景
        cols : [[
            {field:"id", title: 'ID', width: 60, fixed:"left",sort:"true", align:'center',display:'none'},
            {field: 'name', title: '客户姓名', align:"center"},
            {field: 'consultman', title: '咨询师姓名', align:'center'},
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

})
