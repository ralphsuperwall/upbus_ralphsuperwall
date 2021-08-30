package ksmart.springboot_test.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import ksmart.springboot_test.domain.Member;

/*
 * 서비스 : 순수하게 비즈니스 로직을 작성하는 클래스
 * HTTP 통신과 관련된 역할의 분리, 주소 분기( controller의 역할 )를 제외
 */

// 빌드할 때( 실행할 때 ) 비즈니스 상태의 service bean 객체이다.
@Service
public class ExamService {
	
	@PostConstruct
	public void examServiceInit() {
		System.out.println("==========================");
		System.out.println("==ExamService 객체 생성 확인==");
		System.out.println("==========================");
		
	}

	public List<Member> getMemberList() {
		// Member 9 개를 담는 리스트
		
		List<Member> memberList = new ArrayList<Member>();
		
		// 반복문을 통해서 id001 ~ id009 까지 만들어보세요.
		// for( 초기값; 조건식; 증감값 ){ }
		// 셀렉트문으로 조회했다고 가정을 한다
		
		for( int i=1; i<10; i++ ) {
			memberList.add(new Member("id00"+i, "pw00"+i, "홍0"+i, "홍0"+i+"@ksmart.or.kr"));
		}
		
		return memberList;
	}
}
