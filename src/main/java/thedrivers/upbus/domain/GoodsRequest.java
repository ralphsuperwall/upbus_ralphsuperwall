package thedrivers.upbus.domain;

/**
 * MySell에서 고객의 위탁 판매
 */
public class GoodsRequest {

    /*private int goodsRequestCode;*/
    private String goodsSellerId;
    private String goodsRequestName;
    private String goodsCategorySubCode;
    private int goodsRequestPrice;
    private int goodsRequestAmount;
    private String goodsRequestImage;
    private String goodsRequestDesc;
    private String goodsRequestDate;
    private boolean goodsRequestApproval;

    /*public int getGoodsRequestCode() {
        return goodsRequestCode;
    }
    public void setGoodsRequestCode(int goodsRequestCode) {
        this.goodsRequestCode = goodsRequestCode;
    }*/

    public String getGoodsSellerId() {
        return goodsSellerId;
    }

    public void setGoodsSellerId(String goodsSellerId) {
        this.goodsSellerId = goodsSellerId;
    }

    public String getGoodsRequestName() {
        return goodsRequestName;
    }

    public void setGoodsRequestName(String goodsRequestName) {
        this.goodsRequestName = goodsRequestName;
    }

    public String getGoodsCategorySubCode() {
        return goodsCategorySubCode;
    }

    public void setGoodsCategorySubCode(String goodsCategorySubCode) {
        this.goodsCategorySubCode = goodsCategorySubCode;
    }

    public int getGoodsRequestPrice() {
        return goodsRequestPrice;
    }

    public void setGoodsRequestPrice(int goodsRequestPrice) {
        this.goodsRequestPrice = goodsRequestPrice;
    }

    public int getGoodsRequestAmount() {
        return goodsRequestAmount;
    }

    public void setGoodsRequestAmount(int goodsRequestAmount) {
        this.goodsRequestAmount = goodsRequestAmount;
    }

    public String getGoodsRequestImage() {
        return goodsRequestImage;
    }

    public void setGoodsRequestImage(String goodsRequestImage) {
        this.goodsRequestImage = goodsRequestImage;
    }

    public String getGoodsRequestDesc() {
        return goodsRequestDesc;
    }

    public void setGoodsRequestDesc(String goodsRequestDesc) {
        this.goodsRequestDesc = goodsRequestDesc;
    }

    public String getGoodsRequestDate() {
        return goodsRequestDate;
    }

    public void setGoodsRequestDate(String goodsRequestDate) {
        this.goodsRequestDate = goodsRequestDate;
    }

    public boolean getGoodsRequestApproval() {
        return goodsRequestApproval;
    }

    public void setGoodsRequestApproval(boolean goodsRequestApproval) {
        this.goodsRequestApproval = goodsRequestApproval;
    }

    @Override
    public String toString() {
        return "GoodsRequest{" +
                /*"goodsRequestCode='" + goodsRequestCode + '\'' +*/
                ", goodsSellerId='" + goodsSellerId + '\'' +
                ", goodsRequestName='" + goodsRequestName + '\'' +
                ", goodsCategorySubCode='" + goodsCategorySubCode + '\'' +
                ", goodsRequestPrice=" + goodsRequestPrice +
                ", goodsRequestAmount=" + goodsRequestAmount +
                ", goodsRequestImage='" + goodsRequestImage + '\'' +
                ", goodsRequestDesc='" + goodsRequestDesc + '\'' +
                ", goodsRequestDate='" + goodsRequestDate + '\'' +
                ", goodsRequestApproval='" + goodsRequestApproval + '\'' +
                '}';
    }
}
