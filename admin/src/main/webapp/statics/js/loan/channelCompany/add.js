/**
 * 新增-渠道公司js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		loanChannelCompany: {
			id: 0,
			status: 1
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../loan/channelCompanys/save?_' + $.now(),
		    	param: vm.loanChannelCompany,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
