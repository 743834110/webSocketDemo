package com.example.demo.mapper;

import com.example.demo.bean.Pager;
import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentMapper {

    Student getStudentById(Integer id);


    List<Student> listStudentByPager(Pager<Student> pager);

}
