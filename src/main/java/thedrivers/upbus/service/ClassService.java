package thedrivers.upbus.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thedrivers.upbus.mapper.ClassMapper;

@Service
@Transactional
public class ClassService {
	
	//*********************  메소드 주입 방식   ****************************
	private final ClassMapper classMappper;
	public ClassService(ClassMapper classMappper) {
		this.classMappper = classMappper;
	}
	
	//***************************************************************
	// 1.클래스 강사 신청을 할 때 데이터를 받아 처리한다.
	//***************************************************************
	public int ClassAddTeacher(	String sessionID
							  ,	String class_techaer_email
							  , String class_teacher_name
							  ,	String class_teacher_team
							  , String class_teacher_phone_number
							  ,	String class_teacher_signup_file
							  , String class_teacher_schedule_file
							  , String class_teacher_resum_file   ) {
		
		// classMapper 객체를 이용해서 인터페이스의 추상메소드를 구현하였고 SQL 실행하는 결과값이 INT 이다.
		return classMappper.ClassAddTeacher(	sessionID
											,	class_techaer_email
											,	class_teacher_name
											,	class_teacher_team
											,	class_teacher_phone_number
											, 	class_teacher_signup_file
											, 	class_teacher_schedule_file
											, 	class_teacher_resum_file	);
	}
	
}