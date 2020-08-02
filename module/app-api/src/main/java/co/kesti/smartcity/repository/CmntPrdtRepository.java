package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.CmntPrdt;
import co.kesti.smartcity.entity.custom.CmntPrdtProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CmntPrdtRepository extends JpaRepository<CmntPrdt, Integer> {

    List<CmntPrdt> findAllByPrdtTypeAndPrdtNameContainingAndDelYnOrderByPrdtSeqDesc(String type, String prdtName, String delYn, Pageable pageable);
    List<CmntPrdt> findAllByPrdtNameContainingAndDelYnOrderByPrdtSeqDesc(String prdtName, String delYn, Pageable pageable);

//
//    @Query("select " +
//            "c.prdtSeq as prdtSeq, " +
//            "c.prdtName as prdtName, " +
//            "c.obsItem as obsItem, " +
//            "c.prdtType as prdtType, " +
//            "c.prdtContents as prdtContents, " +
//            "c.prdtImgPath as prdtImgPath, " +
//            "c.attachedFilePath as attachedFilePath, " +
//            "c.cretDt as cretDt, " +
//            "c.cretrId as cretrId, " +
//
//            "(select cd.dtlCdNm from CdDtl cd where cd.cdDtlKey.cdGroupId = 'OBSTYPE' and cd.cdDtlKey.dtlCd = c.prdtType) as prdtTypeName, " +
//            "(select cd.dtlCdNm from CdDtl cd where cd.cdDtlKey.cdGroupId = 'OBS' and cd.cdDtlKey.dtlCd = c.obsItem) as obsItemName, " +
//
//            "m.userNm as userNm " +
//            "from CmntPrdt c, ComMbr m " +
//            "where c.prdtSeq = ?1 and c.cretrId = m.mbrId")
//    Optional<CmntPrdtProjection> getProductById(Integer prdtSeq);
}
