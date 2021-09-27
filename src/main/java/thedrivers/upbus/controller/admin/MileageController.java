package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/mileage")
@Controller
public class MileageController {
	
	String pageType = "admin/mileage";
	
	@GetMapping("/Statistics")
	public String statistics(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "마일리지 통계 조회");
		return pageType+"/Statistics";
	}
	@GetMapping("/ListManage")
	public String list(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "전체 회원 마일리지 내역 조회");
		return pageType+"/ListManage";
	}

}
