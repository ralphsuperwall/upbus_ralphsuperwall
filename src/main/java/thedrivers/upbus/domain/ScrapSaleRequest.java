package thedrivers.upbus.domain;

public class ScrapSaleRequest {
	private String scrapSaleRequestCode;
	private String upcylingMaterialListCode;
	private String memberId;
	private int scrapRequestAmount;
	private String scrapRequestDate;
	private int scrapRequestResult;
	private String shippingOutAddr;
	private String shippingInAddr;
	private String logisticsName;
	private String logisticsNumber;
	private UpcylingMaterialList upcylingMaterialList;
	
	public String getScrapSaleRequestCode() {
		return scrapSaleRequestCode;
	}
	public void setScrapSaleRequestCode(String scrapSaleRequestCode) {
		this.scrapSaleRequestCode = scrapSaleRequestCode;
	}
	public String getUpcylingMaterialListCode() {
		return upcylingMaterialListCode;
	}
	public void setUpcylingMaterialListCode(String upcylingMaterialListCode) {
		this.upcylingMaterialListCode = upcylingMaterialListCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getScrapRequestAmount() {
		return scrapRequestAmount;
	}
	public void setScrapRequestAmount(int scrapRequestAmount) {
		this.scrapRequestAmount = scrapRequestAmount;
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
	public String getShippingOutAddr() {
		return shippingOutAddr;
	}
	public void setShippingOutAddr(String shippingOutAddr) {
		this.shippingOutAddr = shippingOutAddr;
	}
	public String getShippingInAddr() {
		return shippingInAddr;
	}
	public void setShippingInAddr(String shippingInAddr) {
		this.shippingInAddr = shippingInAddr;
	}
	public String getLogisticsName() {
		return logisticsName;
	}
	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}
	public String getLogisticsNumber() {
		return logisticsNumber;
	}
	public void setLogisticsNumber(String logisticsNumber) {
		this.logisticsNumber = logisticsNumber;
	}
	
	public UpcylingMaterialList getUpcylingMaterialList() {
		return upcylingMaterialList;
	}
	public void setUpcylingMaterialList(UpcylingMaterialList upcylingMaterialList) {
		this.upcylingMaterialList = upcylingMaterialList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapSaleRequest [scrapSaleRequestCode=");
		builder.append(scrapSaleRequestCode);
		builder.append(", upcylingMaterialListCode=");
		builder.append(upcylingMaterialListCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", scrapRequestAmount=");
		builder.append(scrapRequestAmount);
		builder.append(", scrapRequestDate=");
		builder.append(scrapRequestDate);
		builder.append(", scrapRequestResult=");
		builder.append(scrapRequestResult);
		builder.append(", shippingOutAddr=");
		builder.append(shippingOutAddr);
		builder.append(", shippingInAddr=");
		builder.append(shippingInAddr);
		builder.append(", logisticsName=");
		builder.append(logisticsName);
		builder.append(", logisticsNumber=");
		builder.append(logisticsNumber);
		builder.append(", upcylingMaterialList=");
		builder.append(upcylingMaterialList);
		builder.append("]");
		return builder.toString();
	}
	
	
}
