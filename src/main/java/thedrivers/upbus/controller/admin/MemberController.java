package thedrivers.upbus.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import thedrivers.upbus.domain.Member;
import thedrivers.upbus.service.MemberService;

@RequestMapping("/admin/member")
@Controller
public class MemberController {
	
	String pageType = "admin/member";
	
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	/***************** [ 3. 회원 로그인 화면 ] **********************/
	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("title", "로그인");

		return "admin/member/login";
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
					return "main";
				}

			}
		}

		// 5.회원이 없는 경우에는 회원 로그인을 다시 해야 한다.

		System.out.println("memberId ::" + memberId);
		System.err.println("memberPw ::" + memberPw);

		// return "redirect:/user/member/Login";
		return "admin/member/login";
	}

	/***************** [ 5. 회원 로그아웃 처리 → 메인화면 ] **********************/
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "main";
	}
	@GetMapping("/List")
	public String List(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "전체 회원 목록");
		List<Member> memberList = memberService.getMemberList();
		
		model.addAttribute("memberList", memberList);
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
