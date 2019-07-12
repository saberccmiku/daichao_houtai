/**
 * 编辑-留言反馈js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		basicComment: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../basic/comments/info?_' + $.now(),
		    	param: vm.basicComment.id,
		    	success: function(data) {
		    		vm.basicComment = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../basic/comments/update?_' + $.now(),
		    	param: vm.basicComment,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})