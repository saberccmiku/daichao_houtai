/**
 * 客户信息js
 */

$(function () {
	initialPage();
	getGrid();  
	vm.getChannelList();
//	$.ajax({
//		url: '../../loan/channels/selectAll?_' + $.now(),  // 接口 路劲 
//		type: 'post',
//		data: "",  //传的参数 
//		success: function (ret) {
//			let res = ret.data    //得到的一个集合  
//			getGrid(res);    // 得到集合后 把这个集合的数据传进这个方法里面 并调用的这个方法
//		}
//	});
	
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
		url: '../../cust/users/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.keyword = vm.keyword;
			params.dateRange = vm.dateRange;
			params.realName = vm.realName;
			params.mobile = vm.mobile;
			params.channel = $('.channelSelect').val();
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "id", title : "用户ID", width : "80px"},
//			{field : "name", title : "用户昵称", width : "100px"},
			{field : "realName", title : "真实姓名", width : "100px"},
//			{field : "idNo", title : "用户证件号码", width : "100px"},
			{field : "mobile", title : "手机号码", width : "100px"},
//			{field : "bankMobile", title : "银行预留手机号", width : "100px"},
//			{field : "bankCode", title : "银行代码", width : "100px"},
//			{field : "cardNo", title : "银行卡号", width : "100px"},
//			{field : "email", title : "用户邮箱", width : "100px"},
			//{field : "avatar", title : "用户头像", width : "100px"},
//			{field : "sex", title : "用户性别", width : "100px"},
//			{field : "birthday", title : "生日", width : "100px"},
//			{field : "password", title : "用户密码", width : "100px"},
//			{field : "alipayId", title : "支付宝账号", width : "100px"},
			//{field : "weixinOpenid", title : "微信互联openid", width : "100px"},
			{field : "registerTime", title : "用户注册时间", width : "170px"},
			{field : "regIp", title : "注册ip", width : "170px"},
			{field : "loginIp", title : "登陆ip", width : "170px"},
			{field : "loginNum", title : "登录次数", width : "50px"},
			{field : "loginTime", title : "当前登录时间", width : "170px"},
			//{field : "lastLoginTime", title : "上次登录时间", width : "100px"},
			//{field : "loginIp", title : "当前登录ip", width : "100px"},
			//{field : "lastLoginIp", title : "上次登录ip", width : "100px"},
//			{field : "type", title : "用户类型", width : "100px"},
//			{field : "level", title : "用户等级", width : "100px"},
//			{field : "points", title : "用户积分", width : "100px"},
			//{field : "bindId", title : "第三方支付绑定id", width : "100px"},
//			{field : "identityStatus", title : "认证状态", width : "100px", formatter : function(value, row, index) {
//				//（0-未完成; 1-已完成）				
//				return value == 0?"未完成":value == 1?"已完成":"";
//			}},
//			{field : "creditLine", title : "授信额度", width : "100px"},
//			{field : "availCreditLine", title : "可用授信额度", width : "100px"},
//			{field : "usedCreditLine", title : "已用授信额度", width : "100px"},
//			{field : "exppoints", title : "用户经验值", width : "100px"},
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
			}},
			{field : "channelName", title : "渠道", width : "100px"},
			//{field : "appId", title : "来自哪个app", width : "100px"},
			//{field : "inviteCode", title : "邀请码", width : "100px"},
			{field : "status", title : "用户状态", width : "100px", formatter : function(value, row, index) {
				//1-正常，0-锁定账户								
				return value == 0?"锁定账户":value == 1?"正常":"";
			}},
			//{field : "remark", title : "备注信息", width : "100px"},
			//{field : "createBy", title : "创建者", width : "100px"},
			//{field : "createTime", title : "创建时间", width : "100px"},
//			{field : "updateBy", title : "最后修改者", width : "100px"},
//			{field : "updateTime", title : "最后修改时间", width : "100px"},
			//{field : "del", title : "删除标记：0-正常，1-已经删除", width : "100px"},
			{title : "操作", formatter : function(value, row, index) {
					var _html = '';
					if (hasPermission('cust:users:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
					}
					if (hasPermission('cust:users:remove')) {
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
        realName : null,
        mobile:null,
        channel:null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增客户信息',
				url: 'cust/user/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				scroll: true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑客户信息',
                url: 'cust/user/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                scroll: true,
                success: function(iframeId){
                    top.frames[iframeId].vm.custUser.id = id;
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
                url: '../../cust/users/remove?_' + $.now(),
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
        }, getChannelList: function(){
            $('.channelSelect').selectBindEx({
                url: '../../loan/channels/selectAll?_' + $.now(),
                placeholder: '请选择渠道',
                value: 'id',
                text: 'channelName'
            });
        },
	}
})