package com.itheima.springbootwebquickstart.service.impl;

import com.itheima.springbootwebquickstart.dao.StudentDao;
import com.itheima.springbootwebquickstart.pojo.Student;
import com.itheima.springbootwebquickstart.pojo.UserPassword;
import com.itheima.springbootwebquickstart.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentService1 implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public Student showGender(Student student) {
        if (student.getGender() == null) {
            student.setGender("未知");
        } else {
            if (student.getGender().equals("1")) {
                student.setGender("男");
            } else if (student.getGender().equals("2")) {
                student.setGender("女");
            } else {
                student.setGender("未知");
            }
        }

        return student;
    }

    @Override
    public boolean isExists(String username) {
        boolean flag = false;
        List<Student> list = studentDao.findAllStudents();
        for (Student student : list) {
            if (username.equals(student.getUsername())) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean judgePassword(String password) {
        boolean flag = false;
        int length = password.length();
        if (length <= 16 && length >= 6) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Student login(String username, String password) {
        List<Student> students = studentDao.findAllStudents();
        for (Student student : students) {
            if (username.equals(student.getUsername())) {
                if (password.equals(student.getPassword())) {
                    return student;
                } else {
                    return new Student(username, null, null, "NotAGreatPassword");
                }
            }
        }
        return null;
    }

    @Override
    public List<Student> show() {
        return studentDao.findAllStudents();
    }

    @Override
    public Student getStuByUsername(String username) {
        List<Student> list = studentDao.findAllStudents();
        for (Student student : list) {
            if (student.getUsername().equals(username)) {
                return new Student(student.getUsername(),student.getAge(),student.getGender(),"******");
            }
        }
        return null;
    }

    @Override
    public boolean delByUsername(String username) {
        return studentDao.delByUsername(username);
    }

    @Override
    public Student updatePassword(UserPassword userPassword) {
        List<Student> students = studentDao.findAllStudents();
        for (Student student : students) {
            if (student.getUsername().equals(userPassword.getUsername())) {
                if (student.getPassword().equals(userPassword.getPassword())) {
                    boolean flag = judgePassword(userPassword.getNewPassword());
                    if (flag) {
                        Student student1 = new Student(student.getUsername(),student.getAge(),student.getGender(),userPassword.getNewPassword());
                        studentDao.updatePassword(student1);
                        return student1;
                    } else {
                        return new Student(student.getUsername(),student.getAge(),student.getGender(),"ABadFormatPassword");
                    }
                } else {
                    return new Student(student.getUsername(),null,null,"NotAGreatPassword");
                }
            }
        }
        return null;
    }

    @Override
    public Student updateUserByUsername(String username, String age, String gender) {
        List<Student> students = studentDao.findAllStudents();
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUsername().equals(username)) {
                index = i;
            }
        }
        if (index != -1) {
            Student student = studentDao.updateUserByUsername(username,age,gender,index);
            return student;
        } else {
            return null;
        }
    }

    @Override
    public void delBatch(List<String> username) {
        List<Integer> index = new ArrayList<>();
        List<Student> students = studentDao.findAllStudents();
        for (int i = 0; i < username.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).getUsername().equals(username.get(i))) {
                    index.add(j);
                }
            }
        }
        studentDao.delBatch(index);
    }
}
