package ua.zvgod.cursach.cursach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.zvgod.cursach.cursach.models.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
