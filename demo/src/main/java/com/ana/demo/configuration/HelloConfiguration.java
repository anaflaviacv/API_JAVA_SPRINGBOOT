package com.ana.demo.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//cofigura instancia de classes, coisas que vem externalmente, como banco de dados, etc
@Configuration
public class HelloConfiguration {

    @Bean
    public String helloWorld(){
        return "HelloWorld";
    }

}
