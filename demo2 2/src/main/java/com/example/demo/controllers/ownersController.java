package com.example.demo.controllers;
import com.example.demo.models.owners;
import com.example.demo.repository.ownersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/Owner")
public class ownersController {

    @Autowired
    private ownersRepository ownersRepository;


    @GetMapping("/all")
    public String allOwner(Model model) {
        model.addAttribute("ownerList", ownersRepository.findAll());
        return "Owner/NewOwner";
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody RedirectView addNewOwner(@RequestParam String name,@RequestParam String surname) {
        owners n = new owners();
        n.setName(name);
        n.setSurname(surname);

        ownersRepository.save(n);
        return new RedirectView("./all");
    }
    @GetMapping(path = "/add")
    public String addOwner() {

        return "Owner/AddOwner";
    }

}

