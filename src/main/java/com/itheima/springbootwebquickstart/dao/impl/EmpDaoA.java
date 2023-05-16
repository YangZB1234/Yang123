package com.itheima.springbootwebquickstart.dao.impl;

import com.itheima.springbootwebquickstart.dao.EmpDao;
import com.itheima.springbootwebquickstart.pojo.Emp;
import com.itheima.springbootwebquickstart.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> list() {
        //获取XML数据
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        return XmlParserUtils.parse(file, Emp.class);
    }
}
