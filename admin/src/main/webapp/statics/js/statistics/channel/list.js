/**
 * 渠道统计表js
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
		url: '../../statistics/channels/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.keyword = vm.keyword;
			params.dateRange = vm.dateRange;
			params.channelName = vm.channelName;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "statDate", title : "统计日期", width : "100px"},
			{field : "channelId", title : "渠道ID", width : "100px"},
//			{field : "channelCode", title : "渠道编码", width : "100px"},
			{field : "channelName", title : "渠道名称", width : "100px"},
			{field : "channelPv", title : "点击次数(PV)", width : "100px"},
			{field : "realRegNumber", title : "真实注册数", width : "100px"},
			{field : "realRegNumber", title : "PV转化", width : "100px",
				formatter : function(value, row, index) {
					var _html = '';
					if(row.userUv == 0){
						_html = "0";
					} else {
						_html = Math.round(row.realRegNumber/row.channelPv * 100) + '%';
					}
					return _html;
				}
			},
			{field : "loginNum", title : "登陆数", width : "100px"},
			{field : "discount", title : "折扣比例", width : "100px"},
			{field : "regBase", title : "注册数", width : "100px"},
//			{field : "status", title : "状态(0-初始，1-正常)", width : "100px"},
			{field : "remark", title : "备注信息", width : "100px"},
//			{field : "createBy", title : "创建者", width : "100px"},
//			{field : "createTime", title : "创建时间", width : "100px"},
			{field : "updateBy", title : "最后修改者", width : "100px"},
			{field : "updateTime", title : "更新时间", width : "200px"},
//			{field : "del", title : "删除标记：0-正常，1-已经删除", width : "100px"},
			{title : "操作", width : "100px", formatter : function(value, row, index) {
					var _html = '';
					if (hasPermission('statistics:channels:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
					}
					if (hasPermission('statistics:channels:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
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
        channelName:null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增渠道统计表',
				url: 'statistics/channel/add.html?_' + $.now(),
				width: '600px',
				height: '500px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑渠道统计表',
                url: 'statistics/channel/edit.html?_' + $.now(),
                width: '430px',
                height: '450px',
                success: function(iframeId){
                    top.frames[iframeId].vm.statisticsChannel.id = id;
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
                url: '../../statistics/channels/remove?_' + $.now(),
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