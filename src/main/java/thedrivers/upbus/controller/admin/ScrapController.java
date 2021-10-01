package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/scrap")
@Controller
public class ScrapController {
	
	String pageType = "admin/scrap";
	
	@GetMapping("/ProcedureManage")
	public String procedureManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 절차 관리");
		return pageType+"/ProcedureManage";
	}

	@GetMapping("/ListManage")
	public String listManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 목록 관리");
		return pageType+"/ListManage";
	}
	@GetMapping("/PaymentManage")
	public String paymentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 결제 관리");
		return pageType+"/PaymentManage";
	}
}
