<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>这是登陆界面</title>
</head>
<body>
<h1>欢迎来到登陆界面</h1>
        <input type="text" required="required" placeholder="用户名" name="u" id="u"></input>
        <input type="password" required="required" placeholder="密码" name="p" id="p"></input>
        <button  type="submit" id="button">登录</button>
</body>
<script>
    jQuery(document).ready(function () {
        //    绑定向后端发送请求的获取手机验证码的请求
        $("#button").on("click",function () {
            var u = $("#u").val();
            var p = $("#p").val();
            if(u== null || u=="")
            {
                alert("用户名不能为空");
                return false;
            }
            if(p== null || p=="")
            {
                alert("密码名不能为空");
                return false;
            }

            $.ajax({
                type:"POST",
                contentType:"application/x-www-form-urlencoded",
                url:"http://localhost:8080/loginPage",
                data:{"u":$("#u").val(),"p":$("#p").val()},
                success:function (data) {
                    if(data.status=="success"){
                        alert("登陆成功");
                    }
                    else{
                        alert("登陆失败"+data.data.errmessage);
                    }
                },
                fail:function (data) {
                    alert("消息发送失败："+data.responseText);
                }
            })
            return false;
        })
    });
</script>



</html>