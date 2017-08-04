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
                        <h5>
                            <%--基金--%>
                            <c:choose>
                                <c:when test="${sharesCode != null && sharesCode !=''}">
                                    购买${sharesCode}基金
                                </c:when>
                                <c:otherwise>
                                   全部股票基金
                                </c:otherwise>
                            </c:choose>
                        </h5>
                    </div>
                    <input type="hidden" id="sharesValue" id="sharesValue" value="${sharesCode}">
                   <%-- <div class="form-group">
                        <label style="width:50px;float:left;">密码：</label>
                        <div style="float:left;">
                            <input type="password" placeholder="密码" class="form-control" width="50">
                        </div>
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
                url:'/fund/funddata.htm',
                serializeGridData: function (postData)
                {
                    if (postData.searchField === undefined) postData.searchField = null;
                    if (postData.searchString === undefined) postData.searchString = null;
                    if (postData.searchOper === undefined) postData.searchOper = null;
                    postData.sharesCode=$("#sharesValue").val();
                    return postData;
                },
                datatype:"json",
                height:590,
                autowidth:true,
                shrinkToFit:true,
                rowNum:15,
                rowList:[10,20,30],
                colNames:["Id","基金代码","基金简称",/*"详细地址",*/"净值估算","单位净值","累计净值","1月(%)","3月(%)","6月(%)","1年(%)","3年(%)","成立来(%)","基金规模(亿)","成立日","获取时间","详情"],
                colModel:[
                    {name:"id",index:"id",editable:false,width:40,sorttype:"int",search:true},
                    {name:"fundCode",index:"fundCode",editable:false,width:55},
                    {name:"fundName",index:"fundName",editable:true,width:180},
                  /*  {name:"detailedUrl",index:"detailedUrl",editable:true,width:210,formatter:function(cellvalue, options, rowObject){  return "<a href="+cellvalue +">"+cellvalue+"</a>"; }},*/
                    {name:"estimateValue",index:"estimateValue",editable:true,width:60,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:4}},
                    {name:"unitValue",index:"unitValue",editable:true,width:60,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:4}},
                    {name:"cumulativeValue",index:"cumulativeValue",editable:true,width:60,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:4}},
                    {name:"oneMonth",index:"oneMonth",editable:false,width:50,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:2}},
                    {name:"threeMonth",index:"threeMonth",editable:true,width:50,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:2}},
                    {name:"sixMonth",index:"sixMonth",editable:true,width:50,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:2}},
                    {name:"oneYear",index:"oneYear",editable:true,width:50,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:2}},
                    {name:"threeYear",index:"threeYear",editable:true,width:50,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:2}},
                    {name:"always",index:"always",editable:true,width:50,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:2}},
                    {name:"fundScale",index:"fundScale",editable:false,width:50,sorttype:"float",formatter:"number",formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:2}},
                    {name:"bulidDate",index:"bulidDate",editable:false,width:70,sorttype:"date",formatter:"date",sortable:false,search:true,stype:'text',searchoptions: {dataInit:datePick ,attr:{title:'选择日期'}}},
                    {name:"createTime",index:"createTime",editable:false,width:70,sorttype:"date",formatter:"date",sortable:false,search:false},
                    {
                        label: '详情', name: '', index: '', width: 45, search:false,
                        /*formatter: function (cellvalue, options, rowObject) {
                            return  "<a  onclick='btn_detail(\""+ rowObject.orderId + "\")'>详细</a>";

                        },*/
                        formatter: function (cellvalue, options, rowObject) {
                           /* return "<a href=\"#\" style=\"color:#f60\" onclick=\"Modify(" + rowObject.id + ")\">详细</a>" }*/
                            return "<a style=color:#f60 href="+rowObject.detailedUrl+"\>详细</a>"
                        }
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
                caption:"投注记录",
                add:true,
                edit:true,
                addtext:"Add",
                edittext:"Edit",
                editurl: '/userorderedit',
                hidegrid:false});
            $("#table_list_1").setSelection(4,true);
            $("#table_list_1").jqGrid(
                    "navGrid",
                    "#pager_list_1",
                    {edit:false,add:false,del:false,search:true},
                    {//EDIT
//                        height:200,reloadAfterSubmit:true
                        closeOnEscape: true,//Closes the popup on pressing escape key
                        reloadAfterSubmit: true,
                        drag: true,
                        editData: {
                            userId: function () {
                                var sel_id = $('#table_list_1').jqGrid('getGridParam', 'selrow');
                                var value = $('#table_list_1').jqGrid('getCell', sel_id, 'id');
                                return value;
                            }
                        }
                    },

                    {//ADD

                    },
                    {//DELETE
                        closeOnEscape: true,
                        closeAfterDelete: true,
                        reloadAfterSubmit: true,
                        closeOnEscape: true,
                        drag: true,
                        afterSubmit: function (response, postdata) {
                            if (response.responseText == "") {
                                $("#table_list_1").trigger("reloadGrid", [{ current: true }]);
                                return [false, response.responseText]
                            }
                            else {
                                $(this).jqGrid('setGridParam', { datatype: 'json' }).trigger('reloadGrid')
                                return [true, response.responseText]
                            }
                        },
                        delData: {
                            userId: function () {
                                var sel_id = $('#table_list_1').jqGrid('getGridParam', 'selrow');
                                var value = $('#table_list_1').jqGrid('getCell', sel_id, 'id');
                                return value;
                            }
                        }

                    },
                    {//SEARCH
                        closeOnEscape: true,
                        closeAfterDelete: true,
                        reloadAfterSubmit: true,
                        multipleSearch:true,// 开启多条件查询
                        drag: true,
                        prmNames : {
                            'page':'currPage',
                            'rows':'pageSize'
                        }

                    }
            );



            $(window).bind(
                    "resize",
                    function(){
                        var width=$(".jqGrid_wrapper").width();
                        $("#table_list_1").setGridWidth(width)}
            )});
        function Modify(id) {
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
            window.open('../fund/funddetial?fundId='+id,'详情','height=710,width=940,resizable=no,location=no');
//            }
        }

    </script>
    <script type="text/javascript" src="../js/stats.js" charset="UTF-8"></script>
</body>
</html>
