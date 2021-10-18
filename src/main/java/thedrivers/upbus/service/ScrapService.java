package thedrivers.upbus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thedrivers.upbus.domain.ScrapListInventory;
import thedrivers.upbus.domain.ScrapSale;
import thedrivers.upbus.domain.ScrapSaleRequest;
import thedrivers.upbus.mapper.ScrapMapper;

@Service
@Transactional
public class ScrapService {
	
	
	private static final Logger log = LoggerFactory.getLogger(ScrapService.class);

	
	private final ScrapMapper scrapMapper;
	//매퍼 연결
	public ScrapService(ScrapMapper scrapMapper) {
		this.scrapMapper = scrapMapper;
	}
	//업사이클링 재고 리스트
	public List<ScrapListInventory> getScrapList(){
		List<ScrapListInventory> scrapList = scrapMapper.getScrapList();
		log.info("업사이클링 재고 리스트: {}", scrapList);
		return scrapList;
	}
	//업사이클링 재료 판매 신청 목록
	public List<ScrapSaleRequest> getScrapSale(){
		System.out.println("ListManage 서비스 실행 ");

		List<ScrapSaleRequest> scrapSaleRequestList = scrapMapper.getScrapSale();
		log.info("업사이클링 재료신청서 리스트: {}", scrapSaleRequestList);
		return	scrapSaleRequestList;
	}
	// 업사이클링 재료 매입 확정 리스트
	public List<ScrapSale> getSaleList(){
		List<ScrapSale> saleList = scrapMapper.getSaleList();
		return saleList;
	}
	// 업사이클링 재료 판매 신청서 상세페이지 이동시 scrapSaleRequestCode로 값 받아오긴
	public ScrapSaleRequest getScrapSaleDetail(String scrapRequestCode){
		ScrapSaleRequest scrapSaleRequestDetailList = scrapMapper.getScrapSaleDetail(scrapRequestCode);
		return scrapSaleRequestDetailList;
	}
	// 업사이클링 재료 판매 신청서 승인 버튼 ajax
	public int scrapSaleApprovalModify(ScrapSaleRequest scrapSaleRequest) {
		return scrapMapper.scrapSaleApprovalModify(scrapSaleRequest);
	}
	// 업사이클링 매입 확정 버튼 ajax
	public int scrapSaleAmountApprovalModify(ScrapSale scrapSale) {
		return scrapMapper.scrapSaleAmountApprovalModify(scrapSale);
	}
	}
