package thedrivers.upbus.domain;

public class ScrapUpcylingList {
	private String scrapMaterialListCode;
	private String scrapCategoryNumber;
	private String scrapName;
	private String scrapPriceUnit;
	private int scrapMaterialPriceWon;
	private int scrapWeightPerPiece;
	private String scrapUpcylingImage;
	private String mileageAccumulateStandardCode;
	public String getScrapMaterialListCode() {
		return scrapMaterialListCode;
	}
	public void setScrapMaterialListCode(String scrapMaterialListCode) {
		this.scrapMaterialListCode = scrapMaterialListCode;
	}
	public String getScrapCategoryNumber() {
		return scrapCategoryNumber;
	}
	public void setScrapCategoryNumber(String scrapCategoryNumber) {
		this.scrapCategoryNumber = scrapCategoryNumber;
	}
	public String getScrapName() {
		return scrapName;
	}
	public void setScrapName(String scrapName) {
		this.scrapName = scrapName;
	}
	public String getScrapPriceUnit() {
		return scrapPriceUnit;
	}
	public void setScrapPriceUnit(String scrapPriceUnit) {
		this.scrapPriceUnit = scrapPriceUnit;
	}
	public int getScrapMaterialPriceWon() {
		return scrapMaterialPriceWon;
	}
	public void setScrapMaterialPriceWon(int scrapMaterialPriceWon) {
		this.scrapMaterialPriceWon = scrapMaterialPriceWon;
	}
	public int getScrapWeightPerPiece() {
		return scrapWeightPerPiece;
	}
	public void setScrapWeightPerPiece(int scrapWeightPerPiece) {
		this.scrapWeightPerPiece = scrapWeightPerPiece;
	}
	public String getScrapUpcylingImage() {
		return scrapUpcylingImage;
	}
	public void setScrapUpcylingImage(String scrapUpcylingImage) {
		this.scrapUpcylingImage = scrapUpcylingImage;
	}
	public String getMileageAccumulateStandardCode() {
		return mileageAccumulateStandardCode;
	}
	public void setMileageAccumulateStandardCode(String mileageAccumulateStandardCode) {
		this.mileageAccumulateStandardCode = mileageAccumulateStandardCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapUpcylingList [scrapMaterialListCode=");
		builder.append(scrapMaterialListCode);
		builder.append(", scrapCategoryNumber=");
		builder.append(scrapCategoryNumber);
		builder.append(", scrapName=");
		builder.append(scrapName);
		builder.append(", scrapPriceUnit=");
		builder.append(scrapPriceUnit);
		builder.append(", scrapMaterialPriceWon=");
		builder.append(scrapMaterialPriceWon);
		builder.append(", scrapWeightPerPiece=");
		builder.append(scrapWeightPerPiece);
		builder.append(", scrapUpcylingImage=");
		builder.append(scrapUpcylingImage);
		builder.append(", mileageAccumulateStandardCode=");
		builder.append(mileageAccumulateStandardCode);
		builder.append("]");
		return builder.toString();
	}

	
}
