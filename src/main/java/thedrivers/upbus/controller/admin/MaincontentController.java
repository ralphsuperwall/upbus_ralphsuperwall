package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/maincontent")
@Controller
public class MaincontentController {
	
	String pageType = "admin/maincontent";
	
	@GetMapping("/ApplicationManage")
	public String applicationManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "메인 컨텐츠 신청 관리");
		return pageType+"/ApplicationManage";
	}
	@GetMapping("/ListManage")
	public String listManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "메인 컨텐츠 목록 관리");
		return pageType+"/ListManage";
	}
	@GetMapping("/ArrangementManage")
	public String arrangementManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "메인 컨텐츠 배치 관리");
		return pageType+"/ArrangementManage";
	}

}
