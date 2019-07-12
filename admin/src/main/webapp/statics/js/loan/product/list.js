/**
 * 产品信息js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
	vm.dateRangeSelect(31);
	//日期选择
    laydate.render({
        elem: '#dateRange',
        range: true,
        theme: '#3C8DBC',
        trigger: 'click',
        done: function(value, date, endDate){
            vm.dateRangeSelect(0);
            vm.dateRange = value;
        }
    });
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../loan/products/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			params.dateRange = vm.dateRange;
			params.productName = vm.productName;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "id", title : "产品ID", width : "100px"},
			{field : "productName", title : "产品名称", width : "130px"},
			{field : "scort", title : "排位", width : "80px"},
			
			{
				field : "status",
				title : "上/下线",
				width : "100px",
				formatter : function(value, row, index) {
				    if (row.status === 1) {
				        if (hasPermission('sys:user:disable')) {
	                        return '<input type="checkbox" class="js-switch" data-id="'+row.id+'" checked>';
	                    } else {
	                        return '<i class="fa fa-toggle-on"></i>';
	                    }
	                }

	                if (row.status === 2) {
	                    if (hasPermission('sys:user:disable')) {
	                        return '<input type="checkbox" class="js-switch" data-id="'+row.id+'">';
	                    } else {
	                        return '<i class="fa fa-toggle-off"></i>';
	                    }
	                }
				}
			}, 
			
			{field : "type", title : "产品类型", width : "100px", formatter : function(value, row, index) {
					return value == 1?"现金贷":value == 2?"贷超":"";
				}
			},
			
//			{field : "companyId", title : "公司ID", width : "100px"},
			{field : "logo", title : "产品LOGO", width : "100px",
				formatter : function(value, row, index) {
					var _html = '<img src="'+row.logo+'" height="40" width="40"/>';
					return _html;
				}
			
			},
			
//			{field : "advantage", title : "产品优势", width : "100px"},
//			{field : "lendSpeed", title : "放款速度(小时)", width : "100px"},
			{field : "link", title : "链接", width : "100px"},
			{field : "linkType", title : "对接方式", width : "50px",
				formatter : function(value, row, index) {
					return value == '1'?"H5":value == '2'?"API":"";
				}
			},
			{field : "minAmt", title : "放款最小额", width : "100px"},
			{field : "maxAmt", title : "放款最大额", width : "100px"},
			{field : "minTerm", title : "最短周期(天)", width : "100px"},
			{field : "maxTerm", title : "最大周期(天)", width : "100px"},
			{field : "dayRate", title : "日利率", width : "100px"},
//			{field : "loanUnit", title : "借款单位（M-月、Q-季、Y-年、D-天）", width : "100px"},
//			{field : "fastestAuditCircle", title : "最快审核周期(小时)", width : "100px"},
//			{field : "passRate", title : "通过率", width : "100px"},
			{field : "categoryId", title : "产品分类", width : "100px",
				formatter : function(value, row, index) {
					return value == '1' ? "精选推荐":
						   value == '2' ? "新品专区":
						   value == '3' ? "100%下单":   
						   value == '4' ? "本周最佳":   
						    "";
				}
			
			},
			{field : "label", title : "产品标签", width : "80px",
				formatter : function(value, row, index) {
					return value == '1' ? "热门推荐":
						   value == '2' ? "额度高":
						   value == '3' ? "利率低":   
						   value == '4' ? "本周最佳":   
						    "";
				}
			},
//			{field : "bannaerTag", title : "是否加入轮播图", width : "100px"},
//			{field : "applyNum", title : "申请人数", width : "80px"},
//			{field : "appId", title : "应用编号", width : "100px",
//				formatter : function(value, row, index) {
//					return value == '10' ? "乐享用":
//						    "";
//				}
//			},
			{field : "status", title : "状态", width : "80px", 
				formatter : function(value, row, index) {
					return value == 0?"初始":value == 1?"正常":value == 2?"下线":"";
				}
			},
			
//			{field : "remark", title : "备注信息", width : "100px"},
			{field : "createBy", title : "创建者", width : "100px"},
			{field : "createTime", title : "创建时间", width : "200px"},
			{field : "updateBy", title : "最后修改者", width : "100px"},
			{field : "updateTime", title : "更新时间", width : "200px"},
			{title : "操作", width : "80px", formatter : function(value, row, index) {
					var _html = '';
					if (hasPermission('loan:products:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i' +
							' class="fa fa-pencil"></i></a>';
					}
					if (hasPermission('loan:products:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
					}
					return _html;
				}
			}
		],
        onPostBody: function () {
            switchUtils.init({
                selector: '.js-switch',
                single: false,
                change: function (switchContainer) {
                    var url = '../../loan/products/disable?_' + $.now();
                    if (switchUtils.checked(switchContainer)) {
                        url = '../../loan/products/enable?_' + $.now();
                    }
                    $.AjaxForm({
                        url: url,
                        param: switchUtils.data(switchContainer, "id"),
                        success: function (data) {
                            vm.load();
                        }
                    });

                }
            });
        }
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		keyword: null,
		dateRangeText : '时间范围',
        dateRange : null,
        productName:null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增产品信息',
				url: 'loan/product/add.html?_' + $.now(),
				width: '850px',
				height: '700px',
                scroll: true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑产品信息',
                url: 'loan/product/edit.html?_' + $.now(),
                width: '850px',
                height: '700px',
                scroll: true,
                success: function(iframeId){
                    top.frames[iframeId].vm.loanProduct.id = id;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
		},
		remove: function(batch, id) {
			var ids = [];
			if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
					return false;
				}
                $.each(ck, function(idx, item){
                    ids[idx] = item.id;
                });
			} else {
			    ids.push(id);
			}
            $.RemoveForm({
                url: '../../loan/products/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
		},
		dateRangeSelect : function(count) {
            if(count == 1){
                vm.dateRangeText = '最近一天';
                vm.dateRange = countDay(-1) + ' - ' + today();
            }else if(count == 7){
                vm.dateRangeText = '最近一周';
                vm.dateRange = countDay(-7) + ' - ' + today();
            }else if(count == 30){
                vm.dateRangeText = '最近一月';
                vm.dateRange = countDay(-30) + ' - ' + today();
            }else{
                vm.dateRangeText = '时间范围';
                vm.dateRange = '';
            }
        }
	}
})