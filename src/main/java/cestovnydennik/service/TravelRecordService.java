package cestovnydennik.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cestovnydennik.dao.TravelRecordRepository;
import cestovnydennik.model.TravelRecord;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TravelRecordService {

    private final TravelRecordRepository travelRecordRepository;

    public TravelRecordService(TravelRecordRepository travelRecordRepository) {
        this.travelRecordRepository = travelRecordRepository;
    }

    public List<TravelRecord> findAll() {
        List<TravelRecord> travelRecords = new ArrayList<>();
        for(TravelRecord travelRecord : travelRecordRepository.findAll()) {
            travelRecords.add(travelRecord);
        }

        return travelRecords;
    }

    public int getRecordCount() {
        int celkove = 0;
        List<TravelRecord> travelRecords = new ArrayList<>();
        for(TravelRecord travelRecord : travelRecordRepository.findAll()) {
            celkove++;
        }

        return celkove;
    }

    public double getKilometersCount() {
        int kilometre = 0;
        List<TravelRecord> travelRecords = new ArrayList<>();
        for(TravelRecord travelRecord : travelRecordRepository.findAll()) {
            kilometre += travelRecord.getVzdialenost();
        }

        return kilometre;
    }

    public double getKilometersCountYear() {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());

        int kilometre_rok = 0;
        List<TravelRecord> travelRecords = new ArrayList<>();
        for(TravelRecord travelRecord : travelRecordRepository.findAll()) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(travelRecord.getDatum());

            if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
                kilometre_rok += travelRecord.getVzdialenost();
            }
        }

        return kilometre_rok;
    }

    public double getNahradyYear() {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());

        int nahrady_rok = 0;
        List<TravelRecord> travelRecords = new ArrayList<>();
        for(TravelRecord travelRecord : travelRecordRepository.findAll()) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(travelRecord.getDatum());

            if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
                nahrady_rok += Math.round(((travelRecord.getSpotreba()/100) * travelRecord.getVzdialenost())*travelRecord.getPalivo_cena() + (travelRecord.getVzdialenost() * 0.183));
            }
        }

        return nahrady_rok;
    }

    public TravelRecord findTravelRecord(int id)
    {
        TravelRecord travelRecordFound = null;
        for(TravelRecord travelRecord : travelRecordRepository.findAll()) {
            if (travelRecord.getId() == id)
            {
                travelRecordFound = travelRecord;
            }
        }
        return travelRecordFound;
    }

    public void add(TravelRecord travelRecord)
    {
        travelRecordRepository.save(travelRecord);
    }

    public void delete(int id)
    {
        travelRecordRepository.deleteById(id);
    }

    public String dateToString(Integer id) {

        TravelRecord travelRecord = findTravelRecord(id);

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String newDatum = formatter.format(travelRecord.getDatum());
        return newDatum;
    }
}
