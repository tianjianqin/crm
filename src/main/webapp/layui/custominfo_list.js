layui.use(['form','layer','table','util','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        util = layui.util,
        laytpl = layui.laytpl,
        table = layui.table;

    //时间戳的处理
    layui.laytpl.toDateString = function(d, format){
        if(d!=null){
            var date = new Date(d || new Date())
                ,ymd = [
                this.digit(date.getFullYear(), 4)
                ,this.digit(date.getMonth() + 1)
                ,this.digit(date.getDate())
            ]
                ,hms = [
                this.digit(date.getHours())
                ,this.digit(date.getMinutes())
                ,this.digit(date.getSeconds())
            ];

            format = format || 'yyyy-MM-dd HH:mm:ss';

            return format.replace(/yyyy/g, ymd[0])
                .replace(/MM/g, ymd[1])
                .replace(/dd/g, ymd[2])
                .replace(/HH/g, hms[0])
                .replace(/mm/g, hms[1])
                .replace(/ss/g, hms[2]);
        }else{
            return '';
        }
    };
//数字前置补零
    layui.laytpl.digit = function(num, length, end){
        var str = '';
        num = String(num);
        length = length || 2;
        for(var i = num.length; i < length; i++){
            str += '0';
        }
        return num < Math.pow(10, length) ? str + (num|0) : num;
    };

    //用户列表
    var tableIns = table.render({
        elem: '#custominfoList',
        url : '/custominfo/list',
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
            {field: 'startdate', title: '开始时间',align:'center',minWidth:100,templet: '<div>{{layui.laytpl.toDateString(d.startdate)}}</div>'},
            {field: 'lastfollowdate', title: '最近联系日期',align:'center',minWidth:100,templet: '<div>{{layui.laytpl.toDateString(d.lastfollowdate)}}</div>'},
            {field: 'plandate', title: '计划联系日期',align:'center',minWidth:100,templet:'<div>{{layui.laytpl.toDateString(d.plandate)}}</div>'},
            {field: 'mark', title: '备注',  align:'center',minWidth:100},
            {title: '操作', minWidth:100, templet:'#custominfoListBar',align:"center",fixed:"right",width:120}
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


    //编辑客户开发信息
    function editCustominfo(edit){
        var index = layui.layer.open({
            title : "修改客户开发信息",
            type : 2,
            content : "custominfo_edit.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".id").val(edit.id);  //ID
                    body.find(".name").val(edit.name);  //名字
                    body.find(".followman").val(edit.followman);
                    body.find(".statu input[value="+edit.statu+"]").prop("checked","checked");  //状态
                    body.find(".startdate").val(layui.laytpl.toDateString(edit.startdate));
                    body.find(".lastfollowdate").val(layui.laytpl.toDateString(edit.lastfollowdate));
                    body.find(".plandate").val(layui.laytpl.toDateString(edit.plandate));
                    body.find(".mark").val(edit.mark);    //备注
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
    table.on('tool(custominfoList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){ //编辑
            editCustominfo(data);
        }
    });
})

