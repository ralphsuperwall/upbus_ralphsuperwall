package thedrivers.upbus.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thedrivers.upbus.domain.Launching;
import thedrivers.upbus.domain.Member;
import thedrivers.upbus.service.MemberService;

@RequestMapping("/user/opening")
@Controller
public class OpeningController {

	String pageType = "user/opening";
	
	private final MemberService memberService;
	
	public OpeningController(MemberService memberService) {
		this.memberService = memberService;
	}
	@GetMapping("/Secssion")
	public String secession(Model model) {	 	
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 탈퇴");
		return "user/member/Secession";
	}	
	@GetMapping("/Application")
	public String application(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "입점 신청");
		return pageType+"/Application";
	}
	@GetMapping("/Application2")
	public String Application2(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 가입");
		return pageType+"/Application2";
	}
	
	/***************** [2. 회원 가입 화면  회원가입버튼 → 로그인 경로 연결 ] **********************/
	
	@PostMapping("/Application2")
	public String Application2(Launching launching) {
		System.out.println(launching);
		
		memberService.Application2(launching);
		
		return pageType + "/Application2";
	}
	@GetMapping("/List")
	public String list(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "입점 내역");
		return pageType+"/List";
	}

}
