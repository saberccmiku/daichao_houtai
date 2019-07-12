/**
 * 产品统计js
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
		url: '../../statistics/products/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.product_id = vm.keyword;
			params.dateRange = vm.dateRange;
			params.productName = vm.productName;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "statDate", title : "统计日期", width : "100px"},
			{field : "productId", title : "产品ID", width : "100px"},
//			{field : "productCode", title : "产品编码", width : "100px"},
			{field : "productName", title : "产品名称", width : "100px"},
//			{field : "touristPv", title : "游客点击数", width : "100px"},
//			{field : "touristUv", title : "游客申请数", width : "100px"},
			{field : "userPv", title : "用户点击数(PV)", width : "100px"},
			{field : "userUv", title : "用户申请数(UV)", width : "100px"},
			{field : "regNum", title : "注册返数", width : "100px"},
			{field : "regNum", title : "UV转化", width : "100px",
				formatter : function(value, row, index) {
					var _html = '';
					if(row.userUv == 0){
						_html = "0";
					} else {
						_html = Math.round(row.regNum/row.userUv * 100) + '%';
					}
					return _html;
				}
			},
			
//			{field : "status", title : "状态(0-初始，1-正常)", width : "100px"},
			{field : "remark", title : "备注信息", width : "100px"},
//			{field : "createBy", title : "创建者", width : "100px"},
//			{field : "createTime", title : "创建时间", width : "200px"},
			{field : "updateTime", title : "更新时间", width : "250px"},
			{field : "updateBy", title : "最后修改者", width : "100px"},
//			{field : "del", title : "删除标记：0-正常，1-已经删除", width : "100px"},
			{title : "操作", width : "80px", formatter : function(value, row, index) {
					var _html = '';
					if (hasPermission('statistics:products:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
					}
					return _html;
				}
			}
		]
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
				title: '新增产品统计',
				url: 'statistics/product/add.html?_' + $.now(),
				width: '600px',
				height: '400px',
                scroll: true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑产品统计',
                url: 'statistics/product/edit.html?_' + $.now(),
                width: '400px',
                height: '380px',
                scroll: true,
                success: function(iframeId){
                    top.frames[iframeId].vm.statisticsProduct.id = id;
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
                url: '../../statistics/products/remove?_' + $.now(),
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