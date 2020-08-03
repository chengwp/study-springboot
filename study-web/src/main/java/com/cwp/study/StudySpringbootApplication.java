package com.cwp.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@MapperScan("com.cwp.study.dao.user.mapper")
public class StudySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringbootApplication.class, args);
    }

}
