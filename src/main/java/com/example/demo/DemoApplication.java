package com.example.demo;

import com.example.demo.bean.Student;
import com.example.demo.config.WebSocketConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

@SpringBootApplication(scanBasePackages =
        {"com.example.demo.controller", "com.example.demo.mapper", "com.example.demo.component"})
@Import({WebSocketConfig.class})
public class DemoApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 配置逻辑视图名到(实际视图名或者访问路径的映射)
     * @return
     */
    @Bean("/index")
    public ParameterizableViewController viewController(){
        ParameterizableViewController controller = new ParameterizableViewController();
        this.logger.info(controller.toString() + ":" + "正在初始化。。。。。。");
        controller.setViewName("index.html");
        return controller;
    }


    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
}
