package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 検索結果をEmployeeクラスに入れて返す
 */
@Service
public class HelloService {

    @Autowired // HelloRepositoryクラスを使う
    private HelloRepository helloRepository;

    public Employee findOne(int id){

        // 1件検索
        // HelloRepositoryクラスでの検索結果はMapに入っている
        Map<String, Object> map = helloRepository.findOne(id);

        // フィールド名を指定して値を取得
        int employeeId = (Integer)map.get("employee_id");
        String employeeName = (String)map.get("employee_name");
        int age = (Integer)map.get("age");

        // Employeeクラスに値をセット
        Employee employee = new Employee();
        employee.setEmployeeid(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setAge(age);

        return employee;
    }
}
