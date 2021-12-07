package thedrivers.upbus.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import thedrivers.upbus.domain.GoodsRequest;
import thedrivers.upbus.service.GoodsService;

import thedrivers.upbus.domain.GoodsInventory;

@RequestMapping("/admin/goods")
@Controller
public class GoodsController {
	

	String pageType = "admin/goods";

	private final GoodsService goodsService;

	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * 현재 승인 대기 중인 위탁 판매 상품의 리스트를 확인하고 승인, 재고 등록, 승인 거절 처리를 하는 기능
	 */
	@GetMapping("/MemberSellManage")
	public String getGoodsRequestList(Model model){

		List<GoodsRequest> goodsRequestList0 = goodsService.getGoodsRequest0();
		List<GoodsRequest> goodsRequestList1 = goodsService.getGoodsRequest1();
		List<GoodsRequest> goodsRequestList2 = goodsService.getGoodsRequest2();
		model.addAttribute("title", "승인 대기 중 위탁 판매 신청");
		model.addAttribute("goodsRequestList0", goodsRequestList0);
		model.addAttribute("goodsRequestList1", goodsRequestList1);
		model.addAttribute("goodsRequestList2", goodsRequestList2);
		return pageType+"/MemberSellManage";
	}

	/**
	 * 위탁 판매 관리 시스템 : 1단계 처리(고객의 위탁 판매를 승인)하는 기능
	 * firstApproval - 1단계 처리 승인, firstDisapproval - 거절
	 */
	@GetMapping("/MemberSellManage/firstApproval/{goodsRequestCode}")
	public String firstApproval(@PathVariable String goodsRequestCode) {
		goodsService.firstApproval(goodsRequestCode);
		return "redirect:/admin/goods/MemberSellManage";
	}

	@GetMapping("/MemberSellManage/firstDisapproval/{goodsRequestCode}")
	public String firstDisapproval(@PathVariable String goodsRequestCode) {
		goodsService.firstDisapproval(goodsRequestCode);
		return "redirect:/admin/goods/MemberSellManage";
	}

	/**
	 * 위탁 판매 관리 시스템 : 2단계 처리(고객이 발송한 상품을 확인하고 재고화 승인)하는 기능
	 * firstApproval - 2단계 처리 승인, firstDisapproval - 재고화 불가 : 고객 반송
	 */
	@GetMapping("/MemberSellManage/secondApproval/{goodsRequestCode}")
	public String secondApproval(@PathVariable String goodsRequestCode) {
		goodsService.secondApproval(goodsRequestCode);
		return "redirect:/admin/goods/MemberSellManage";
	}

	@GetMapping("/MemberSellManage/secondDisapproval/{goodsRequestCode}")
	public String secondDisapproval(@PathVariable String goodsRequestCode) {
		goodsService.secondDisapproval(goodsRequestCode);
		return "redirect:/admin/goods/MemberSellManage";
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
	@GetMapping("/MemberSellInventory")
	public String MemberSellInventory(Model model) {
		List<GoodsInventory> goodsInventoryList = goodsService.getGoodsInventory();
		model.addAttribute("goodsInventoryList", goodsInventoryList);
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "위탁 판매 상품 결제 관리");
		return pageType+"/MemberSellInventory";
	}
}
