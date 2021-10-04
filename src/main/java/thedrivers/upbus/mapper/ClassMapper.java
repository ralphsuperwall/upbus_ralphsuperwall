package thedrivers.upbus.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper {
	
	/**************************************************************************
	 * 1.클래스 강사 신청을 할 때 데이터를 받아 처리한다. *
	 **************************************************************************/
	public int ClassAddTeacher(	String sessionID
							  ,	String class_techaer_email
							  , String class_teacher_name
							  ,	String class_teacher_team
							  , String class_teacher_phone_number
							  ,	String class_teacher_signup_file
							  , String class_teacher_schedule_file
							  , String class_teacher_resum_file   ); 

}
