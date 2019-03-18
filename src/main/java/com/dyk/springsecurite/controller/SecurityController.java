package com.dyk.springsecurite.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @RequestMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //    @PostMapping("/login")
    //    public String login1(){
    //        return "welcome";
    //    }

    @RequestMapping("/level1/{path}")
    public String leve1(@PathVariable("path") String path){
        return "level1/" + path ;
    }

    @RequestMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path){
        return "level2/" + path ;
    }

    @RequestMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path){
        return "level3/" + path ;
    }


}
