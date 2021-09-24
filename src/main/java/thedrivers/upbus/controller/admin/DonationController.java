package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/donation")
@Controller
public class DonationController {
	
	String pageType = "admin/donation";
	
	@GetMapping("/ApplicationManage")
	public String applicationManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "후원 신청 관리");
		return pageType+"/ApplicationManage";
	}
	@GetMapping("/StatusManage")
	public String statusManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "후원 현황 관리");
		return pageType+"/StatusManage";
	}

}
