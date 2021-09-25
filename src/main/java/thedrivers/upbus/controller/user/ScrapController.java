package thedrivers.upbus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/scrap")
@Controller
public class ScrapController {

	String pageType = "admin/scrap";
	
	@GetMapping("/List")
	public String list(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 목록");
		return pageType+"/List";
	}
	@GetMapping("/Application")
	public String application(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 신청");
		return pageType+"/Application";
	}
	@GetMapping("/Sell")
	public String sell(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 판매");
		return pageType+"/Sell";
	}
	@GetMapping("/Buy")
	public String buy(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 구매");
		return pageType+"/Buy";
	}
	

}
