package thedrivers.upbus.domain;

public class ScrapSale {
	private String scrapSaleCode;
	private String scrapSaleRequestCode;
	private String scrapReceivingDate;
	private String scrapInspectionDate;
	private String statusAmount;
	public String getScrapSaleCode() {
		return scrapSaleCode;
	}
	public void setScrapSaleCode(String scrapSaleCode) {
		this.scrapSaleCode = scrapSaleCode;
	}
	public String getScrapSaleRequestCode() {
		return scrapSaleRequestCode;
	}
	public void setScrapSaleRequestCode(String scrapSaleRequestCode) {
		this.scrapSaleRequestCode = scrapSaleRequestCode;
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
	public String getStatusAmount() {
		return statusAmount;
	}
	public void setStatusAmount(String statusAmount) {
		this.statusAmount = statusAmount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapSale [scrapSaleCode=");
		builder.append(scrapSaleCode);
		builder.append(", scrapSaleRequestCode=");
		builder.append(scrapSaleRequestCode);
		builder.append(", scrapReceivingDate=");
		builder.append(scrapReceivingDate);
		builder.append(", scrapInspectionDate=");
		builder.append(scrapInspectionDate);
		builder.append(", statusAmount=");
		builder.append(statusAmount);
		builder.append("]");
		return builder.toString();
	}
	
}
