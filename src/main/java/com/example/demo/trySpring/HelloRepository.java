package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
DBへのCRUD操作を行う
 */
@Repository // リポジトリクラスをDIに登録
public class HelloRepository {

    // JdbcTemplate(Springが用意するJDBC接続用のクラス)
    // @Autowired をつけることでインスタンスを取得する
    // イメージ的には private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object>findOne(int id){

        // SELECT文(文字列結合されるため、スペースを開ける
        String query = "SELECT "
                + "employee_id,"
                + "employee_name,"
                + "age "
                + "FROM employee "
                + "WHERE employee_id=?";

        // 検索を実行
        Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
        
        return employee;
    }
}
