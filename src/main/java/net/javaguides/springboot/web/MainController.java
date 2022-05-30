package net.javaguides.springboot.web;

import net.javaguides.springboot.repository.ItemRepository;
import net.javaguides.springboot.repository.RestaurantInfoRepository;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping({"/menu"})
	public ModelAndView getAllItems() {
		ModelAndView mav = new ModelAndView("menu");
		mav.addObject("items", itemRepository.findAll());
		return mav;
	}

	@Autowired
	private RestaurantInfoRepository restoRepository;

	@GetMapping({"/contactUs"})
	public ModelAndView getAllRestaurants() {
		ModelAndView mav = new ModelAndView("contactUs");
		mav.addObject("restaurants", restoRepository.findAll());
		return mav;
	}

	@Autowired
	private UserRepository userRepository;

	@GetMapping({"/userDashboard"})
	public ModelAndView displayUserDash() {
		ModelAndView mav = new ModelAndView("userDashboard");
		mav.addObject("userDash", userRepository.findAll());
		return mav;
	}
}
