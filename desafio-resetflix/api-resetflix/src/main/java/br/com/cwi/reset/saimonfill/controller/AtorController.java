package br.com.cwi.reset.saimonfill.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class AtorController {

    @GetMapping
    public String helloworld() {
        return "Minha API resetflix está UP!!!";
    }
}
