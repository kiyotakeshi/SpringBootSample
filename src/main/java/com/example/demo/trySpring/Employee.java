package com.example.demo.trySpring;

import lombok.Data;

/*
検索結果を入れるクラス
リポジトリークラスやサービスクラス間で渡すクラスのことを、
Springではdomainクラスと呼ぶ
 */
@Data // Lombokの機能でgetter,setterを自動で作成
public class Employee {
    private int employeeid;
    private String employeeName;
    private int age;
}
