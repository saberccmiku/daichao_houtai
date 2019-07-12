/**
 * 编辑-渠道统计表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		statisticsChannel: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../statistics/channels/info?_' + $.now(),
		    	param: vm.statisticsChannel.id,
		    	success: function(data) {
		    		vm.statisticsChannel = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../statistics/channels/update?_' + $.now(),
		    	param: vm.statisticsChannel,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})