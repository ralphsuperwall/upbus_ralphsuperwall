package thedrivers.upbus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import thedrivers.upbus.domain.Member;

@Mapper
public interface MemberMapper {
	//인터페이스 추상메소드, 상수만 선언할 수 있다. 선언

	//회원 등록
	public int Signup(Member member);
	
	//회원목록 조회
	public List<Member> getMemberList();
	
	//ajax
	public String getCompareMemberId(String memberId);
}
