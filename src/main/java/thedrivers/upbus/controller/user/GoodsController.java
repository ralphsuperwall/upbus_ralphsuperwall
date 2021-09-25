package thedrivers.upbus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/goods")
@Controller
public class GoodsController {

	String pageType = "admin/goods";
	
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
	@GetMapping("/MySell")
	public String mySell(Model model) {		
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "내 업사이클링 물품 판매");
		return pageType+"/MySell";
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
