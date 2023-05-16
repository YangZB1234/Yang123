package com.itheima.springbootwebquickstart.dao;

import com.itheima.springbootwebquickstart.pojo.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    List<Student> findAllStudents();

    boolean delByUsername(String username);

    void updatePassword(Student student1);

    Student updateUserByUsername(String username, String age, String gender, int index);

    void delBatch(List<Integer> index);
}
