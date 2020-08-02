package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CdDtlKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CdDtlRepository extends JpaRepository<CdDtl, CdDtlKey> {

    Optional<CdDtl> findByCdDtlKey(CdDtlKey cdDtlKey);

    void deleteByCdDtlKey(CdDtlKey cdDtlKey);

    List<CdDtl> findAllByCdDtlKeyCdGroupId(String cdGroupId);


    @Transactional
    @Modifying
    @Query("update CdDtl c set c.cdDtlKey.cdGroupId  = ?2 where c.cdDtlKey.cdGroupId = ?1")
    Integer updateCdGroupId(String cdGroupId, String newCdGroupId);
}
