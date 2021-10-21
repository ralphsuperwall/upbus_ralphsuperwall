package thedrivers.upbus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thedrivers.upbus.domain.ScrapCategory;
import thedrivers.upbus.domain.ScrapListInventory;
import thedrivers.upbus.domain.ScrapSale;
import thedrivers.upbus.domain.ScrapSaleRequest;
import thedrivers.upbus.domain.ScrapUpcylingList;
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
	
	public Object scrapSaleApprovalModify(ScrapSaleRequest scrapSaleRequest) {
		int result = 0;
		int scrapSaleRequestResult = 0;
		int scrapRequestAmount = scrapSaleRequest.getScrapRequestAmount();
		//신청서 승인 업데이트
		result += scrapMapper.scrapSaleApprovalModify(scrapSaleRequest);
		scrapSaleRequestResult = scrapSaleRequest.getScrapRequestResult();
		//신청서 승인 시 매입관리 입고
		System.out.println(scrapRequestAmount+"---------------------------------------------------");
		for(int i = 1; i <= scrapRequestAmount; ++i) {
			if(result > 0 && scrapSaleRequestResult > 0) {
				ScrapSale scrapSale = new ScrapSale();
				scrapSale.setScrapRequestCode(scrapSaleRequest.getScrapRequestCode());
			 result += scrapMapper.scrapSaleInsert(scrapSale);	
			}
		}
		return result;
	}
	// 업사이클링 매입 확정 버튼 ajax
	public int scrapSaleAmountApprovalModify(ScrapSale scrapSale) {
		int result = 0;
		int scrapSaleAmount = 0;
		
		//신청서 승인 업데이트
		result += scrapMapper.scrapSaleAmountApprovalModify(scrapSale);
		scrapSaleAmount = scrapSale.getScrapStatusAmount();
		//신청서 승인 시 업사이클링 재고 등록
			if(result > 0 && scrapSaleAmount > 0) {
				ScrapListInventory scrapListInventory = new ScrapListInventory();
				scrapListInventory.setScrapInventoryCode(scrapListInventory.getScrapInventoryCode());
				scrapListInventory.setScrapInventoryStatus(scrapListInventory.getScrapInventoryStatus());
				scrapListInventory.setScrapInventoryStatusCheck(scrapListInventory.getScrapInventoryStatusCheck());
				scrapListInventory.setScrapInventoryPrimaryDate(scrapListInventory.getScrapInventoryPrimaryDate());
				scrapListInventory.setScrapStatus(scrapListInventory.getScrapStatus());
				
				result += scrapMapper.scrapInventoryInsert(scrapListInventory);
			}
		
		return result;
	}
	

	//user
	//업사이클링 재료 판매 신청서 유저에서 신청해서 관ㄹ리자로 파라미터값 보내기 자동증가
	public String getscrapRequestCode() {
		return scrapMapper.getscrapRequestCode();
	}
	
	// 업사이클링 재료 판매 신청서 유저에서 신청해서 관ㄹ리자로 파라미터값 보내기 
	public int scrapSaleRequest(ScrapSaleRequest scrapSaleRequest) {
		return scrapMapper.scrapSaleRequest(scrapSaleRequest);
	}
	//스크랩 메인 카테고리
	public List<ScrapCategory> getScrapCategoryList(){
		List<ScrapCategory> scrapCategoryMainList = scrapMapper.getScrapCategoryList();
		return scrapCategoryMainList;
	}
	//스크랩 서브 카테고리
	public List<ScrapUpcylingList> getScrapCategorySubList(String scrapCategory){
		List<ScrapUpcylingList> scrapCategorySubList = scrapMapper.getScrapCategorySubList(scrapCategory);
		return scrapCategorySubList;
	}
	
}
