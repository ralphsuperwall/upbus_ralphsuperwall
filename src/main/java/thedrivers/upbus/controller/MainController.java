package thedrivers.upbus.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "UPBUS :: 새활용버스");
		model.addAttribute("h1text", "업사이클링 이커머스 플랫폼");
		return "main";
	}
}
