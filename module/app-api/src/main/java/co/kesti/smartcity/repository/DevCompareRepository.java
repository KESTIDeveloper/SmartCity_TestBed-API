package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DevCompareRepository extends JpaRepository<DevCompare, DevCompareKey> {


    List<DevCompare> findAllByDevCompareKeyDevId(String devId);


    @Query("select d from DevInfo d, DevCompare c " +
            "where c.devCompareKey.devId = ?1 and d.devId = c.devCompareKey.compareDevId " +
            "order by c.compareOrder asc")
    List<DevInfo> getDevCompareByDevId(String devId);

    void deleteByDevCompareKeyDevId(String devId);
}
