package edu.sample.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mapping/*")
public class MappingController {
	
	private static final String JSP_FILE = "display";
	
	@RequestMapping("add")
	public String add(Model model) {
		model.addAttribute("requestParam", "This is request param: add");
		model.addAttribute("user", "user: add");
		return JSP_FILE;
	}
	
	@RequestMapping(value = "display/{user}")
	public String display(
			@RequestParam("requestParam") String requestParam,
			@PathVariable("user") String user,
			Model model) {
		
		model.addAttribute("requestParam", requestParam);
		model.addAttribute("user", user);
		return JSP_FILE;
	}
	
	@RequestMapping(value = {"delete", "remove"},  method = RequestMethod.GET)
	public String remove(Model model) {
		model.addAttribute("requestParam", "This is request param: remove, delete");
		model.addAttribute("user", "user: remove, delete");
		return JSP_FILE;
	}
	
	@RequestMapping
	public void catchAll(Model model) {
		model.addAttribute("requestParam", "This is request param: catch all");
		model.addAttribute("user", "user: catch all");
	}

}
