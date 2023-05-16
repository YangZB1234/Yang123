package com.itheima.springbootwebquickstart.controller;

import com.itheima.springbootwebquickstart.pojo.Emp;
import com.itheima.springbootwebquickstart.service.EmpService;
import com.itheima.springbootwebquickstart.service.impl.EmpServiceA;
import com.itheima.springbootwebquickstart.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpCotroller {
    @Autowired
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result listEmp(){
        //返回数据
        List<Emp> empList = empService.change();
        return Result.success(empList);
    }
}
