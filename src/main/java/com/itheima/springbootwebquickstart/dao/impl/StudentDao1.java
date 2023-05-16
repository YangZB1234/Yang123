package com.itheima.springbootwebquickstart.dao.impl;

import com.itheima.springbootwebquickstart.dao.StudentDao;
import com.itheima.springbootwebquickstart.pojo.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDao1 implements StudentDao {
    static List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return list;
    }

    @Override
    public boolean delByUsername(String username) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                list.remove(i);
                i--;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void updatePassword(Student student1) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(student1.getUsername())) {
                index = i;
            }
        }
        list.set(index,student1);
    }

    @Override
    public Student updateUserByUsername(String username, String age, String gender, int index) {
        Student student = new Student(username,age,gender,list.get(index).getPassword());
        list.set(index,student);
        return student;
    }

    @Override
    public void delBatch(List<Integer> index) {
        for (int i = 0; i < index.size(); i++) {
            list.remove(index.get(i).intValue());
        }
    }
}
