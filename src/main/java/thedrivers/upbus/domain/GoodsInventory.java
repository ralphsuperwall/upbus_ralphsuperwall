package thedrivers.upbus.domain;

/**
 * 고객 위탁 판매 목록(업체 판매 목록은 EgoodsInventory임에 유의)
 */
public class GoodsInventory {

    public String memberId;
    public int goodsRequestAmount;
    //goods_inventory 테이블 
    private String goodsInventoryCode;
	private String goodsRequestCode;
	private String goodsCategoryCode;
	private String goodsName;
	private int goodsInventoryStatus;
	private int goodsInventoryStatusCheck;
	private String goodsInventoryPrimaryDate;
	private String goodsInventoryPrimaryIncharge;
	private int goodsStatus;
	private String goodsInventoryLastCheckDate;
	private String goodsInventoryLastCheckIncharge;
	private String goodsImage;
	private int goodsPrice;
	private String goodsSalesStatus;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getGoodsRequestAmount() {
		return goodsRequestAmount;
	}
	public void setGoodsRequestAmount(int goodsRequestAmount) {
		this.goodsRequestAmount = goodsRequestAmount;
	}
	public String getGoodsInventoryCode() {
		return goodsInventoryCode;
	}
	public void setGoodsInventoryCode(String goodsInventoryCode) {
		this.goodsInventoryCode = goodsInventoryCode;
	}
	public String getGoodsRequestCode() {
		return goodsRequestCode;
	}
	public void setGoodsRequestCode(String goodsRequestCode) {
		this.goodsRequestCode = goodsRequestCode;
	}
	public String getGoodsCategoryCode() {
		return goodsCategoryCode;
	}
	public void setGoodsCategoryCode(String goodsCategoryCode) {
		this.goodsCategoryCode = goodsCategoryCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsInventoryStatus() {
		return goodsInventoryStatus;
	}
	public void setGoodsInventoryStatus(int goodsInventoryStatus) {
		this.goodsInventoryStatus = goodsInventoryStatus;
	}
	public int getGoodsInventoryStatusCheck() {
		return goodsInventoryStatusCheck;
	}
	public void setGoodsInventoryStatusCheck(int goodsInventoryStatusCheck) {
		this.goodsInventoryStatusCheck = goodsInventoryStatusCheck;
	}
	public String getGoodsInventoryPrimaryDate() {
		return goodsInventoryPrimaryDate;
	}
	public void setGoodsInventoryPrimaryDate(String goodsInventoryPrimaryDate) {
		this.goodsInventoryPrimaryDate = goodsInventoryPrimaryDate;
	}
	public String getGoodsInventoryPrimaryIncharge() {
		return goodsInventoryPrimaryIncharge;
	}
	public void setGoodsInventoryPrimaryIncharge(String goodsInventoryPrimaryIncharge) {
		this.goodsInventoryPrimaryIncharge = goodsInventoryPrimaryIncharge;
	}
	public int getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public String getGoodsInventoryLastCheckDate() {
		return goodsInventoryLastCheckDate;
	}
	public void setGoodsInventoryLastCheckDate(String goodsInventoryLastCheckDate) {
		this.goodsInventoryLastCheckDate = goodsInventoryLastCheckDate;
	}
	public String getGoodsInventoryLastCheckIncharge() {
		return goodsInventoryLastCheckIncharge;
	}
	public void setGoodsInventoryLastCheckIncharge(String goodsInventoryLastCheckIncharge) {
		this.goodsInventoryLastCheckIncharge = goodsInventoryLastCheckIncharge;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsSalesStatus() {
		return goodsSalesStatus;
	}
	public void setGoodsSalesStatus(String goodsSalesStatus) {
		this.goodsSalesStatus = goodsSalesStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsInventory [memberId=");
		builder.append(memberId);
		builder.append(", goodsRequestAmount=");
		builder.append(goodsRequestAmount);
		builder.append(", goodsInventoryCode=");
		builder.append(goodsInventoryCode);
		builder.append(", goodsRequestCode=");
		builder.append(goodsRequestCode);
		builder.append(", goodsCategoryCode=");
		builder.append(goodsCategoryCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", goodsInventoryStatus=");
		builder.append(goodsInventoryStatus);
		builder.append(", goodsInventoryStatusCheck=");
		builder.append(goodsInventoryStatusCheck);
		builder.append(", goodsInventoryPrimaryDate=");
		builder.append(goodsInventoryPrimaryDate);
		builder.append(", goodsInventoryPrimaryIncharge=");
		builder.append(goodsInventoryPrimaryIncharge);
		builder.append(", goodsStatus=");
		builder.append(goodsStatus);
		builder.append(", goodsInventoryLastCheckDate=");
		builder.append(goodsInventoryLastCheckDate);
		builder.append(", goodsInventoryLastCheckIncharge=");
		builder.append(goodsInventoryLastCheckIncharge);
		builder.append(", goodsImage=");
		builder.append(goodsImage);
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append(", goodsSalesStatus=");
		builder.append(goodsSalesStatus);
		builder.append("]");
		return builder.toString();
	}
   
}
