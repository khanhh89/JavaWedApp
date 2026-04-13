package org.example.bt2sesion07.controller;

import org.example.bt2sesion07.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

// Phần 1:
// Nguyên tắc bị vi phạm: DRY - viết code lặp lại cùng 1 logic ở nhiều nơi
//Rủi ro khi mở rộng 20 trang:
//Sửa 1 chỗ phải sửa cả 20 chỗ
//Thêm trang mới quên thêm dòng nội dung đấy
//Bảo trì tốn thời gian, code khó đọc, khó kiểm soát
@Controller
@RequestMapping("/dishes")
public class DishController {
    @ModelAttribute("category")
    public List<String> Categorys(){
        return Arrays.asList("Món chính", "Món phụ", "Món uống");
    }
    // thêm mới
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("dish", new Dish());
        return "dish-add";
        }
    @GetMapping("/edit")
    public String editForm(Model model) {
        model.addAttribute("dish", new Dish("Trà sữa", "Món uống"));
        return "dish-edit";
    }
    @GetMapping("/search")
    public  String searchForm(Model model) {
        return "dish-search";
    }
}
