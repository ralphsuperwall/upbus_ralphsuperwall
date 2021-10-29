package thedrivers.upbus.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import thedrivers.upbus.domain.Member;
import thedrivers.upbus.service.MemberService;

@RequestMapping("/user/member")
@Controller
public class MemberController {

	String pageType = "user/member";
	
private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	/***************** [ 1. 회원 가입 화면 ] **********************/
	@GetMapping("/Signup")
	public String Signup(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 가입");
		return pageType+"/Signup";
	}
	
	/***************** [2. 회원 가입 화면  회원가입버튼 → 로그인 경로 연결 ] **********************/
	
	@PostMapping("/Signup")
	public String Signup(Member member) {
		System.out.println(member);
		
		memberService.Signup(member);
		
		return pageType + "/login";
	}

	/***************** [ 3. 회원 로그인 화면 ] **********************/
	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("title", "로그인");

		return pageType + "/Login";
	}

	/***************** [ 4. 회원 로그인 화면 → 버튼 처리] **********************/
	@PostMapping("/login")
	public String login(@RequestParam(name = "memberId", required = false) String memberId,
			@RequestParam(name = "memberPw", required = false) String memberPw, HttpSession session,
			RedirectAttributes redirectAttr) {

		// 1. 컨트롤러에서 memberId, memberPw 에 대해 유효성검사
		if (memberId != null && !"".equals(memberId) && memberPw != null && !"".equals(memberPw)) {

			// 2.아이디와 비밀번호가 있으면 우선 아이디를 검색하는 서비스가 필요하게 된다.
			Member member = memberService.getMemberInfobyId(memberId);

			// 3.아이디가 없으면 member = null 이지만 있는 경우에 SQL 조회해서 셋팅됨
			if (member != null) {
				// 4.아이디가 조회되어 검색에 성공했다는 뜻은 비밀번호만 비교하면 됨
				if (memberPw.equals(member.getMemberPw())) {
					// 5.아이디와 비밀번호가 동일하면 세션에 등록
					session.setAttribute("SID", member.getMemberId());
					session.setAttribute("SLEVEL", member.getMemberDivision());
					session.setAttribute("SNAME", member.getMemberName());

					// return "redirect:/user/member/Login";
					return "mainuser";
				}

			}
		}

		// 5.회원이 없는 경우에는 회원 로그인을 다시 해야 한다.

		System.out.println("memberId ::" + memberId);
		System.err.println("memberPw ::" + memberPw);

		// return "redirect:/user/member/Login";
		return pageType + "/Login";
	}

	/***************** [ 5. 회원 로그아웃 처리 → 메인화면 ] **********************/
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "mainuser";
	}

   @GetMapping(value="/idCheck", produces = "application/json")
   @ResponseBody                              
   public Map<String, Object> idCheck(
         @RequestParam(value="userId", required = false) String memberId
   ) {
	  String DBgetID = memberService.getCompareMemberId(memberId);
	   
      System.out.println(memberId + "<< memberId");
      Map<String, Object> map = new HashMap<String, Object>();
      
      if(memberId == null || (memberId != null && "".equals(memberId.trim()))){ 
         map.put("result", -9999);
      }else if(DBgetID != null && DBgetID.equals(memberId)){
         map.put("result", 1);
      }else {
         map.put("result", 0);
      }
      System.out.println(map);
      
      return map;
   } 
   
	@GetMapping("/Secssion")
	public String secession(Model model) {	 	
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 탈퇴");
		return pageType+"/Secession";
	}	
	
	@PostMapping("/Modify")
	public String modify(Member member
						, Model model) {
		
		//화면에서 form http 메소드 방식 post
		//키:값 => 잘만들어진 dto 생성해주면서 값을 바인딩 해준다. => 커맨드객체
		//모든 요소의 속성 name=> 키, dto 프로퍼티 == name, get, set 메소드를 통해서
		
		System.out.println("화면에서 입력받은 값:" + member);
		if(member != null && member.getMemberId() != null) {			
			int result = memberService.modify(member);
			
			if(result == 1) {
				model.addAttribute("result", "회원수정성공함");		
			}else if( result == 0 ) {
				model.addAttribute("result", "회원수정실패함");
			}
			
		}
		
		
		return "mainuser";
	}
	
	@GetMapping("/Modify")
	public String modify(HttpSession session, Model model) {
		
		String memberId = (String) session.getAttribute("SID");
		
		Member member = memberService.getMemberInfobyId(memberId);
		
		model.addAttribute("member", member);
		model.addAttribute("h1text", "회원 정보 수정");
		return pageType+"/Modify";
	}
	
	/***************** [ 회원 삭제 전 공지 화면 이동] **********************/
	@GetMapping("/MemberDeleteWarning")
	public String MemberDeleteWarning(Member member, Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "회원 정보 삭제");
		return pageType+"/MemberDeleteWarning";
	}	
	
	@PostMapping("/MemberDelete")
	public String memberDelete(	 @RequestParam(name="memberId", required = false) String memberId
								,@RequestParam(name="memberPw", required = false) String memberPw 
				                  ,RedirectAttributes redirectAttr) {
		
		
			String result = memberService.memberDelete(memberId, memberPw);
			
			if("회원삭제 실패".equals(result)) {
				redirectAttr.addAttribute("memberId", memberId);
				redirectAttr.addAttribute("result", "회원 비밀번호가 일치하지 않습니다.");
				
				//Get방식 localhost/removeMember?memberId=id012&result=회원 비밀번호가 일치하지 않습니다.
				return "redirect:/removeMember";
			}
			
			System.out.println(result);
		return "mainuser";
	}
	
	/***************** [ 회원 삭제  공지 화면 회원 탈퇴 버튼 클릭 → 회원삭제화면 이동] **********************/
	@GetMapping("/MemberDelete")	
	public String memberDelete(@RequestParam(name="memberId", required = false) String memberId
							  ,@RequestParam(name="result", required = false) String result
							  ,Model model){
				
				
				model.addAttribute("title", "회원탈퇴");
				model.addAttribute("memberId", memberId);
				if(result != null) model.addAttribute("result", result);
		
				return pageType + "/MemberDelete";
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
