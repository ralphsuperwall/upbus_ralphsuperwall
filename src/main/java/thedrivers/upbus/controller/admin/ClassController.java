package thedrivers.upbus.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import thedrivers.upbus.domain.ClassAddTeacherList;
import thedrivers.upbus.domain.ClassNotice;
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
	
	
	// (2-1) classAddTeacherManage : 클래스 강사 신청 화면에서 클래스 기간 승인에 대한 버튼에 대한 AJAX 를 사용한다.
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
	
	// (2-2) classAddTeacherManage : 클래스 강사 신청 화면에서 클래스 최종 승인에 대한 버튼에 대한 AJAX 를 사용한다.
	@PostMapping(value ="/FinalApproveCheckAjax")
	@ResponseBody
	public Map<String, Object> finalApproveCheckAjax( Model model
												   , @RequestParam( value = "SignupCode") String signupCode
												   , @RequestParam( value = "FinalApproveRequestResult" ) String FinalApproveRequestResult ){
		
		System.out.println(signupCode + "signupCode" );
		System.out.println(FinalApproveRequestResult + "FinalApproveRequestResult");
		
		// 형변환이 문제가 되기 때문에 홈페이지에서 받은 String을 Int 형으로 바꾸어주도록 합니다.
		int finalApproveRequestResult = Integer.parseInt(FinalApproveRequestResult);
		
		// AJAX 호출 시 데이터 결과를 다시 반환하여 보내줄 객체를 선언한다.
		Map<String, Object> map = new HashMap <String, Object>();
		// 비즈니스 로직 (2-2) : 화면에서 입력받은 값(컨트롤러 : 코드, 버튼결과 )을 DB 내 AddTeacherSignupCode 에 해당하는 속성(기간체크, 체크일자 )UPDATE 수정처리
		// 비즈니스 로직 (2-3) : 화면에서 입력받은 값(컨트롤러 : 코드 )을 DB 내 member 의 선생구분을 수정하도록 함.
		map.put("result", classService.modifyClassAddTeacherFinalCheck(signupCode, finalApproveRequestResult));
		
		return map;
	}
	
	// (2-2) 클래스 등록 관리 시스템 화면 (관리자) 으로 이동하는 페이지
	@GetMapping("/EnrollmentManage")
	public String enrollmentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "클래스 등록 관리");
		return pageType+"/EnrollmentManage";
	}
	
	// (3) 클래스 등록 관리 시스템
	@PostMapping(value = "/addClassNoticeAjax", produces = "application/json")
	@ResponseBody
	public String addClassNoticeAjax(ClassNotice classNotice) {
		
		System.out.println(classNotice);
		classService.addClassNotice(classNotice);
		return "redirect:admin/class/EnrollmentManage";
	}
	
	// (4) 클래스 일정 관리 시스템
	@GetMapping("ClassScheduleManagement")
	public String classScheduleManagement(Model model) {
		model.addAttribute("schedule", "calender");
		
		// 테스트 용도의 index 파일
		return pageType + "/index";
	}
	
	
	// (테스트용도) 게시판 파일들 ( html ) 컨트롤러 무한 반복 작성 X → 바로 테스트 하기 위한 연결
	// /static/fullcalendar/~.html 파일들은 여기에서 바로 페이지명을 받으면 바로 페이지로 넘기도록 한다.
	@RequestMapping(value="/resource/static/fullcalendar/{pageName}")
	public String getSinglePage(@PathVariable("pageName") String pageName) {
		System.out.println(pageName + "← pageName");
		return "/resource/static/fullcalendar/" + pageName;
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