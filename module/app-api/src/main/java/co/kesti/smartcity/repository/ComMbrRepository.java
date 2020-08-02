package co.kesti.smartcity.repository;

import co.kesti.smartcity.entity.ComMbr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComMbrRepository extends JpaRepository<ComMbr, Integer> {

    List<ComMbr> findAllByMbrClasIn(List<String> classList);
    Optional<ComMbr> findByMbrId(String cretrId);
}
