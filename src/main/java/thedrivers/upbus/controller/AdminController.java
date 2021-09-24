package thedrivers.upbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	String pageType = "admin";
	
	@GetMapping("/standard/MileageManage")
	public String mileageManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "마일리지 등급 기준 관리");
		return pageType+"/standard/MileageManage";
	}
	
	@GetMapping("/standard/ExpManage")
	public String expManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "경험치 기준관리");
		return pageType+"/standard/ExpManage";
	}
	
}
