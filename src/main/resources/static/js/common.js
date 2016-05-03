if(typeof (Common) === 'undefined' || Common == null) Common = {};
Common.setting = {
	pages : {
		CONTEXTPAGE: 5 //显示连续的页数
		,PAGESIZE: [5, 10, 20, 50] //每页显示条数
	}
}

Common.method = {
	/*
	 * 页码控件，配置说明：
	 * Common.setting.pages 配置页码相关参数
	 * Common.method.pages 页码相关函数
	 * 使用说明：
	 * 页面引入common.js文件，在需要显示页码的地方插入<div class="page"></div>
	 * 然后在页码启动函数内调用Common.method.pages.genPageNumber函数
	 * 参数说明：
	 * formID：form表单id
	 * currentIndex：当前页数
	 * sizePerPage：当前选择的每页显示条数
	 * totalPage： 总页数
	 *  
	 */
	pages:{
		//生成页码链接跳转执行方法
		genPageSkipJS: function(formID, targetPage, currentIndex, sizePerPage, totalPage){
			if(targetPage==currentIndex || targetPage>totalPage || targetPage < 1){
				return;
			}
			$('input[name="currentIndex"]').val(targetPage);
			$('#'+formID).submit();
		}
		//生成连续页码的页码数
		,nearbyPageNumber: function(currentPage, totalPage, size){
			if(currentPage>=1&&size>=0){
				size = Math.min(size, totalPage);
				var nearbyPage = new Array();
				var firstPage = currentPage - Math.ceil(size/2);
				firstPage = firstPage >= 1 ? firstPage : 1;
				if(firstPage > (totalPage - size)){
					firstPage = totalPage - size;
				}
				for(var i=1; i <= size; i++){
					nearbyPage[i] = firstPage + i;
				}
				return nearbyPage;
			}
			return new Array(0);
		}
		//生成连续页码
		,genContextLink: function(formID, currentIndex, sizePerPage, totalPage){
			var pages = Common.method.pages.nearbyPageNumber(currentIndex, totalPage, Common.setting.pages.CONTEXTPAGE);
			var link = '';
			for(i=1; i<pages.length; ++i){
				var on = pages[i]==currentIndex?'class="cur"':'';
				link += '<a '+on+' href="#" onclick="Common.method.pages.genPageSkipJS(\''+formID+'\','+pages[i]+','+currentIndex+','+sizePerPage+','+totalPage+')">'+pages[i]+'</a>';
			}
			return link;
		}
		//生成页码
		,genPageNumber: function(formID, currentIndex, sizePerPage, totalPage){
			$('div[class="page"]').append('<select name="sizePerPage"></select>');
			//从配置中读取每页显示的数量
			var pagesize = Common.setting.pages.PAGESIZE;
			for(i=0;i<pagesize.length;++i){
				$('select[name="sizePerPage"]').append('<option value="'+pagesize[i]+'">'+pagesize[i]+'</option>');
			}
			//生成页码链接!
			var perPage = currentIndex - 1 <=1 ? 1:currentIndex -1;
			var nextPage = currentIndex + 1;
			var lastPage = totalPage;
			$('div[class="page"]').append('<a href="#" onclick="Common.method.pages.genPageSkipJS(\''+formID+'\','+1+','+currentIndex+','+sizePerPage+','+totalPage+')">首页</a>');
			$('div[class="page"]').append('<a href="#" onclick="Common.method.pages.genPageSkipJS(\''+formID+'\','+perPage+','+currentIndex+','+sizePerPage+','+totalPage+')">上一页</a>');
			$('div[class="page"]').append(Common.method.pages.genContextLink(formID, currentIndex, sizePerPage, totalPage));
			$('div[class="page"]').append('<a href="#" onclick="Common.method.pages.genPageSkipJS(\''+formID+'\','+nextPage+','+currentIndex+','+sizePerPage+','+totalPage+')">下一页</a>');
			$('div[class="page"]').append('<a href="#" onclick="Common.method.pages.genPageSkipJS(\''+formID+'\','+lastPage+','+currentIndex+','+sizePerPage+','+totalPage+')">末页</a>');
			$('div[class="page"]').append('<span>第'+(currentIndex)+'页,共'+totalPage+'页</span>');
			//设置每页实现数量下拉框的默认值
			$('select[name="sizePerPage"]').val(sizePerPage);
			
			$('div[class="page"]').append('<input type="hidden" name="currentIndex" value="'+currentIndex+'" />');
			$('input[name="currentIndex"]').val(currentIndex);
			
			$('select[name="sizePerPage"]').change(function(){
				$('input[name="currentIndex"]').val(0);
				$('#'+formID).submit();
			});
		}
	}
		
}

$(document).ready(function() {
	//全选/反选
	$(".checkAll").click(function(){
		var sta = $(".checkAll").is(':checked');
		$(".checkBoxPreRow").prop('checked', sta);
	});
	
}) 