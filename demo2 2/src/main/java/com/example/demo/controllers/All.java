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
@RequestMapping(path="/All")
public class All {

    @GetMapping("/All")
    public String All(Model model) {

        return "All/All";
    }
    public String allVisitor(Model model) {

        return "All/All";
    }

}
