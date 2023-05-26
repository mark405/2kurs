package ua.zvgod.cursach.cursach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.zvgod.cursach.cursach.models.Guest;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

    Optional<Guest> findBySessionId(String sessionId);
}
