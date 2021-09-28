package thedrivers.upbus.mapper;

import org.apache.ibatis.annotations.Mapper;
import thedrivers.upbus.domain.GoodsCategoryMain;
import thedrivers.upbus.domain.GoodsRequest;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<GoodsCategoryMain> getGoodsCategoryMainList();
    int goodsRequest(GoodsRequest goodsRequest);
    int getGoodsRequestAmount(String memberId);
}
