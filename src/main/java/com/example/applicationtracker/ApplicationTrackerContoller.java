package com.example.applicationtracker;


import jakarta.persistence.PostUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/application-tracker")
public class ApplicationTrackerContoller {

    private final ApplicationTrackerService applicationTrackerService;


    public ApplicationTrackerContoller(ApplicationTrackerService applicationTrackerService) {
        this.applicationTrackerService = applicationTrackerService;

    }

    @GetMapping
    public List<Application> getApplications(){
        return applicationTrackerService.getApplicationTracker();
    }

    @PostMapping
    public void insertApplication( @RequestBody Application application){
        applicationTrackerService.insertApplication(application);

    }

    @PutMapping("{id}")
    public Application updateApplication(@PathVariable Integer id, @RequestBody Application application){
       return applicationTrackerService.updateApplication(application,id);

    }

@DeleteMapping("{id}")
public void deleteApplication(@PathVariable Integer id){
        applicationTrackerService.deleteApplication(id);
}

}
