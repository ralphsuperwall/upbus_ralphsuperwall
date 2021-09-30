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
	
	@GetMapping("/ProcedureManage")
	public String procedureManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 절차 관리");
		return pageType+"/ProcedureManage";
	}
	//업사이클링 재료 판매 신청서 리스트
	@GetMapping("/ListManage")
	public String listManage(Model model) {
		System.out.println("ListManage 컨트롤러 실행 ");
		
		List<ScrapSaleRequest> scrapSaleRequestList = scrapService.getScrapSale();		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 목록 관리");
		model.addAttribute("scrapRequestList", scrapSaleRequestList);
		return pageType+"/ListManage";
	}
	
	@GetMapping("/PaymentManage")
	public String paymentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 결제 관리");
		return pageType+"/PaymentManage";
	}
	
	@GetMapping("/ScrapRequest") 
	public String scrapRequest(@RequestParam(name="scrapSaleRequestCode", required = false) String scrapSaleRequestCode
								,Model model ) {
		// scrapSaleRequestCode 값 받아서 db select
		ScrapSaleRequest scrapSaleRequestDetailList = scrapService.getScrapSaleDetail(scrapSaleRequestCode);
		 
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text","업사이클링 재료  관리"); 
		model.addAttribute("scrapSaleRequestDetailList", scrapSaleRequestDetailList); 
		
		System.out.println(scrapSaleRequestDetailList);
		
		return pageType+"/ScrapRequest"; 
	}
	
	@PostMapping(value = "/ScrapRequestApprovalAjax", produces = "application/json") 
	@ResponseBody
	public Map<String,Object> ScrapRequestApprovalAjax(Model model, ScrapSaleRequest scrapSaleRequest) {		
		Map<String,Object> map = new HashMap<String,Object>();		
		map.put("result", scrapService.scrapSaleApprovalModify(scrapSaleRequest));	
		return map; 
	}
	 
}
