package ua.zvgod.cursach.cursach.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.zvgod.cursach.cursach.models.Guest;
import ua.zvgod.cursach.cursach.repositories.GuestRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GuestService {

    private GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Transactional
    public void manageGuest(HttpSession session) {
        Optional<Guest> guest = guestRepository.findBySessionId(session.getId());
        if (guest.isEmpty()) {
            Guest newGuest = new Guest();
            newGuest.setSessionId(session.getId());
            newGuest.setLastVisited(LocalDateTime.now());
            newGuest.setNumberOfVisits(1);

            guestRepository.save(newGuest);
        } else {
            guest.get().setLastVisited(LocalDateTime.now());
            guest.get().setNumberOfVisits(guest.get().getNumberOfVisits() + 1);
            guestRepository.save(guest.get());
        }
        System.out.println(session.getId());

    }

}
