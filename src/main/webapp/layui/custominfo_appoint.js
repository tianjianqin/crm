layui.use(['form','layer','table','util','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        util = layui.util,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#custominfoList',
        url : '/custominfo/appointList',
        cellMinWidth : 65,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "custominfoListTable",
        even: true, //开启隔行背景
        cols : [[
            {field:"id", title: 'ID', width: 60, fixed:"left",sort:"true", align:'center',display:'none'},
            {field: 'name', title: '客户姓名', width:100, align:"center"},
            {field: 'followman', title: '跟单人姓名', width:120, align:'center'},
            {field: 'statu', title: '客户状态', align:'center',templet:function(d){
                if(d.statu == "0"){
                    return '<span class="layui-btn-xs layui-btn">未联系</span>' ;
                }else if(d.statu == "1"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-normal">未接通</span>' ;
                }else if(d.statu == "2"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-normal">紧跟</span>' ;
                }else if(d.statu == "3"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-normal">已上门</span>' ;
                }else if(d.statu == "4"){
                    return '<span class="layui-btn layui-btn-xs layui-btn-danger">死单</span>';
                }else if(d.statu == "5") {
                    return '<span class="layui-btn-xs layui-btn layui-btn-warm">电话无效</span>'
                }
            }},
            {field: 'startdate', title: '开始时间',align:'center',minWidth:100},
            {field: 'lastfollowdate', title: '最近联系日期',align:'center',minWidth:100},
            {field: 'plandate', title: '计划联系日期',align:'center',minWidth:100},
            {field: 'mark', title: '备注',  align:'center',minWidth:100},
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("custominfoListTable",{
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

