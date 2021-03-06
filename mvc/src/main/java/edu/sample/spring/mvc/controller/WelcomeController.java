package edu.sample.spring.mvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Model model) {
		Date today = new Date();
		
		// This will pass to target view
		model.addAttribute("today", today);
		
		// The return String is the view name
		// Here the view is /WEB-INF/jsp/welcome.jsp
		return "welcome";
	}
	
}
