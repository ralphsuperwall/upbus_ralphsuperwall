package thedrivers.upbus.domain;

public class MileageUserList {
	//일부로 마일리지적립,사용 기준코드를 안넣었음
	String mileageUserListCode;
	String memberId;
	String mileageUserListAmount;
	String mileageUserListDate;
	String mileageUserListType;
	String mileageUserListCancel;
	
	public String getMileageUserListCode() {
		return mileageUserListCode;
	}
	public void setMileageUserListCode(String mileageUserListCode) {
		this.mileageUserListCode = mileageUserListCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMileageUserListAmount() {
		return mileageUserListAmount;
	}
	public void setMileageUserListAmount(String mileageUserListAmount) {
		this.mileageUserListAmount = mileageUserListAmount;
	}
	public String getMileageUserListDate() {
		return mileageUserListDate;
	}
	public void setMileageUserListDate(String mileageUserListDate) {
		this.mileageUserListDate = mileageUserListDate;
	}
	public String getMileageUserListType() {
		return mileageUserListType;
	}
	public void setMileageUserListType(String mileageUserListType) {
		this.mileageUserListType = mileageUserListType;
	}
	public String getMileageUserListCancel() {
		return mileageUserListCancel;
	}
	public void setMileageUserListCancel(String mileageUserListCancel) {
		this.mileageUserListCancel = mileageUserListCancel;
	}
	@Override
	public String toString() {
		return "MileageUserList [mileageUserListCode=" + mileageUserListCode + ", memberId=" + memberId
				+ ", mileageUserListAmount=" + mileageUserListAmount + ", mileageUserListDate=" + mileageUserListDate
				+ ", mileageUserListType=" + mileageUserListType + ", mileageUserListCancel=" + mileageUserListCancel
				+ "]";
	}
	
	
}
