package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


import java.util.Locale;

@Controller
@RequestMapping("/form")
public class CustomForms {

    @RequestMapping("/showForm")
    public String showForm(){
        return "my-form";
    }

//    @RequestMapping("/processForm")
//    public String processForm(){
//        return "process-form";
//    }

//    @RequestMapping("/processForm")
//    public String processForm(HttpServletRequest request, Model model){
//        String theName = request.getParameter("studentName");
//
//        theName = theName.toUpperCase(Locale.ROOT);
//
//        String result = "Yo !" + theName;
//
//        model.addAttribute("message", result);
//
//        return "process-form";
//    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentName") String theName, Model model){
        theName = theName.toUpperCase(Locale.ROOT);

        String result = "Yo !" + theName;

        model.addAttribute("message", result);

        return "process-form";
    }

}
