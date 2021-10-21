package thedrivers.upbus.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thedrivers.upbus.domain.ClassAddTeacherList;
import thedrivers.upbus.domain.ClassNotice;
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
	
	//***************************************************************
	// 2-1.관리자 화면에서 클래스 강사 기간 승인 버튼을 클릭시 DB 내 데이터(CHECK)와 UPDATE 가 수정이 된다. (리턴 : 1.0)
	//***************************************************************
	public int modifyClassAddTeacherCheck(String signupCode, int termApproveRequestResult) {
		return classMappper.modifyClassAddTeacherCheck(signupCode, termApproveRequestResult);
	}
	
	//***************************************************************
	// 2-2.관리자 화면에서 클래스 강사 신청 승인 버튼을 클릭시 DB 내 데이터(CHECK)와 UPDATE 가 수정이 된다.
	//***************************************************************
	public int modifyClassAddTeacherFinalCheck(String signupCode, int finalApproveRequestResult) {
		int result = classMappper.modifyClassAddTeacherFinalCheck(signupCode, finalApproveRequestResult);
		
		//***************************************************************
		// 2-3.class_teacher_signup 코드와 최종 승인의 결과값의 조건으로 해당 member_id 의 선생이 되도록 설정한다.
		//***************************************************************
		classMappper.modifyMemberTeacherDivision(signupCode, finalApproveRequestResult);
		
		return result;
	}

	//***************************************************************
	// 3.클래스 등록 관리 시스템 화면에서 클래스 필수 입력 사항 확인 단계 버튼 클릭 시 class_notice 테이블에 삽입하는 비즈니스 로직
	//***************************************************************
	public int addClassNotice(ClassNotice classNotice) {
		return classMappper.addClassNotice(classNotice);
	}
}