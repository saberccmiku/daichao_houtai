/**
 * 新增-产品统计js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		statisticsProduct: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../statistics/products/save?_' + $.now(),
		    	param: vm.statisticsProduct,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
