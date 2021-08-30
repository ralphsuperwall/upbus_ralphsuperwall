/*
 * package ksmart.springboot_test.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping;
 * 
 * import ksmart.springboot_test.domain.Member; import
 * ksmart.springboot_test.service.ExamService;
 * 
 * @Controller public class ExamController {
 * 
 *//**
	 * 의존성 주입(DI) 1. 필드주입 방식
	 * 
	 * @Autowired private ExamService 2. setter 메소드 주입방식 3. 생성자 메소드 주입방식
	 * @autowired springframework 4.3 이후부터
	 *//*
		 * @Autowired private ExamService examService;
		 * 
		 * @Autowired public void setExamService(ExamService examService) {
		 * this.examService = examService; }
		 * 
		 * private
		 * 
		 * 
		 * 
		 * 
		 * 
		 * @GetMapping("/exam2") public String getMemberList(Model model) { //상대적으로 new
		 * 사용안한다 examService.getMemberList(); return "exam/exam2"; }
		 * 
		 * // 실습문제
		 * 
		 * @GetMapping("/exam1") // 기본적으로 get 방식으로 넘어가게 된다. public String exam1(Model
		 * model) { // 0. 리턴데이터타입이 string이면 경로로 인식한다. Member m = new Member("i", "p",
		 * "홍", "홍01");
		 * 
		 * // Member 클래스를 통해 생성된 객체의 변수(property)에 각각의 값을 세팅 // Member 클래스를 통해 생성된 객체의
		 * 주소값을 Member 클래스 데이터 타입 객체 참조 변수 m에 대입한다. // Member m = new Member(); // 현재
		 * m에는 주소값이 담겨있다. // Member 클래스 데이터 타입 = Member 클래스 데이터 타입
		 * 
		 * // 2.값을 다시 세팅한다 m.setMemberId("id001"); m.setMemberPw("pw001");
		 * m.setMemberName("홍01"); m.setMemberEmail("홍01@ksmart.or.kr"); // 4.SYSOUT :
		 * 멤버들이 잘 세팅되었는지 확인해보기
		 * 
		 * System.out.println(m); //Member클래스에 toString()이 있으면 toString()이 호출됨
		 * System.out.println(m.getMemberId());
		 * 
		 * 
		 * // 5.Model model.addAttribute("title", "회원정보"); model.addAttribute("m", m);
		 * 
		 * 
		 * // 3.redirect : 경로가 아니라 주소를 요청하게 된다. // return "redirect:/";
		 * 
		 * // 6.경로 재설정 return "exam/exam1"; // src/main/resuorces/templates/ +
		 * "exam/exam1" +.html } }
		 */

package ksmart.springboot_test.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ksmart.springboot_test.domain.Member;
import ksmart.springboot_test.service.ExamService;

// 실행이 되어있는 상태 : 서블렛
@Controller
public class ExamController {
	/*
	 * 의존성주입 (DI)
	 * 1.필드주입방식 - 실무
	 * 2.setter 메소드 주입방식 - 실무
	 * 3.생성자 메소드 주입방식 -> 스트링부트에서 선호한다.
	 */
	
	/*
	 * 1. 필드주입방식 방법
	 * @Autowired 자동으로 연결해준다. 
	 * private ExamService examService; 이거 이용할테니 주입해주세요
	 * 
	 */
	 
	/*
	 * 2. setter 메소드주입방식 방법
	 * @Autowired 
	 * public void setExamService(ExamService examService) {
	 * this.examService = examService; }
	 */
	
	
	// 3.생성자 메서드 주입방식
	// pom.xml 파일에서 parent ctrl + 클릭시 확인이 가능하다
	private final ExamService examService;
	
	@Autowired
	public ExamController(ExamService examService) {
		this.examService = examService;
	}
	
	@PostConstruct
	public void examServiceInit() {
		System.out.println("==========================");
		System.out.println("==ExamController객체생성확인==");
		System.out.println("==========================");
		
	}
	
	@GetMapping("/exam2")
	public String getMemberList(Model model) {
		// 서비스계층( 비즈니스로직 )을  회원정보를 조회한다
		// 상대적으로 new 연산자를 사용안한다.
		List<Member> memberList = examService.getMemberList();
		
		System.out.println("===============================");
		System.out.println( memberList + "←MemberList");
		System.out.println("===============================");
		
		model.addAttribute("memberList", memberList);
		
		return "exam/exam2";
	}
	
	
	// 실습문제 
	@GetMapping("/exam1")	// 기본적으로 get 방식으로 넘어가게 된다.
	public String exam1(Model model) {
		// 7.생성하자마자 setiing
		Member m = new Member("i", "p", "홍", "홍01");
		
		// 1.DTO 객체 생성
		// Member m = new Member();
		// Member 클래스 데이터 타입 = Member 클래스 데이터 타입

		// 2.값을 세팅한다
		m.setMemberId("id001");
		m.setMemberPw("pw001");
		m.setMemberName("홍01");
		m.setMemberEmail("홍01@ksmart.or.kr");
		// 4.SYSOUT : 멤버들이 잘 세팅되었는지 확인해보기
		
		System.out.println(m);
		System.out.println(m.getMemberId());
		
		 
		// 5.Model 
		model.addAttribute("title", "회원정보");
		model.addAttribute("m", m);
		

		// 3.redirect : 경로가 아니라 주소를 요청하게 된다.
		// return "redirect:/";	
		
		// 6.경로 재설정
		return "exam/exam1"; 
		// src/main/resuorces/templates/ + "exam/exam1" +.html
	}
}
