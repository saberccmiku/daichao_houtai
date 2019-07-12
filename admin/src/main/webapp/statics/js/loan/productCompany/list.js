/**
 * 放贷公司信息js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../loan/productCompanys/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "id", title : "公司ID", width : "100px"},
//			{field : "companyCode", title : "产品公司编码", width : "100px"},
			{field : "companyName", title : "公司名称", width : "100px"},
//			{field : "logo", title : "公司logo", width : "100px"},
			{field : "type", title : "类型", width : "100px"},
			{field : "rechargeAmt", title : "充值金额", width : "100px"},
			{field : "balance", title : "余额", width : "100px"},
			{field : "price", title : "单价", width : "100px"},
			{field : "contactName", title : "联系人", width : "100px"},
			{field : "contactPhone", title : "联系人手机号", width : "100px"},
			{field : "address", title : "公司地址", width : "100px"},
//			{field : "status", title : "状态", width : "100px",
//				formatter : function(value, row, index) {
//					return value == 0?"不可用":value == 1?"可用":"";
//				}
//			},
			
			{
				field : "status",
				title : "状态",
				width : "60px",
				formatter : function(value, row, index) {
				    if (row.status === 1) {
				        if (hasPermission('sys:user:disable')) {
	                        return '<input type="checkbox" class="js-switch" data-id="'+row.id+'" checked>';
	                    } else {
	                        return '<i class="fa fa-toggle-on"></i>';
	                    }
	                }

	                if (row.status === 0) {
	                    if (hasPermission('sys:user:enable')) {
	                        return '<input type="checkbox" class="js-switch" data-id="'+row.id+'">';
	                    } else {
	                        return '<i class="fa fa-toggle-off"></i>';
	                    }
	                }
				}
			},
			
			{field : "remark", title : "备注信息", width : "100px"},
			{field : "createBy", title : "创建者", width : "100px"},
			{field : "createTime", title : "创建时间", width : "100px"},
			{field : "updateBy", title : "最后修改者", width : "100px"},
			{field : "updateTime", title : "更新时间", width : "100px"},
//			{field : "del", title : "删除标记：0-正常，1-已经删除", width : "100px"},
			{title : "操作", formatter : function(value, row, index) {
					var _html = '';
					if (hasPermission('loan:productCompanys:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
					}
					if (hasPermission('loan:productCompanys:remove')) {
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
                    var url = '../../loan/productCompanys/disable?_' + $.now();
                    if (switchUtils.checked(switchContainer)) {
                        url = '../../loan/productCompanys/enable?_' + $.now();
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
		keyword: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增放贷公司信息',
				url: 'loan/productCompany/add.html?_' + $.now(),
				width: '700px',
				height: '600px',
                scroll: true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑放贷公司信息',
                url: 'loan/productCompany/edit.html?_' + $.now(),
                width: '700px',
                height: '600px',
                scroll: true,
                success: function(iframeId){
                    top.frames[iframeId].vm.loanProductCompany.id = id;
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
                url: '../../loan/productCompanys/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
		}
	}
})