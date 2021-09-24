package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/opening")
@Controller
public class OpeningController {
	
	String pageType = "admin/opening";
	
	@GetMapping("/ApplicationManage")
	public String applicationManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "입첨 신청 관리");
		return pageType+"/ApplicationManage";
	}
	@GetMapping("/EnterpriseManage")
	public String enterpriseManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "입점 기업 관리");
		return pageType+"/EnterpriseManage";
	}
	@GetMapping("/EnterpriseSellApplicationManage")
	public String enterpriseSellApplicationManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "입점 기업 판매 신청 관리");
		return pageType+"/EnterpriseSellApplicationManage";
	}
	

}
