package ua.zvgod.cursach.cursach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.zvgod.cursach.cursach.models.JobForm;

public interface JobFormRepository extends JpaRepository<JobForm, Integer> {
}
