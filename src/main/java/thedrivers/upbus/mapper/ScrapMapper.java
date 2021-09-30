package thedrivers.upbus.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import thedrivers.upbus.domain.ScrapSaleRequest;

@Mapper
public interface ScrapMapper {
	// 1.업사이클링 재료 판매 신청서 목록 조회
	public List<ScrapSaleRequest> getScrapSale();
	// 1-2 업사이클링 재료 판매 신청서 상세 조회
	public ScrapSaleRequest getScrapSaleDetail(String scrapSaleRequestCode);

	
	// 2.업사이클링 재료 판매 신청서 승인
	
	public int scrapSaleApprovalModify(ScrapSaleRequest scrapSaleRequest);
	
}
