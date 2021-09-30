package thedrivers.upbus.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 2.조건없이 전체회원조회
	public List<Member> getMemberList(){
		List<Member> memberList = memberMapper.getMemberList();
		return memberList;
	}
	
	// 3.아이디를 조회해서 있는 지 확인하고 있으면 String 반환 없으면 X
	public String getCompareMemberId(String memberId) { 
		String mId = memberMapper.getCompareMemberId(memberId);
		return mId;
		
	}

}
