package com.itheima.springbootwebquickstart.controller;

import com.itheima.springbootwebquickstart.pojo.Student;
import com.itheima.springbootwebquickstart.pojo.UserPassword;
import com.itheima.springbootwebquickstart.service.StudentService;
import com.itheima.springbootwebquickstart.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/user/register")
    public Result create(Student student) {
        boolean flag = studentService.isExists(student.getUsername());
        if (flag) {
            return Result.error("用户名已存在");
        }
        if (student.getPassword() == null) {
            student.setPassword("123456");
            Student student1 = studentService.showGender(student);
            studentService.addStudent(student1);
            return Result.success(student1);
        } else {
            boolean flag1 = studentService.judgePassword(student.getPassword());
            if (flag1) {
                Student student1 = studentService.showGender(student);
                studentService.addStudent(student1);
                return Result.success(student1);
            } else {
                return Result.error("密码长度有误");
            }
        }
    }

    @RequestMapping("/user/login")
    public Result login(String username, String password) {
        Student student = studentService.login(username, password);
        if (student == null) {
            return Result.error("用户不存在");
        }
        if (student.getUsername().equals(username) && student.getPassword().equals("NotAGreatPassword")) {
            return Result.error("密码错误");
        } else {
            return Result.success(student);
        }
    }

    @RequestMapping("/user/list")
    public Result show() {
        List<Student> list = studentService.show();
        List<Student> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            list1.add(new Student(student.getUsername(),student.getAge(),student.getGender(),"******"));
        }
        return Result.success(list1.toString());
    }

    @RequestMapping("/user/{username}")
    public Result showByUsername(@PathVariable String username) {
        Student student = studentService.getStuByUsername(username);
        if (student == null) {
            return Result.error("无此学生");
        } else {
            return Result.success(student);
        }
    }

    @RequestMapping("/user/del")
    public Result delByUsername(String username){
        boolean flag = studentService.delByUsername(username);
        if (flag) {
            return Result.success();
        } else {
            return Result.error("删除失败");
        }
    }

    @RequestMapping("/user/updatePassword")
    public Result updatePassword(@RequestBody UserPassword userPassword) {
        Student student = studentService.updatePassword(userPassword);
        if (student == null) {
            return Result.error("用户名不存在");
        } else {
            if (student.getPassword().equals("NotAGreatPassword")) {
                return Result.error("密码不正确");
            } else if (student.getPassword().equals("ABadFormatPassword")){
                return Result.error("新密码格式有误");
            }else {
                return Result.success(student);
            }
        }
    }

    @RequestMapping("/user/updateUserByUsername")
    public Result updateUserByUsername(String username,String age,String gender) {
        Student student = studentService.updateUserByUsername(username,age,gender);
        if (student == null) {
            return Result.error("用户不存在");
        } else {
            return Result.success(student);
        }
    }

    @RequestMapping("/user/delBatch")
    public Result delBatch(@RequestParam List<String> username) {
        studentService.delBatch(username);
        return Result.success();
    }


}
