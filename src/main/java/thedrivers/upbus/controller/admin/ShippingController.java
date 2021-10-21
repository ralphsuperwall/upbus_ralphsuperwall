package thedrivers.upbus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thedrivers.upbus.domain.GoodsCategorySub;
import thedrivers.upbus.domain.GoodsRequest;
import thedrivers.upbus.domain.Shipping;
import thedrivers.upbus.service.GoodsService;
import thedrivers.upbus.service.ShippingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@PostMapping (value = "/LogisticsManage/Contract", produces = "application/json")
	@ResponseBody
	public List<Shipping> getLogisticsContract(@RequestParam(value = "logisticsCode") String logisticsCode){

		List<Shipping> logisticsContract = shippingService.getLogisticsContract(logisticsCode);
		return logisticsContract;
	}

	@PostMapping (value = "/LogisticsManage/Renew", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getRenewCode(@RequestParam(value = "logisticsCode") String logisticsCode){

		String renewTargetCode = logisticsCode;
		String logisticsContractCode = shippingService.getLogisticsContractCode();
		Map<String, Object> renewTarget = new HashMap<String, Object>();

		renewTarget.put("logisticsContractCode", logisticsContractCode);
		renewTarget.put("renewTargetCode", logisticsCode);
		return renewTarget;
	}

	@PostMapping (value = "/LogisticsManage/NewLogistics", produces = "application/json")
	@ResponseBody
	public int getGoodsCategorySubList(@RequestParam("newLogisCode") String newLogisCode){
		int checkLogisCode = shippingService.getExistingCode(newLogisCode);
		return checkLogisCode;
	}

	@PostMapping (value = "/LogisticsManage/LogisticsDelete", produces = "application/json")
	@ResponseBody
	public int deleteLogistics(@RequestParam("logisticsCode") String logisticsCode){
		int deleteResult = shippingService.deleteLogistics(logisticsCode);
		return deleteResult;
	}

	@PostMapping("LogisticsManage/renewContract")
	public String renewContract(Shipping shipping){
		shippingService.renewContract(shipping);
		return "redirect:/admin/shipping/LogisticsManage";
	}

	@PostMapping("LogisticsManage/newLogistics")
	public String newLogistics(Shipping shipping){
		shippingService.newLogistics(shipping);
		return "redirect:/admin/shipping/LogisticsManage";
	}


	@GetMapping("/StatisticsManage")
	public String statisticsManage(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "배송업체 계약 통계 관리");
		return pageType+"/StatisticsManage";
	}
}
