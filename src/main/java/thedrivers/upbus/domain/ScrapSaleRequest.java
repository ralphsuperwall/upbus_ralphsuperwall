package thedrivers.upbus.domain;

public class ScrapSaleRequest {
	private String scrapRequestCode;
	private String scrapMaterialListCode;
	private String scrapMemberId;
	private int scrapRequestAmount;
	private String scrapRequestImage;
	private String scrapRequestDate;
	private int scrapRequestResult;
	private String scrapShippingOutAddr;
	private String scrapShippingInAddr;
	private String scrapLogisticsName;
	private String scrapLogisticsNumber;
	private ScrapUpcylingList scrapUpcylingList;
	public String getScrapRequestCode() {
		return scrapRequestCode;
	}
	public void setScrapRequestCode(String scrapRequestCode) {
		this.scrapRequestCode = scrapRequestCode;
	}
	public String getScrapMaterialListCode() {
		return scrapMaterialListCode;
	}
	public void setScrapMaterialListCode(String scrapMaterialListCode) {
		this.scrapMaterialListCode = scrapMaterialListCode;
	}
	public String getScrapMemberId() {
		return scrapMemberId;
	}
	public void setScrapMemberId(String scrapMemberId) {
		this.scrapMemberId = scrapMemberId;
	}
	public int getScrapRequestAmount() {
		return scrapRequestAmount;
	}
	public void setScrapRequestAmount(int scrapRequestAmount) {
		this.scrapRequestAmount = scrapRequestAmount;
	}
	public String getScrapRequestImage() {
		return scrapRequestImage;
	}
	public void setScrapRequestImage(String scrapRequestImage) {
		this.scrapRequestImage = scrapRequestImage;
	}
	public String getScrapRequestDate() {
		return scrapRequestDate;
	}
	public void setScrapRequestDate(String scrapRequestDate) {
		this.scrapRequestDate = scrapRequestDate;
	}
	public int getScrapRequestResult() {
		return scrapRequestResult;
	}
	public void setScrapRequestResult(int scrapRequestResult) {
		this.scrapRequestResult = scrapRequestResult;
	}
	public String getScrapShippingOutAddr() {
		return scrapShippingOutAddr;
	}
	public void setScrapShippingOutAddr(String scrapShippingOutAddr) {
		this.scrapShippingOutAddr = scrapShippingOutAddr;
	}
	public String getScrapShippingInAddr() {
		return scrapShippingInAddr;
	}
	public void setScrapShippingInAddr(String scrapShippingInAddr) {
		this.scrapShippingInAddr = scrapShippingInAddr;
	}
	public String getScrapLogisticsName() {
		return scrapLogisticsName;
	}
	public void setScrapLogisticsName(String scrapLogisticsName) {
		this.scrapLogisticsName = scrapLogisticsName;
	}
	public String getScrapLogisticsNumber() {
		return scrapLogisticsNumber;
	}
	public void setScrapLogisticsNumber(String scrapLogisticsNumber) {
		this.scrapLogisticsNumber = scrapLogisticsNumber;
	}
	public ScrapUpcylingList getScrapUpcylingList() {
		return scrapUpcylingList;
	}
	public void setScrapUpcylingList(ScrapUpcylingList scrapUpcylingList) {
		this.scrapUpcylingList = scrapUpcylingList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapSaleRequest [scrapRequestCode=");
		builder.append(scrapRequestCode);
		builder.append(", scrapMaterialListCode=");
		builder.append(scrapMaterialListCode);
		builder.append(", scrapMemberId=");
		builder.append(scrapMemberId);
		builder.append(", scrapRequestAmount=");
		builder.append(scrapRequestAmount);
		builder.append(", scrapRequestImage=");
		builder.append(scrapRequestImage);
		builder.append(", scrapRequestDate=");
		builder.append(scrapRequestDate);
		builder.append(", scrapRequestResult=");
		builder.append(scrapRequestResult);
		builder.append(", scrapShippingOutAddr=");
		builder.append(scrapShippingOutAddr);
		builder.append(", scrapShippingInAddr=");
		builder.append(scrapShippingInAddr);
		builder.append(", scrapLogisticsName=");
		builder.append(scrapLogisticsName);
		builder.append(", scrapLogisticsNumber=");
		builder.append(scrapLogisticsNumber);
		builder.append(", scrapUpcylingList=");
		builder.append(scrapUpcylingList);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
