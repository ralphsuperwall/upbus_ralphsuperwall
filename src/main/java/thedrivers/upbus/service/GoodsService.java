package thedrivers.upbus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thedrivers.upbus.domain.GoodsCategoryMain;
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

    public List<GoodsCategoryMain> getGoodsCategoryMainList(){
        List<GoodsCategoryMain> goodsCategoryMainList = goodsMapper.getGoodsCategoryMainList();
        return goodsCategoryMainList;

    }

}