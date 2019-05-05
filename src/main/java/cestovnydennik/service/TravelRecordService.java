package cestovnydennik.service;


import java.util.ArrayList;
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
}
