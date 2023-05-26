package ua.zvgod.cursach.cursach.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.zvgod.cursach.cursach.services.GuestService;

@Controller
public class InfoController {
    private GuestService guestService;

    @Autowired
    public InfoController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/")
    public String redirectToInfo() {
        return "redirect:/info";
    }
    @GetMapping("/info")
    public String showInfo(HttpSession session) {
        guestService.manageGuest(session);
        return "index";
    }
}
