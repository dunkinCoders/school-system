package backend.educationproject.services;

import backend.educationproject.repositories.HomeworksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkService {
    private final HomeworksRepository homeworksRepository;

    @Autowired
    public HomeworkService(HomeworksRepository homeworksRepository) {
        this.homeworksRepository = homeworksRepository;
    }
}
