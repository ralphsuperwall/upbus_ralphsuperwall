package thedrivers.upbus.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user/member")
@Controller
public class MemberController {

	String pageType = "user/member";
	
	@GetMapping("/Signup")
	public String signup(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 가입");
		return pageType+"/Signup";
	}
	@GetMapping("/Secession")
	public String secession(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 탈퇴");
		return pageType+"/Secession";
	}	
	@GetMapping("/Modify")
	public String modify(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 정보 수정");
		return pageType+"/Modify";
	}	
	@GetMapping("/Cart")
	public String cart(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "장바구니");
		return pageType+"/Cart";
	}	
	@GetMapping("/MyGrade")
	public String myGrade(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "내 활동 등급");
		return pageType+"/MyGrade";
	}	
	@GetMapping("/MyExp")
	public String myExp(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "내 활동 경험치");
		return pageType+"/MyExp";
	}	
	@GetMapping("/MyMileage")
	public String myMileage(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "마일리지 조회");
		return pageType+"/MyMileage";
	}
	@GetMapping("/MyClass")
	public String myClass(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "클래스 참가 현황");
		return pageType+"/MyClass";
	}
	@GetMapping("/MyRevenue")
	public String myRevenue(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "수익 조회");
		return pageType+"/MyRevenue";
	}	

}
