package cestovnydennik.controller;

import cestovnydennik.model.TravelRecord;
import cestovnydennik.service.TravelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private TravelRecordService travelRecordService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("travelRecords", travelRecordService.findAll());
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/newRecord")
    public String add(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/saveRecord")
    public String save(@ModelAttribute TravelRecord travelRecord, BindingResult bindingResult,  HttpServletRequest request) {
        travelRecordService.add(travelRecord);
        request.setAttribute("travelRecord", travelRecordService.findAll());
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/editRecord")
    public String edit(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("travelRecord", travelRecordService.findTravelRecord(id));
        request.setAttribute("mode", "MODE_EDIT");
        return "index";
    }

    @GetMapping("/deleteRecord")
    public String deleteRecord(@RequestParam int id, HttpServletRequest request) {
        travelRecordService.delete(id);
        request.setAttribute("travelRecord", travelRecordService.findAll());
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }
}
