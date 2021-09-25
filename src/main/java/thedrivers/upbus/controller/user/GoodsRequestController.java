package thedrivers.upbus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsRequestController {

    /**
     * 데이터베이스 연동 후 의존성 주입 및 서비스 연결 예정
     */
    /*private final GoodsRequestService goodsRequestService;

    public GoodsRequestController(GoodsRequestService goodsRequestService) {
        this.goodsRequestService = goodsRequestService;
    }*/


    /*, HttpSession session*/
    @GetMapping("/goodsRequest")
    public String goodsRequest(Model model) {

        /*아이디
        String sellerId = (String) session.getAttribute("SID");*/

        model.addAttribute("title", "UPBUS");
        model.addAttribute("h1text", "내가 만든 업사이클링 상품 판매 위탁하기");
        return "goods/goodsRequest";

    }

    /*@GetMapping("/goodsSellerRequest")
    public String goodsRequest(GoodsRequest goodsRequest) {
        System.out.println(goodsRequest);
        goodsRequestService.goodsRequest(goodsRequest);
        return "redirect:/goodsRequest";
    }*/
}