package thedrivers.upbus.domain;

public class UpcylingMaterialList {
	private String upcylingMaterialListCode;
	private int scrapCategoryNumber;
	private String materialName;
	public String getUpcylingMaterialListCode() {
		return upcylingMaterialListCode;
	}
	public void setUpcylingMaterialListCode(String upcylingMaterialListCode) {
		this.upcylingMaterialListCode = upcylingMaterialListCode;
	}
	public int getScrapCategoryNumber() {
		return scrapCategoryNumber;
	}
	public void setScrapCategoryNumber(int scrapCategoryNumber) {
		this.scrapCategoryNumber = scrapCategoryNumber;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpcylingMaterialList [upcylingMaterialListCode=");
		builder.append(upcylingMaterialListCode);
		builder.append(", scrapCategoryNumber=");
		builder.append(scrapCategoryNumber);
		builder.append(", materialName=");
		builder.append(materialName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
