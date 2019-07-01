package cn.itcast.springboot.mybatis;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("cn.itcast.springboot.mybatis.mapper")
@EnableAsync
public class AppAss {

	public static void main(String[] args) {
		  SpringApplication.run(AppAss.class, args);
	}
}