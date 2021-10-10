package thedrivers.upbus.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thedrivers.upbus.domain.ClassAddTeacherList;
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
	// 1.클래스 강사 신청을 할 때 데이터를 받아 처리한다. ( User 서비스 )
	//***************************************************************
	public int classAddTeacher(	String sessionID
							  ,	String classTechaerEmail
							  , String classTeacherName
							  ,	String classTeacherTeam
							  , String classTeacherPhoneNumber
							  ,	String classTeacherSignupFile
							  , String classTeacherScheduleFile
							  , String classTeacherResumFile   ) {
		
		// classMapper 객체를 이용해서 인터페이스의 추상메소드를 구현하였고 SQL 실행하는 결과값이 INT 이다.
		return classMappper.classAddTeacher(	sessionID
											,	classTechaerEmail
											,	classTeacherName
											,	classTeacherTeam
											,	classTeacherPhoneNumber
											, 	classTeacherSignupFile
											, 	classTeacherScheduleFile
											, 	classTeacherResumFile	);
	}
	
	//***************************************************************
	// 2.관리자 화면에서 클래스 강사 신청현황의 모든 데이터를 가져와 화면에 뿌려주는 역할을 한다. (리턴 : list) (입력값 X)
	//***************************************************************
	public List<ClassAddTeacherList> getClassAddTeacherList(){
		
		// ClassAddTecaherList() 의 Mapper 의 메소드를 호출하여 결과를 가져온다.
		List<ClassAddTeacherList> classAddTeacherList = classMappper.getClassAddTeacherList();
		
		return classAddTeacherList;
	}
	
}