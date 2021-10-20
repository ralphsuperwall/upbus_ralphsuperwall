package thedrivers.upbus.domain;

public class Egoods {
	private String egoodsCode;
	private String memberId;
	private String egoodsName;
	private String egoodsPrice;
	private String egoodsAmount;
	private String egoodsImage;
	private String egoodsDate;
	public String getEgoodsCode() {
		return egoodsCode;
	}
	public void setEgoodsCode(String egoodsCode) {
		this.egoodsCode = egoodsCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getEgoodsName() {
		return egoodsName;
	}
	public void setEgoodsName(String egoodsName) {
		this.egoodsName = egoodsName;
	}
	public String getEgoodsPrice() {
		return egoodsPrice;
	}
	public void setEgoodsPrice(String egoodsPrice) {
		this.egoodsPrice = egoodsPrice;
	}
	public String getEgoodsAmount() {
		return egoodsAmount;
	}
	public void setEgoodsAmount(String egoodsAmount) {
		this.egoodsAmount = egoodsAmount;
	}
	public String getEgoodsImage() {
		return egoodsImage;
	}
	public void setEgoodsImage(String egoodsImage) {
		this.egoodsImage = egoodsImage;
	}
	public String getEgoodsDate() {
		return egoodsDate;
	}
	public void setEgoodsDate(String egoodsDate) {
		this.egoodsDate = egoodsDate;
	}
	@Override
	public String toString() {
		return "Egoods [egoodsCode=" + egoodsCode + ", memberId=" + memberId + ", egoodsName=" + egoodsName
				+ ", egoodsPrice=" + egoodsPrice + ", egoodsAmount=" + egoodsAmount + ", egoodsImage=" + egoodsImage
				+ ", egoodsDate=" + egoodsDate + "]";
	}

	
	
}
