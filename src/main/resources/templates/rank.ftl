<!DOCTYPE html>
<html>
<head>
    <title>商品排行榜</title>
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
</head>
<body>

<h2>商品排行榜</h2>

<table>
    <thead>
    <tr>
        <th>排名</th>
        <th>商品名</th>
        <th>成交金额</th>
    </tr>
    </thead>
    <tbody>
    <#list rankedGoodsList as rankItem>
        <tr>
            <td>${rankItem.rankNumber}</td>
            <td>${rankItem.name}</td>
            <td>${rankItem.allPrice}</td>
        </tr>
    </#list>
    </tbody>
</table>

</body>
</html>