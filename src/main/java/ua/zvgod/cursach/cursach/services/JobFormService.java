package ua.zvgod.cursach.cursach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.zvgod.cursach.cursach.models.Guest;
import ua.zvgod.cursach.cursach.models.JobForm;
import ua.zvgod.cursach.cursach.models.QAForm;
import ua.zvgod.cursach.cursach.repositories.GuestRepository;
import ua.zvgod.cursach.cursach.repositories.JobFormRepository;

import java.util.Optional;

@Service
public class JobFormService {
    private JobFormRepository jobFormRepository;
    private GuestRepository guestRepository;

    @Autowired
    public JobFormService(JobFormRepository jobFormRepository, GuestRepository guestRepository) {
        this.jobFormRepository = jobFormRepository;
        this.guestRepository = guestRepository;
    }

    @Transactional
    public void save(JobForm jobForm, String sessionId) {
        Optional<Guest> guest = guestRepository.findBySessionId(sessionId);
        jobForm.setGuest(guest.get());
        jobFormRepository.save(jobForm);
    }
}
