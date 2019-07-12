/**
 * 编辑-渠道信息js
 */
//$(function(){
//    vm.getComList();
//})

var vm = new Vue({
	el:'#dpLTE',
	data: {
		loanChannel: {
//			companyId : '',
			id: 0
		}
	},
	methods : {
//		getComList: function(){
//            $('.ccSelect').selectBindEx({
//                url: '../../loan/channelCompanys/select?_' + $.now(),
//                placeholder: '请选择公司',
//                value: 'id',
//                text: 'companyName'
//            });
//        },
		setForm: function() {
			$.SetForm({
				url: '../../loan/channels/info?_' + $.now(),
		    	param: vm.loanChannel.id,
		    	success: function(data) {
		    		vm.loanChannel = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
//			vm.loanChannel.companyId = $('.ccSelect').val();
		    $.ConfirmForm({
		    	url: '../../loan/channels/update?_' + $.now(),
		    	param: vm.loanChannel,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})