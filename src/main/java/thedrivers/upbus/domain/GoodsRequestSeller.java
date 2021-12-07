package thedrivers.upbus.domain;

public class GoodsRequestSeller {

    private String goodsRequestCode;
    private String goodsSellerName;
    private String goodsSellerAddress;
    private String goodsSellerPhone;

    public String getGoodsRequestCode() {
        return goodsRequestCode;
    }

    public void setGoodsRequestCode(String goodsRequestCode) {
        this.goodsRequestCode = goodsRequestCode;
    }

    public String getGoodsSellerName() {
        return goodsSellerName;
    }

    public void setGoodsSellerName(String goodsSellerName) {
        this.goodsSellerName = goodsSellerName;
    }

    public String getGoodsSellerAddress() {
        return goodsSellerAddress;
    }

    public void setGoodsSellerAddress(String goodsSellerAddress) {
        this.goodsSellerAddress = goodsSellerAddress;
    }

    public String getGoodsSellerPhone() {
        return goodsSellerPhone;
    }

    public void setGoodsSellerPhone(String goodsSellerPhone) {
        this.goodsSellerPhone = goodsSellerPhone;
    }

    @Override
    public String toString() {
        return "GoodsRequestSeller{" +
                "goodsRequestCode='" + goodsRequestCode + '\'' +
                ", goodsSellerName='" + goodsSellerName + '\'' +
                ", goodsSellerAddress='" + goodsSellerAddress + '\'' +
                ", goodsSellerPhone='" + goodsSellerPhone + '\'' +
                '}';
    }
}
