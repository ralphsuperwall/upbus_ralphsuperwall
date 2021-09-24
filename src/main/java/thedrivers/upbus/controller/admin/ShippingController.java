package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/shipping")
@Controller
public class ShippingController {
	
	String pageType = "admin/shipping";
	
	@GetMapping("/ApplicationManage")
	public String applicationManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "배송업체 계약 신청 관리");
		return pageType+"/ApplicationManage";
	}
	@GetMapping("/StatisticsManage")
	public String statisticsManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "배송업체 계약 통계 관리");
		return pageType+"/StatisticsManage";
	}
}
