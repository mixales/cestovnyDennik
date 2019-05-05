package cestovnydennik.controller;

import cestovnydennik.model.TravelRecord;
import cestovnydennik.service.TravelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Time;
import java.util.Date;

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

    @GetMapping("/add")
    public String addTravelRecord(@RequestParam String vozidlo, @RequestParam String cesta_start, @RequestParam String cesta_ciel, @RequestParam Time cas_start,
                                  @RequestParam Time cas_ciel, @RequestParam Time cas_praca_zaciatok, @RequestParam Time cas_praca_koniec, @RequestParam int vzdialenost, @RequestParam double spotreba, @RequestParam double palivo_cena){
        TravelRecord travelRecord = new TravelRecord(vozidlo, new Date(), cesta_start, cesta_ciel, cas_start, cas_ciel, cas_praca_zaciatok, cas_praca_koniec, vzdialenost, spotreba, palivo_cena);
        travelRecordService.add(travelRecord);
        return "Zaznam pridany";
    }

    @GetMapping("/delete")
    public String deleteTravelRecord(@RequestParam int id){
        travelRecordService.delete(id);
        return "Zaznam vymazany";
    }
}