package com.minister.visitorsapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping ("/")
    @ResponseBody
    public String handleTest(){
        return "i am checking weather project is live or not! ";
    }
}
