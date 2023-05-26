package ua.zvgod.cursach.cursach.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.zvgod.cursach.cursach.models.QAForm;
import ua.zvgod.cursach.cursach.services.GuestService;
import ua.zvgod.cursach.cursach.services.QAFormService;

@Controller
public class ServicesController {
    private GuestService guestService;
    private QAFormService qaFormService;
    @Autowired
    public ServicesController(GuestService guestService, QAFormService qaFormService) {
        this.guestService = guestService;
        this.qaFormService = qaFormService;
    }
    @GetMapping("/services")
    public String showServices(HttpSession session, @ModelAttribute("qa_form") QAForm qaForm) {
        guestService.manageGuest(session);
        return "services";
    }

    @GetMapping("/qa_form_confirmation")
    public String showConfirmation() {
        return "/qa_form_confirmation";
    }

    @PostMapping("/post_qa_form")
    public String insertQAForm(HttpSession session, @ModelAttribute("qa_form") @Valid QAForm qaForm,
                               BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "/services";
        }

        qaFormService.save(qaForm, session.getId());
        return "redirect:/qa_form_confirmation";
    }
}
