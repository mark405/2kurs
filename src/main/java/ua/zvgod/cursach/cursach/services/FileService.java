package ua.zvgod.cursach.cursach.services;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ua.zvgod.cursach.cursach.models.JobForm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileService {
    public String processFile(JobForm jobForm, MultipartFile multipartFile) throws IOException {
        String fileName = jobForm.getName() + "_" + multipartFile.getOriginalFilename();
        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get(fileName);
        Files.write(path, bytes);

        return path.toString();
    }
}
