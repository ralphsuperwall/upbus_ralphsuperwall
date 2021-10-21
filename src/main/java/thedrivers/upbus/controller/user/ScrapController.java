package thedrivers.upbus.controller.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import thedrivers.upbus.domain.GoodsCategorySub;
import thedrivers.upbus.domain.ScrapCategory;
import thedrivers.upbus.domain.ScrapSaleRequest;
import thedrivers.upbus.domain.ScrapUpcylingList;
import thedrivers.upbus.service.ScrapService;

@RequestMapping("/user/scrap")
@Controller
public class ScrapController {

	String pageType = "user/scrap";
	
	private final ScrapService scrapService;
	
	public ScrapController(ScrapService scrapService) {
		this.scrapService = scrapService;
	}
	
	
	@GetMapping("/List")
	public String list(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 목록");
		return pageType+"/List";
	}
	@GetMapping("/Application")
	public String application(Model model) {	
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 신청");
		return pageType+"/Application";
	}
	@GetMapping("/Sell")
	public String sell(Model model, ScrapSaleRequest scrapSaleRequest) {
		// 업사이클링 재료 판매 신청서 자동으로 상품 코드 넣기
		String scrapRequestCode = scrapService.getscrapRequestCode();
		//Sell에서 대분류 카테고리를 선택하면 카테고리를 불러옴
		List<ScrapCategory> scrapCategory = scrapService.getScrapCategoryList();
		
		model.addAttribute("scrapRequestCode", scrapRequestCode);
		model.addAttribute("scrapCategory", scrapCategory);
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 판매");
		return pageType+"/Sell";
	}
	@GetMapping("/Sell/scrapSeleRequest")
	public String scrapRequest(ScrapSaleRequest scrapSaleRequest) {
		scrapService.scrapSaleRequest(scrapSaleRequest);
		return "redirect:/user/scrap/Sell";
	}
	@GetMapping(value = "user/scrap/Sell/GetScrapSubCategory", produces = "application/json")
	@ResponseBody
	public List<ScrapUpcylingList> getScrapCategorySubList(@RequestParam("scrapCategory")
																	 String scrapCategory){

		List<ScrapUpcylingList> scrapCategorySubList = scrapService.getScrapCategorySubList(scrapCategory);
		return scrapCategorySubList;
	}
	@GetMapping("/Buy")
	public String buy(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "업사이클링 재료 구매");
		return pageType+"/Buy";
	}
	

}
