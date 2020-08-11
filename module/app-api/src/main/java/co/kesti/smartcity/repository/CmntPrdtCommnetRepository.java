package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.CmntPrdtComment;
import co.kesti.smartcity.entity.custom.CmntPrdtCommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CmntPrdtCommnetRepository extends JpaRepository<CmntPrdtComment, Integer> {


    @Query("select " +
            "c.prdtSeq as prdtSeq, " +
            "c.prdtCommentSeq as prdtCommentSeq, " +
            "c.prdtCommentParent as prdtCommentParent, " +
            "c.prdtCommentContent as prdtCommentContent, " +
            "c.likeCnt as likeCnt, " +
            "c.dislikeCnt as dislikeCnt, " +
            "c.ipAdress as ipAdress, " +
            "c.cretrId as cretrId, " +
            "c.amdrId as amdrId, " +
            "c.cretDt as cretDt, " +
            "c.delYn as delYn, " +

            "m.userNm as userNm " +
            "from CmntPrdtComment c, ComMbr m " +
            "where c.prdtSeq = ?1 and c.cretrId = m.mbrId " +
            "order by c.prdtCommentSeq asc")
    List<CmntPrdtCommentProjection> findAllByPrdtSeqOrderByCretDtAsc(Integer prdtSeq);


    @Transactional
    @Modifying
    @Query("update CmntPrdtComment c set c.delYn = 'N' where c.prdtSeq = ?1")
    void deleteAllByPrdtSeq(Integer prdtSeq);


    void deleteByPrdtSeqAndPrdtCommentSeq(Integer prdtSeq, Integer prdtCommentSeq);

}
