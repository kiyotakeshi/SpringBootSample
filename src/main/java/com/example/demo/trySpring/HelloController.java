package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// DIで利用できるようになる
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    // GETメソッドが呼ばれた際の処理
    @GetMapping("/hello")

    // メソッドの頭にgetをつけるのが慣習
    public String getHello(){

        // hello.htmlに画面遷移(拡張子無しのファイル名を指定)
        return "hello";
    }

    // POSTメソッドで送られた時の処理
    @PostMapping("/hello")

    // @RequestParamで画面からの入力内容を受け取れる
    // 引数にhtmlのname属性の値を指定
    public String postRequest(@RequestParam("text1")String str, Model model){

        // 画面から受け取った文字列をModelに登録
        model.addAttribute("sample", str);

        // helloResponse.htmlに画面遷移
        return "helloResponse";
    }

    /**
     * hello.html からPOSTされる値を処理
     * @param str
     * @param model
     * @return
     */
    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2")String str, Model model){

        // Stringからint型に変換
        int id = Integer.parseInt(str);

        // 1件検索
        Employee employee = helloService.findOne(id);

        // 検索結果をModelに登録(画面側で受け取る)
        model.addAttribute("id", employee.getEmployeeid());
        model.addAttribute("name", employee.getEmployeeName());
        model.addAttribute("age", employee.getAge());

        // helloResponseDB.html に画面遷移
        return "helloResponseDB";
    }
}
