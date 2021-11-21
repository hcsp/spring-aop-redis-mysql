<!DOCTYPE html>
<html>
<head>
    <title>
        排行榜
    </title>
</head>
<body>
<table>
    <tr>
        <th>排名</th>
        <th>商品</th>
        <th>成交金额</th>
    </tr>
    <#list ranks as item>
        <tr>
            <td>${item?index+1}</td>
            <td>${item.goods.name}</td>
            <td>${item.price}</td>
        </tr>
    </#list>
</table>
</body>