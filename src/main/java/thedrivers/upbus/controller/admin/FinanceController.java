package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/finance")
@Controller
public class FinanceController {
	
	String pageType = "admin/finance";
	
	@GetMapping("/IncomeList")
	public String incomeList(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "사이트 수입 조회");
		return pageType+"/IncomeList";
	}
	@GetMapping("/ExpenditureList")
	public String expenditureList(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "사이트 지출 조회");
		return pageType+"/ExpenditureList";
	}
	@GetMapping("/TotalList")
	public String totalList(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "사이트 통합 조회");
		return pageType+"/TotalList";
	}
	

}
