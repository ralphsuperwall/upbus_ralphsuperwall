package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thedrivers.upbus.domain.GoodsCategorySub;
import thedrivers.upbus.domain.GoodsRequest;
import thedrivers.upbus.domain.Shipping;
import thedrivers.upbus.service.GoodsService;
import thedrivers.upbus.service.ShippingService;

import java.util.List;

@RequestMapping("/admin/shipping")
@Controller
public class ShippingController {
	
	String pageType = "admin/shipping";
	private final ShippingService shippingService;

	public ShippingController(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	@GetMapping("/LogisticsManage")
	public String applicationManage(Model model) {
		List<Shipping> logistics = shippingService.getLogistics();
		model.addAttribute("logistics", logistics);
		return pageType+"/LogisticsManage";
	}

	@PostMapping (value = "/admin/LogisticsManage/Contract", produces = "application/json")
	@ResponseBody
	public List<Shipping> getLogisticsContract(@RequestParam(value = "logisticsContractCode") String logisticsContractCode){

		List<Shipping> logisticsContract = shippingService.getLogisticsContract(logisticsContractCode);
		System.out.println(logisticsContract);
		return logisticsContract;
	}

	@GetMapping("/StatisticsManage")
	public String statisticsManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "배송업체 계약 통계 관리");
		return pageType+"/StatisticsManage";
	}
}
