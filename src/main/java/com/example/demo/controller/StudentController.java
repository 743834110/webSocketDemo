package com.example.demo.controller;


import com.example.demo.bean.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping({"/"})
    public String index(Model model){
        Student student = new Student(1, "张三", 15, "eeee");
        model.addAttribute("student", student);
        this.logger.info(student.toString());

        return "index";
    }



}
