package thedrivers.upbus.domain;

// DTO : 클래스 대관 장소 업체 리스트 신청, 승인, 클래스 공지에 쓰이기 때문에 Domain 으로 만들었습니다.
public class ClassRentPlaceList {
	private String classRentPlaceCode;
	private String classRentCompany;
	private String classRentPlaceName;
	private String classRentPlaceImage;
	private String classRentPlaceAddress;
	private int classRentPlaceAcceptPerson;
	private int classRentPlaceHopePerson;
	private String classRentPlaceSignupDate;
	private int classRentPlaceConfirmCheck;
	private String classRentPlaceConfirmDate;
	
	// DTO 를 셋팅하고 겟팅할 수 있는 메소드들 ( SETTER, GETTER 메소드 )
	public String getClassRentPlaceCode() {
		return classRentPlaceCode;
	}
	public String getClassRentCompany() {
		return classRentCompany;
	}
	public String getClassRentPlaceName() {
		return classRentPlaceName;
	}
	public String getClassRentPlaceImage() {
		return classRentPlaceImage;
	}
	public String getClassRentPlaceAddress() {
		return classRentPlaceAddress;
	}
	public int getClassRentPlaceAcceptPerson() {
		return classRentPlaceAcceptPerson;
	}
	public int getClassRentPlaceHopePerson() {
		return classRentPlaceHopePerson;
	}
	public String getClassRentPlaceSignupDate() {
		return classRentPlaceSignupDate;
	}
	public int getClassRentPlaceConfirmCheck() {
		return classRentPlaceConfirmCheck;
	}
	public String getClassRentPlaceConfirmDate() {
		return classRentPlaceConfirmDate;
	}
	public void setClassRentPlaceCode(String classRentPlaceCode) {
		this.classRentPlaceCode = classRentPlaceCode;
	}
	public void setClassRentCompany(String classRentCompany) {
		this.classRentCompany = classRentCompany;
	}
	public void setClassRentPlaceName(String classRentPlaceName) {
		this.classRentPlaceName = classRentPlaceName;
	}
	public void setClassRentPlaceImage(String classRentPlaceImage) {
		this.classRentPlaceImage = classRentPlaceImage;
	}
	public void setClassRentPlaceAddress(String classRentPlaceAddress) {
		this.classRentPlaceAddress = classRentPlaceAddress;
	}
	public void setClassRentPlaceAcceptPerson(int classRentPlaceAcceptPerson) {
		this.classRentPlaceAcceptPerson = classRentPlaceAcceptPerson;
	}
	public void setClassRentPlaceHopePerson(int classRentPlaceHopePerson) {
		this.classRentPlaceHopePerson = classRentPlaceHopePerson;
	}
	public void setClassRentPlaceSignupDate(String classRentPlaceSignupDate) {
		this.classRentPlaceSignupDate = classRentPlaceSignupDate;
	}
	public void setClassRentPlaceConfirmCheck(int classRentPlaceConfirmCheck) {
		this.classRentPlaceConfirmCheck = classRentPlaceConfirmCheck;
	}
	public void setClassRentPlaceConfirmDate(String classRentPlaceConfirmDate) {
		this.classRentPlaceConfirmDate = classRentPlaceConfirmDate;
	}

	// DTO 를  toString 메소드를 (@Override) 재정의하여 바꾸어 호출 시에 어떤 값인지 문자열로 변환해 확인할 수 있또록 함
	@Override
	public String toString() {
		return "ClassRentPlaceList [classRentPlaceCode=" + classRentPlaceCode + ", classRentCompany=" + classRentCompany
				+ ", classRentPlaceName=" + classRentPlaceName + ", classRentPlaceImage=" + classRentPlaceImage
				+ ", classRentPlaceAddress=" + classRentPlaceAddress + ", classRentPlaceAcceptPerson="
				+ classRentPlaceAcceptPerson + ", classRentPlaceHopePerson=" + classRentPlaceHopePerson
				+ ", classRentPlaceSignupDate=" + classRentPlaceSignupDate + ", classRentPlaceConfirmCheck="
				+ classRentPlaceConfirmCheck + ", classRentPlaceConfirmDate=" + classRentPlaceConfirmDate + "]";
	}
	
	
	

}
