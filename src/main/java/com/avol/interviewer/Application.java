package com.avol.interviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan("com.avol.interviewer.models")
public class Application {

    public static void main(String[] args) {
        System.out.println("--------------------------- Start Application ---------------------------");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}
