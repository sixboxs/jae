package test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author DELL
 */
@Controller
@SpringBootApplication
@MapperScan("test")
@ServletComponentScan
public class App {

    @RequestMapping("/")
    @ResponseBody
    String home(HttpServletRequest request){
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}

