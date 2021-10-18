package thedrivers.upbus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thedrivers.upbus.domain.GoodsCategorySub;
import thedrivers.upbus.domain.Egoods;
import thedrivers.upbus.domain.GoodsCategoryMain;
import thedrivers.upbus.domain.GoodsRequest;
import thedrivers.upbus.service.GoodsService;
import java.util.List;

@Controller
@RequestMapping("/user/goods")
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

        /*아이디를 세션에서 받아와야 함 - 회원 테이블 연동 후
        String sellerId = (String) session.getAttribute("SID");*/

		/**
		 * 고객 위탁 판매 MySell에서 자동으로 상품코드를 부여함
		 */
		String goodsRequestCode = goodsService.getGoodsRequestCode();

		/**
		 * 고객 위탁 판매 MySell에서 고객이 상품 카테고리를 선택할 때 데이터베이스의 상품 카테고리를 불러오는 기능
		 */
		List<GoodsCategoryMain> goodsCategoryMainList = goodsService.getGoodsCategoryMainList();

		model.addAttribute("goodsRequestCode", goodsRequestCode);
		model.addAttribute("goodsCategoryMainList", goodsCategoryMainList);
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "내가 만든 업사이클링 상품 판매 위탁하기");
		return pageType+"/MySell";

	}

	/**
	 * 고객 위탁 판매 MySell에서 고객이 상품 내용을 기입하고 신청하는 기능
	 */
	@GetMapping("/MySell/goodsSellerRequest")
	public String goodsRequest(GoodsRequest goodsRequest) {
		goodsService.goodsRequest(goodsRequest);
		System.out.println(goodsRequest);
		return "redirect:/user/goods/MySell";
	}


	/**
	 * 고객 위탁 판매 MySell에서 고객이 판매 상품 개수를 입력하면 현재 판매중인 상품의 개수를 더해 기준치 10을 초과하는지 확인하는 기능
	 */
	@GetMapping(value = "user/goods/MySell", produces = "application/json")
	@ResponseBody
	public int amountCheck(@RequestParam("goodsRequestAmount") int goodsRequestAmount,
						   @RequestParam("goodsSellerId") String memberId) {
		/*int sellingGoodsAmount = goodsService.getGoodsRequestAmount(memberId);*/
		int sellingGoodsAmount = 2;
		int requestedGoodsAmount = goodsRequestAmount;
		int checkResult = sellingGoodsAmount + requestedGoodsAmount;

		return checkResult;
	}
	/*@GetMapping("user/goods/MySell/{code}")
	public String getMySell(@PathVariable(value = "service") String service){
		if(service.equals(""))

		return "";
	}*/

	@GetMapping(value = "user/goods/MySell/GetSubCategory", produces = "application/json")
	@ResponseBody
	public List<GoodsCategorySub> getGoodsCategorySubList(@RequestParam("goodsMainCategory")
																	 String goodsMainCategory){

		List<GoodsCategorySub> goodsCategorySubList = goodsService.getGoodsCategorySubList(goodsMainCategory);
		return goodsCategorySubList;
	}

	
	@GetMapping("/EnterpriseList")
	public String goodsRequest1(Model model) {
		
		/*아이디를 세션에서 받아와야 함 - 회원 테이블 연동 후
        String sellerId = (String) session.getAttribute("SID");*/
		
		/**
		 * 고객 위탁 판매 MySell에서 자동으로 상품코드를 부여함
		 */
		String goodsRequestCode = goodsService.getGoodsRequestCode();
		
		/**
		 * 고객 위탁 판매 MySell에서 고객이 상품 카테고리를 선택할 때 데이터베이스의 상품 카테고리를 불러오는 기능
		 */
		List<GoodsCategoryMain> goodsCategoryMainList = goodsService.getGoodsCategoryMainList();
		
		model.addAttribute("goodsRequestCode", goodsRequestCode);
		model.addAttribute("goodsCategoryMainList", goodsCategoryMainList);
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "내가 만든 업사이클링 상품 판매 위탁하기");
		List<Egoods> egoodsList = goodsService.getEgoodsList();
		
		model.addAttribute("egoodsList", egoodsList);
		return pageType+"/EnterpriseList";
		
	}
	
	/**
	 * 고객 위탁 판매 MySell에서 고객이 상품 내용을 기입하고 신청하는 기능
	 */
	@GetMapping("/EnterpriseList/goodsSellerRequest")
	public String goodsRequest1(GoodsRequest goodsRequest) {
		goodsService.goodsRequest(goodsRequest);
		System.out.println(goodsRequest);
		return "redirect:/user/goods/EnterpriseList";
	}
	
	
	/**
	 * 고객 위탁 판매 MySell에서 고객이 판매 상품 개수를 입력하면 현재 판매중인 상품의 개수를 더해 기준치 10을 초과하는지 확인하는 기능
	 */
	@GetMapping(value = "user/goods/EnterpriseList", produces = "application/json")
	@ResponseBody
	public int amountCheck1(@RequestParam("goodsRequestAmount") int goodsRequestAmount,
			@RequestParam("goodsSellerId") String memberId) {
		/*int sellingGoodsAmount = goodsService.getGoodsRequestAmount(memberId);*/
		int sellingGoodsAmount = 2;
		int requestedGoodsAmount = goodsRequestAmount;
		int checkResult = sellingGoodsAmount + requestedGoodsAmount;
		
		return checkResult;
	}
	/*@GetMapping("user/goods/MySell/{code}")
	public String getMySell(@PathVariable(value = "service") String service){
		if(service.equals(""))

		return "";
	}*/
	
	@GetMapping(value = "user/goods/EnterpriseList/GetSubCategory", produces = "application/json")
	@ResponseBody
	public List<GoodsCategorySub> getGoodsCategorySubList1(@RequestParam("goodsMainCategory")
	String goodsMainCategory){
		
		List<GoodsCategorySub> goodsCategorySubList = goodsService.getGoodsCategorySubList(goodsMainCategory);
		return goodsCategorySubList;
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

