package com.itheima.springbootwebquickstart.service;

import com.itheima.springbootwebquickstart.pojo.Student;
import com.itheima.springbootwebquickstart.pojo.UserPassword;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    Student showGender(Student student);

    boolean isExists(String username);

    boolean judgePassword(String password);

    Student login(String username, String password);

    List<Student> show();

    Student getStuByUsername(String username);

    boolean delByUsername(String username);

    Student updatePassword(UserPassword userPassword);

    Student updateUserByUsername(String username, String age, String gender);

    void delBatch(List<String> username);
}
