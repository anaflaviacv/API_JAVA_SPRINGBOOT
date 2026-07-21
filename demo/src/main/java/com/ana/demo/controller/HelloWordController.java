package com.ana.demo.controller;
import com.ana.demo.service.HelloWordService;
import com.ana.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-word")
public class HelloWordController {
    @Autowired
    private HelloWordService helloWordService; //dependency injection, falando pro spring que essa dependencia deve ser injetada

    //GET /hello-word
    @GetMapping
    public String helloWord(){
        return helloWordService.helloWord("World");
    }

    @PostMapping("/{id}")
    public String sayHello(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody User body){
        return "Hello World " + body.getName() + ", id: " + id;
    }
}
