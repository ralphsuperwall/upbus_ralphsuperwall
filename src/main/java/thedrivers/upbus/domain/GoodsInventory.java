package thedrivers.upbus.domain;

/**
 * 고객 위탁 판매 목록(업체 판매 목록은 EgoodsInventory임에 유의)
 */
public class GoodsInventory {

    public String memberId;
    public int goodsRequestAmount;

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
}
