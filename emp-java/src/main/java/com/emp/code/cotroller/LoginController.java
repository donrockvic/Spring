package com.emp.code.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login-page";
    }

    @GetMapping("/no-access")
    public String showNoAccess(){
        return "no-access";
    }
}
