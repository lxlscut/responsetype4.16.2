<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>商品注册界面</title>
</head>
<body>
<h1>欢迎来到注册界面</h1>
<input type="text" required="required" placeholder="商品名" name="title" id="title"></input>
<input type="text" required="required" placeholder="商品价格" name="price" id="price"></input>
<input type="text" required="required" placeholder="商品库存" name="stock" id="stock"></input>
<input type="text" required="required" placeholder="商品描述" name="description" id="description"></input>
<input type="text" required="required" placeholder="商品描述链接" name="url" id="url"></input>
<button  type="submit" id="button">注册</button>
</body>
<script>
    jQuery(document).ready(function () {
        //    绑定向后端发送请求的获取手机验证码的请求
        $("#button").on("click",function () {
            var title = $("#title").val();
            var price = $("#price").val();
            var stock = $("#stock").val();
            var description = $("#description").val();
            var url = $("#url").val();
            if(title== null || title=="")
            {
                alert("商品名不能为空");
                return false;
            }
            if(price== null || price=="")
            {
                alert("价格不能为空");
                return false;
            }
            if(stock== null || stock=="")
            {
                alert("库存不能为空");
                return false;
            }
            if(description== null || description=="")
            {
                alert("商品描述不能为空");
                return false;
            }
            if(url== null || url=="")
            {
                alert("商品描述url不能为空");
                return false;
            }
            $.ajax({
                type:"POST",
                contentType:"application/x-www-form-urlencoded",
                url:"http://localhost:8080/item/create",
                data:{"title":$("#title").val(),
                    "price":$("#price").val(),
                    "stock":$("#stock").val(),
                    "description":$("#description").val(),
                    "url":$("#url").val()},
                xhrFields: {
                    withCredentials: true
                },
                crossDomain: true,
                success:function (data) {
                    if(data.status=="success"){
                        alert("创建商品成功");
                    }
                    else{
                        alert("创建商品失败"+data.data.errmessage);
                    }
                },
                fail:function (data) {
                    alert("创建商品请求发送失败，原因为："+data.responseText);
                }
            })
            return false;
        })
    });
</script>
</html>