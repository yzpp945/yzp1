package com.yzpjy.controller;

import com.yzpjy.domain.Itmes;
import com.yzpjy.service.ItmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItmesService service;

    @RequestMapping("/findbyid")
    public String findbyid(Model model){
        Itmes itmes = service.findbyid(1);
        model.addAttribute("item",itmes);
        return "itemDetail";
    }
}
