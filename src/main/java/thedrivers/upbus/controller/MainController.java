package thedrivers.upbus.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "UPCYCLING PROJECT");
		model.addAttribute("h1text", "page configuration example");
		return "mainuser";
	}
}
