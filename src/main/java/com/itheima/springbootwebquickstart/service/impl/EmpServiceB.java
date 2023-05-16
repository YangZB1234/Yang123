package com.itheima.springbootwebquickstart.service.impl;

import com.itheima.springbootwebquickstart.dao.EmpDao;
import com.itheima.springbootwebquickstart.pojo.Emp;
import com.itheima.springbootwebquickstart.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceB implements EmpService {
    @Autowired
    private EmpDao empDao;
    //数据转换
    @Override
     public List<Emp> change() {
         List<Emp> empList = empDao.list();
         empList.forEach(emp -> {
             String gender = emp.getGender();
             if (gender.equals("1")) {
                 emp.setGender("男士");
             } else if (gender.equals("2")) {
                 emp.setGender("女士");
             } else {
                 emp.setGender("未知");
             }

             String job = emp.getJob();
             if (job.equals("1")) {
                 emp.setJob("老师");
             } else if (job.equals("2")){
                 emp.setJob("班主任");
             } else if (job.equals("3")) {
                 emp.setJob("就业指导");
             }
         });
         return empList;
     }

}
