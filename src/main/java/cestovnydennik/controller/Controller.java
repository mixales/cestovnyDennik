package cestovnydennik.controller;

import cestovnydennik.service.TravelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Controller {

    @Autowired
    private TravelRecordService travelRecordService;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello world!";
    }

    @GetMapping("/all")
    public String allTravelRecords(){
        return travelRecordService.findAll().toString();
    }
}