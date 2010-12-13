package com.burrsutter.springmvcjpagae;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	// private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		// TODO: need to figure out logging in a GAE world
		// logger.info("Welcome home!");
		System.out.println("Home Controller");
		return "redirect:/todos/all";
	}
	
}

