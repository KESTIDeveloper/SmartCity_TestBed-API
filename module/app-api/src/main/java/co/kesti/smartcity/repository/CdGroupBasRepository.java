package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.CdGroupBas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CdGroupBasRepository extends JpaRepository<CdGroupBas, String> {

    @Transactional
    @Modifying
    @Query("update CdGroupBas c set c.cdGroupId  = ?2 where c.cdGroupId = ?1")
    Integer updateCdGroupId(String cdGroupId, String newCdGroupId);
}
