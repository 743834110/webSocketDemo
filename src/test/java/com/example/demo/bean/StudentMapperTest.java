package com.example.demo.bean;

import com.example.demo.DemoApplication;
import com.example.demo.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testQuery(){
        Student student = this.studentMapper.queryStudentById(5);
        System.out.println(student);
    }
}
