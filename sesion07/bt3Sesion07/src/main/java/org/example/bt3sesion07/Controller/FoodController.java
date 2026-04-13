package org.example.bt3sesion07.Controller;

import org.example.bt3sesion07.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    private static final String UPLOAD_DIR = "D:/Dowload/upload";

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return List.of("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        return "food-add";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute("food") Food food,
                          @RequestParam("image") MultipartFile file,
                          Model model) {
        if (file == null || file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ảnh món ăn!");
            return "food-add";
        }

        String contentType = file.getContentType();
        String originalName = file.getOriginalFilename();
        if (contentType == null || !contentType.startsWith("image/")) {
            model.addAttribute("error", "File không đúng định dạng ảnh!");
            return "food-add";
        }
        if (originalName != null && !originalName.matches(".*\\.(jpg|jpeg|png)$")) {
            model.addAttribute("error", "Chỉ chấp nhận file .jpg, .jpeg, .png");
            return "food-add";
        }
        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá tiền không được âm!");
            return "food-add";
        }

        // 4. Lưu file
        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            String uniqueFileName = System.currentTimeMillis() + "_" + originalName;
            String filePath = UPLOAD_DIR + uniqueFileName;
            file.transferTo(new File(filePath));

//            food.setImagePath(filePath);

            // 5. In thông tin ra console (không lưu RAM)
            System.out.println("======= THÊM MÓN MỚI =======");
            System.out.println("Tên: " + food.getName());
            System.out.println("Nhóm: " + food.getCategory());
            System.out.println("Giá: " + food.getPrice());
            System.out.println("Đường dẫn ảnh: " + filePath);
            System.out.println("============================");

            model.addAttribute("success", "Thêm món ăn thành công!");

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi lưu file: " + e.getMessage());
        }
        return "food-add";
    }
}
