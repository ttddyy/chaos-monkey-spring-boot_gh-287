package com.example.demochaosmonkey;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final String name;

    public GreetingService(String name) {
        this.name = name;
    }

    //    public String greet() {
    public final String greet() {
        return "Hello " + this.name;
    }

}
