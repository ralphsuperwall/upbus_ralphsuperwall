package thedrivers.upbus.mapper;

import org.apache.ibatis.annotations.Mapper;
import thedrivers.upbus.domain.GoodsCategoryMain;
import thedrivers.upbus.domain.GoodsCategorySub;
import thedrivers.upbus.domain.GoodsRequest;


import java.util.List;

@Mapper
public interface GoodsMapper {

    List<GoodsCategoryMain> getGoodsCategoryMainList();
    List<GoodsCategorySub> getGoodsCategorySubList(String goodsMainCategory);
    List<GoodsRequest> getGoodsRequest0();
    List<GoodsRequest> getGoodsRequest1();
    String getGoodsRequestCode();
    int firstApproval(String goodsRequestCode);
    int firstDisapproval(String goodsRequestCode);
    int goodsRequest(GoodsRequest goodsRequest);
    int getGoodsRequestAmount(String memberId);
}
