package org.example.qltbd.controller;

import jakarta.validation.Valid;
import org.example.qltbd.model.Gadget;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;
@Controller
@RequestMapping("/gadgets")
public class GadgetController {

    private List<Gadget> list = new ArrayList<>();
    private Long idCounter = 1L;

    // READ + SEARCH
    @GetMapping
    public String list(Model model,
                       @RequestParam(name = "keyword", required = false) String keyword) {

        List<Gadget> result = list;

        if (keyword != null && !keyword.isEmpty()) {
            String key = keyword.toLowerCase();
            result = list.stream()
                    .filter(g -> g.getProductName().toLowerCase().contains(key)
                            || g.getBrand().toLowerCase().contains(key))
                    .collect(Collectors.toList());
        }

        model.addAttribute("list", result);
        model.addAttribute("keyword", keyword);
        return "list";
    }

    // SHOW ADD
    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("gadget", new Gadget());
        return "form";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Gadget gadget,
                      BindingResult result) {

        if (result.hasErrors()) {
            return "form";
        }

        gadget.setId(idCounter++);
        gadget.setProductImage("default.png");
        list.add(gadget);

        return "redirect:/gadgets";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Long id, Model model){
        for (Gadget g : list) {
            if (g.getId().equals(id)) {
                model.addAttribute("gadget", g);
                return "form";
            }
        }
        return "redirect:/gadgets";
    }
    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute Gadget gadget,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "form";
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(gadget.getId())) {
                gadget.setProductImage(list.get(i).getProductImage());
                list.set(i, gadget);
                break;
            }
        }

        return "redirect:/gadgets";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        list.removeIf(g -> g.getId().equals(id));
        return "redirect:/gadgets";
    }
}