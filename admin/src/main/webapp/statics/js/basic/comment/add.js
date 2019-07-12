/**
 * 新增-留言反馈js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		basicComment: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../basic/comments/save?_' + $.now(),
		    	param: vm.basicComment,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
