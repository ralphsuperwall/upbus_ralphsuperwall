package thedrivers.upbus.domain;

/**
 * MySell에서 현재 지정된 카테고리 범주 불러오기
 */
public class GoodsCategoryMain {

    private String goodsCategoryMainCode;
    private String goodsCategoryMainName;

    public String getGoodsCategoryMainCode() {
        return goodsCategoryMainCode;
    }

    public void setGoodsCategoryMainCode(String goodsCategoryMainCode) {
        this.goodsCategoryMainCode = goodsCategoryMainCode;
    }

    public String getGoodsCategoryMainName() {
        return goodsCategoryMainName;
    }

    public void setGoodsCategoryMainName(String goodsCategoryMainName) {
        this.goodsCategoryMainName = goodsCategoryMainName;
    }

    @Override
    public String toString() {
        return "GoodCategoryMain{" +
                "goodsCategoryMainCode='" + goodsCategoryMainCode + '\'' +
                ", goodsCategoryMainName='" + goodsCategoryMainName + '\'' +
                '}';
    }
}