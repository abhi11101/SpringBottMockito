package org.abhi.springbottmockito.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/api/home")
    public String goHome(){
        return "Home Page";
    }
}
