/**
 * Created by snow on 2016/3/14.
 */
var ace_icon = ace.vars['icon'];
//树节点信息
var pid;
var id;
var name;
var pName;
var url;
var type;
var menuType;
var menuTypeStr;
var icon;
var seq;

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
//初始化树
function initTree(){
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
    $('#menuTree').on('selected.fu.tree',function(event,data){
        var node = data.selected[0];
        //节点信息
        id=node.additionalParameters.id;
        pid=node.additionalParameters.pid;
        name=node.text;
        pName=node.additionalParameters.pName;
        url=node.additionalParameters.url;
        type = node.type;
        menuType = node.additionalParameters.menuType;
        menuTypeStr=node.additionalParameters.menuTypeStr;
        icon=node.additionalParameters.icon;
        seq=node.additionalParameters.seq;

        //显示操作按钮
        $("#btnAddMenu").css("display","");
        $("#btnEditMenu").css("display","");
        $("#btnDeleteMenu").css("display","");

        //隐藏菜单编辑域
        $("#editPanel").css("display","none");
        //给菜单显示域赋值
        $("#infoPName").val(pName);
        $("#infoMenuName").val(name);
        $("#infoIcon").val(icon);
        $("#infoMenuUrl").val(url);
        $("#infoMenuType").val(menuTypeStr);
        $("#infoSeq").val(seq);
        //显示菜单信息域
        $("#infoPanel").css("display","block");
    });
}

//初始化页面
function initPage(){
    $("#infoPanel").css("display","none");
    $("#editPanel").css("display","none");
    $("#btnAddMenu").css("display","none");
    $("#btnEditMenu").css("display","none");
    $("#btnDeleteMenu").css("display","none");
}

jQuery(function($){
        initTree();
        $("#menuTree").tree("discloseAll");
        //添加新菜单
        $("#btnAddMenu").on("click",function(){
            $("#menuForm")[0].reset();//重置表单值
            $("#pid").val(id);
            $("#pName").val(name);
            //隐藏菜单信息域、显示菜单编辑域
            $("#infoPanel").css("display","none");
            $("#editPanel").css("display","");
        });
    //编辑菜单
        $("#btnEditMenu").on("click",function(){
            $("#menuForm")[0].reset();
            $("#id").val(id);
            $("#pid").val(pid);
            $("#pName").val(pName);
            $("#menuName").val(name);
            $("#menuUrl").val(url);
            $("#menuType").val(menuType);
            $("#menuIcon").val(icon);
            $("#seq").val(seq);
            //隐藏菜单信息域、显示菜单编辑域
            $("#infoPanel").css("display","none");
            $("#editPanel").css("display","");
        });
    //删除菜单
        $("#btnDeleteMenu").on("click",function(){
            if(!confirm("确定删除该菜单?")) return;
            if(type=='folder'){
                alert("该节点存在子节点，不能删除!");
                return;
            }
            $.ajax({
                url:"/menu/delete",
                type:"POST",
                data:{id:id},
                dataType:"json",
                success:function(data){
                    if(data.success){
                        alert(data.msg);
                        $("#menuTree").tree("destroy");
                        $("#menuTreeDiv").append("<ul id='menuTree'></ul>");
                        initTree();
                        setTimeout(function(){
                            $("#menuTree").tree("discloseAll");
                        },3000);
                        initPage();
                    } else alert(data.msg);
                }
            })
        });
        //保存菜单
        $("#btnSave").on("click", function () {
            if(!validateForm()) return;
            var data = $("#menuForm").serialize();
            $.ajax({
                url: "/menu/save",
                type: "POST",
                data: data,
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        alert(data.msg);
                        $("#menuTree").tree("destroy");
                        $("#menuTreeDiv").append("<ul id='menuTree'></ul>");
                        initTree();
                        setTimeout(function(){
                            $("#menuTree").tree("discloseAll");
                        },3000);
                        initPage();
                    }
                }
            })
        })
});
//验证表单数据是否合法
function validateForm(){
    var name = $("#menuName").val();
    var url = $("#menuUrl").val();
    var seq = $("#seq").val();
    if(name==''){
        alert("菜单名称不能为空!");
        return false;
    }
    if(url==''){
        alert("url不能为空!");
        return false;
    }
    if(isNaN(seq)){
        alert("排序码必须为数字!");
        return false;
    }
    return true;
}


/*
$("#btnSave").on("click",function(){
    var data = $("#menuForm").serialize();
    $.ajax({
        url:"/menu/save",
        type:"POST",
        data:data,
        dataType:"json",
        success:function(data){
            if(data.success){
                bootbox.dialog({
                    message:data.msg
                })
            }
        }
    })
})*/
