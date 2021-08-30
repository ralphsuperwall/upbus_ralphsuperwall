package ksmart.springboot_test.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@PostConstruct
	public void mainControllerinit() {
		System.out.println("=========================");
		System.out.println("MainController 객체 생성");
		System.out.println("=========================");
	}	
	
	@GetMapping("/ksmartView")
	public String ksmartView(Model model) {
		//model.addAttribute("member", 객체참조변수);
		model.addAttribute("title", "mvc패턴 완벽정리");
		model.addAttribute("model", "데이터와 비즈니스 로직을 관리합니다.");
		model.addAttribute("view", "레이아웃과 화면을 처리합니다.");
		model.addAttribute("controller", "명령을 모델과 뷰 부분으로 라우팅합니다. 주소분기.");
		
		//mvc view경로 기본설정 "src/main/resources/templates/" + mvc +".html"
		return "mvc"; 
	}
	
	/**
	 * GetMapping => HTTP통신에서 GET방식 주소요청 ex:) localhost
	 * @return 
	 * @Controller String => 기본적으로 프로젝트 내의 화면 경로 root(template)
	 * Spring Mvc -> Model model : 화면에 전달하는 정보(객체)
	 * 
	 */
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("h1text", "HELLO! SPRING BOOT LAYOUT");
		return "main";
	}
}
