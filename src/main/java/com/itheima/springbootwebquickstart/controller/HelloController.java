package com.itheima.springbootwebquickstart.controller;

import com.itheima.springbootwebquickstart.pojo.User;
import com.itheima.springbootwebquickstart.utils.Result;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return "hello world";
    }

    @RequestMapping("/simpleParam1")
    public String simpleParam(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        int ageInt = Integer.parseInt(age);
        System.out.println(name + "->" + ageInt);
        return "ok";
    }

    @RequestMapping("/simpleParam2")
    public String simpleParam2(String name,String age) {
        int ageInt = Integer.parseInt(age);
        System.out.println(name + "==" + ageInt);
        return "ok";
    }

    @RequestMapping("/Pojo1")
    public String pojo1(User user) {
        System.out.println(user);
        return "okk";
    }

    @RequestMapping("/Pojo2")
    public Result pojo2(User user) {
        System.out.println(user);
        return Result.success(user);
    }

    @RequestMapping("/arrParam")
    public String arrParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "ok";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@RequestParam (name = "updatetime")@DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime time) {
        System.out.println(time);
        return "ok";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User a) {
        System.out.println(a);
        return "ok";
    }

    @RequestMapping("/path/{name}/{age}")
    public String pathParam(@PathVariable String name, @PathVariable String age) {
        System.out.println(name);
        System.out.println(age);
        return "ok";
    }
}
