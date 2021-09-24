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

@RequestMapping("/user/class")
@Controller
public class ClassController {
	
	// 1. 클래스 강사를 신청하는 페이지로 이동하흔 GetMapping("ClassAdd")
	@GetMapping("/ClassAdd")
	public String ClassAdd(Model model) {
		
		model.addAttribute("title", "클래스강사신청");
		
		return "user/class/ClassAdd";
	}
	
/*	@GetMapping("/ClassAddJsonCall")
	public String ClassAddJsonCall() {
		return "user/class/ClassAddJsonCall";
	}
	
	
	// produces → 응답 컨텐츠 파일을 실행한다.
	@PostMapping(value="/ClassAddJsonCall" , produces="application/json")
	@ResponseBody
	public Map ClassAddJsonCallAjax(@RequestParam("memberId") String memberId){
		
		int result = 0;
		
		//db조회시 아이디 값이 있다면 1
		if("id001".equals(memberId)) {
			result = 1;
		}
		
		Map<String,Object> map = new HashMap<String,Object>();		
		map.put("result", result);		
		return map;
	}*/
}
