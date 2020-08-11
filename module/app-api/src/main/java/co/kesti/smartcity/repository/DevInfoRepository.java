package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.custom.DevInfoCountryStatsProjection;
import co.kesti.smartcity.entity.custom.DevInfoProjection;
import co.kesti.smartcity.entity.custom.DevInfoStatsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DevInfoRepository extends JpaRepository<DevInfo, String> {

    Page<DevInfo> findAllByOrderByCretDtDesc(Pageable pageable);

    @Query("select " +
            "d.devId as devId, " +
            "d.devName as devName, " +
            "d.devPassword as devPassword, " +
            "d.latitVal as latitVal, " +
            "d.lngitVal as lngitVal, " +
            "d.protocolRule as protocolRule, " +
            "d.connStatus as connStatus, " +
            "d.liveStatus as liveStatus, " +
            "d.cretrId as cretrId, " +
            "m.userNm as userNm, " +

            "cd.dtlCdNm as protocolRuleName " +

            "from DevInfo d, ComMbr m, CdDtl cd   " +
            "where d.cretrId = m.mbrId and cd.cdDtlKey.cdGroupId = 'PROTR' and cd.cdDtlKey.dtlCd = d.protocolRule order by d.cretDt desc")
    Page<DevInfoProjection> selectAllByOrderByCretDtDesc(Pageable pageable);


    @Transactional
    @Modifying
    @Query("update DevInfo d set d.liveStatus = ?2 where d.devId = ?1")
    Integer updateLiveStatusById(String deviceId, String liveStatus);


    @Query("select " +
            "d.devId as devId, " +
            "d.devName as devName, " +
            "d.devPassword as devPassword, " +
            "d.latitVal as latitVal, " +
            "d.lngitVal as lngitVal, " +
            "d.protocolRule as protocolRule, " +
            "d.connStatus as connStatus, " +
            "d.liveStatus as liveStatus, " +
            "d.cretrId as cretrId, " +
            "m.userNm as userNm, " +

            "cd.dtlCdNm as protocolRuleName " +

            "from DevInfo d, ComMbr m, CdDtl cd   " +
            "where d.mbrSeq = ?1 and d.cretrId = m.mbrId and cd.cdDtlKey.cdGroupId = 'PROTR' and cd.cdDtlKey.dtlCd = d.protocolRule order by d.cretDt desc")
    Page<DevInfoProjection> getDevInfoProjectionsByMbrSeq(Integer mbrSeq, Pageable pageable);

    List<DevInfo> findAllByTestDevYn(Boolean testDevYn);
    List<DevInfo> findAllByTestDevYnAndCretrId(Boolean testDevYn, String cretrId);

    List<DevInfo> findAllByTestDevYnAndDevId(Boolean testDevYn, String devId);

    @Query("select d.prdtType as prdtType, d.testDevYn as testDevYn, count(d) as count from DevInfo d group by d.prdtType, d.testDevYn")
    List<DevInfoStatsProjection> getDevInfoStats();

//    select c.country_name, count(1) from  testbedweb.dev_info d, testbedweb.com_mbr c
//    where d.test_dev_yn = true and d.cretr_id = c.mbr_id group by c.country_name;

    @Query("select m.countryName from DevInfo d, ComMbr m where d.testDevYn = ?1 and d.cretrId = m.mbrId")
    List<String> getDevInfoCountryStats(Boolean testDevYn);


    @Query("select d from DevInfo d, DevCompare c where c.devCompareKey.devId = ?1 and c.devCompareKey.compareDevId = d.devId")
    List<DevInfo> getMyCompareDevice(String devId);
}
