package ksmart.springboot_test.domain;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	
	/*
	 * 자바 메서드 ~ 로 만들어라.
	 * 메소드 방법 : 접근지정자 / 정적, 동적 / 반환형 / 메소드명 ( 매개변수 ) { // 소스코드 }
	 * 기본에 충실을 해라. 늦었을 때 가장 늦었어요. 더 늦기 전에 해야 한다.
	 * 
	 * get => 멤버 변수에 담겨져 있는 값을 반환하는 메소드
	 * set => 멤버 변수에 값을 담는 메서드
	 * (1) 자바에서의 네이밍 법칙 
	 * : 카멜( 메소드, 변수 : 소문자 대문자 ), 파스칼( 클래스, 대문자, 대문자 )- 자바에서 대중적으로 많이 사용함
	 * (2) DB 에서의 스네이크 법칙
	 * 스네이크( MySQL 대소문자 구별안함 : 문자_문자 ) 
	 * (3) 헝가리안( 타입명시 strMemberId )
	 * 
	 * set 메서드
	 * 누구나 접근이 용이할 수 있게(public), 값을 담는 용도이기 때문에(void)
	 * 선언 : public void setMemberId(String MemberID){ this.MemberID = MemberID };
	 * 호출 : m.setMemberId("id001");
	 *
	 * get 메서드
	 * 
	 * 선언 : public void getMemberId() { return getMemberId }
	 * 호출 : String memberId = m.getMemberId();
	 * 자바는 타입언어이기 때문에  두 개의 자료형이 같아야한다. String = String
	 * 
	 * 선언 :
	 * public String getMemberId(String param) {
			return this.MemberId + param; // 이것도 가능함
		}
	      호출 : String meberId = m.getMemberId("id001");
	 * */
	
	/* [ 생성자 메서드 ]
	 * public Member() {
	 * 		super();
	 * }
	 */
	
	// 메서드 오버로딩 : 같은 메서드명을 가지지만 다른 자료형, 다른 매개변수
	public Member() {
		
	}
	
	public Member(String memberId, String memberPw, String memberName, String memberEmail) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		System.out.println(memberId + "← memberId");
		this.memberId = memberId; 
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	
	public void setMemberPw(String memberPw) {
		System.out.println(memberPw + "← memberPw");
		this.memberPw = memberPw;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		System.out.println(memberName + "← memberName");
		this.memberName = memberName;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}
	
	public void setMemberEmail(String memberEmail) {
		System.out.println(memberEmail + "← MemberEmail");
		this.memberEmail = memberEmail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memberId=");
		builder.append(memberId);
		builder.append(", memberPw=");
		builder.append(memberPw);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberEmail=");
		builder.append(memberEmail);
		builder.append("]");
		return builder.toString();
	}

	
	/*
	 * m.toString(); // To String 객체의 값을 찍어내는 메소드 // 모든 클래스는 부모클래스를 가지고 있다. 최상위 객체
	 * object // 오버라이드 : 메소드를 재정의를 할 수 있다.
	 * 
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return super.toString(); // super. 내가 바라보고 있는 최상위 객체 }
	 */
	


}

	
	/**
	 * 자바 시작했는데 get set 메소드 못만드면 욕먹습니다. 실무가면 왕따당합니다.
	 * 메소드 방법 : 접근지정자 반환형 메소드이름(매개변수)
	 * get => 멤버변수에 담겨져있는 값을 반환하는 메소드 
	 * set => 멤버변수에 값을 담는 메소드
	 * m.setMember("id001");
	 * String memverId = m.getMeberId("id001");
	 * 카멜(소문자대문자메소드, 변수), 파스칼(클래스 대문자대문자), <<< 많이씀 
 	 * 스네이크(db쪽=> mysql 대소문자 구별안함), 헝가리안(타입을 명시 strMemberId)
	 */
	
	
	

