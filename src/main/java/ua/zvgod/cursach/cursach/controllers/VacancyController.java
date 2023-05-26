package ua.zvgod.cursach.cursach.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.zvgod.cursach.cursach.models.JobForm;
import ua.zvgod.cursach.cursach.models.QAForm;
import ua.zvgod.cursach.cursach.services.FileService;
import ua.zvgod.cursach.cursach.services.GuestService;
import ua.zvgod.cursach.cursach.services.JobFormService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class VacancyController {
    private GuestService guestService;
    private JobFormService jobFormService;
    private FileService fileService;

    @Autowired
    public VacancyController(GuestService guestService, JobFormService jobFormService, FileService fileService) {
        this.guestService = guestService;
        this.jobFormService = jobFormService;
        this.fileService = fileService;
    }

    @GetMapping("/vacancy")
    public String showVacancy(HttpSession session, @ModelAttribute("job_form") JobForm jobForm) {
        guestService.manageGuest(session);
        return "vacancy";
    }

    @GetMapping("/job_form_confirmation")
    public String showConfirmation() {
        return "/job_form_confirmation";
    }

    @PostMapping("/post_job_form")
    public String insertJobForm(HttpSession session,
                                @ModelAttribute("job_form") @Valid JobForm jobForm,
                                BindingResult bindingResult,
                                @RequestParam("file")MultipartFile multipartFile) {

        if(bindingResult.hasErrors()) {
            return "/vacancy";
        }

        if(!multipartFile.isEmpty()) {
            try {
                String filePath = fileService.processFile(jobForm, multipartFile);
                jobForm.setFilePath(filePath);
            }catch (IOException e) {
                e.printStackTrace();
                return "/vacancy";
            }
        } else {
            return "/vacancy";
        }

        jobFormService.save(jobForm, session.getId());

        return "redirect:/job_form_confirmation";
    }
}
