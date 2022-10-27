package com.cg.sprint.controller.testcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/api/v1")
public class TestController {

	
	@GetMapping("/test")
	public String showTest() {
		
		return "Test Success full ";
	}
}
