/**
 * Created by Administrator on 2016/7/12.
 */
config.menukey = 'BaseJs';

var BaseJs = {};

(function(){


    var fundView = function(){
        var mmg=null;

        var cols =  [
            {
                title: '操作',
                name: 'operation',
                lockWidth:true,
                sortable: false,
                width: 60,
                renderer:function (val,item) {
                    var html ="";
                    if(val=="" ||val== null){
                        if(item.isLock==1){
                            html += "<a title='解锁' class='render_a' ><span class='glyphicon glyphicon-lock' aria-hidden='true' name='lock'></span></a>"
                        }else{
                            html += "<a title='编辑' class='render_a' ><span class='glyphicon glyphicon-edit' aria-hidden='true' name='edit'></span></a>"
                            html += "<a title='锁定' class='render_a' ><span class='glyphicon glyphicon-lock' aria-hidden='true' name='lock'></span></a>"
                            html += "<a title='删除' class='render_a' > <span name='delete' class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>"
                        }

                    }else{
                        html ="<span>"+val+"</span>";
                    }
                    return html;
                },

            },

            {
                title: 'Id',
                name: 'id',
                sortable:true,
                width: 40,

            },
            {
                title: '基金代码',
                name: 'fundCode',
                sortable:true,
                width: 90,
            },
            {
                title: '基金简称',
                name: 'fundName',
                width: 100,
                tips:true,
            },
            {
                title: '净值估算',
                name: 'estimateValue',
                width: 60
            },
            {
                title: '单位净值',
                name: 'unitValue',
                width: 60
            },


            {
                title: '累计净值',
                name: 'cumulativeValue',
                width: 40
            },
            {
                title: '1月(%)',
                name: 'oneMonth',
                width: 40
            },


            {
                title: '3月(%)',
                name: 'threeMonth',
                width: 40
            },
            {
                title: '6月(%)',
                name: 'sixMonth',
                width: 40
            },
            {
                title: '1年(%)',
                name: 'oneYear',
                width: 50
            },
            {
                title: '3年(%)',
                name: 'threeYear',
                width: 50
            },
            {
                title: '成立来(%)',
                name: 'always',
                width: 50
            },
            {
                title: '基金规模(亿)',
                name: 'fundScale',
                width: 50
            },
            {
                title: '成立日',
                name: 'bulidDate',
                width: 50
            },

            {
                title: '获取时间',
                name: 'createTime',
                width: 60,
                renderer: function (val) {
                    if(val&&val!=""){
                        return utool.myOnlyDate.date(val, "yyyy-MM-dd");
                    }else{
                        return "-"
                    }

                }
            },


            /*{
                title: '操作',
                name: 'cz',
                width: 60,
                renderer:function (val,item) {
                    var html ="";
                    if(item.isLock==1){
                        html += "<a title='解锁' class='render_a' ><span class='glyphicon glyphicon-lock' aria-hidden='true' name='lock'></span></a>"

                    }else{
                        html += "<a title='编辑' class='render_a' ><span class='glyphicon glyphicon-edit' aria-hidden='true' name='edit'></span></a>"
                        html += "<a title='锁定' class='render_a' ><span class='glyphicon glyphicon-lock' aria-hidden='true' name='lock'></span></a>"
                        html += "<a title='删除' class='render_a' > <span name='delete' class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>"
                    }
                    return html;
                },
            },*/

        ];

       /* cols.splice(0,0,{
            title: '操作',
            name: '',
            lockWidth:true,
            sortable: false,
            width: 60,
            renderer:function (val,item) {
                var html ="";
                if(item.isLock==1){
                    html += "<a title='解锁' class='render_a' ><span class='glyphicon glyphicon-lock' aria-hidden='true' name='lock'></span></a>"

                }else{
                    html += "<a title='编辑' class='render_a' ><span class='glyphicon glyphicon-edit' aria-hidden='true' name='edit'></span></a>"
                    html += "<a title='锁定' class='render_a' ><span class='glyphicon glyphicon-lock' aria-hidden='true' name='lock'></span></a>"
                    html += "<a title='删除' class='render_a' > <span name='delete' class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>"
                }
                return html;
            },
        })*/

        var index_model = new Vue({
            el : '#pageinit',
            data : {
                //Rights:resultData.Rights,
                page : 1,
                limit : 25,
                sortDirection:'',
                sortExpression:'',

                fundName: "",
                fundCode: "",

            },
            methods : {
                updateBatch:function (id){
                    items = mmg.selectedRows()
                    var projectIds = new Array
                    if (items.length < 1) {
                        layer.alert('请选择指定行');
                        return
                    }
                    items.forEach(function (el) {
                        projectIds.push(el.projectId)
                    });
                    layer.open({
                        type: 2,
                        title: "批量修改",
                        shade: [0.1, '#FFF'],
                        area: ["760px", "650px"],
                        content: './fundadd.html?projectIds=' + projectIds,
                        end: function () {
                            //index_model.getData()
                        }
                    });
                },



                //获取初始信息，并绑定列表单个编辑函数
                getData : function(){
                    var data = {
                        pageBean:{
                            page :  this.page,
                            limit : this.limit,
                            sortDirection:this.sortDirection,
                            sortExpression:this.sortExpression,
                        },

                        fundName: this.fundName,
                        fundCode:this.fundCode,
                    }
                    mmg.load(data);
                },
                exportData: function () {
                    window.open(config.path
                        + 'project/export?limit=1000000&'
                        + 'fundName=' + (this.fundName ? this.fundName : "")
                        + "&fundCode=" + (this.fundCode ? this.fundCode : ""));
                },
                addInfo:function () {
                    var _this=this;
                    layer.open({
                        type: 2,
                        title: "添加",
                        shade: 0.8,
                        area: ["760px", "650px"],
                        content: './fundadd.html',
                        end:function (){
                        }
                    });
                },
                /*importData:function(){
                    layer.open({
                        type: 2,
                        title: "上传",
                        shade: 0.8,
                        area: ["760px", "250px"],
                        content: './fundimport.html',
                        end:function (){
                        }
                    });
                },*/
                serachInfo:function (){
                    this.page=1;
                    this.getData()
                },
                reset:function (){
                    this.page = 1;
                    this.limit = 25;
                    this.sortDirection = "";
                    this.sortExpression = "";

                    this.fundName = "";
                    this.fundCode = "";
                  /*
                    index_model.$nextTick(function() {
                        $('#typeParent').trigger('chosen:updated');//更新选项
                        $('#typeChild').trigger('chosen:updated');//更新选项

                    })*/
                    this.getData()
                },

            },
            created:function (){

                new pickerDateRange('OfflineTime', {
                    defaultText: ' 至 ',
                    isSingleDay: false,
                    stopToday: false,
                    calendars: 2,
                    shortbtn:true,//是否显示快捷操作
                    startDate:"", //默认开始时间
                    endDate: "",	//默认结束时间
                    inputTrigger: 'dateRange',
                    success: function(obj) { //选择日期后的回调函数
                        index_model.beginDate = obj.startDate;
                        index_model.endDate = obj.endDate;
                        index_model.getData()
                    }
                })


                /*utool.ajax.ajaxRequest("POST", config.path + "operator/list", {page : 1, limit : 1000}, "json").done(function (returnData) {
                    returnData = JSON.parse(returnData);
                    if (returnData.code == 200) {
                        index_model.executeOperatorArr = returnData.data;
                        index_model.businessOperatorArr = returnData.data;
                        index_model.customerOperatorArr = returnData.data;

                        index_model.$nextTick(function () {
                            $('#executeOperator').chosen().change(function (tar, val) {
                                index_model.executeOperator = val.selected;
                            });
                            $('#businessOperator').chosen().change(function (tar, val) {
                                index_model.businessOperator = val.selected;
                            });
                            $('#customerOperator').chosen().change(function (tar, val) {
                                index_model.customerOperator = val.selected;
                            });
                        })
                    }

                })*/



               /* utool.ajax.ajaxRequest("POST", config.path + "project/selectType?parentName=" , {}, "json").done(function (returnData) {
                    returnData = JSON.parse(returnData);
                    if (returnData.code == 200) {
                        index_model.typeParentArr = returnData.data;
                        index_model.$nextTick(function () {
                            $('#typeParent').chosen().change(function (tar, val) {
                                index_model.typeParent = val.selected;
                                index_model.chose(val.selected);
                            });
                        })
                    }

                })*/
            }
        });

        mmg = $('.mmg').mmGrid({
            height: "auto",
            cols: cols,
            sortStatus: 'asc',
            checkCol: true,
            multiSelect: true,
            fullWidthRows: true,
            autoLoad: false,
            showBackboard: true,
            method: 'post',
            root: 'data',
            url:config.path+"fund/fundlist",
            params: {
                pageBean:{
                    page : 1,
                    limit : 25,
                    sortDirection:'',
                    sortExpression:'',
                }

            },
            plugins: [
                $('#pg').mmPaginator()
            ],
            limitChange:function(limit){
                index_model.limit = limit;
                index_model.page = 1;
                index_model.getData();
            },
            pageChange:function(page){
                index_model.page=page;
                index_model.getData();
            },
            sortChange:function(sort){
                index_model.sortDirection=sort.sortStatus;
                index_model.sortExpression=sort.sortName;
                index_model.getData();
            }
        })

        mmg.on('cellSelected', function(e, item, rowIndex, colIndex){
            var ele = $(e.target);
            if(ele.is('span[name="edit"]')){
                layer.open({
                    type: 2,
                    title: "修改",
                    shade: 0.8,
                    area: ["760px", "650px"],
                    content: './fundadd.html?projectId='+item.projectId,
                    end:function (){
                        index_model.getData()
                    }
                });
            }else if (ele.is('span[name="lock"]')) {
                layer.confirm("确认解锁/锁定此条信息?", {title: "提示"}, function () {
                    if(item.isLock ==1){
                        var str = "解锁成功"
                        var paramdata= {projectId:item.projectId,workCode:item.workCode,isLock :0}
                    }else{
                        var str = "锁定成功"
                        var paramdata= {projectId:item.projectId,workCode:item.workCode,isLock :1}
                    }

                    utool.ajax.ajaxRequest("POST", config.path + "project/update",paramdata, "json").done(function (returnData) {
                        returnData = JSON.parse(returnData);
                        if (returnData.code == 200) {
                            index_model.getData();
                            layer.alert(str, function (index) {
                                layer.close(index);
                            })
                        } else {
                            layer.alert('获取数据错误，错误原因' + returnData.msg, {title: '错误', icon: 2});
                        }

                    })
                })
                e.stopPropagation()
            }else if (ele.is('span[name="delete"]')) {
                layer.confirm("确认删除此条信息?", {title: "提示"}, function () {

                    var paramdata= {'projectId':item.projectId}
                    utool.ajax.ajaxRequest("POST", config.path + "project/delete",paramdata, "json").done(function (returnData) {
                        returnData = JSON.parse(returnData);
                        if (returnData.code == 200) {
                            index_model.getData();
                            layer.alert("删除成功", function (index) {
                                layer.close(index);
                            })
                        } else {
                            layer.alert('获取数据错误，错误原因' + returnData.msg, {title: '错误', icon: 2});
                        }

                    })
                })
                e.stopPropagation()
            }
        })

        /*mmg.on('loadSuccess', function(e, item){
            var data = {
                projectName: index_model.projectName,
                workCode: index_model.workCode,
                typeParent: index_model.typeParent,
                typeChild: index_model.typeChild,
                projectState: index_model.projectState,
                isLock: index_model.isLock,
                executeOperator: index_model.executeOperator,
                businessOperator: index_model.businessOperator,
                customerOperator: index_model.customerOperator,
                beginDate:index_model.beginDate,
                endDate:index_model.endDate,
            }
            utool.ajax.ajaxRequest("POST", config.path + "project/sum",data, "json").done(function (returnData) {
                returnData = JSON.parse(returnData);
                if (returnData.code == 200) {
                    var itemData = {
                        operation : '汇总',
                        projectState:'-',
                        workCode : '-',
                        projectName: '-',
                        beginDate: '-',
                        endDate: '-',
                        typeParent: '-',
                        typeChild: '-',
                        cooperationModel: '-',
                        totalType: '-',
                        isLock: '-',
                        executeOperator: '-',
                        businessOperator: '-',
                        customerOperator: '-',
                        customerOperator: '-',
                        createOperator: '-',
                        createTime: '',
                        saleMoney: returnData.data.saleMoneySum,
                        totalCommission: returnData.data.totalCommissionSum,
                        estimateCommission: returnData.data.estimateCommissionSum,
                    }
                    mmg.addRow(itemData, 0);
                } else {
                    layer.alert('获取数据错误，错误原因' + returnData.msg, {title: '错误', icon: 2});
                }
            })
        })*/

        index_model.getData();
    };


    /*var ProjectViewAdd=function (){
        var projectId= utool.search.getSearch("projectId");
        var listIds = new Array;
        var projectIds= utool.search.getSearch("projectIds").split(",");
        if(projectIds&&projectIds.length>0&&projectIds[1]!=null&&projectIds[1]!=""){
            listIds = projectIds
        }
        var isSingle = true

        if(projectId&&projectId>0){
            isSingle = true
        }else if(listIds&&listIds.length>0){
            isSingle = false
        }
        if((projectId==null||projectId=='')&&(listIds==null||listIds=='')){
            isSingle = true
        }
        var add_model = new Vue({
            el : '#pageinit',
            data : {
                projectId:projectId,
                projectName: "",
                workCode: "",
                typeParent: "",
                typeChild: "",
                projectState: "",
                executeOperator: "",
                businessOperator: "",
                customerOperator: "",
                beginDate:"",
                endDate:"",
                cooperationModel:"",
                totalType:"",
                linkNo:"",
                remark:'',
                updateOperator:'',
                viewOperators:'',
                executeOperatorArr: [],
                businessOperatorArr: [],
                customerOperatorArr: [],
                typeParentArr: [],
                typeChildArr: [],
                listIds:listIds,
                isSingle:isSingle
            },
            methods : {
                noRed:function (id){
                    $("#" + id) .removeClass("err-input");
                },
                getId:function (name){
                    add_model[name] = $("#"+name).val() || "";
                },
                parentFn: function (name) {
                    layer.open({
                        type: 2,
                        title: false,
                        shade: [0.1, '#FFF'],
                        closeBtn: false,
                        area: ["100%", "100%"],
                        content: './projectoperator.html?name=' + name,
                        end: function () {
                            add_model.getId("executeOperator");
                            add_model.getId("businessOperator");
                            add_model.getId("customerOperator");
                            add_model.getId("updateOperator");
                            add_model.getId("viewOperators");

                        }
                    });
                },
                chose: function (parentName) {
                    utool.ajax.ajaxRequest("POST", config.path + "project/selectType?parentName=" + parentName, {}, "json").done(function (returnedData) {
                        returnedData = JSON.parse(returnedData);
                        add_model.typeChildArr = returnedData.data;
                        add_model.$nextTick(function () {
                            $('#typeChild').trigger('chosen:updated');//更新选项
                            $('#typeChild').chosen().change(function (tar, val) {
                                add_model.typeChild = val.selected;
                                $('#typeChild').trigger('chosen:updated');//更新选项
                            });
                        })
                    })
                },
                submit:function (){
                    if(isSingle && this.projectName == ""){
                        $("#projectName").addClass("err-input");
                        return
                    }
                    if(isSingle &&this.workCode == ""){
                        $("#workCode").addClass("err-input");
                        return
                    }
                    if(isSingle && this.beginDate == ""){
                        $("#beginDate").addClass("err-input");
                        return
                    }

                    if(isSingle && this.endDate == ""){
                        $("#endDate").addClass("err-input");
                        return
                    }
                   /!* if(isSingle && this.linkNo == ""){
                        $("#linkNo").addClass("err-input");
                        return
                    }*!/
                    if(this.executeOperator == ""){
                        $("#executeOperator").addClass("err-input");
                        return
                    }
                    if(this.businessOperator == ""){
                        $("#businessOperator").addClass("err-input");
                        return
                    }
                    if(this.customerOperator == ""){
                        $("#customerOperator").addClass("err-input");
                        return
                    }
                    if(this.updateOperator == ""){
                        $("#updateOperator").addClass("err-input");
                        return
                    }
                    if(this.viewOperators == ""){
                        $("#viewOperators").addClass("err-input");
                        return
                    }
                    if(this.typeParent == ""){
                        layer.msg("请选择一级类别");
                        return
                    }
                    if(this.typeChild == ""){
                        layer.msg("请选择二级类别");
                        return
                    }
                    if(this.projectState == ""){
                        layer.msg("请选择项目状态");
                        return
                    }
                    if(isSingle && this.cooperationModel == ""){
                        layer.msg("请选择合作模式");
                        return
                    }
                    if(isSingle && this.totalType == ""){
                        layer.msg("请选择结算类型");
                        return
                    }

                    if(listIds && listIds.length>0){
                        console.info(listIds==null)
                        console.info("批量修改:"+listIds)
                        console.info("批量修改:"+listIds.length)
                        var postData = {
                            typeParent: this.typeParent,
                            typeChild: this.typeChild,
                            projectState: this.projectState,
                            executeOperator: this.executeOperator,
                            businessOperator: this.businessOperator,
                            customerOperator: this.customerOperator,
                            updateOperator:this.updateOperator,
                            viewOperators:this.viewOperators,
                            listIds:this.listIds
                        }
                        var url = config.path + "project/update";
                        var str = "批量修改项目成功";
                    }else{
                        if(projectId && projectId>0){
                            var postData = {
                                projectId:projectId,
                                projectName: this.projectName,
                                workCode: this.workCode,
                                typeParent: this.typeParent,
                                typeChild: this.typeChild,
                                projectState: this.projectState,
                                executeOperator: this.executeOperator,
                                businessOperator: this.businessOperator,
                                customerOperator: this.customerOperator,
                                beginDate:this.beginDate,
                                endDate:this.endDate,
                                cooperationModel:this.cooperationModel,
                                totalType:this.totalType,
                                linkNo:this.linkNo,
                                remark:this.remark,
                                updateOperator:this.updateOperator,
                                viewOperators:this.viewOperators,

                            }
                            var url = config.path + "project/update";
                            var str = "修改项目成功";
                        }else{
                            console.info("添加项目成功:"+listIds)

                            var postData = {
                                projectName: this.projectName,
                                workCode: this.workCode,
                                typeParent: this.typeParent,
                                typeChild: this.typeChild,
                                projectState: this.projectState,
                                executeOperator: this.executeOperator,
                                businessOperator: this.businessOperator,
                                customerOperator: this.customerOperator,
                                beginDate:this.beginDate,
                                endDate:this.endDate,
                                cooperationModel:this.cooperationModel,
                                totalType:this.totalType,
                                linkNo:this.linkNo,
                                remark:this.remark,
                                updateOperator:this.updateOperator,
                                viewOperators:this.viewOperators,
                            }
                            var url = config.path + "project/add";
                            var str = "添加项目成功";
                        }
                    }
                    layer.load(0, {shade: false});
                    utool.ajax.ajaxRequest("POST",url,postData,"json").done(function (returnData){
                        returnData = JSON.parse(returnData);
                        layer.closeAll()
                        if(returnData.code==200){
                            layer.alert(str,function (){
                                parent.layer.closeAll();
                            })
                            parent.location.reload();
                        }else{
                            layer.alert('获取数据错误，错误原因'+ returnData.msg,{title : '错误',icon : 2});
                        }
                    })
                },
                cancel:function(){
                    parent.layer.closeAll();
                }
            },
            created:function (){

                laydate.render({
                    elem: '#beginDate', //需显示日期的元素选择器
                    event: 'click', //触发事件
                    format: 'yyyy-MM-dd', //日期格式
                    value: this.beginDate,
                    isclear: true, //是否显示清空
                    issure: true, //是否显示确认
                    min: '1900-01-01 00:00:00', //最小日期
                    max: '2099-12-31 23:59:59', //最大日期
                    fixed: false, //是否固定在可视区域
                    zIndex: 99999999, //css z-index
                    done: function(value){//选择好日期的回调
                        add_model.beginDate = value;
                    }
                });

                laydate.render({
                    elem: '#endDate', //需显示日期的元素选择器
                    event: 'click', //触发事件
                    format: 'yyyy-MM-dd', //日期格式
                    value: this.beginDate,
                    isclear: true, //是否显示清空
                    issure: true, //是否显示确认
                    min: '1900-01-01 00:00:00', //最小日期
                    max: '2099-12-31 23:59:59', //最大日期
                    fixed: false, //是否固定在可视区域
                    zIndex: 99999999, //css z-index
                    done: function(value){//选择好日期的回调
                        add_model.endDate = value;
                    }
                });

                /!*new pickerDateRange('OfflineTime', {
                    defaultText: ' 至 ',
                    isSingleDay: false,
                    stopToday: false,
                    calendars: 2,
                    shortbtn:true,//是否显示快捷操作
                    startDate:"", //默认开始时间
                    endDate: "",	//默认结束时间
                    inputTrigger: 'dateRange',
                    success: function(obj) { //选择日期后的回调函数
                        add_model.beginDate = obj.startDate;
                        add_model.endDate = obj.endDate;
                    }
                })*!/
                if(projectId && projectId>0){
                    utool.ajax.ajaxRequest("POST", config.path + "project/get?projectId="+projectId , {}, "json").done(function (returnData) {
                        returnData = JSON.parse(returnData);
                        if (returnData.code == 200) {
                            add_model.projectName= returnData.data.projectName;
                            add_model.workCode= returnData.data.workCode;
                            add_model.typeParent= returnData.data.typeParent;
                            add_model.typeChild= returnData.data.typeChild;
                            add_model.projectState= returnData.data.projectState;
                            add_model.executeOperator= returnData.data.executeOperator;
                            add_model.businessOperator= returnData.data.businessOperator;
                            add_model.customerOperator= returnData.data.customerOperator;
                            add_model.beginDate= returnData.data.beginDate;
                            add_model.endDate= returnData.data.endDate;
                            add_model.cooperationModel= returnData.data.cooperationModel;
                            add_model.totalType= returnData.data.totalType;
                            add_model.linkNo= returnData.data.linkNo;
                            add_model.remark= returnData.data.remark;
                            add_model.updateOperator= returnData.data.updateOperator;
                            add_model.viewOperators= returnData.data.viewOperators;


                            /!*utool.ajax.ajaxRequest("POST", config.path + "operator/list", {page : 1, limit : 1000}, "json").done(function (returnData) {
                                returnData = JSON.parse(returnData);
                                if (returnData.code == 200) {
                                    add_model.executeOperatorArr = returnData.data;
                                    add_model.businessOperatorArr = returnData.data;
                                    add_model.customerOperatorArr = returnData.data;
                                    add_model.$nextTick(function () {
                                        $('#executeOperator').chosen().change(function (tar, val) {
                                            add_model.executeOperator = val.selected;
                                        });
                                        $('#businessOperator').chosen().change(function (tar, val) {
                                            add_model.businessOperator = val.selected;
                                        });
                                        $('#customerOperator').chosen().change(function (tar, val) {
                                            add_model.customerOperator = val.selected;
                                        });
                                    })
                                }

                            })*!/

                            utool.ajax.ajaxRequest("POST", config.path + "project/selectType?parentName=" , {}, "json").done(function (returnData) {
                                returnData = JSON.parse(returnData);
                                if (returnData.code == 200) {
                                    add_model.typeParentArr = returnData.data;
                                    add_model.$nextTick(function () {
                                        $('#typeParent').chosen().change(function (tar, val) {
                                            add_model.typeParent = val.selected;
                                            add_model.chose(val.selected);
                                        });
                                    })
                                }
                            })
                            add_model.chose(add_model.typeParent);
                        }

                    })

                }else{
                    utool.ajax.ajaxRequest("POST", config.path + "project/selectType?parentName=" , {}, "json").done(function (returnData) {
                        returnData = JSON.parse(returnData);
                        if (returnData.code == 200) {
                            add_model.typeParentArr = returnData.data;
                            add_model.$nextTick(function () {
                                $('#typeParent').chosen().change(function (tar, val) {
                                    add_model.typeParent = val.selected;
                                    add_model.chose(val.selected);
                                });
                            })
                        }
                        add_model.chose(-1);

                    })

                }
            }
        });
    };*/



    BaseJs.fundView=fundView;

   /* BaseJs.ProjectViewAdd=ProjectViewAdd;*/



})()