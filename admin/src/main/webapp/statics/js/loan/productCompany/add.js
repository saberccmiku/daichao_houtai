/**
 * 新增-放贷公司信息js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		loanProductCompany: {
			id: 0,
			type: 1,
			status: 1
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../loan/productCompanys/save?_' + $.now(),
		    	param: vm.loanProductCompany,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
