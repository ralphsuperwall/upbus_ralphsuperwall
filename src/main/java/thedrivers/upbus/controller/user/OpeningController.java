package thedrivers.upbus.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import thedrivers.upbus.domain.Launching;
import thedrivers.upbus.mapper.MemberMapper;
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
	public String application(Model model, HttpSession session) {
		String memberId = (String) session.getAttribute("SID");
		if(memberId != null && !"".equals(memberId)) {
			boolean launchingCheck = false;
			Launching launching = memberService.getMemberInfobyId2(memberId);
			if(launching != null) launchingCheck = true;
			model.addAttribute("launchingCheck", launchingCheck);
			
		}
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "입점 신청");
		return pageType+"/Application";
	}
	@GetMapping("/Application2")
	public String Application2(HttpSession session, Model model) {
		
		String memberId1 = (String) session.getAttribute("SID");
		
		Launching launching = memberService.getMemberInfobyId2(memberId1);
		
		model.addAttribute("launching", launching);	
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 가입");
		return pageType+"/Application2";
	}
	
	/***************** [2. 회원 가입 화면  회원가입버튼 → 로그인 경로 연결 ] **********************/
	
	@PostMapping("/Application2")
	public String Application2(Launching launching) {
		System.out.println(launching);
		
		memberService.Application2(launching);
		
		return "/mainuser";
	}
	
	@PostMapping("/List")
	public String list(Launching launching
						, Model model) {
		
		//화면에서 form http 메소드 방식 post
		//키:값 => 잘만들어진 dto 생성해주면서 값을 바인딩 해준다. => 커맨드객체
		//모든 요소의 속성 name=> 키, dto 프로퍼티 == name, get, set 메소드를 통해서
		
		System.out.println("화면에서 입력받은 값:" + launching);
		if(launching != null && launching.getMemberId1() != null) {			
		}
		return "mainuser";
	}
	
	@GetMapping("/List")
	public String list(HttpSession session, Model model) {
		
		String memberId1 = (String) session.getAttribute("SID");
		
		Launching launching = memberService.getMemberInfobyId2(memberId1);
		
		model.addAttribute("launching", launching);
		model.addAttribute("h1text", "회원 정보 수정");
		return pageType+"/List";
	}
	@PostMapping("/Remove")
	public String Remove(	 @RequestParam(name="memberId1", required = false) String memberId1
								,@RequestParam(name="memberPw", required = false) String memberPw 
				                  ,RedirectAttributes redirectAttr) {
		
		
			String result = memberService.Remove(memberId1, memberPw);
			
			if("입점 내역 삭제 실패".equals(result)) {
				redirectAttr.addAttribute("memberId1", memberId1);
				redirectAttr.addAttribute("result", "회원 비밀번호가 일치하지 않습니다.");
				
				return "redirect:/Remove";
			}
			
			System.out.println(result);
		return "mainuser";
	}
	
	@GetMapping("/Remove")	
	public String Remove(@RequestParam(name="memberId1", required = false) String memberId1
							  ,@RequestParam(name="result", required = false) String result
							  ,Model model){
				
				
				model.addAttribute("title", "회원탈퇴");
				model.addAttribute("memberId1", memberId1);
				if(result != null) model.addAttribute("result", result);
		
				return pageType + "/Remove";
	}
}
