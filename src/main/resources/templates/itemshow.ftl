<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>商品浏览主页面</title>
</head>
<body>
<h1>欢迎来到注册界面</h1>
<table class="table-view">
    <thead>
    <tr>
        <th>商品名</th>
        <th>商品图片</th>
        <th>商品描述</th>
        <th>商品价格</th>
        <th>商品销量</th>
        <th>商品库存</th>
    </tr>
    </thead>
    <tbody id="container">
    </tbody>
</table>
</body>
<script>
    //定义全局数组信息
    var listitem = []
    jQuery(document).ready(function () {
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/item/queryall",
                xhrFields: {
                    withCredentials: true
                },
                crossDomain: true,
                success:function (data) {
                    if(data.status=="success"){
                     //   alert("获取商品请求成功");
                        listitem = data.data;
                        reloaddom();
                    }
                    else{
                        alert("获取商品请求失败"+data.data.errmsg);
                    }
                },
                fail:function (data) {
                    alert("获取商品请求失败，原因为："+data.responseText);
                }
        });
    });
function reloaddom() {
    for(var i=1;i<listitem.length;i++){
        itemvo = listitem[i];
        var dom = "<tr data-id ='"+itemvo.id+"'id='itemdetail"+itemvo.id +"'><td>"+itemvo.title+"</td><td><img src='"+itemvo.url +"'/></td><td>"+itemvo.description+"</td><td>"+itemvo.price+"</td><td>"+ itemvo.sale+"</td><td>"+itemvo.stock+"</td></tr>"
        $("#container").append($(dom));
        $("#itemdetail"+itemvo.id).on("click",function (e) {
            window.location.href="http://localhost:8080/item/getitem1?id="+$(this).data("id");
        });
    }
}
</script>
</html>