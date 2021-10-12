package thedrivers.upbus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import thedrivers.upbus.domain.ClassAddTeacherList;

@Mapper
public interface ClassMapper {
	
	/**************************************************************************
	 * 1.클래스 강사 신청을 할 때 데이터를 받아 처리한다. *
	 **************************************************************************/
	public int classAddTeacher(	String sessionID
							  ,	String classTechaerEmail
							  , String classTeacherName
							  ,	String classTeacherTeam
							  , String classTeacherPhoneNumber
							  ,	String classTeacherSignupFile
							  , String classTeacherScheduleFile
							  , String classTeacherResumFile   ); 
	
	/**************************************************************************
	 * 2.입력값 없이 메소드를 호출하면 class_teacher_signup 테이블의 값을 찾아서 리스트를 가져와야 한다. (반환 : 리스트<도메인>) *
	 **************************************************************************/
	public List<ClassAddTeacherList> getClassAddTeacherList();
	
	/**************************************************************************
	 * 3.입력값 ( 버튼의 승인 결과값, 코드 ) 메소드를 호출하면 class_teacher_signup 테이블의 속성을 찾아서 수정한다 ( 반환 : 1,0 ) *
	 **************************************************************************/
	public int modifyClassAddTeacherCheck(String signupCode, int termApproveRequestResult);
	

	/**************************************************************************
	 * 4.메소드를 호출하면 class_teacher_signup 테이블에서 승인한 최종 결과를 찾아서 수정한다. *
	 **************************************************************************/
	public int modifyClassAddTeacherFinalCheck(String signupCode, int finalApproveRequestResult);
	
}

