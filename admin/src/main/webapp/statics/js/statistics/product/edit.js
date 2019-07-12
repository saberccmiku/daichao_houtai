/**
 * 编辑-产品统计js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		statisticsProduct: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../statistics/products/info?_' + $.now(),
		    	param: vm.statisticsProduct.id,
		    	success: function(data) {
		    		vm.statisticsProduct = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../statistics/products/update?_' + $.now(),
		    	param: vm.statisticsProduct,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})