package com.example.applicationtracker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationTrackerService {

    private final ApplicationTrackerRepository applicationTrackerRepository;

    public ApplicationTrackerService(
            ApplicationTrackerRepository applicationTrackerRepository
    ){
        this.applicationTrackerRepository = applicationTrackerRepository;
    }

    public List<Application> getApplicationTracker(){
        return applicationTrackerRepository.findAll();
    }

    public void insertApplication(Application application) {
        applicationTrackerRepository.save(application);
    }

    public Application updateApplication(Application application, Integer id) {
        if(!applicationTrackerRepository.existsById(id)){
            throw new RuntimeException("Application not found");
        }
        return  applicationTrackerRepository.save(application);
    }

    public void deleteApplication(Integer id) {
        if(!applicationTrackerRepository.existsById(id)){
            throw new RuntimeException("Application not found");
        }else applicationTrackerRepository.deleteById(id);
    }


}
