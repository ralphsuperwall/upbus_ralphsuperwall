package thedrivers.upbus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import thedrivers.upbus.domain.GoodsCategoryMain;
import thedrivers.upbus.domain.GoodsRequest;
import thedrivers.upbus.service.GoodsService;

import java.util.List;

@RequestMapping("/user/goods")
@Controller
public class GoodsController {

	String pageType = "user/goods";

	private final GoodsService goodsService;

	public GoodsController(GoodsService goodsService) {
			this.goodsService = goodsService;
		}


	/**
	 * 고객 위탁 판매 MySell 페이지
	 */
	@GetMapping("/MySell")
	public String goodsRequest(Model model) {

        /*아이디
        String sellerId = (String) session.getAttribute("SID");*/

		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "내가 만든 업사이클링 상품 판매 위탁하기");
		return pageType+"/MySell";

	}

	/**
	 * 고객 위탁 판매 MySell에서 고객이 상품 내용을 기입하고 신청하는 기능
	 */
	@GetMapping("/goodsSellerRequest")
	public String goodsRequest(GoodsRequest goodsRequest) {
		System.out.println(goodsRequest);
		goodsService.goodsRequest(goodsRequest);
		return "redirect:/MySell";
	}

	/**
	 * 고객 위탁 판매 MySell에서 고객이 상품 카테고리를 선택할 때 데이터베이스의 상품 카테고리를 불러오는 기능
	 */
	@RequestMapping("/MySell")
	public String getGoodsCategoryMainList(Model model) {
		List<GoodsCategoryMain> goodsCategoryMainList = goodsService.getGoodsCategoryMainList();

		model.addAttribute("goodsCategoryMainList", goodsCategoryMainList);
		model.addAttribute("h1text", "내가 만든 업사이클링 상품 판매 위탁하기");
		return pageType+"/MySell";
	}

	/**
	 * 고객 위탁 판매 MySell에서 고객이 판매 상품 개수를 입력하면 현재 판매중인 상품의 개수를 더해 기준치 10을 초과하는지 확인하는 기능
	 */
	@GetMapping(value = "/MySell", produces = "application/json")
	@ResponseBody
	public int amountCheck(@RequestParam("goodsRequestAmount") int goodsRequestAmount,
						   @RequestParam("goodsSellerId") String memberId) {
		/* int sellingGoodsAmount = goodsRequestService.getGoodsRequestAmount(memberId);*/
		int sellingGoodsAmount = 4; //테스트를 위한 임의의 값. 뷰에서 받은 아이디로 검색했을 때 판매중인 상품의 개수가 4개라고 가정
		int requestedGoodsAmount = goodsRequestAmount;
		int checkResult = sellingGoodsAmount + requestedGoodsAmount;

		return checkResult;
	}

	
	@GetMapping("/EnterpriseList")
	public String enterpriseList(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "기업 판매 상품 목록");
		return pageType+"/EnterpriseList";
	}
	
	@GetMapping("/MemberList")
	public String memberList(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "위탁 판매 상품 목록");
		return pageType+"/MemberList";
	}

	@GetMapping("/Order")
	public String order(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "상품 주문");
		return pageType+"/Order";
	}
	@GetMapping("/OrderList")
	public String orderList(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "주문 현황");
		return pageType+"/OrderList";
	}

}
