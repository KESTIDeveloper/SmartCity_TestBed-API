package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.ComRegst;
import co.kesti.smartcity.entity.custom.ComRegstProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ComRegstRepository extends JpaRepository<ComRegst, Integer> {

//    @Query("select " +
//            "c.regstSeq as regstSeq, " +
//            "c.regstDt as regstDt, " +
//            "c.usePurpose as usePurpose, " +
//            "c.regstName as regstName, " +
//            "c.cretrId as cretrId, " +
//            "c.amdrId as amdrId, " +
//            "c.cretDt as cretDt, " +
//            "m.userNm as userNm " +
//            "from ComRegst c, ComMbr m " +
//            "where c.cretrId = ?1 and c.cretrId = m.mbrId order by c.regstDt desc")

    @Query("select " +
            "c.regstSeq as regstSeq, " +
            "c.regstDt as regstDt, " +
            "c.usePurpose as usePurpose, " +
            "c.regstName as regstName, " +
//            "c.cretrId as cretrId, " +
            "c.amdrId as amdrId, " +
            "c.cretDt as cretDt " +
            "from ComRegst c " +
            "order by c.regstDt desc")
    Page<ComRegstProjection> getComRegstsByCretrId(String cretrId, Pageable pageable);


    Page<ComRegst> findAllByComMbrCretrIdOrderByRegstDtDesc(String cretrId, Pageable pageable);

}
