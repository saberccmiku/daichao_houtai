/**
 * 编辑-产品信息js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		loanProduct: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../loan/products/info?_' + $.now(),
		    	param: vm.loanProduct.id,
		    	success: function(data) {
		    		vm.loanProduct = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../loan/products/update?_' + $.now(),
		    	param: vm.loanProduct,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})