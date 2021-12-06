package com.nb.kaeo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/")
    public String get() {
        return "Hello";
    }

}
