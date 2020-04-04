<!DOCTYPE html>
<html lang="zh">
<head>
    <title>展示所有商品</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>List of Goods Order By Sales volume</h2>

<table>
    <tr>
        <th>排名</th>
        <th>商品名</th>
        <th>成交金额</th>
    </tr>

    <#list sortedGoods as goods>
        <tr>
            <td>${goods_index+1}</td>
            <td>${goods.name}</td>
            <td>${goods.amount}</td>
        </tr>
    </#list>
</table>

</body>
</html>