package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.DevObsInfo;
import co.kesti.smartcity.entity.DevObsInfoKey;
import co.kesti.smartcity.entity.DevRealtimeObs;
import co.kesti.smartcity.entity.DevRealtimeObsKey;
import co.kesti.smartcity.entity.custom.DevObsInfoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevObsInfoRepository extends JpaRepository<DevObsInfo, DevObsInfoKey> {

    Optional<DevObsInfo> findByDevObsInfoKey(DevObsInfoKey devObsInfoKey);
    void deleteByDevObsInfoKey(DevObsInfoKey devObsInfoKey);


    @Query("select " +
            "d.devObsInfoKey.devId as devId, " +
            "d.devObsInfoKey.obsItemId as obsItemId, " +
            "d.registeDt as registeDt, " +
            "d.unitType as unitType, " +
            "cd.dtlCdNm as obsItemName " +
            "from DevObsInfo d, CdDtl cd " +
            "where d.devObsInfoKey.devId = ?1 and cd.cdDtlKey.cdGroupId = 'OBS' and cd.cdDtlKey.dtlCd = d.devObsInfoKey.obsItemId " +
            "order by d.registeDt desc")
    Page<DevObsInfoProjection> getDevObsInfosByDevId(String devId, Pageable pageable);


    Page<DevObsInfo> findAllByOrderByRegisteDtDesc(Pageable pageable);

    List<DevObsInfo> findAllByDevObsInfoKeyDevId(String devId);


    void deleteByDevObsInfoKey_DevId(String devId);
}
