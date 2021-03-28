package com.github.hcsp.dao;

import com.github.hcsp.entities.RankItem;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RankOrderDao {
    String sqlStatement = "select goods_name, sum(sum_price) as total_price\n" +
            "from (select g.name as goods_name, goods_id, price * quantity as sum_price\n" +
            "      from `order`\n" +
            "               inner join goods g on `order`.goods_id = g.id\n" +
            "               inner join user u on `order`.user_id = u.id) t\n" +
            "group by goods_id\n" +
            "order by total_price desc;";
    private final List<RankItem> result = new LinkedList<>();

    public List<RankItem> doRankOrder() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String password = "123456";
            String userName = "root";
            String url = "jdbc:mysql://localhost:3306/mall?characterEncoding=utf-8";
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sqlStatement);
            while (resultSet.next()) {
                RankItem rankItem = new RankItem(resultSet.getString(1), resultSet.getInt(2));
                result.add(rankItem);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
