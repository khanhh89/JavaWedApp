package org.example.sesion05.controller;

import org.example.sesion05.bt2.Dish;
import org.example.sesion05.model.Products;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    // hiển thị danh sách sp ra man hình
    List<Products> products = new ArrayList<>(
            Arrays.asList(
                new Products(1, "Đào Xuân Khánh", 5000, 1, true),
                    new Products(2, "Khanh Dao", 50000, 1 , true)
            )
    );
    List<Dish> list = new ArrayList<>(
            Arrays.asList(
                    new Dish(1, "Cơm rang", 2000, true),
                    new Dish(2, "Phở gà", 25000, true),
                    new Dish(3, "Bún chó", 40000, false),
                    new Dish(5, "Bánh mỳ bơ sữa", 20000, true)
            )
    );
    @RequestMapping
    public String home(Model model) {
        model.addAttribute("shop", products);
        return "home";
    }
    @GetMapping("/delete/{id}")
    public String handleDelete(@PathVariable(name = "id") int id){
        products = products.stream().filter(p->p.getId()!=id).toList();
        return  "redirect:/";
    }
    @GetMapping("/bai3/edit/{id}")
    public String handleEdit(@PathVariable("id") int id, Model model){
        Dish dish = list.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            model.addAttribute("dishes", list);
            return "dish-list";
        }
        model.addAttribute("dish", dish);
        return "edit-dish";
    }
    @RequestMapping("/bai3/dish-list")
    public String dishList(Model model){
        model.addAttribute("dishes", list);
        return "dish-list";
    }
}
