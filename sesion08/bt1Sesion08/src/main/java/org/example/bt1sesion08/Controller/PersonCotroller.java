package org.example.bt1sesion08.Controller;

import jakarta.validation.Valid;
import org.example.bt1sesion08.dto.PersonDTO;
import org.example.bt1sesion08.model.Gender;
import org.example.bt1sesion08.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class PersonCotroller {
    List<Person> personList = new ArrayList<>(
            Arrays.asList(
                    new Person(1L, "Đào Xuan Khánh", Gender.FEMALE, LocalDate.of(2006,1,13),19,"khanhdao123@gmail.com")
        )
    );
    @GetMapping
    public String home(Model model) {
        model.addAttribute("persons", personList);
        return "person-list";
    }
    @GetMapping("/view-add")
        public String viewAdd(Model model){
        model.addAttribute("personDTO", new PersonDTO());
            return "person-form";
        }
    @PostMapping("/handle-submit")
    public String handleSubmit(@Valid @ModelAttribute(name = "personDTO") PersonDTO personDTO , BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("personDTO", personDTO);
            return "person-form";
        }
        Person newPerson = new Person(
                        personDTO.getId(),
                        personDTO.getName(),
                Gender.valueOf(personDTO.getGender().toUpperCase()),
                LocalDate.parse(personDTO.getBirthDate()),
                        personDTO.getAge(),
                        personDTO.getEmail()
                    );

        personList.add(newPerson);
        return "redirect:/";
    }
}
