package demo.springboot.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-boot rest服务
 * 
 * @author macma 2016年9月23日 下午1:38:44
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloService {

    @RequestMapping("/hi")
    public String hi(@RequestParam MultiValueMap<String, String> params) {
        System.out.println(params);
        return "hi:" + params.getFirst("name");
    }

    ///////
    public static void main(String[] args) {
        SpringApplication.run(HelloService.class, args);
    }

}
