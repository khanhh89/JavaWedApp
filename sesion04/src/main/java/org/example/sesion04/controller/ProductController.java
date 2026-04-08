package org.example.sesion04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/bai4/products")
    public String getProductList(
            @RequestParam("category") String category,
            @RequestParam("limit") Integer limit,
            ModelMap model
    ) {
        model.addAttribute("cate", category)
                .addAttribute("lim", limit)
                .addAttribute("msg", "Tìm kiếm thành công!");

        return "productList";
    }
}
