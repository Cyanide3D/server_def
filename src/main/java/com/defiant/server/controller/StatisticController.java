package com.defiant.server.controller;

import com.defiant.server.model.Statistic;
import com.defiant.server.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
//@RequestMapping("/statistic")
//public class StatisticController {
//
//    @Autowired
//    private StatisticService statisticService;
//
//    @GetMapping("/members")
//    public String statistic(Model model) {
//        model.addAttribute("statistic", statisticService.getWeeklyStatistic());
//        return "statistic/weekly";
//    }
//
//    @PostMapping("/members")
//    public String saveStatistic(@ModelAttribute("statistic") Statistic statistic) {
//        statisticService.saveWeeklyStatistic(statistic);
//        return "redirect:/statistic/members";
//    }
//
//}
