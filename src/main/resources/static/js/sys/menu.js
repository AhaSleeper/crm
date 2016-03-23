/**
 * Created by snow on 2016/3/14.
 */
var DataSourceTree = function (options) {
    this.url = options.url;
}
//var treeDataSource = new DataSourceTree({data: tree_data});
var ace_icon = ace.vars['icon'];

var data = {"data":[{"name":"客户管理","type":"folder","additionalParameters":{"children":[{"name":"客户信息管理","type":"item","additionalParameters":{"children":[],"id":"2","itemSelected":false}}],"id":"1","itemSelected":false}}]}
jQuery(function($){
    var DataSourceTree = function (options) {
        this.url = options.url;
    }

    DataSourceTree.prototype.data = function (options, callback) {
        var self = this;
        var $data = null;

        var param = null

        if (!("name" in options) && !("type" in options)) {
            param = 0;//load the first level
        }
        else if ("type" in options && options.type == "folder") {
            if ("additionalParameters" in options  && "children" in options.additionalParameters) {
                param = options.additionalParameters["id"];
            }
        }

        if (param != null) {
            $.ajax({
                url: this.url,
                data: 'pid=' + param,
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    alert(data);
                    callback({ data: data })
                },
                error: function (response) {
                    console.log(response);
                }
            })
        }
    };
    var dataSource = new DataSourceTree({url:"/menu/tree"});
    var TreeData = function(options, callback) {
        var self = this;
        var param = null
        console.log(options.type);
        if ("type" in options && options.type == "folder") {
            if ("dataAttributes" in options && "children" in options.dataAttributes) {
                param = options.dataAttributes["id"];
            }
        }

        if (param != null) {
            $.ajax({
                url: this.options.url,
                data: 'id=' + param,
                type: 'POST',
                dataType: 'json',
                success: function (response) {
                    callback(response)
                },
                error: function (response) {
                    console.log(response);
                }
            })
        }
    setTimeout(function () {
        callback({ data: [
            { name: 'Ascending and Descending', type: 'folder', dataAttributes: { id: 'folder1' } },
            { name: 'Sky and Water I (with custom icon)', type: 'item', dataAttributes: { id: 'item1', 'data-icon': 'glyphicon glyphicon-file' } },
            { name: 'Drawing Hands', type: 'folder', dataAttributes: { id: 'folder2' } },
            { name: 'Waterfall', type: 'item', dataAttributes: { id: 'item2' } },
            { name: 'Belvedere', type: 'folder', dataAttributes: { id: 'folder3' } },
            { name: 'Relativity (with custom icon)', type: 'item', dataAttributes: { id: 'item3', 'data-icon': 'glyphicon glyphicon-picture' } },
            { name: 'House of Stairs', type: 'folder', dataAttributes: { id: 'folder4' } },
            { name: 'Convex and Concave', type: 'item', dataAttributes: { id: 'item4' } }
        ]});

    }, 400);
}
    function dynamicDataSource(openedParentData, callback) {
        var childNodesArray = [];

        // call API, posting options
        $.ajax({
            'type': 'post',
            'url': '/menu/tree',
            'data': openedParentData  // first call with be an empty object
        })
            .done(function(data) {
                // configure datasource
                var childObjectsArray = data;

                // pass an array with the key 'data' back to the tree
                // [ {'name': [string], 'type': [string], 'attr': [object] } ]
                callback({
                    data: childNodesArray
                });

            });
    }
    $('#tree1').ace_tree({
        dataSource: new dynamicDataSource(null,callback) ,
        multiSelect:false,
        loadingHTML:'<div class="tree-loading"></div>',
        'open-icon' : 'ace-icon tree-minus',
        'close-icon' : 'ace-icon tree-plus',
        'selectable' : false,
        'selected-icon' : 'ace-icon fa fa-check',
        'unselected-icon' : 'ace-icon fa fa-times'
    });

    $('#tree2').ace_tree({
        dataSource: null ,
        loadingHTML:'<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
        'open-icon' : 'ace-icon fa fa-folder-open',
        'close-icon' : 'ace-icon fa fa-folder',
        'selectable' : false,
        'selected-icon' : null,
        'unselected-icon' : null
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
            alert("click");
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