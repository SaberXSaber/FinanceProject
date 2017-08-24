<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


    <style>
        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <%--<h5>投注记录</h5>--%>
                            <div>
                                <label style="height: 25px">1月涨幅>=:</label>
                                <input id="oneMonth" name="oneMonth" type="text" style="height: 30px;text-align:center" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
                                <label style="height: 25px">3月涨幅>=:</label>
                                <input id="threeMonth" name="threeMonth" type="text" style="height: 30px;text-align:center" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
                                <label style="height: 25px">6月涨幅>=:</label>
                                <input id="sixMonth" name="sixMonth" type="text" style="height: 30px;text-align:center" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
                                <label style="height: 25px">1年涨幅>=:</label>
                                <input id="oneYear" name="oneYear" type="text" style="height: 30px;text-align:center" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
                                <label style="height: 25px">3年涨幅>=:</label>
                                <input id="threeYear" name="threeYear" type="text" style="height: 30px;text-align:center" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
                                <label style="height: 25px">成立来涨幅>=:</label>
                                <input id="always" name="always" type="text" style="height: 30px;text-align:center" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
                                <button data-toggle="button" class="btn btn-primary" type="button" id="btnSearch" name="btnSearch" style="">查询</button>
                                <button data-toggle="button" class="btn btn-primary" type="button" id="export" name="export" style="float: right">下载</button>
                            </div>
                    </div>
                    <%--<div>
                        <label style="height: 25px">1月:</label>
                        <input id="test" name="test" type="text" style="height: 30px;text-align:center"/>
                        <button data-toggle="button" class="btn btn-primary" type="button" id="btnSearch" name="btnSearch" style="float: right">查询</button>
                    </div>--%>
                    <div class="ibox-content">

                       <%-- <h4 class="m-t">高级用法</h4>--%>

                        <div class="jqGrid_wrapper">
                            <table id="table_list_1"></table>
                            <div id="pager_list_1"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="../js/jquery.min.js?v=2.1.4"></script>
    <script src="../js/bootstrap.min.js?v=3.3.6"></script>
    <script src="../js/plugins/peity/jquery.peity.min.js"></script>
    <script src="../js/plugins/jqgrid/i18n/grid.locale-cnffe4.js?0820"></script>
    <script src="../js/plugins/jqgrid/jquery.jqGrid.minffe4.js?0820"></script>
    <script src="../js/content.min.js?v=1.0.0"></script>
    <script src="../js/plugins/jqgrid/json2.js"></script>
    <script src="../js/jDialog/jquery.dialog.js"></script>
    <script src="../js/plugins/datapicker/bootstrap-datepicker.js"></script>


    <script>
        $(document).ready(function(){
            datePick = function(elem)
            {
                jQuery(elem).datepicker({ dateFormat: 'yy-mm-dd' });
            }
            $.jgrid.defaults.styleUI="Bootstrap";
            $("#table_list_1").jqGrid({
                url:'/shares/sharesAnalysisdata.htm',
                serializeGridData: function (postData)
                {
                    if (postData.searchField === undefined) postData.searchField = null;
                    if (postData.searchString === undefined) postData.searchString = null;
                    if (postData.searchOper === undefined) postData.searchOper = null;
                    postData.oneMonth = $("#oneMonth").val();
                    postData.threeMonth = $("#threeMonth").val();
                    postData.sixMonth = $("#sixMonth").val();
                    postData.oneYear = $("#oneYear").val();
                    postData.threeYear = $("#threeYear").val();
                    postData.always = $("#always").val();
                    return postData;
                },
                datatype:"json",
                height:590,
                autowidth:true,
                shrinkToFit:true,
                rowNum:15,
                rowList:[10,20,30],
                colNames:["股票代码","股票名称","购买数","涨跌幅","股票详情","购买此股票基金"],
                colModel:[
                    {name:"sharesCode",index:"sharesCode",editable:true,width:160},
                    {name:"sharesName",index:"sharesName",editable:true,width:160},
                    {name:"buyNum",index:"buyNum",sorttype:"float",editable:true,width:80,search:true},
                    {name:"totalRatio",index:"totalRatio",sorttype:"float",editable:true,width:80,formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:4}},

                   /* {name:'Modify',index:'id', align:'center',sortable:false,width:30}*/
                    {
                        label: '股票详情', name: '', index: 'operate', width: 45,search:false,
                        formatter: function (cellvalue, options, rowObject) {
                            return "<a style=color:#f60 href=http://quote.eastmoney.com/sz"+rowObject.sharesCode+"\.html\>详细</a>" }

                    },
                    {
                        label: '购买此股票基金', name: '', index: 'operate', width: 60, search:false,
                        /*formatter: function (cellvalue, options, rowObject) {
                            return  "<a  onclick='btn_detail(\""+ rowObject.orderId + "\")'>详细</a>";

                        },*/
                        formatter: function (cellvalue, options, rowObject) {
                            return "<a style=color:#f60 href=/fund/list?sharesCode="+rowObject.sharesCode+"\>查看</a>" }
                    },
                ],
                pager:"#pager_list_1",
                viewrecords:true,
                gridComplete:function(){
                    var ids=$("#table_list_1").jqGrid('getDataIDs');
                    for(var i=0; i<ids.length; i++){
                        var id=ids[i];
                        modify ="<a href='#' class='ui-icon ui-icon-pencil hand setPosition' onclick='editGateway("+ "\"" + id + "\""+")'></a>";
                        $("#table_list_1").jqGrid('setRowData', ids[i], { Modify: modify});
                    }
                },
                caption:"分析详情",
                hidegrid:false});
            $("#table_list_1").jqGrid(
                    "navGrid",
                    "#pager_list_1",
                    {edit:false,add:false,del:false,search:false}

            );
            $(window).bind(
                    "resize",
                    function(){
                        var width=$(".jqGrid_wrapper").width();
                        $("#table_list_1").setGridWidth(width)}
            )});
        function Modify(sharesName) {
           /* var KeyValue = GetJqGridRowValue("#table_list_1", "orderId");
            if (id!=null) {
                KeyValue=id;
            }
            if (IsChecked(KeyValue)) {*/
                /*var url = "/OrderDetail?orderId=" + id;
                Dialog(url, "Detail", "车辆详情", 750, 300, function (iframe) {
                    top.frames[iframe].AcceptClick();
                });*/
/*
            location.replace("/OrderDetail?orderId=" + id);
*/
            window.open('/fund/list?sharesCode='+sharesCode,'详情','height=710,width=940,resizable=no,location=no');
//            }
        }

        $("#btnSearch").click(function () {
          /*  var postData = $("#table_list_1").jqGrid("getGridParam", "postData");
            ParamJson = $("#test").val();
            $.extend(postData, { Param: ParamJson });*/
            $("#table_list_1").jqGrid("setGridParam", { search: true }).trigger("reloadGrid", [{ page: 1}]); //重载JQGrid
        });

        $("#export").click(function () {
            var oneMonth = $("#oneMonth").val();
            var threeMonth = $("#threeMonth").val();
            var sixMonth = $("#sixMonth").val();
            var oneYear = $("#oneYear").val();
            var threeYear = $("#threeYear").val();
            var always = $("#always").val();

            window.open('/shares/exportReport?oneMonth='+oneMonth+'&threeMonth='+threeMonth+'&sixMonth='+sixMonth+'&oneYear='+oneYear+'&threeYear='+threeYear+'&always='+always);

            /*$.ajax({
                type: "GET",
                url: "/shares/exportReport.htm",
                data: {
                    'oneMonth':oneMonth,
                    'threeMonth':threeMonth,
                    'sixMonth':sixMonth,
                    'oneYear':oneYear,
                    'threeYear':threeYear,
                    'always':always,
                },
                dataType: "json",
                success: function(data){
                },
                error:function(data){
                    alert("下载失败")
                }
            });*/
        });


    </script>
    <script type="text/javascript" src="../js/stats.js" charset="UTF-8"></script>
</body>
</html>
