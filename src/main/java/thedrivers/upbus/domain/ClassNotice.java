package thedrivers.upbus.domain;

// 클래스 공지의 Domain 생성
public class ClassNotice {
	
	public String classNoticeCode;
	public String className;
	public String classTeacherName;
	public String classContent;
	public int classRegistrationCost;
	public int classGoalCount;
	public int classNowCount;
	public int classLeastCount;
	public String classConfirmStatus;
	public String classNoticeRegisterDate;
	public String classNoticeStartDate;
	public String classNoticeEndDate;
	public String getClassNoticeCode() {
		return classNoticeCode;
	}
	public String getClassName() {
		return className;
	}
	public String getClassTeacherName() {
		return classTeacherName;
	}
	public String getClassContent() {
		return classContent;
	}
	public int getClassRegistrationCost() {
		return classRegistrationCost;
	}
	public int getClassGoalCount() {
		return classGoalCount;
	}
	public int getClassNowCount() {
		return classNowCount;
	}
	public int getClassLeastCount() {
		return classLeastCount;
	}
	public String getClassConfirmStatus() {
		return classConfirmStatus;
	}
	public String getClassNoticeRegisterDate() {
		return classNoticeRegisterDate;
	}
	public String getClassNoticeStartDate() {
		return classNoticeStartDate;
	}
	public String getClassNoticeEndDate() {
		return classNoticeEndDate;
	}
	public void setClassNoticeCode(String classNoticeCode) {
		this.classNoticeCode = classNoticeCode;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setClassTeacherName(String classTeacherName) {
		this.classTeacherName = classTeacherName;
	}
	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}
	public void setClassRegistrationCost(int classRegistrationCost) {
		this.classRegistrationCost = classRegistrationCost;
	}
	public void setClassGoalCount(int classGoalCount) {
		this.classGoalCount = classGoalCount;
	}
	public void setClassNowCount(int classNowCount) {
		this.classNowCount = classNowCount;
	}
	public void setClassLeastCount(int classLeastCount) {
		this.classLeastCount = classLeastCount;
	}
	public void setClassConfirmStatus(String classConfirmStatus) {
		this.classConfirmStatus = classConfirmStatus;
	}
	public void setClassNoticeRegisterDate(String classNoticeRegisterDate) {
		this.classNoticeRegisterDate = classNoticeRegisterDate;
	}
	public void setClassNoticeStartDate(String classNoticeStartDate) {
		this.classNoticeStartDate = classNoticeStartDate;
	}
	public void setClassNoticeEndDate(String classNoticeEndDate) {
		this.classNoticeEndDate = classNoticeEndDate;
	}
	@Override
	public String toString() {
		return "ClassNotice [classNoticeCode=" + classNoticeCode + ", className=" + className + ", classTeacherName="
				+ classTeacherName + ", classContent=" + classContent + ", classRegistrationCost="
				+ classRegistrationCost + ", classGoalCount=" + classGoalCount + ", classNowCount=" + classNowCount
				+ ", classLeastCount=" + classLeastCount + ", classConfirmStatus=" + classConfirmStatus
				+ ", classNoticeRegisterDate=" + classNoticeRegisterDate + ", classNoticeStartDate="
				+ classNoticeStartDate + ", classNoticeEndDate=" + classNoticeEndDate + "]";
	}
	
	

}
