/**
 * 新增-客户信息js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		custUser: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../cust/users/save?_' + $.now(),
		    	param: vm.custUser,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
