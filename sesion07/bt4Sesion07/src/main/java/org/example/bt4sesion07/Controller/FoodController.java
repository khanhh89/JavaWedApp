package org.example.bt4sesion07.Controller;


import org.example.bt4sesion07.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/food")
public class FoodController {

    private static final String UPLOAD_DIR = "D:/Dowload/upload/";
    private static final List<Food> foodList = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong(1);

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return List.of("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("food", new Food());
        return "food-add";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute("food") Food food,
                          @RequestParam("image") MultipartFile file,
                          RedirectAttributes redirectAttributes) {

        // 1. Kiểm tra file
        if (file == null || file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Vui lòng chọn ảnh món ăn!");
            return "redirect:/food/add";
        }

        // 2. Kiểm tra định dạng
        String contentType = file.getContentType();
        String originalName = file.getOriginalFilename();
        if (contentType == null || !contentType.startsWith("image/")) {
            redirectAttributes.addFlashAttribute("error", "File không đúng định dạng ảnh!");
            return "redirect:/food/add";
        }
        if (originalName != null && !originalName.matches(".*\\.(jpg|jpeg|png)$")) {
            redirectAttributes.addFlashAttribute("error", "Chỉ chấp nhận file .jpg, .jpeg, .png");
            return "redirect:/food/add";
        }

        // 3. Kiểm tra giá tiền
        if (food.getPrice() < 0) {
            redirectAttributes.addFlashAttribute("error", "Giá tiền không được âm!");
            return "redirect:/food/add";
        }

        // 4. Kiểm tra kích thước file (phòng trường hợp cấu hình servlet không bắt)
        if (file.getSize() > 2 * 1024 * 1024) {
            redirectAttributes.addFlashAttribute("error", "File ảnh không được vượt quá 2MB!");
            return "redirect:/food/add";
        }

        // 5. Tạo tên file duy nhất (timestamp + tên gốc)
        String uniqueFileName = System.currentTimeMillis() + "_" + originalName;
        String filePath = UPLOAD_DIR + uniqueFileName;

        try {
            // Tạo thư mục nếu chưa tồn tại
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // Lưu file
            file.transferTo(new File(filePath));

            // Gán đường dẫn ảnh vào food
            food.setImagePath(filePath);

            // Lưu vào danh sách tạm (gán id tự tăng)
            food.setId(idGenerator.getAndIncrement());
            foodList.add(food);

            // In console thông tin
            System.out.println("======= THÊM MÓN THÀNH CÔNG =======");
            System.out.println("ID: " + food.getId());
            System.out.println("Tên: " + food.getName());
            System.out.println("Nhóm: " + food.getCategory());
            System.out.println("Giá: " + food.getPrice());
            System.out.println("Đường dẫn ảnh: " + filePath);
            System.out.println("Tổng số món: " + foodList.size());
            System.out.println("===================================");

            // Redirect sang trang chi tiết với id
            redirectAttributes.addFlashAttribute("success", "Thêm món thành công!");
            return "redirect:/food/detail?id=" + food.getId();

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi khi lưu file: " + e.getMessage());
            return "redirect:/food/add";
        }
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") Long id, Model model) {
        Food food = foodList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (food == null) {
            model.addAttribute("error", "Không tìm thấy món ăn!");
            return "error";
        }
        model.addAttribute("food", food);
        return "food-detail";
    }
}