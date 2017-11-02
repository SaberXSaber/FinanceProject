<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>lottery管理后台 - 用户投注管理</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <!-- jqgrid-->
    <link href="../css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">

    <link href="../css/animate.min.css" rel="stylesheet">
    <link href="../css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="../css/plugins/datapicker/datepicker3.css" rel="stylesheet">



</head>

<body class="gray-bg">

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div>
                    <label style="height: 25px">热门股票头:</label>
                    <input id="startnum" name="startnum" type="text" style="height: 30px;text-align:center" />
                    ~~~
                    <label style="height: 25px">热门股票尾:</label>
                    <input id="endnum" name="endnum" type="text" style="height: 30px;text-align:center" />
                    <button data-toggle="button" class="btn btn-primary" type="button" id="btnSearch" name="btnSearch" style="">查询</button>
                </div>

                <table class="table table-striped table-bordered table-hover dataTables-example">
                    <thead>
                    <tr>
                        <th>基金code</th>
                        <th>基金name</th>
                        <th>热门股票占比数</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listdiff}" var="shares" >
                        <tr class="gradeX">
                           <%-- <td>${shares.key} </td>--%>
                            <td>${fn:split(shares.key,"_")[0]}</td>
                               <td>${fn:split(shares.key,"_")[1]}</td>

                            <td>${shares.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>




    <%--<div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>折线图</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="graph_flot.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        &lt;%&ndash;<div class="echarts" id="echarts-line-chart"></div>&ndash;%&gt;
                        <div id="myChart" style="height: 400px; width:750px; border: 1px solid #ccc; padding: 10px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>--%>

    <script src="../js/jquery.min.js?v=2.1.4"></script>
    <script src="../js/bootstrap.min.js?v=3.3.6"></script>
    <script src="../js/plugins/peity/jquery.peity.min.js"></script>
    <script src="../js/plugins/jqgrid/i18n/grid.locale-cnffe4.js?0820"></script>
    <script src="../js/plugins/jqgrid/jquery.jqGrid.minffe4.js?0820"></script>
    <script src="../js/content.min.js?v=1.0.0"></script>
    <script src="../js/plugins/jqgrid/json2.js"></script>
    <script src="../js/jDialog/jquery.dialog.js"></script>
    <script src="../js/plugins/datapicker/bootstrap-datepicker.js"></script>
   <%-- <script src="../js/plugins/echarts/echarts-all.js"></script>--%>
<%--
    <script src="../js/plugins/echarts/echarts.common.min.js"></script>
--%>
  <%--  <script src="../js/demo/echarts-demo.min.js"></script>--%>


    <script type="text/javascript" src="../js/stats.js" charset="UTF-8"></script>
    <script type="text/javascript">
       /* var myChart = echarts.init(document.getElementById('myChart'));
        option = {
            title: {
                text: '折线图堆叠'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
//                data: ['周一','周二','周三','周四','周五','周六','周日']
                data :[]
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'邮件营销',
                    type:'line',
                    stack: '总量',
//                    data:[120, 132, 101, 134, 90, 230, 210]
                    data:[]
                },
                {
                    name:'联盟广告',
                    type:'line',
                    stack: '总量',
                    //                    data:[120, 132, 101, 134, 90, 230, 210]
                    data:[]
                },
                {
                    name:'视频广告',
                    type:'line',
                    stack: '总量',
                    //                    data:[120, 132, 101, 134, 90, 230, 210]
                    data:[]
                },
                {
                    name:'直接访问',
                    type:'line',
                    stack: '总量',
                    //                    data:[120, 132, 101, 134, 90, 230, 210]
                    data:[]
                },
                {
                    name:'搜索引擎',
                    type:'line',
                    stack: '总量',
                    //                    data:[120, 132, 101, 134, 90, 230, 210]
                    data:[]
                }
            ]
        };

        $.ajax({
            type : "post",
            async : true, //异步执行
            url : "AcceptData",
            dataType : "json", //返回数据形式为json
            success : function(json) {
                if (json) {
                    fetchData(function (data) {
                        myChart.hideLoading();
                        myChart.setOption({
                            xAxis:{
                                data:json.xAxisData
                            },

                            series: json.seriesList

                        });
                    });
                }
            },
            error : function(errorMsg) {
                alert("请求数据失败");
            }
        });

        myChart.setOption(option);*/

        $("#btnSearch").click(function () {
            var startnum=document.getElementById("startnum").value;
            var endnum=document.getElementById("endnum").value;
            window.location.href="/fund/fundresult?startnum="+startnum+"&endnum="+endnum;
        });
    </script>
</body>
</html>
