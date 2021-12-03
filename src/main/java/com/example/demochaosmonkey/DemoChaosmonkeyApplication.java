package com.example.demochaosmonkey;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoChaosmonkeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoChaosmonkeyApplication.class, args);
    }

    @Bean
    public String name() {
        return "Foo";
    }
    @Bean
    public CommandLineRunner runner(GreetingService greetingService) {
        return (args) -> {
            System.out.println("Greet: " + greetingService.greet());
        };
    }
}
