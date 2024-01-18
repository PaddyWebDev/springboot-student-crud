package com.proj.CrudApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
    @RequestMapping("/")
    public String Main() {
        return "helloWorld";
    }
}
