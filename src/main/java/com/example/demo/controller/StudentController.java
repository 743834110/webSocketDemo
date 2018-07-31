package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    public String index(){


        this.logger.info("dfdffd");
        return "";
    }
}
