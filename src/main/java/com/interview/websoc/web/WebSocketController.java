package com.interview.websoc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSocketController {

	@RequestMapping(value="/websocket/single", method=RequestMethod.GET)
    public String single(Model model) {
       System.err.println("websocket controller : single");
       return "/websoc/webSocketSingle";
    }
	@RequestMapping(value="/websocket/multiple", method=RequestMethod.GET)
    public String multiple(Model model) {
        System.err.println("websocket controller : multiple");
        return "/websoc/webSocketMultiple";
     }
}
