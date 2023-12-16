package com.example.demo.controllers;
import com.example.demo.models.Visitors;
import com.example.demo.repository.VisitorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Struct;
import java.util.Optional;


@Controller
@RequestMapping(path="/visitors")
public class VisitorsController {

    @Autowired
    private VisitorsRepository visitorsRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody RedirectView addNewUser(@RequestParam String name) {
        Visitors n = new Visitors();
        n.setName(name);

        visitorsRepository.save(n);
        return new RedirectView("./all");
    }

    @GetMapping("/all")
    public String allVisitors(Model model) {
        model.addAttribute("visitorsList", visitorsRepository.findAll());
        return "visitors/NewVisitors";
    }

    public String allVisitor(Model model) {
        model.addAttribute("visitorList", visitorsRepository.findAll());
        return "visitors/NewVisitors";
    }

    @GetMapping(path = "/add")
    public String addVisitor() {

        return "visitors/addVisitors";
    }

    @PostMapping(path = "/delete")
    public @ResponseBody RedirectView addNewUser(@RequestParam Integer id) {
        visitorsRepository.deleteById(id);
        return new RedirectView("./all");
    }

    @PostMapping(path = "/uppdate")
    public @ResponseBody RedirectView uppdateUser(@RequestParam Integer id, @RequestParam String name) {
        Optional<Visitors> visitors = visitorsRepository.findById(id);
        Visitors visitor = visitors.get();
        visitor.setName(name);
        visitorsRepository.save(visitor);
        return new RedirectView("./all");
    }

    @GetMapping(path = "/uppdate")
    public String UppdateName(@RequestParam Integer id, Model model) {
        model.addAttribute("visitor", visitorsRepository.findById(id));


        return "visitors/uppdate";

    }
}
