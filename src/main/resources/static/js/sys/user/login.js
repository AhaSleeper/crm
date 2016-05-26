/**
 * Created by Administrator on 2016/4/19.
 */
$(function(){
    $("#btnLogin").on("click",function(){
        console.log("login")
       if(!validate()) return;
        var data=$("#userForm").serialize();
        $.ajax({
            url:"/doLogin",
            type:"POST",
            data:data,
            success:function(data){
                if(data.success){
                    window.location.href="/loadUserMenu";
                } else alert(data.msg);
            }
        })
    })
})
function validate(){
    var userName = $("#userName").val();
    var password = $("#password").val();
    if(userName==''){
        alert("用户名不能为空！");
        return false;
    }
    if(password==''){
        alert("密码不能为空!");
        return false;
    }
    return true;
}