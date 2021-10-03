package thedrivers.upbus.domain;

public class GoodsCategorySub {
    private String goodsCategorySubCode;
    private String goodsCategoryMainCode;
    private String goodsCategorySubName;

    public String getGoodsCategorySubCode() {
        return goodsCategorySubCode;
    }

    public void setGoodsCategorySubCode(String goodsCategorySubCode) {
        this.goodsCategorySubCode = goodsCategorySubCode;
    }

    public String getGoodsCategoryMainCode() {
        return goodsCategoryMainCode;
    }

    public void setGoodsCategoryMainCode(String goodsCategoryMainCode) {
        this.goodsCategoryMainCode = goodsCategoryMainCode;
    }

    public String getGoodsCategorySubName() {
        return goodsCategorySubName;
    }

    public void setGoodsCategorySubName(String goodsCategorySubName) {
        this.goodsCategorySubName = goodsCategorySubName;
    }

    @Override
    public String toString() {
        return "GoodCategorySub{" +
                "goodsCategorySubCode='" + goodsCategorySubCode + '\'' +
                ", goodsCategoryMainCode='" + goodsCategoryMainCode + '\'' +
                ", goodsCategorySubName='" + goodsCategorySubName + '\'' +
                '}';
    }
}
