package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/standard")
@Controller
public class StandardController {
	
	String pageType = "admin/standard";
	
	@GetMapping("/MileageManage")
	public String mileageManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "마일리지 등급 기준 관리");
		return pageType+"/MileageManage";
	}
	@GetMapping("/ExpManage")
	public String expManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "경험치 기준관리");
		return pageType+"/ExpManage";
	}
	@GetMapping("/MemberAccessManage")
	public String memberAccessManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "전체 회원 권한 관리");
		return pageType+"/MemberAccessManage";
	}
}
