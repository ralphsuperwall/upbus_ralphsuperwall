package thedrivers.upbus.mapper;

import org.apache.ibatis.annotations.Mapper;

import thedrivers.upbus.domain.GoodsCategoryMain;
import thedrivers.upbus.domain.GoodsCategorySub;
import thedrivers.upbus.domain.GoodsInventory;
import thedrivers.upbus.domain.GoodsRequest;
import thedrivers.upbus.domain.Member;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<GoodsCategoryMain> getGoodsCategoryMainList();
    List<GoodsCategorySub> getGoodsCategorySubList(String goodsMainCategory);
    List<GoodsRequest> getGoodsRequest0();
    List<GoodsRequest> getGoodsRequest1();
    List<GoodsRequest> getGoodsRequest2();
    List<GoodsRequest> mySellStatus(String memberId);
    List<Member> getApplyMember(String memberId);
    String getGoodsRequestCode();
    int firstApproval(String goodsRequestCode);
    int firstDisapproval(String goodsRequestCode);
    int secondApproval(String goodsRequestCode);
    int secondDisapproval(String goodsRequestCode);
    int goodsRequest(GoodsRequest goodsRequest);
    int getGoodsRequestAmount(String memberId);
	// 개인위탁판매 재고 리스트 조회
	public List<GoodsInventory> getGoodsInventory();

}
