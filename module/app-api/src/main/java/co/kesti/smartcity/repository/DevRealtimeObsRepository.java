package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.DevRealtimeObs;
import co.kesti.smartcity.entity.DevRealtimeObsKey;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevRealtimeObsRepository extends JpaRepository<DevRealtimeObs, DevRealtimeObsKey> {

    void deleteByDevRealtimeObsKey(DevRealtimeObsKey devRealtimeObsKey);

    @Query("select d from DevRealtimeObs d where d.devRealtimeObsKey.devId = ?1 and d.devRealtimeObsKey.obsItemId = ?2 order by d.devRealtimeObsKey.obsTime desc")
    List<DevRealtimeObs> getLatestObsItemValue(String devId, String obsItemId, Pageable pageable);


}
