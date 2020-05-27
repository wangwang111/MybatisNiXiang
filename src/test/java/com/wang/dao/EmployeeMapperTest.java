package com.wang.dao;

import com.wang.bean.Employee;
import com.wang.bean.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class EmployeeMapperTest {

  @Autowired
  private EmployeeMapper employeeMapper;

  public void selectExample() {
    // (.. and ..) or (..)
    EmployeeExample employeeExample = new EmployeeExample();
    EmployeeExample.Criteria criteria = employeeExample.createCriteria();
    criteria.andGenderEqualTo("1");

    EmployeeExample.Criteria criteria1 = employeeExample.createCriteria();
    criteria1.andEmailEqualTo("333@qq.com");
    employeeExample.or(criteria);

    List<Employee> employees = employeeMapper.selectByExample(employeeExample);
    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }

  public void insert() {
    Employee employee = new Employee();
    employee.setEmail("111@qq.com");
    employee.setGender("1");
    employee.setLastName("wang");

    employeeMapper.insert(employee);
  }

  public void selectAll() {
    List<Employee> employees = employeeMapper.selectByExample(null);

    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }
}
