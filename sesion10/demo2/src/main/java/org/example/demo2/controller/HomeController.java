package org.example.demo2.controller;

import jakarta.validation.Valid;
import org.example.demo2.model.Played;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/players")
public class HomeController {

    private List<Played> list = new ArrayList<>();
    private Long idCount = 1L;

    // ===== HOME =====
    @GetMapping
    public String home(Model model){
        model.addAttribute("list", list);
        return "home";
    }

    // ===== FORM CREATE =====
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("player", new Played());
        return "create";
    }

    // ===== SAVE =====
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("player") Played player,
                       BindingResult result,
                       @RequestParam(value = "file", required = false) MultipartFile file,
                       Model model) throws IOException {

        // nếu lỗi validation
        if(result.hasErrors()){
            return "create";
        }

        // upload file
        if(file != null && !file.isEmpty()){
            String fileName = file.getOriginalFilename();
            String uploadDir = "D:/uploads/";
            
            // Đảm bảo thư mục tồn tại
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs(); // Tạo thư mục nếu chưa có
            }

            // Lưu file
            File destinationFile = new File(uploadDir + fileName);
            file.transferTo(destinationFile);
            player.setAvatar(fileName);
        }

        // set id
        player.setId(idCount++);

        // lưu vào list
        list.add(player);

        return "redirect:/players";
    }
}