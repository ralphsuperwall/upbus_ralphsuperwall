package thedrivers.upbus.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import thedrivers.upbus.domain.ClassAddTeacherList;
import thedrivers.upbus.service.ClassService;

@RequestMapping("/admin/class")
@Controller
public class ClassController {
	
	String pageType = "admin/class";
	
	/**
	 * 메소드 주입 방식 (service)
	 */
	
	private final ClassService classService;
	
	public ClassController(ClassService classService) {
		this.classService = classService;
	}
	
	
	// (1) classAddTeacherManage : 클래스 강사 신청을 관리자가 받고 승인하도록 하는 화면
	@GetMapping("/ClassAddTeacherManage")
	public String classAddTeacherManage(Model model) {
		model.addAttribute("title", "클래스강사신청관리");
		
		// 클래스 강사 신청( class_teacher_signup 테이블 )에서 조회된 리스트들을 가져온다.
		List<ClassAddTeacherList> classAddTeacherList = classService.getClassAddTeacherList();
		
		model.addAttribute("classAddTeacherList", classAddTeacherList);
		
		return  pageType+"/ClassAddTeacherManage";
	}
	
	
	// (2) classAddTeacherManage : 클래스 강사 신청 화면에서 클래스 기간 승인에 대한 버튼에 대한 AJAX 를 사용한다.
	@PostMapping(value ="/TermApproveCheckAjax")
	@ResponseBody
	public Map<String, Object> termApproveCheckAjax( Model model
												   , @RequestParam( value = "SignupCode") String signupCode
												   , @RequestParam( value = "TermApproveRequestResult" ) String TermApproveRequestResult ){
		
		// 형변환이 문제가 되기 때문에 홈페이지에서 받은 String을 Int 형으로 바꾸어주도록 합니다.
		int termApproveRequestResult = Integer.parseInt(TermApproveRequestResult);
		
		// AJAX 호출 시 데이터 결과를 다시 반환하여 보내줄 객체를 선언한다.
		Map<String, Object> map = new HashMap <String, Object>();
		// 비즈니스 로직 : 화면에서 입력받은 값(컨트롤러 : 코드, 버튼결과 )을 DB 내 AddTeacherSignupCode 에 해당하는 속성(기간체크, 체크일자 )UPDATE 수정처리
		map.put("result", classService.modifyClassAddTeacherCheck(signupCode, termApproveRequestResult));
		
		return map;
	}
	
	// (3) classAddTeacherManage : 클래스 강사 신청 화면에서 클래스 최종 승인에 대한 버튼에 대한 AJAX 를 사용한다.
	@PostMapping(value ="/FinalApproveCheckAjax")
	@ResponseBody
	public Map<String, Object> finalApproveCheckAjax( Model model
												   , @RequestParam( value = "SignupCode") String signupCode
												   , @RequestParam( value = "FinalApproveRequestResult" ) String FinalApproveRequestResult ){
		
		System.out.println(signupCode + "signupCode" );
		System.out.println(FinalApproveRequestResult + "signupCode");
		
		// 형변환이 문제가 되기 때문에 홈페이지에서 받은 String을 Int 형으로 바꾸어주도록 합니다.
		int finalApproveRequestResult = Integer.parseInt(FinalApproveRequestResult);
		
		// AJAX 호출 시 데이터 결과를 다시 반환하여 보내줄 객체를 선언한다.
		Map<String, Object> map = new HashMap <String, Object>();
		// 비즈니스 로직 : 화면에서 입력받은 값(컨트롤러 : 코드, 버튼결과 )을 DB 내 AddTeacherSignupCode 에 해당하는 속성(기간체크, 체크일자 )UPDATE 수정처리
		map.put("result", classService.modifyClassAddTeacherFinalCheck(signupCode, finalApproveRequestResult));
		
		return map;
	}
	
	@GetMapping("/EnrollmentManage")
	public String enrollmentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "클래스 등록 관리");
		return pageType+"/EnrollmentManage";
	}
	@GetMapping("/StatusManage")
	public String statusManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "클래스 현황 관리");
		return pageType+"/StatusManage";
	}
	@GetMapping("/PaymentManage")
	public String paymentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "클래스 결제 관리");
		return pageType+"/PaymentManage";
	}
}