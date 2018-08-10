/**
 * Created by Administrator on 2016/7/12.
 */
config.menukey = 'BaseJs';

var BaseJs = {};

(function(){


    var ProjectView = function(){
        var mmg=null;

        var cols =  [
            /*{
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

            },*/

            /*{
                title: 'Id',
                name: 'id',
                sortable:true,
                width: 40,

            },*/
            {
                title: '股票代码',
                name: 'sharesCode',
                sortable:true,
                width: 90,
            },
            {
                title: '股票名称',
                name: 'sharesName',
                width: 100,
                tips:true,
            },
            {
                title: '购买数',
                name: 'buyNum',
                width: 60
            },
            {
                title: '涨跌幅',
                name: 'totalRatio',
                width: 60
            },
            {
                title: '走势图',
                name: 'totalRatio',
                width: 60,
                renderer:function (val,item) {
                    var html ="";
                    html += "<a title='走势图' class='render_a' ><span class='fa fa-line-chart' aria-hidden='true' name='report'></span></a>"
                    return html;
                },
            },
           /* {
                title: '购买此股票基金',
                name: 'totalRatio',
                width: 60
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
                pageBean:{
                    page : 1,
                    limit : 25,
                    sortDirection:'',
                    sortExpression:'',
                },

                projectName: "",
                workCode: "",
                typeParent: "",
                typeChild: "",
                projectState: "",
                isLock: "",
                executeOperator: "",
                businessOperator: "",
                customerOperator: "",
                beginDate:"",
                endDate:"",
                executeOperatorArr: [],
                businessOperatorArr: [],
                customerOperatorArr: [],
                typeParentArr: [],
                typeChildArr: [],
                listIds:[],
            },
            methods : {


                exportBatch:function (){
                    items = mmg.selectedRows()
                    var projectIds = new Array
                    if (items.length < 1) {
                        layer.alert('请选择指定行');
                        return
                    }
                    items.forEach(function (el) {
                        projectIds.push(el.projectId)
                    });
                    window.open(config.path
                        + 'project/export?limit=1000000&'
                        + 'projectName=' + (this.projectName ? this.projectName : "")
                        + "&workCode=" + (this.workCode ? this.workCode : "")
                        + "&typeParent=" + (this.typeParent ? this.typeParent : "")
                        + "&typeChild=" + (this.typeChild ? this.typeChild : "")
                        + "&projectState=" + (this.projectState ? this.projectState : "")
                        + "&isLock=" + (this.isLock ? this.isLock : "")
                        + "&executeOperator=" + (this.executeOperator ? this.executeOperator : "")
                        + "&businessOperator=" + (this.businessOperator ? this.businessOperator : "")
                        + "&customerOperator=" + (this.customerOperator ? this.customerOperator : "")
                        + "&listIds=" + (projectIds ? projectIds : "")
                        + "&beginDate=" + (this.beginDate ? this.beginDate : "")
                        + "&endDate=" + (this.endDate ? this.endDate : ""));
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
                        projectName: this.projectName,
                        workCode: this.workCode,
                        typeParent: this.typeParent,
                        typeChild: this.typeChild,
                        projectState: this.projectState,
                        isLock: this.isLock,
                        executeOperator: this.executeOperator,
                        businessOperator: this.businessOperator,
                        customerOperator: this.customerOperator,
                        beginDate:this.beginDate,
                        endDate:this.endDate,
                    }
                    mmg.load(data);
                },
                exportData: function () {
                    window.open(config.path
                        + 'project/export?limit=1000000&'
                        + 'projectName=' + (this.projectName ? this.projectName : "")
                        + "&workCode=" + (this.workCode ? this.workCode : "")
                        + "&typeParent=" + (this.typeParent ? this.typeParent : "")
                        + "&typeChild=" + (this.typeChild ? this.typeChild : "")
                        + "&projectState=" + (this.projectState ? this.projectState : "")
                        + "&isLock=" + (this.isLock ? this.isLock : "")
                        + "&executeOperator=" + (this.executeOperator ? this.executeOperator : "")
                        + "&businessOperator=" + (this.businessOperator ? this.businessOperator : "")
                        + "&customerOperator=" + (this.customerOperator ? this.customerOperator : "")
                        + "&beginDate=" + (this.beginDate ? this.beginDate : "")
                        + "&endDate=" + (this.endDate ? this.endDate : ""));
                },
                addInfo:function () {
                    var _this=this;
                    layer.open({
                        type: 2,
                        title: "添加",
                        shade: 0.8,
                        area: ["90%", "80%"],
                        content: './fundadd.html',
                        end:function (){
                        }
                    });
                },

                serachInfo:function (){
                    this.page=1;
                    this.getData()
                },
                reset:function (){
                    this.page = 1;
                    this.limit = 25;
                    this.sortDirection = "";
                    this.sortExpression = "";

                    this.projectName = "";
                    this.workCode = "";
                    this.typeParent = "";
                    this.typeChild = "";
                    this.projectState = "";
                    this.isLock = "";
                    this.executeOperator = "";
                    this.businessOperator = "";
                    this.customerOperator = "";
                    this.beginDate= "";
                    this.endDate= "";

                    //初始化部门
                    index_model.$nextTick(function() {
                        $('#typeParent').trigger('chosen:updated');//更新选项
                        $('#typeChild').trigger('chosen:updated');//更新选项
                        $('#projectState').trigger('chosen:updated');//更新选项
                        $('#isLock').trigger('chosen:updated');//更新选项
                        $('#executeOperator').trigger('chosen:updated');//更新选项
                        $('#businessOperator').trigger('chosen:updated');//更新选项
                        $('#customerOperator').trigger('chosen:updated');//更新选项
                    })
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
            url:config.path+"shares/sharesAnalysisdatalist",
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
            if(ele.is('span[name="report"]')){
                layer.open({
                    type: 2,
                    title: "修改",
                    shade: 0.8,
                    area: ["80%", "80%"],
                    content: './report.html?sharesCode='+item.sharesCode,
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

        index_model.getData();
    };

    BaseJs.ProjectView=ProjectView;



})()