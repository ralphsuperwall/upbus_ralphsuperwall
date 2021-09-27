package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/member")
@Controller
public class MemberController {
	
	String pageType = "admin/member";
	
	@GetMapping("/List")
	public String list(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "전체 회원 목록");
		return pageType+"/List";
	}
	
	@GetMapping("/InfoManage")
	public String infoManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "전체 회원 정보 관리");
		return pageType+"/InfoManage";
	}
	
	@GetMapping("/GradeManage")
	public String gradeManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "전체 회원 등급 관리");
		return pageType+"/GradeManage";
	}
	
	@GetMapping("/ExpManage")
	public String expManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "전체 회원 경험치 관리");
		return pageType+"/ExpManage";
	}

}
