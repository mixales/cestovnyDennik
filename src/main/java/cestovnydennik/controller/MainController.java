package cestovnydennik.controller;

import cestovnydennik.service.TravelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private TravelRecordService travelRecordService;

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
