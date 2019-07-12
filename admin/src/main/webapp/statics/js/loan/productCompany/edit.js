/**
 * 编辑-放贷公司信息js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		loanProductCompany: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../loan/productCompanys/info?_' + $.now(),
		    	param: vm.loanProductCompany.id,
		    	success: function(data) {
		    		vm.loanProductCompany = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../loan/productCompanys/update?_' + $.now(),
		    	param: vm.loanProductCompany,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})