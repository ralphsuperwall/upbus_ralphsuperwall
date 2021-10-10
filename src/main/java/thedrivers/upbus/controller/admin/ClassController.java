package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/class")
@Controller
public class ClassController {
	
	String pageType = "admin/class";
	
	@GetMapping("/EnrollmentManage")
	public String enrollmentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "클래스 등록 관리");
		return pageType+"/EnrollmentManage";
	}
	@GetMapping("/StatusManage")
	public String statusManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "클래스 현황 관리");
		return pageType+"/StatusManage";
	}
	@GetMapping("/PaymentManage")
	public String paymentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "클래스 결제 관리");
		return pageType+"/PaymentManage";
	}
}
