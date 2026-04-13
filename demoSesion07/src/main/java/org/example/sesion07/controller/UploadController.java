package org.example.sesion07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class UploadController {

    // Đường dẫn trỏ tới thư mục lưu file (sẽ tự động tạo trong thư mục gốc của project)
    public static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping
    public String formUpload() {
        return "form-upload";
    }

    @PostMapping
    public String uploadImage(@RequestParam("image") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn ảnh để tải lên!");
            return "form-upload";
        }

        try {
            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); // Tạo thư mục nếu chưa tồn tại
            }

            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
            // Thực hiện lưu file
            file.transferTo(filePath.toFile());

            model.addAttribute("message", "Tải ảnh lên thành công: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Tải ảnh lên thất bại do lỗi hệ thống.");
        }

        return "form-upload";
    }
}
