package thedrivers.upbus.domain;

public class ScrapCategory {
	private int scrapCategoryNumber;
	private String scrapCategoryName;
	private String scrapCategoryRegisterDate;
	public int getScrapCategoryNumber() {
		return scrapCategoryNumber;
	}
	public void setScrapCategoryNumber(int scrapCategoryNumber) {
		this.scrapCategoryNumber = scrapCategoryNumber;
	}
	public String getScrapCategoryName() {
		return scrapCategoryName;
	}
	public void setScrapCategoryName(String scrapCategoryName) {
		this.scrapCategoryName = scrapCategoryName;
	}
	public String getScrapCategoryRegisterDate() {
		return scrapCategoryRegisterDate;
	}
	public void setScrapCategoryRegisterDate(String scrapCategoryRegisterDate) {
		this.scrapCategoryRegisterDate = scrapCategoryRegisterDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapCategory [scrapCategoryNumber=");
		builder.append(scrapCategoryNumber);
		builder.append(", scrapCategoryName=");
		builder.append(scrapCategoryName);
		builder.append(", scrapCategoryRegisterDate=");
		builder.append(scrapCategoryRegisterDate);
		builder.append("]");
		return builder.toString();
	}
}
