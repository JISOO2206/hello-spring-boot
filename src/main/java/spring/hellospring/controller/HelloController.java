package spring.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){   //spring이 model을 만들어서 넣어줌.
        model.addAttribute("data","spring");
        // key/value 형식으로 값을 담을 수 있다.
        return "hello"; //resources/templates/hello.html로 찾아가서 렌더링하라는 의미.
        //data는 model에 넘기면서.
    }

}
