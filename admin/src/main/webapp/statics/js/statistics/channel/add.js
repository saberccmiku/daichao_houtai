/**
 * 新增-渠道统计表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		statisticsChannel: {
			id: 0,
			regBase: 0,
			discount: 0,
			realRegNumber: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../statistics/channels/save?_' + $.now(),
		    	param: vm.statisticsChannel,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
		discount: function() {
			vm.statisticsChannel.regBase = 1;
				
//				$('.pcSelect').val();
		}
	}
})
