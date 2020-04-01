package com.ecut.teachingevalutionsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = "com.ecut.teachingevalutionsystem.orm.mapper")
public class TeachingevalutionsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachingevalutionsystemApplication.class, args);
    }

}
