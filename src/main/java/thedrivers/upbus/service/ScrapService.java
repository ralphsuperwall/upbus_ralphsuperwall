package thedrivers.upbus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thedrivers.upbus.domain.ScrapSaleRequest;
import thedrivers.upbus.mapper.ScrapMapper;

@Service
@Transactional
public class ScrapService {
	
	
	private static final Logger log = LoggerFactory.getLogger(ScrapService.class);

	
	private final ScrapMapper scrapMapper;
	
	public ScrapService(ScrapMapper scrapMapper) {
		this.scrapMapper = scrapMapper;
	}
	
	public List<ScrapSaleRequest> getScrapSale(){
		System.out.println("ListManage 서비스 실행 ");

		List<ScrapSaleRequest> scrapSaleRequestList = scrapMapper.getScrapSale();
		log.info("업사이클링 재료신청서 리스트: {}", scrapSaleRequestList);
		return	scrapSaleRequestList;
	}
	
	public ScrapSaleRequest getScrapSaleDetail(String scrapSaleRequestCode){
		ScrapSaleRequest scrapSaleRequestDetailList = scrapMapper.getScrapSaleDetail(scrapSaleRequestCode);
		return scrapSaleRequestDetailList;
	}
	
	public int scrapSaleApprovalModify(ScrapSaleRequest scrapSaleRequest) {
		return scrapMapper.scrapSaleApprovalModify(scrapSaleRequest);
	}
}
