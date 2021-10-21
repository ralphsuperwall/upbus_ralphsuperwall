package thedrivers.upbus.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import thedrivers.upbus.domain.ScrapListInventory;
import thedrivers.upbus.domain.ScrapSale;
import thedrivers.upbus.domain.ScrapSaleRequest;
import thedrivers.upbus.service.ScrapService;

@RequestMapping("/admin/scrap")
@Controller
public class ScrapController {
	
	
	private final ScrapService scrapService;
	
	public ScrapController(ScrapService scrapService) {
		this.scrapService = scrapService;
	}
	
	String pageType = "admin/scrap";
	
	//업사이클링 재고 리스트
	@GetMapping("/ListManage")
	public String listManage(Model model) {
		
		List<ScrapListInventory> scrapList = scrapService.getScrapList();
		model.addAttribute("scrapList", scrapList);
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 재고 관리");
		return pageType+"/ListManage";
	}
	//업사이클링 재료 판매 신청서 리스트
	@GetMapping("/SaleListManage")
	public String saleListManage(Model model) {
		
		
		List<ScrapSaleRequest> scrapRequestList = scrapService.getScrapSale();		
		model.addAttribute("scrapRequestList", scrapRequestList);
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 판매 신청서 관리");
		return pageType+"/SaleListManage";
	}
	// 업사이클링 재료 입고 확정 리스트
	@GetMapping("/ScrapSaleList")
	public String scrapSaleList(Model model) {
		List<ScrapSale> saleList = scrapService.getSaleList();
		model.addAttribute("saleList", saleList);
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 매입 입고 관리");
		return pageType+"/ScrapSaleList";
	}
	
	@GetMapping("/PaymentManage")
	public String paymentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 결제 관리");
		return pageType+"/PaymentManage";
	}
	
	@GetMapping("/ScrapRequest") 
	public String scrapRequest(@RequestParam(name="scrapRequestCode", required = false) String scrapRequestCode
								,Model model ) {
		// scrapSaleRequestCode 값 받아서 db select
		ScrapSaleRequest scrapSaleRequestDetailList = scrapService.getScrapSaleDetail(scrapRequestCode);
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text","업사이클링 재료 판매 신청 상세페이지"); 
		model.addAttribute("scrapSaleRequestDetailList", scrapSaleRequestDetailList); 
		return pageType+"/ScrapRequest"; 
	}
	//업사이클링 재료 신청서 승인 버튼 ajax
	@PostMapping(value = "/ScrapRequestApprovalAjax", produces = "application/json") 
	@ResponseBody
	public Map<String,Object> ScrapRequestApprovalAjax(Model model, ScrapSaleRequest scrapSaleRequest) {	
		System.out.println(scrapSaleRequest + "-----------------------------------------------scrapSaleRequest");
		Map<String,Object> map = new HashMap<String,Object>();		
		map.put("result", scrapService.scrapSaleApprovalModify(scrapSaleRequest));

		return map; 
	}
	@PostMapping(value ="/scrapSaleApprovalAjax", produces="application/json")
	@ResponseBody
	public Map<String,Object> scrapSaleApprovalAjax(Model model, ScrapSale scrapsale){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result", scrapService.scrapSaleAmountApprovalModify(scrapsale));
		return map;
	}
}
