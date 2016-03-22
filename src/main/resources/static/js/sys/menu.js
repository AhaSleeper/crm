/**
 * Created by snow on 2016/3/14.
 */
/*var DataSourceTree = function(options) {
    this._data 	= options.data;
    this._delay = options.delay;
}

DataSourceTree.prototype.data = function(options, callback) {
    var self = this;
    var $data = null;

    if(!("name" in options) && !("type" in options)){
        $data = this._data;//the root tree
        callback({ data: $data });
        return;
    }
    else if("type" in options && options.type == "folder") {
        if("additionalParameters" in options && "children" in options.additionalParameters)
            $data = options.additionalParameters.children;
        else $data = {}//no data
    }

    if($data != null)//this setTimeout is only for mimicking some random delay
        setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);

    //we have used static data here
    //but you can retrieve your data dynamically from a server using ajax call
    //checkout examples/treeview.html and examples/treeview.js for more info
};

var tree_data = {
    '客户管理' : {name: '客户管理', type: 'folder'}	,
    '营销管理' : {name: '营销管理', type: 'folder'}	,
    '服务管理' : {name: '服务管理', type: 'folder'}	,
    '统计报表管理' : {name: '统计报表管理', type: 'folder'},
    '基础数据管理' : {name: '基础数据管理', type: 'folder'}	,
    '系统管理' : {name: '系统管理', type: 'folder'}
}
tree_data['客户管理']['additionalParameters'] = {
    'children' : {
        '客户信息管理' : {name: '客户信息管理', type: 'item'},
        '客户流失管理' : {name: '客户流失管理', type: 'item'}
    }
}
tree_data['营销管理']['additionalParameters'] = {
    'children' : {
        '销售机会管理' : {name: '销售机会管理', type: 'item'},
        '客户开发计划' : {name: '客户开发计划', type: 'item'}
    }
}

tree_data['服务管理']['additionalParameters'] = {
    'children' : {
        '服务创建' : {name: '服务创建', type: 'item'},
        '服务分配' : {name: '服务分配', type: 'item'},
        '服务处理' : {name: '服务处理', type: 'item'},
        '服务反馈' : {name: '服务反馈', type: 'item'},
        '服务归档' : {name: '服务归档', type: 'item'}
    }
}
tree_data['统计报表管理']['additionalParameters'] = {
    'children' : {
        '客户贡献分析' : {name: '客户贡献分析', type: 'item'},
        '客户构成分析' : {name: '客户构成分析', type: 'item'},
        '客户流失分析' : {name: '客户流失分析', type: 'item'},
        '客户服务分析' : {name: '客户服务分析', type: 'item'}
    }
}
tree_data['基础数据管理']['additionalParameters'] = {
    'children' : {
        '数据字典管理' : {name: '数据字典管理', type: 'item'}
    }
}
tree_data['系统管理']['additionalParameters'] = {
    'children' : {
        '用户管理' : {name: '用户管理', type: 'item'},
        '菜单管理' : {name: '菜单管理', type: 'item'},
        '角色管理' : {name: '角色管理', type:'item'}
    }
}*/
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
    $('#tree1').ace_tree({
        dataSource: dataSource ,
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
            alert("selected");
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