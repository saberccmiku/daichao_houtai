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
		url: '../../stat/getChannelStatlist?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.keyword = vm.keyword;
			params.dateRange = vm.dateRange;
			params.channelName = vm.channelName;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "registerTime", title : "统计日期", width : "100px"},
			{field : "channelId", title : "渠道ID", width : "100px"},
			{field : "channelName", title : "渠道名称", width : "100px"},
			{field : "linkPv", title : "链接pv", width : "100px"},
			{field : "regSum", title : "注册数", width : "100px"},
			{field : "regSumInLinkPv", title : "注册率(注册/pv)", width : "100px",
				formatter : function(value, row, index) {
					var _html = '';
					if(row.linkPv == 0){
						_html = "0";
					} else {
						_html = Math.round(row.regSum/row.linkPv * 100) + '%';
					}
					return _html;
				}
			},
			
			{field : "loginSum", title : "登陆数", width : "100px"},
			{field : "regSumInLinkPv", title : "登陆率(登陆/注册)", width : "100px",
				formatter : function(value, row, index) {
					var _html = '';
					if(row.regSum == 0){
						_html = "0";
					} else {
						_html = Math.round(row.loginSum/row.regSum * 100) + '%';
					}
					return _html;
				}
				
			},

			{field : "activeTime", title : "平均活跃时间(s)", width : "100px",
				formatter : function(value, row, index) {
					var _html = '';
					if(row.loginSum == 0){
						_html = "0";
					} else {
						_html = Math.round(row.activeTime/row.loginSum);
					}
					return _html;
				}
			},
			{field : "uvSum", title : "平均UV", width : "100px",
				formatter : function(value, row, index) {
					var _html = '';
					if(row.loginSum == 0){
						_html = "0";
					} else {
						_html = Math.round(row.uvSum/row.loginSum*100)/100;
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