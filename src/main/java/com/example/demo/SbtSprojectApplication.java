package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/*

@EnableJpaAuditing
 : JPA Auditing 기능을 사용하기 위해 main 클래스(BoardApplication)에 
  @EnableJpaAuditing 어노테이션을 붙여줍니다. 
 */

@EnableJpaAuditing
@SpringBootApplication
public class SbtSprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbtSprojectApplication.class, args);
	}
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
}
