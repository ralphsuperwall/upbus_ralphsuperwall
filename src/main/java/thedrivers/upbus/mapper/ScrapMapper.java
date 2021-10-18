package thedrivers.upbus.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import thedrivers.upbus.domain.ScrapListInventory;
import thedrivers.upbus.domain.ScrapSale;
import thedrivers.upbus.domain.ScrapSaleRequest;

@Mapper
public interface ScrapMapper {
	// 1.업사이클링 재료 판매 신청서 목록 조회
	public List<ScrapSaleRequest> getScrapSale();
	// 1-2 업사이클링 재료 판매 신청서 상세 조회
	public ScrapSaleRequest getScrapSaleDetail(String scrapRequestCode);
	// 2.업사이클링 재료 판매 신청서 승인	
	public int scrapSaleApprovalModify(ScrapSaleRequest scrapSaleRequest);
	// 3.업사이클링 재료 재고 리스트
	public List<ScrapListInventory> getScrapList();
	// 4.업사이클링 매입 확정 리스트
	public List<ScrapSale> getSaleList();
	// 5.업사이클링 매입 확정 버튼 승인
	public int scrapSaleAmountApprovalModify(ScrapSale scrapSale);
}
