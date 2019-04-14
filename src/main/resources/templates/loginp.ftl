<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>这是登陆界面</title>
</head>
<body>
<h1>获取验证码</h1>
        <input type="text" required="required" placeholder="用户名" name="u" id="u"></input>

        <button  type="submit" id="button">登录</button>
</body>
<script>
    jQuery(document).ready(function () {
        //    绑定向后端发送请求的获取手机验证码的请求
        $("#button").on("click",function () {
            var u = $("#u").val();
            if(u== null || u=="")
            {
                alert("用户名不能为空");
                return false;
            }
            $.ajax({
                type:"POST",
                contentType:"application/x-www-form-urlencoded",
                url:"http://localhost:8080/get/sign",
                data:{"u":$("#u").val()},
                success:function (data) {
                    if(data.status=="success"){
                        alert("短信发送成功");
                         // window.location.href="E:\\code\\responsetype\\src\\main\\resources\\templates\\regis.html";
                        window.location.href="http://localhost:8080/login/mmm";
                    }
                    else{
                        alert("短信发送失败"+data.data.errmessage);
                    }
                },
                fail:function (data) {
                    alert("otp发送失败，原因为："+data.responseText);
                }
            })
            return false;
        })
    });
</script>
</html>