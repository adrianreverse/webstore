package com.webstore.ui;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final String WELCOME_PAGE = "welcome"; 
	private static final String GREETING_ATTRIBUTE = "greeting";
	private static final String TAGLINE_ATTRIBUTE = "tagline";
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username

		
		ModelAndView mv = new ModelAndView(WELCOME_PAGE);
		mv.addObject(GREETING_ATTRIBUTE, "Witaj w sklepie internetowym!")
		.addObject(TAGLINE_ATTRIBUTE, "Wyj¹tkowym i jedynym sklepie internetowym")
		.addObject("username", name);
		return mv;
	}
}