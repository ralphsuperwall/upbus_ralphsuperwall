package thedrivers.upbus.domain;

public class ScrapListInventory {
	private String scrapInventoryCode;
	private String scrapRequestCode;
	private int scrapInventoryStatus;
	private int scrapInventoryStatusCheck;
	private String scrapInventoryPrimaryDate;
	private String scrapInventoryPrimaryIncharge;
	private int scrapStatus;
	private String scrapInventoryLastDate;
	private String scrapInventoryLastIncharge;
	private String scrapImage;
	private int scrapPrice;
	public String getScrapInventoryCode() {
		return scrapInventoryCode;
	}
	public void setScrapInventoryCode(String scrapInventoryCode) {
		this.scrapInventoryCode = scrapInventoryCode;
	}
	public String getScrapRequestCode() {
		return scrapRequestCode;
	}
	public void setScrapRequestCode(String scrapRequestCode) {
		this.scrapRequestCode = scrapRequestCode;
	}
	public int getScrapInventoryStatus() {
		return scrapInventoryStatus;
	}
	public void setScrapInventoryStatus(int scrapInventoryStatus) {
		this.scrapInventoryStatus = scrapInventoryStatus;
	}
	public int getScrapInventoryStatusCheck() {
		return scrapInventoryStatusCheck;
	}
	public void setScrapInventoryStatusCheck(int scrapInventoryStatusCheck) {
		this.scrapInventoryStatusCheck = scrapInventoryStatusCheck;
	}
	public String getScrapInventoryPrimaryDate() {
		return scrapInventoryPrimaryDate;
	}
	public void setScrapInventoryPrimaryDate(String scrapInventoryPrimaryDate) {
		this.scrapInventoryPrimaryDate = scrapInventoryPrimaryDate;
	}
	public String getScrapInventoryPrimaryIncharge() {
		return scrapInventoryPrimaryIncharge;
	}
	public void setScrapInventoryPrimaryIncharge(String scrapInventoryPrimaryIncharge) {
		this.scrapInventoryPrimaryIncharge = scrapInventoryPrimaryIncharge;
	}
	public int getScrapStatus() {
		return scrapStatus;
	}
	public void setScrapStatus(int scrapStatus) {
		this.scrapStatus = scrapStatus;
	}
	public String getScrapInventoryLastDate() {
		return scrapInventoryLastDate;
	}
	public void setScrapInventoryLastDate(String scrapInventoryLastDate) {
		this.scrapInventoryLastDate = scrapInventoryLastDate;
	}
	public String getScrapInventoryLastIncharge() {
		return scrapInventoryLastIncharge;
	}
	public void setScrapInventoryLastIncharge(String scrapInventoryLastIncharge) {
		this.scrapInventoryLastIncharge = scrapInventoryLastIncharge;
	}
	public String getScrapImage() {
		return scrapImage;
	}
	public void setScrapImage(String scrapImage) {
		this.scrapImage = scrapImage;
	}
	public int getScrapPrice() {
		return scrapPrice;
	}
	public void setScrapPrice(int scrapPrice) {
		this.scrapPrice = scrapPrice;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapListInventory [scrapInventoryCode=");
		builder.append(scrapInventoryCode);
		builder.append(", scrapRequestCode=");
		builder.append(scrapRequestCode);
		builder.append(", scrapInventoryStatus=");
		builder.append(scrapInventoryStatus);
		builder.append(", scrapInventoryStatusCheck=");
		builder.append(scrapInventoryStatusCheck);
		builder.append(", scrapInventoryPrimaryDate=");
		builder.append(scrapInventoryPrimaryDate);
		builder.append(", scrapInventoryPrimaryIncharge=");
		builder.append(scrapInventoryPrimaryIncharge);
		builder.append(", scrapStatus=");
		builder.append(scrapStatus);
		builder.append(", scrapInventoryLastDate=");
		builder.append(scrapInventoryLastDate);
		builder.append(", scrapInventoryLastIncharge=");
		builder.append(scrapInventoryLastIncharge);
		builder.append(", scrapImage=");
		builder.append(scrapImage);
		builder.append(", scrapPrice=");
		builder.append(scrapPrice);
		builder.append("]");
		return builder.toString();
	}
	
}
