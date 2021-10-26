package thedrivers.upbus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import thedrivers.upbus.domain.Launching;
import thedrivers.upbus.domain.Member;

@Mapper
public interface MemberMapper {
	//인터페이스 추상메소드, 상수만 선언할 수 있다. 선언

	//회원 등록
	public int Signup(Member member);
	
	//회원목록 조회
	public List<Member> getMemberList();
	
	//입점신청 내역 조회
	public List<Launching> getLaunchingList();
	
	//ajax
	public String getCompareMemberId(String memberId);
	
	//회원 정보 수정
	public int modify(Member member);
	
	//입점 정보 수정
	public int list(Launching launching);
	
	//회원 정보 조회
	public Member getMemberInfoById(String memberId);
	
	//입점 정보 조회
	public Launching getMemberInfoById2(String memberId1);
	
	//회원삭제
	public int memberDelete(String memberId);
	
	//입점 신청
	public int Application2(Launching launching);
}
