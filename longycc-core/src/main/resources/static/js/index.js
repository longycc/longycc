//默认访问地址
var url = "http://localhost:8080/"
//邮件正则表达式
var email_regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
//密码正则表达式
var password_regexp = "^[\\w.]{6,18}$";


//登录注册滑动属性
$("#signUp").click(function (){
    $("#dowebok").addClass("right-panel-active")
})
$("#signIn").click(function (){
    $("#dowebok").removeClass("right-panel-active")
})
//注册
function signup(){
    var username = $("#username").val();
    var email = $("#signUn_email").val();
    var password = $("#signUn_password").val();
    if(!verify(email,"email")){
        return ;
    };
    if(!verify(!password,"password")){
        return ;
    };
    $.ajax({
        url: url+"signup",
        type: "GET",
        headers: {
            "username": username,
            "email": email,
            "password": password
        },
        data: {},
        success: function (data){
            if (data == 1){
                alert("注册成功，请登录吧（O_O)!")
                $("#dowebok").removeClass("right-panel-active")
            }else {
                alert("注册失败，QAQ ")

            }
        },
        error: function (error){
            alert("注册失败，请重试！")
        }
    })
}
//登录
function signIn(){
    var email = $("#signIn_email").val();
    var password = $("#signIn_password").val();
    if(!verify(email,"signIn_email")){
        return ;
    };
    if(!verify(password,"signIn_password")){
        return ;
    };
    $.ajax({
        url: url+"signin",
        type: "GET",
        headers: {
            "email": email,
            "password": password
        },
        data: {},
        success: function (data){
            if(data==1){
                window.location="portal"
            }else {
                alert("邮件或密码错误! ")
            }

        },
        error: function (error){
            alert("登录失败，请检查账户密码！")
        }
    })
}
//校验
function verify(value,type){
    if(!type.indexOf("email")<0){
        if (value==""){
            tooltip(type,"请输入邮箱！QAQ");
            return false;
        };
        if (value.indexOf("@")<0){
            return false;
        };
        if(!value.match(email_regexp)){
            tooltip(type,"邮箱格式不正确!");
            return false;
        };
        return true;
    }else {
        if (value==""){
            tooltip(type,"请输入密码！QAQ");
            return false;
        };
        if (!value.match(password_regexp)){
            tooltip(type,"密码格式不正确！")
            return false;
        }
        return true;
    }
}
function tooltip(type,data){
    type = type+"_tooltip";
    var temp = $("#"+type);
    temp.text(data);
    setTimeout(function (){
        temp.text("");
    },3000);
}