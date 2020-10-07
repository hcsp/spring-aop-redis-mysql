<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>排名</th>
        <th>商品名</th>
        <th>成交金额</th>
    </tr>
    </thead>
    <tbody>
    <#list rankItems as rankItem>
        <tr>
            <td>${rankItem?index+1}</td>
            <td>${rankItem.goods.name}</td>
            <td>${rankItem.earnings}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>