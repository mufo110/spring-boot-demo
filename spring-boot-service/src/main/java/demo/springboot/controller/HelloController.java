package demo.springboot.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.service.HelloService;

/**
 * spring-boot rest服务
 * 
 * @author macma 2016年9月23日 下午1:38:44
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@ComponentScan(basePackages = { "demo.springboot" })
@MapperScan("demo.springboot")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam MultiValueMap<String, String> params) {
        System.out.println(params);
        List l = helloService.getAllUserInfo();
        System.out.println("users:" + l.size());
        return "hi:" + params.getFirst("name");
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }

}
