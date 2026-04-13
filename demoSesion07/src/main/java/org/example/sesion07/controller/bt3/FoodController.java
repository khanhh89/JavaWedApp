package org.example.sesion07.controller.bt3;

import org.example.sesion07.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    private static final List<Food> foodList = new ArrayList<>();
    private static final String UPLOAD_PATH = "C:/RikkeiFood_Temp/";
    @GetMapping({"", "/"})
    public String redirectToFoodList() {
        return "redirect:/food/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("food", new Food());
        return "food-add";
    }

    @GetMapping("/list")
    public String listFood(Model model) {
        model.addAttribute("foodList", foodList);
        return "food-app";
    }

    @PostMapping("/save")
    public String saveFood(@ModelAttribute("food") Food food,
                           @RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá không hợp lệ");
            return "food-add";
        }
        
        if (file == null || file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ảnh món ăn");
            return "food-add";
        }
        
        String originalFileName = file.getOriginalFilename();
        if (originalFileName != null && !originalFileName.toLowerCase().matches(".*\\.(jpg|png|jpeg)$")) {
            model.addAttribute("error", "Chỉ chấp nhận file ảnh (.jpg, .png, .jpeg)");
            return "food-add";
        }
        try {
            File folder = new File(UPLOAD_PATH);
            if (!folder.exists()) folder.mkdirs();

            // Bẫy dữ liệu: Tránh ghi đè file bằng cách thêm timestamp vào tên
            String uniqueFileName = System.currentTimeMillis() + "_" + originalFileName;
            File destination = new File(UPLOAD_PATH + uniqueFileName);
            
            // Lưu file vật lý
            file.transferTo(destination);

            // Set ID định danh và thông tin đường dẫn
            food.setId(java.util.UUID.randomUUID().toString());
            food.setImgUrl(uniqueFileName);
            food.setDisplayPath("/external-img/" + uniqueFileName);
            food.setPhysicalPath(destination.getAbsolutePath());
            
            foodList.add(food);
            redirectAttributes.addFlashAttribute("message", "Thêm món ăn thành công!");
            return "redirect:/food/detail?id=" + food.getId();
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi hệ thống khi xử lý ảnh!");
            return "food-add";
        }
    }

    @GetMapping("/detail")
    public String showFoodDetail(@RequestParam("id") String id, Model model) {
        Food foodDetail = foodList.stream()
                .filter(f -> id.equals(f.getId()))
                .findFirst()
                .orElse(null);
        
        model.addAttribute("food", foodDetail);
        return "food-detail";
    }
}
