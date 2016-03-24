/**
 * Created by snow on 2016/3/14.
 */
var ace_icon = ace.vars['icon'];

jQuery(function($){
    var remoteUrl = '/menu/tree';

    var remoteDateSource = function(options, callback) {
        var parent_id = null
        if( !('text' in options || 'type' in options) ){
            parent_id = 0;//load first level data
        }
        else if('type' in options && options['type'] == 'folder') {//it has children
            if('additionalParameters' in options && 'children' in options.additionalParameters)
                parent_id = options.additionalParameters['id']
        }

        if(parent_id !== null) {
            $.ajax({
                url: remoteUrl,
                data: 'pid='+parent_id,
                type: 'POST',
                dataType: 'json',
                success : function(data) {
                    //if(response.status == "OK")
                        callback({ data: data })
                },
                error: function(response) {
                    //console.log(response);
                }
            })
        }
    }
    $('#tree1').ace_tree({
        dataSource: remoteDateSource ,
        loadingHTML:'<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
        'open-icon' : 'ace-icon fa fa-folder-open',
        'close-icon' : 'ace-icon fa fa-folder',
        'itemSelect' : true,
        'folderSelect': true,
        'multiSelect': false,
        'selected-icon' : null,
        'unselected-icon' : null,
        'folder-open-icon' : 'ace-icon tree-plus',
        'folder-close-icon' : 'ace-icon tree-minus'
    });
    $('#tree1')
        .on('updated', function(e, result) {
            //result.info  >> an array containing selected items
            //result.item
            //result.eventType >> (selected or unselected)
        })
        .on('selected', function(e) {
        })
        .on('unselected', function(e) {
        })
        .on('opened', function(e) {
        })
        .on('closed', function(e) {
        }).on('click',function(e){
        });
    /**
     $('#tree1').on('loaded', function (evt, data) {
		});

     $('#tree1').on('opened', function (evt, data) {
		});

     $('#tree1').on('closed', function (evt, data) {
		});

     $('#tree1').on('selected', function (evt, data) {
		});
     */
});