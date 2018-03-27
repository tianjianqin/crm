
layui.use(['form','element','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element;
    $ = layui.jquery;
    //icon动画
    $(".panel a").hover(function(){
        $(this).find(".layui-anim").addClass("layui-anim-scaleSpring");
    },function(){
        $(this).find(".layui-anim").removeClass("layui-anim-scaleSpring");
    })
    $(".panel a").click(function(){
        parent.addTab($(this));
    })


    //用户数量
    $.get("/user/count",function(data){
        $(".userAll span").text(data.count);
    })

    // 基于准备好的dom，初始化echarts实例
    var myChartPie = echarts.init(document.getElementById('pieTable'));
    $.get("getPieData",{},function(pieData){
        // 指定图表的配置项和数据
        var option = {
            title : {
                text: '数据统计饼状图',
//                subtext: '纯属虚构',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                //data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
                data:pieData.legendData
            },
            series : [
                {
                    name: '数据统计',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:pieData.seriesData,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChartPie.setOption(option);
    },"json");



})



