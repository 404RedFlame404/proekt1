package com.example.demo.controllers;
import com.example.demo.models.apartment;
import com.example.demo.repository.apartmentRepository;
import com.example.demo.repository.ownersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.Struct;
import java.util.Optional;


@Controller
@RequestMapping(path="/Apartment")

public class apartmentController {

    @Autowired
    private apartmentRepository apartmentRepository;
    @Autowired
    private ownersRepository ownerRepository;

    @GetMapping(path = "/all")
    public String allApart(Model model){
        model.addAttribute("apartList", apartmentRepository.findAll());
        return "Apartment/NewApartment";
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody RedirectView addNewApartment(@RequestParam String type,@RequestParam Integer room,@RequestParam Integer price, Model model) {
        apartment n = new apartment();
        model.addAttribute("ownerList", ownerRepository.findAll());
        n.setType(type);
        n.setRoom(room);
        n.setPrice(price);

        apartmentRepository.save(n);
        return new RedirectView("./all");
    }

    @GetMapping(path = "/add")
    public String addApartment() {

        return "Apartment/addapartment";
    }

}
