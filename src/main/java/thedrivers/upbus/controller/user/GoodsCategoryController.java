package thedrivers.upbus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 데이터베이스 연동이 완료된 후 해당 컨트롤러로 연결되는 서비스 오픈
 */
/*
@Controller
@RequestMapping("/goods")
public class GoodsCategoryController {

    private final GoodsCategoryService goodsCategoryService;

    public GoodsCategoryController(GoodsCategoryService goodsCategoryService) {
        this.goodsCategoryService = goodsCategoryService;
    }


    @GetMapping("/goodsRequest")
    public String getGoodsCategoryMainList(Model model) {
        List<GoodsCategoryMain> goodsCategoryMainList = goodsCategoryService.getGoodsCategoryMainList();

        model.addAttribute("goodsCategoryMainList", goodsCategoryMainList);
        model.addAttribute("htext", "내가 만든 업사이클링 상품 판매 위탁하기");
        System.out.println(goodsCategoryMainList);
        return "goods/goodsRequest";

    }
}*/
