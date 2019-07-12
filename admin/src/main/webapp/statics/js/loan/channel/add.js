/**
 * 新增-渠道信息js
 */
//$(function(){
//    vm.getComList();
//})

var vm = new Vue({
	el:'#dpLTE',
	data: {
		loanChannel: {
			id: 0,
			status: 1,
//			companyId : '',
			channelUrl: 'http://wap.zhongdailianmeng.com/lxy_reg/'
		}
	},
	methods : {
//		getComList: function(){
//            $('.ccSelect').selectBindEx({
//                url: '../../loan/channelCompanys/select?_' + $.now(),
//                placeholder: '请选择公司',
//                value: 'id',
//                text: 'companyName',
//                selected:$("#param_companyId").val()
//            });
//        },
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
//			vm.loanChannel.companyId = $('.ccSelect').val();
		    $.SaveForm({
		    	url: '../../loan/channels/save?_' + $.now(),
		    	param: vm.loanChannel,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
