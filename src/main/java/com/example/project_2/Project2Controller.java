package com.example.project_2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Project2Controller {
    @Autowired
    MakerRepository makerRepo;

    @Autowired
    MotionRepository motionRepo;

    @GetMapping("/maintenance")
    public String getMaintenance() {
        return "maintenance";
    }

    @GetMapping("/listing")
    public String list(Model model) {
        model.addAttribute("makers", makerRepo.findAll());
        return "listing";
    }

    @PostMapping("/maintenance")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
            @RequestParam String description, @RequestParam String date) {

        Maker existingMaker = makerRepo.findByEmail(email);

        if (existingMaker == null) {
            Maker maker = new Maker();
            maker.setFirstName(firstName);
            maker.setLastName(lastName);
            maker.setEmail(email);
            makerRepo.save(maker);
            existingMaker = maker;
        }
        Motion motion = new Motion();
        motion.setDescription(description);
        motion.setDate(date);
        motion.setMaker(existingMaker);
        motionRepo.save(motion);
        return "redirect:/listing";
    }
}
