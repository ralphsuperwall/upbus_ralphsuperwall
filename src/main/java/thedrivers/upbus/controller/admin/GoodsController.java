package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thedrivers.upbus.domain.GoodsRequest;
import thedrivers.upbus.service.GoodsService;

import java.util.List;
import java.util.Map;

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
	public String getMemberList(Model model){

		//비즈니스 계층 호출
		List<GoodsRequest> goodsRequestList0 = goodsService.getGoodsRequest0();
		List<GoodsRequest> goodsRequestList1 = goodsService.getGoodsRequest1();
		//결과 Model 객체 세팅
		model.addAttribute("title", "승인 대기 중 위탁 판매 신청");
		model.addAttribute("goodsRequestList0", goodsRequestList0);
		model.addAttribute("goodsRequestList1", goodsRequestList1);
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
