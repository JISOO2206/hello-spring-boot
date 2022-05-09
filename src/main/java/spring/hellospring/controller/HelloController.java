package spring.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){   //spring이 model을 만들어서 넣어줌.
        model.addAttribute("data","spring");
        // key/value 형식으로 값을 담을 수 있다.
        return "hello"; //resources/templates/hello.html로 찾아가서 렌더링하라는 의미.
        //data는 model에 넘기면서.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-String")
    @ResponseBody   //이 의미는 http에서 body부에 data(return)에 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
        // name에 String을 넣는다면 'hello String'이 된다.
    }
    //이 방법을 사용하면 이전과의 차이점은 view(html)가 없고 데이터가 그대로 내려간다.

    @GetMapping("hello-api")
    @ResponseBody   // 이 어노테이션이 있으면, http 응답에 이 데이터를 그대로 넘겨야 한다는 식으로 동작한다.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();  // 객체가 있으면 json 방식을 만들어 반환하는 게 기본 정책이다.
        hello.setName(name);
        return hello; // hello 객체를 넘김
    }
    // 위는 key, value로 이루어진 구조다. json 방식임.


    static class Hello{

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    // java Bean 규약
    // getter/setter를 이용하여 변수에 접근하는 방식으로 property 접근 방식이라고 함.


}
