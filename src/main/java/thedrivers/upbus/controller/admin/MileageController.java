package thedrivers.upbus.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import thedrivers.upbus.domain.MileageUserList;
import thedrivers.upbus.service.MileageService;

@RequestMapping("/admin/mileage")
@Controller
public class MileageController {
	
	String pageType = "admin/mileage";
	
	private final MileageService mileageService;
	
	public MileageController(MileageService mileageService) {
		this.mileageService = mileageService;
	}
	
	@GetMapping("/Statistics")
	public String statistics(Model model) {
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "마일리지 통계 조회");
		return pageType+"/Statistics";
	}
	@GetMapping("/ListManage")
	public String list(@RequestParam(name="searchKey", required = false) String searchKey
			   ,@RequestParam(name="searchValue", required = false) String searchValue
			   ,Model model) {
		
		Map<String, Object> paramMap= new HashMap<String, Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<MileageUserList> mileageUserList = mileageService.getMileageUserList();
		model.addAttribute("title", "UPBUS");
		model.addAttribute("h1text", "전체 회원 마일리지 내역 조회");
		model.addAttribute("mileageUserList",mileageUserList);
		return pageType+"/ListManage";
	}
	
	@GetMapping("/ajaxUser")
	@ResponseBody
	public List<MileageUserList> ajax(@RequestParam(value = "memberId", required = false) String memberId, Model model){
		System.out.println(memberId);
		model.addAttribute("aaaa", "dasdasdasd");
		List<MileageUserList> mileageUserList = mileageService.getMileageUserList(memberId);
		System.out.println(mileageUserList);
		model.addAttribute("mileageUserList",mileageUserList);
		return mileageUserList;
		
	}
	

}
