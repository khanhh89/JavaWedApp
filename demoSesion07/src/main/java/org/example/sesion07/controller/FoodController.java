package org.example.sesion07.controller;

import org.example.sesion07.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    public static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    // Lưu danh sách món ăn tạm thời trong bộ nhớ
    private static final List<Food> foodList = new ArrayList<>();

    @GetMapping
    public String showFoodApp(Model model) {
        model.addAttribute("foodList", foodList);
        return "food-app";
    }

    @PostMapping("/save")
    public String saveFood(@RequestParam("name") String name,
                           @RequestParam("imgUrl") MultipartFile file,
                           RedirectAttributes redirectAttributes) {

        if (file.isEmpty() || name == null || name.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng nhập tên và chọn ảnh.");
            return "redirect:/food";
        }

        try {
            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());

            Food food = new Food();
            food.setName(name);
            food.setImgUrl(fileName);
            food.setDisplayPath("/uploads/" + fileName); // Đường dẫn web để hiển thị ảnh
            foodList.add(food);
            redirectAttributes.addFlashAttribute("message", "Thêm món ăn thành công!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Lỗi khi tải ảnh lên.");
        }
        return "redirect:/food";
    }
}