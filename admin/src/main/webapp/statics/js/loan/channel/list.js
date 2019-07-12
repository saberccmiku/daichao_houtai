/**
 * 渠道信息js
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
		url: '../../loan/channels/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.keyword = vm.keyword;
			params.dateRange = vm.dateRange;
			params.channelName = vm.channelName;
			
			return params;
		},
		columns: [
			{checkbox: true},
//			{field : "channelCode", title : "渠道编码", width : "100px"},
			{field : "id", title : "渠道ID", width : "100px"},
			{field : "channelName", title : "渠道名称", width : "120px"},
			{field : "channelUrl", title : "渠道链接", width : "200px",
				formatter : function(value, row, index) {
					return row.channelUrl + '?channel=' + row.id;
				}
			},
			{field : "remark", title : "备注信息", width : "100px"},
			{field : "companyId", title : "渠道公司ID", width : "100px"},
			{field : "pv", title : "总点击数", width : "100px"},
//			{field : "appId", title : "应用编号", width : "100px"},
			
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
	                    if (hasPermission('sys:user:disable')) {
	                        return '<input type="checkbox" class="js-switch" data-id="'+row.id+'">';
	                    } else {
	                        return '<i class="fa fa-toggle-off"></i>';
	                    }
	                }
				}
			}, 
			{field : "createBy", title : "创建者", width : "100px"},
			{field : "createTime", title : "创建时间", width : "200px"},
			{field : "updateBy", title : "最后修改者", width : "100px"},
			{field : "updateTime", title : "更新时间", width : "200px"},
			//{field : "del", title : "删除标记：0-正常，1-已经删除", width : "100px"},
			{title : "操作",width : "100px", formatter : function(value, row, index) {
					var _html = '';
					if (hasPermission('loan:channels:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
					}
					if (hasPermission('loan:channels:remove')) {
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
                    var url = '../../loan/channels/disable?_' + $.now();
                    if (switchUtils.checked(switchContainer)) {
                        url = '../../loan/channels/enable?_' + $.now();
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
		id:null,
		keyword: null,
		dateRangeText : '时间范围',
        dateRange : null,
        channelName:null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增渠道链接',
				url: 'loan/channel/add.html?_' + $.now(),
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
                title: '编辑渠道信息',
                url: 'loan/channel/edit.html?_' + $.now(),
                width: '600px',
                height: '400px',
                scroll: true,
                success: function(iframeId){
                    top.frames[iframeId].vm.loanChannel.id = id;
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
                url: '../../loan/channels/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
		},dateRangeSelect : function(count) {
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