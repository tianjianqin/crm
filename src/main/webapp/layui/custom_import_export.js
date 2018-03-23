layui.use(['form','layer','upload','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        upload = layui.upload,
    laytpl = layui.laytpl,
        table = layui.table;

    //时间戳的处理
    layui.laytpl.toDateString = function(d, format){
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

    //客户列表
    var tableIns = table.render({
        elem: '#customList',
        url : '/custom/list',
        cellMinWidth : 65,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "customListTable",
        even: true, //开启隔行背景
        cols : [[
            {field:"id", title: 'ID', width: 60, fixed:"left",sort:"true", align:'center',display:'none'},
            {field: 'name', title: '客户姓名', minWidth:100, align:"center"},
            {field: 'education', title: '教育水平', minWidth:100, align:'center'},
            {field: 'phoneno', title: '手机号', align:'center'},
            {field: 'qq', title: 'QQ', align:'center',minWidth:100},
            {field: 'email', title: '邮箱', align:'center',templet:function(d){
                return '<a class="layui-blue" href="mailto:'+d.email+'">'+d.email+'</a>';
            }},
            {field: 'customstatu', title: '客户状态', align:'center',templet:function(d){
                if(d.customstatu == "0"){
                    return '<span class="layui-btn-xs layui-btn">未上门</span>' ;
                }else if(d.customstatu == "1"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-normal">已上门</span>' ;
                }else if(d.customstatu == "2"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-normal">销售跟进中</span>' ;
                }else if(d.customstatu == "3"){
                    return '<span class="layui-btn-xs layui-btn layui-btn-normal">咨询跟进中</span>' ;
                }else if(d.customstatu == "4"){
                    return '<span class="layui-btn layui-btn-xs layui-btn-danger">死单</span>';
                }else if(d.customstatu == "5") {
                    return '<span class="layui-btn-xs layui-btn layui-btn-warm">已报名</span>'
                }
            }},
            {field: 'createdate', title: '创建日期',align:'center',minWidth:100,templet: '<div>{{layui.laytpl.toDateString(d.createdate)}}</div>'},
            {field: 'invitename', title: '邀请人姓名',  align:'center',minWidth:100},
        ]]
    });


    //搜索
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("customListTable",{
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

    //选完文件后不自动上传
    upload.render({
        elem: '#select'
        ,url: '/import'
        ,auto: false
        ,accept: 'file' //普通文件
        //,multiple: true
        ,bindAction: '#import'
        ,done: function(data){
            setTimeout(function () {
                top.layer.msg(data.msg);
                layer.closeAll("iframe");
                //刷新页面
                window.location.reload();
            }, 2000);
            return false;
        }
    });

})