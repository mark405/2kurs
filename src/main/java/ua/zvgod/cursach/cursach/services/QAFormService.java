package ua.zvgod.cursach.cursach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.zvgod.cursach.cursach.models.Guest;
import ua.zvgod.cursach.cursach.models.QAForm;
import ua.zvgod.cursach.cursach.repositories.GuestRepository;
import ua.zvgod.cursach.cursach.repositories.QAFormRepository;

import java.util.Optional;

@Service
public class QAFormService {
    private QAFormRepository qaFormRepository;
    private GuestRepository guestRepository;

    @Autowired
    public QAFormService(QAFormRepository qaFormRepository, GuestRepository guestRepository) {
        this.qaFormRepository = qaFormRepository;
        this.guestRepository = guestRepository;
    }

    @Transactional
    public void save(QAForm qaForm, String sessionId) {
        Optional<Guest> guest = guestRepository.findBySessionId(sessionId);
        qaForm.setGuest(guest.get());
        qaFormRepository.save(qaForm);
    }
}
