<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
</head>
<body>
欢迎
<table border="1">
    <tr>
        <td>商品名</td>
        <td>商品价格</td>
        <td>商品描述</td>
        <td>商品销量</td>
        <td>商品库存</td>
        <td>商品图片</td>
    </tr>
<#--    <#list li  as u>-->
        <tr>
            <td> ${DT.title}</td>
            <td> ${DT.price}</td>
            <td> ${DT.stock}</td>
            <td> ${DT.description}</td>
            <td> ${DT.sale}</td>
            <td><img src=" ${DT.url}"></td>
        </tr>
<#--    </#list>-->
</table>
</body>
</html>