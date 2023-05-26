package ua.zvgod.cursach.cursach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.zvgod.cursach.cursach.models.Worker;
import ua.zvgod.cursach.cursach.repositories.WorkerRepository;

import java.util.List;

@Component
public class WorkerService {
    private WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Transactional
    public List<Worker> findAll() {
        List<Worker> workers = workerRepository.findAll();

        return workers;
    }
}
