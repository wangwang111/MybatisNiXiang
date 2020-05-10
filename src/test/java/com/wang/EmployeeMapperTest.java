package com.wang;

//import com.wang.dao.EmployeeMapper;
//import com.wang.entity.Employee;
import com.wang.dao.EmployeeMapper;
import com.wang.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class EmployeeMapperTest {

  public SqlSessionFactory getSqlSessionFactory() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    return new SqlSessionFactoryBuilder().build(inputStream);
  }

  @Test
  public void test() throws Exception {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

    Employee employee = new Employee();
    employee.setEmail("111@qq.com");
    employee.setGender("1");
    employee.setLastName("wang");

    mapper.insert(employee);
  }
}
