package thedrivers.upbus.domain;

public class ScrapSale {
	private String scrapSaleCode;
	private String scrapRequestCode;
	private String scrapMileageUserListCode;
	private String scrapReceivingDate;
	private String scrapInspectionDate;
	private int scrapStatusAmount;
	private int scrapWeight;
	public String getScrapSaleCode() {
		return scrapSaleCode;
	}
	public void setScrapSaleCode(String scrapSaleCode) {
		this.scrapSaleCode = scrapSaleCode;
	}
	public String getScrapRequestCode() {
		return scrapRequestCode;
	}
	public void setScrapRequestCode(String scrapRequestCode) {
		this.scrapRequestCode = scrapRequestCode;
	}
	public String getScrapMileageUserListCode() {
		return scrapMileageUserListCode;
	}
	public void setScrapMileageUserListCode(String scrapMileageUserListCode) {
		this.scrapMileageUserListCode = scrapMileageUserListCode;
	}
	public String getScrapReceivingDate() {
		return scrapReceivingDate;
	}
	public void setScrapReceivingDate(String scrapReceivingDate) {
		this.scrapReceivingDate = scrapReceivingDate;
	}
	public String getScrapInspectionDate() {
		return scrapInspectionDate;
	}
	public void setScrapInspectionDate(String scrapInspectionDate) {
		this.scrapInspectionDate = scrapInspectionDate;
	}
	public int getScrapStatusAmount() {
		return scrapStatusAmount;
	}
	public void setScrapStatusAmount(int scrapStatusAmount) {
		this.scrapStatusAmount = scrapStatusAmount;
	}
	public int getScrapWeight() {
		return scrapWeight;
	}
	public void setScrapWeight(int scrapWeight) {
		this.scrapWeight = scrapWeight;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapSale [scrapSaleCode=");
		builder.append(scrapSaleCode);
		builder.append(", scrapRequestCode=");
		builder.append(scrapRequestCode);
		builder.append(", scrapMileageUserListCode=");
		builder.append(scrapMileageUserListCode);
		builder.append(", scrapReceivingDate=");
		builder.append(scrapReceivingDate);
		builder.append(", scrapInspectionDate=");
		builder.append(scrapInspectionDate);
		builder.append(", scrapStatusAmount=");
		builder.append(scrapStatusAmount);
		builder.append(", scrapWeight=");
		builder.append(scrapWeight);
		builder.append("]");
		return builder.toString();
	}
	
	
}
