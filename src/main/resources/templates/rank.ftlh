 <!doctype html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <meta name="viewport"
           content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
     <meta http-equiv="X-UA-Compatible" content="ie=edge">
     <title>Document</title>
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
 <table id="rank">
     <tr>
         <th>排名</th>
         <th>商品名</th>
         <th>成交金额</th>
     </tr>
     <#list items as x>
        <tr>
            <td>${x?index+1}</td>
            <td>${x.name}</td>
            <td>${x.price}</td>
        </tr>
     </#list>
 </table>
 </body>
 </html>