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
	@PostMapping(value ="/TermApproveCheckAjax", produces="appliaction/json")
	@ResponseBody
	public Map<String, Object> termApproveCheckAjax( Model model
												   , @RequestParam( value = "TermApproveCheckValue" ) String termApproveCheckValue ){
		Map<String, Object> map = new HashMap <String, Object>();

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
