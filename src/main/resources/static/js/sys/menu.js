/**
 * Created by snow on 2016/3/14.
 */
var ace_icon = ace.vars['icon'];

jQuery(function($){
    var remoteUrl = '/menu/tree';

    var remoteDateSource = function(options, callback) {
        var parent_id = null;
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
    $('#menuTree').ace_tree({
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
    $('#menuTree')
        .on('updated', function(e, result) {
            //result.info  >> an array containing selected items
            //result.item
            //result.eventType >> (selected or unselected)
        })
        .on('selected', function(e) {
            console.log("tree selected");
        })
        .on('unselected', function(e) {
        })
        .on('opened', function(e) {
        })
        .on('closed', function(e) {
        }).on('click',function(e){

        }).on('selected.fu.tree',function(event,data){
            var node = data.selected[0];
            console.log("selected.fu.tree data.text="+node.text+",node.type="+node.type+",node.additionalParameters=["+"pid="+node.additionalParameters.pid
            +",id="+node.additionalParameters.id+",icon="+node.additionalParameters.icon+",url="+node.additionalParameters.url+"]");
        });
    /**
     $('#menuTree').on('loaded', function (evt, data) {
		});

     $('#menuTree').on('opened', function (evt, data) {
		});

     $('#menuTree').on('closed', function (evt, data) {
		});

     $('#menuTree').on('selected', function (evt, data) {
		});
     */
});