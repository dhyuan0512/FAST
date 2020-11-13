package com.cy;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * SpringBoot项目启动类:(必须由@SpringBootApplication注解)
 * 1)此类启动时会由spring框架自动扫描本类所在包以及子包中的类
 * 2)此类启动时会加载配置文件(spring.factories),并基于配置文件中的类进行自动配置.
 */
@SpringBootApplication
@MapperScan("com.cy.fast.sys.dao")
@Slf4j
public class FastSpringBootApplication {
	/**
	 * 端口
	 */
	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		//启动spring boot应用
		SpringApplication.run(FastSpringBootApplication.class, args);
	}

	/**
	 * 启动成功
	 */
	@Bean
	public ApplicationRunner applicationRunner() {
		return applicationArguments -> {
			try {
				//获取本机内网IP
				log.info("启动成功：" + "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port);
				//获取本机Swagger
				log.info("启动成功Swagger：" + "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port+"/swagger-ui.html");
			} catch (UnknownHostException e) {
				//输出到日志文件中
				log.error(e.getMessage());
			}
		};
	}
}
