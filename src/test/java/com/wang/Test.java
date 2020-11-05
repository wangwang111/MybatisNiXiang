package com.wang;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

public class Test {

  @org.junit.Test
  public void doGenerate() throws Exception {
    List<String> warnings = new ArrayList<String>();
    ConfigurationParser cp = new ConfigurationParser(warnings);
    String xmlName = "generatorConfig.xml";  //mysql 8
    Configuration config = cp.parseConfiguration(this.getClass().getClassLoader().getResourceAsStream(xmlName));

    DefaultShellCallback shellCallback = new DefaultShellCallback(true);
    try {
      MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
      myBatisGenerator.generate(null);
      System.out.println("逆向工程生成数据成功!!!");
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

}
