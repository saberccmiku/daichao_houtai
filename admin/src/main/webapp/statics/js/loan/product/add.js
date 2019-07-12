/**
 * 新增-产品信息js
 */
$(function(){
    vm.getComList();
})

var vm = new Vue({
	el:'#dpLTE',
	data: {
		loanProduct: {
			id: 0,
			logo : '',
			type: 1,
			loanUnit: 'D',
			linkType: 1,
			categoryId: 1,
			label:1,
			status: 1,
			companyId : ''
		}
	},
	methods : {
		getComList: function(){
            $('.pcSelect').selectBindEx({
                url: '../../loan/productCompanys/select?_' + $.now(),
                placeholder: '请选择公司',
                value: 'id',
                text: 'companyName'
            });
        },
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
			vm.loanProduct.companyId = $('.pcSelect').val();
		    $.SaveForm({
		    	url: '../../loan/products/save?_' + $.now(),
		    	param: vm.loanProduct,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
        selectCover: function() {
            $('#cover').trigger('click');
        },
        uploadCover: function() {
//            if(checkFileExt($('#cover').val(), ['jpg', 'png'])) {
                $.ajaxFileUpload({
                    url: '../../loan/products/uploadImg',
                    type: 'post',
                    fileElementId: ['cover'],
                    dataType: 'json',
                    success: function (data) {
                        if(data.code=='0'){
                        	vm.loanProduct.logo = data.rows;
                            dialogMsg(data.msg, 'success');
                        }else{
                           dialogMsg(data.msg, 'error');
                        }
                    },
                    error: function (data, status, e) {
                       dialogMsg(e, 'error')
                    }
                });
//            } else {
//                dialogMsg('仅支持jpg，png类型！');
//            }
            $('#cover').on('change', vm.uploadCover);
        }
	
	}
})

