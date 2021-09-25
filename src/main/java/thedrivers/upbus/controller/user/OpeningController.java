package thedrivers.upbus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/opening")
@Controller
public class OpeningController {

	String pageType = "admin/opening";
	
	@GetMapping("/Application")
	public String application(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "입점 신청");
		return pageType+"/Application";
	}
	@GetMapping("/List")
	public String list(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "입점 내역");
		return pageType+"/List";
	}

}
