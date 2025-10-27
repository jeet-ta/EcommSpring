package com.example.Ecomm.basic;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld{


    @GetMapping("/{name}")
    public HelloResponse helloParam(@PathVariable String name) {
        return new HelloResponse("Hello " + name );
    }

    @GetMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse("Hello World");
    }
    @PostMapping ("/hello")
    public String helloPost(@RequestBody String name) {
        return "Hello " + name + " How are you?";
    }

}