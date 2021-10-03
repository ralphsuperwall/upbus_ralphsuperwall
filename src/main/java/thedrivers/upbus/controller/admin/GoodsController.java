package thedrivers.upbus.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thedrivers.upbus.domain.GoodsInventory;
import thedrivers.upbus.service.GoodsService;

@RequestMapping("/admin/goods")
@Controller
public class GoodsController {
	
	private final GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	String pageType = "admin/goods";
	
	@GetMapping("/ApplicationManage")
	public String applicationManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "위탁 판매 상품 신청 관리");
		return pageType+"/ApplicationManage";
	}
	//개인위탁판매 재고 리스트
	@GetMapping("/MemberSellManage")
	public String memberSellManage(Model model) {
		System.out.println("MemberSellManage 컨트롤러 실행");
		List<GoodsInventory> goodsInventoryList = goodsService.getGoodsInventory();
		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "위탁 판매 상품 판매 관리");
		model.addAttribute("goodsInventoryList", goodsInventoryList);
		return pageType+"/MemberSellManage";
	}
	
	@GetMapping("/EnterpriseSellManage")
	public String EnterpriseSellManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "기업 판매 상품 판매 관리");
		return pageType+"/EnterpriseSellManage";
	}
	
	@GetMapping("/EnterprisePaymentManage")
	public String enterprisePaymentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "기업 판매 상품 결제 관리");
		return pageType+"/EnterprisePaymentManage";
	}
	@GetMapping("/MemberPaymentManage")
	public String memberPaymentManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "위탁 판매 상품 결제 관리");
		return pageType+"/MemberPaymentManage";
	}
}
