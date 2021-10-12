package thedrivers.upbus.controller.user;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import thedrivers.upbus.service.ClassService;

@RequestMapping("/user/class")
@Controller
public class ClassController {
	
	//**************************  메소드 주입 방식   *******************************
	private final ClassService classService;
	public ClassController(ClassService classService) {
		this.classService = classService;
	}
	
	/**************************************************************************
	 * 1.클래스 강사 신청으로 가는 페이지의 연결을 담당하는 메소드 *
	 **************************************************************************/
	@GetMapping("/ClassAddTeacher")
	public String ClassAddTeacher(Model model) {

		model.addAttribute("title", "클래스강사신청");

		return "user/class/ClassAddTeacher";
	}

	/**************************************************************************
	 * 2.클래스 강사 신청 페이지에서 버튼을 클릭할 시에 데이터가 들어오고 이를 처리해주는 서비스를 호출하는 메소드*
	 **************************************************************************/
	@PostMapping("/ClassAddTeacher")
	public String classAddTeacher( HttpSession session
								 , @RequestParam(name = "class_techaer_email", required = false) 			String classTechaerEmail
								 , @RequestParam(name = "class_teacher_name", required = false) 			String classTeacherName
								 , @RequestParam(name = "class_teacher_team", required = false) 			String classTeacherTeam
								 , @RequestParam(name = "class_teacher_phone_number", required = false)		String classTeacherPhoneNumber
								 , @RequestParam(name = "class_teacher_signup_file", required = false) 		String classTeacherSignupFile
								 , @RequestParam(name = "class_teacher_schedule_file", required = false) 	String classTeacherScheduleFile
								 , @RequestParam(name = "class_teacher_resum_file", required = false) 		String classTeacherResumFile) throws Exception {
		
		// HttpSession 객체의 메소드의 getAttribute 메소드를 이용해 가져온다.
		String sessionID = (String) session.getAttribute("SID");

		// 데이터를 입력받은 그대로 서비스를 호출할 떄 매개변수 값으로 넣어주도록 한다.
		classService.classAddTeacher( sessionID
									, classTechaerEmail
									, classTeacherName
									, classTeacherTeam
									, classTeacherPhoneNumber
									, classTeacherSignupFile
									, classTeacherScheduleFile
									, classTeacherResumFile);

		return "user/class/ClassAddTeacherList";
	}
	
	/**************************************************************************
	 * 3.클래스 강사에서 데이터를 보낼 떄 AJAX 를 활용해서 동일한 파일 이름이 있는 지 확인하여 있으면 막는다. *
	 **************************************************************************/
	@PostMapping( value="/fileCheck")
	@ResponseBody
	public Map<String, String> fileCheck( @RequestParam(name = "class_teacher_signup_file", required = false) 		String class_teacher_signup_file
										 , @RequestParam(name = "class_teacher_schedule_file", required = false) 	String class_teacher_schedule_file
										 , @RequestParam(name = "class_teacher_resum_file", required = false) 		String class_teacher_resum_file) throws Exception	{

		Map<String, String> map = new HashMap<String, String>();
		System.out.println(map);
		
		// 1. 신청서 파일이 입력되지 않은 경우
		if(class_teacher_signup_file == null || "".equals(class_teacher_signup_file.trim())) {
			// map 에 result 변수로 "에러 문구" 지정
			map.put("Error1", "signup_file_Error");
			
		// 2. 스케쥴 파일이 입력되지 않은 경우
		}else if(class_teacher_schedule_file == null || "".equals(class_teacher_schedule_file.trim())) {
			// map 에 result 변수로 "에러 문구" 지정
			map.put("Error2", "schedule_file_Error");
		
		// 3. 이력서 파일이 입력되지 않은 경우
		}else if(class_teacher_resum_file == null || "".equals(class_teacher_resum_file.trim())) {
			map.put("Error3", "resum_file_Error");
		}
		System.out.println(map);
		return map;
		
	}
	
	/**************************************************************************
	 * 4.클래스 강사  신청이 완료되거나 신청이 취소 되는 경우 경로가 연결이 된다. *
	 **************************************************************************/
	@GetMapping("classAddTeacherList")
	public String classAddTeacherList() {
		return "user/class/ClassAddTeacherList";
	}
	
	
}