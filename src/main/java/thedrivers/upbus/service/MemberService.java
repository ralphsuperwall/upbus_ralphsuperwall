package thedrivers.upbus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import thedrivers.upbus.domain.Launching;
import thedrivers.upbus.domain.Member;
import thedrivers.upbus.mapper.MemberMapper;

@Service
public class MemberService {
	
	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	// 1.회원추가
	public int Signup(Member member) {
		return memberMapper.Signup(member);
	}
	// 회원 정보 수정
	public int modify(Member member) {
		return memberMapper.modify(member);
	}
	//입점 정보 수정
	public int list(Launching launching) {
		return memberMapper.list(launching);
	}
	// 회원정보 가져오기
	public Member getMemberInfobyId(String memberId) {
		return memberMapper.getMemberInfoById(memberId);
	}
	// 입점신청 정보 가져오기
	public Launching getMemberInfobyId2(String memberId1) {
		return memberMapper.getMemberInfoById2(memberId1);
	}
	// 2.조건없이 전체회원조회
	public List<Member> getMemberList(){
		List<Member> memberList = memberMapper.getMemberList();
		return memberList;
	}
	//입점신청 내역
	public List<Launching> getLaunchingList(){
		List<Launching> launchingList = memberMapper.getLaunchingList();
		return launchingList;
	}
	//입점신청
	public int Application2(Launching launching) {
		return memberMapper.Application2(launching);
	}
	// 3.아이디를 조회해서 있는 지 확인하고 있으면 String 반환 없으면 X
	public String getCompareMemberId(String memberId) { 
		String mId = memberMapper.getCompareMemberId(memberId);
		return mId;
		
	}
	// 4. 회원탈퇴 로직
	public String memberDelete(String memberId, String memberPw) {
		String result = "회원삭제 실패";
			
		//입력받은 값 memberId 비밀번호 일치여부
		Member member = memberMapper.getMemberInfoById(memberId);
		if(member != null) {
			if(memberPw.equals(member.getMemberPw())) {
				//삭제 프로세스
				memberMapper.memberDelete(memberId);
				result = "회원삭제 성공";
			}
		}
		return result;
	}
	//5. 입점 내역 삭제 로직
	public String Remove(String memberId, String memberPw) {
		String result = "입점 내역 삭제 실패";
		
		//입력받은 값 memberId 비밀번호 일치여부
		Member member = memberMapper.getMemberInfoById(memberId);
		if(member != null) {
			if(memberPw.equals(member.getMemberPw())) {
				//삭제 프로세스
				memberMapper.Remove(memberId);
				result = "회원삭제 성공";
			}
		}
		return result;
	}

}
