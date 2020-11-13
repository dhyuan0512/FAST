package com.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * SpringBoot项目启动类:(必须由@SpringBootApplication注解)
 * 1)此类启动时会由spring框架自动扫描本类所在包以及子包中的类
 * 2)此类启动时会加载配置文件(spring.factories),并基于配置文件中的类进行自动配置.
 */
@SpringBootApplication
@MapperScan("com.cy.fast.sys.dao")
public class FastSpringBootApplication {
	public static void main(String[] args) {
		//启动spring boot应用
		SpringApplication.run(FastSpringBootApplication.class, args);
	}
}
