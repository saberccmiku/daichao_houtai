/**
 * 编辑-客户信息js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		custUser: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../cust/users/info?_' + $.now(),
		    	param: vm.custUser.id,
		    	success: function(data) {
		    		vm.custUser = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../cust/users/update?_' + $.now(),
		    	param: vm.custUser,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})