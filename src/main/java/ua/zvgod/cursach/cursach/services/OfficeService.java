package ua.zvgod.cursach.cursach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.zvgod.cursach.cursach.models.Office;
import ua.zvgod.cursach.cursach.repositories.OfficeRepository;

import java.util.List;

@Service
public class OfficeService {
    private OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Transactional
    public List<Office> findall() {
        List<Office> offices = officeRepository.findAll();

        return offices;
    }
}
