<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>排行榜</title>
</head>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>
<body>
<h1>排行榜</h1>
<div>

</div>
<table>
    <thead>
    <tr>
        <td>排名</td>
        <td>商品名</td>
        <td>成交金额</td>
    </tr>
    </thead>
    <tbody>
        <#list goodsList as item>
            <tr>
                <td>${item?index + 1}</td>
                <td>${item.name}</td>
                <td>${item.price}</td>
            </tr>
        </#list>
    </tbody>
</table>
</body>
</html>