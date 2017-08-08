package com.interview.greeting.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	//@RequestMapping("/greeting")
	//RequestMapping(value="/method6", produces={"application/json","application/xml"}, consumes="text/html")
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, 
    			Model model) {
        model.addAttribute("name", name);
        model.addAttribute("message", this.message);
        System.err.println("inside controller");
        return "/greeting/greeting";
    }

}