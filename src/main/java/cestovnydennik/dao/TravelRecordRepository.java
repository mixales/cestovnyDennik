package cestovnydennik.dao;

import cestovnydennik.model.TravelRecord;
import org.springframework.data.repository.CrudRepository;

public interface TravelRecordRepository extends CrudRepository<TravelRecord, Integer> {
}
