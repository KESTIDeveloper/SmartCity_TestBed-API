package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CdDtlKey;
import co.kesti.smartcity.entity.ComRegstDtl;
import co.kesti.smartcity.entity.ComRegstDtlKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComRegstDtlRepository extends JpaRepository<ComRegstDtl, ComRegstDtlKey> {

    Page<ComRegstDtl> findAllByComRegstDtlKeyRegstSeqOrderByComRegstDtlKeySeqAsc(Integer regstSeq, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update ComRegstDtl c set c.delYn = 'Y' where c.comRegstDtlKey.regstSeq = ?1 and c.comRegstDtlKey.seq = ?2")
    Integer updateDelYnById(Integer regstSeq, Integer se1);


    @Query("select max(c.comRegstDtlKey.seq) + 1 from ComRegstDtl c where c.comRegstDtlKey.regstSeq = ?1")
    Integer getNextSeqByregstSeq(Integer regstSeq);
}
