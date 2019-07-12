/**
 * 编辑-渠道公司js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		loanChannelCompany: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../loan/channelCompanys/info?_' + $.now(),
		    	param: vm.loanChannelCompany.id,
		    	success: function(data) {
		    		vm.loanChannelCompany = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../loan/channelCompanys/update?_' + $.now(),
		    	param: vm.loanChannelCompany,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})