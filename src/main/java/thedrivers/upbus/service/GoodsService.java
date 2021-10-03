package thedrivers.upbus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thedrivers.upbus.domain.GoodsCategoryMain;
import thedrivers.upbus.domain.GoodsCategorySub;
import thedrivers.upbus.domain.GoodsInventory;
import thedrivers.upbus.domain.GoodsRequest;
import thedrivers.upbus.mapper.GoodsMapper;

import java.util.List;

@Service
@Transactional
public class GoodsService {

    private static final Logger log = LoggerFactory.getLogger(GoodsService.class);

    private final GoodsMapper goodsMapper;

    public GoodsService(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    public int goodsRequest(GoodsRequest goodsRequest) {
        return goodsMapper.goodsRequest(goodsRequest);
    }

    public int getGoodsRequestAmount(String memberId){
        return goodsMapper.getGoodsRequestAmount(memberId);
    }

    public String getGoodsRequestCode() {
        return goodsMapper.getGoodsRequestCode();
    }

    public List<GoodsCategoryMain> getGoodsCategoryMainList(){
        List<GoodsCategoryMain> goodsCategoryMainList = goodsMapper.getGoodsCategoryMainList();
        return goodsCategoryMainList;
    }

    public List<GoodsCategorySub> getGoodsCategorySubList(String goodsMainCategory){
        List<GoodsCategorySub> goodsCategorySubList = goodsMapper.getGoodsCategorySubList(goodsMainCategory);
        return goodsCategorySubList;
    }
    //개인위탁판매 재고 테이블 리스트
  	public List<GoodsInventory> getGoodsInventory(){
  		System.out.println("MemberSellManage");
  		List<GoodsInventory> goodsInventoryList = goodsMapper.getGoodsInventory();
  		log.info("개인위탁판매 재고 리스트 : {}", goodsInventoryList);
  		return goodsInventoryList;
  	}

}