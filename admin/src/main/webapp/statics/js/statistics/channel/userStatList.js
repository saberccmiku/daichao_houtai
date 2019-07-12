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
		url: '../../stat/getUserStatlist?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.dateRange = vm.dateRange;
			params.channelName = vm.channelName;
			return params;
		},
		
		columns: [
			{checkbox: true},
			{field : "userId", title : "用户ID", width : "80px"},
//			{field : "name", title : "用户昵称", width : "100px"},
//			{field : "realName", title : "真实姓名", width : "100px"},
//			{field : "idNo", title : "用户证件号码", width : "100px"},
			{field : "mobile", title : "手机号码", width : "100px"},
			{field : "channelName", title : "渠道", width : "100px"},
			{field : "pv", title : "pv", width : "100px"},
			{field : "uv", title : "uv", width : "100px"},
			{field : "loginNum", title : "登录次数", width : "50px"},
			{field : "registerTime", title : "用户注册时间", width : "170px"},
			{field : "regIp", title : "注册ip", width : "170px"},
			{field : "loginIp", title : "登陆ip", width : "170px"},
			{field : "loginTime", title : "当前登录时间", width : "170px"},
			{field : "lastLoginTime", title : "上次登录时间", width : "100px"},
			{field : "loginIp", title : "当前登录ip", width : "100px"},
			{field : "lastLoginIp", title : "上次登录ip", width : "100px"},
			
			{field : "activeTime", title : "活跃时间", width : "100px"},
			
			{field : "source", title : "来源", width : "100px", formatter : function(value, row, index) {
				//（1-ios,2-android,3-H5）						
				return value == 1?"ios":value == 2?"android":value == 3?"H5":"";
			}},
			{field : "terminal", title : "注册终端", width : "100px", formatter : function(value, row, index) {
				//1-微信 2-qq 3-浏览器 4-app							
				return value == 1?"微信":value == 2?"qq":value == 3?"app":"";
			}},
			{field : "loginSource", title : "登陆来源", width : "100px", formatter : function(value, row, index) {
				//（1-ios,2-android,3-H5）						
				return value == 1?"ios":value == 2?"android":value == 3?"H5":"";
			}}
		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
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