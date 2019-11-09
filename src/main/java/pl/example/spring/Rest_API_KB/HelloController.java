package pl.example.spring.Rest_API_KB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String GetHello() {
        String data = LocalDateTime.now().toString();
        return "hello " + data;
    }



}