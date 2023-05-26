package ua.zvgod.cursach.cursach.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.zvgod.cursach.cursach.models.Office;
import ua.zvgod.cursach.cursach.models.Worker;
import ua.zvgod.cursach.cursach.services.GuestService;
import ua.zvgod.cursach.cursach.services.OfficeService;
import ua.zvgod.cursach.cursach.services.WorkerService;

import java.util.List;

@Controller
public class AboutController {

    private GuestService guestService;
    private WorkerService workerService;
    private OfficeService officeService;

    @Autowired
    public AboutController(GuestService guestService, WorkerService workerService, OfficeService officeService) {
        this.guestService = guestService;
        this.workerService = workerService;
        this.officeService = officeService;
    }

    @GetMapping("/about")
    public String showAbout(Model model, HttpSession session) {
        guestService.manageGuest(session);
        List<Worker> workerList = workerService.findAll();
        List<Office> officeList = officeService.findall();
        model.addAttribute("workers", workerList);
        model.addAttribute("offices", officeList);
        return "about";
    }
}
