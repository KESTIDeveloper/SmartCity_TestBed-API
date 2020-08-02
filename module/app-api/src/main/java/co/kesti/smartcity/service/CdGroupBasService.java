package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.CdGroupBas;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.model.request.RequestCdGroupBas;
import co.kesti.smartcity.repository.CdDtlRepository;
import co.kesti.smartcity.repository.CdGroupBasRepository;
import co.kesti.smartcity.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CdGroupBasService {

    private final CdGroupBasRepository cdGroupBasRepository;
    private final CdDtlRepository cdDtlRepository;

    public CdGroupBasService(CdGroupBasRepository cdGroupBasRepository, CdDtlRepository cdDtlRepository) {
        this.cdGroupBasRepository = cdGroupBasRepository;
        this.cdDtlRepository = cdDtlRepository;
    }

    public List<CdGroupBas> getCodeGroups() {
        return cdGroupBasRepository.findAll();
    }

    public CdGroupBas getCodeGroupOrThrow(String cdGroupId) {
        return cdGroupBasRepository.findById(cdGroupId)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "CodeGroup not found: "+cdGroupId));
    }

    public CdGroupBas createCodeGroup(RequestCdGroupBas requestCdGroupBas) {
        CdGroupBas cdGroupBas = requestCdGroupBas.toCodeGroup();
        return cdGroupBasRepository.save(cdGroupBas);
    }

    @Transactional
    public Integer updateCdGroupId(String cdGroupId, String newCdGroupId) {
        cdGroupBasRepository.updateCdGroupId(cdGroupId, newCdGroupId);
        return cdDtlRepository.updateCdGroupId(cdGroupId, newCdGroupId);
    }

    @Transactional
    public CdGroupBas updateCodeGroup(String cdGroupId, RequestCdGroupBas requestCdGroupBas) {
        getCodeGroupOrThrow(cdGroupId);

        log.info("{}", JsonUtils.toPrettyString(requestCdGroupBas));

        if (!cdGroupId.equals(requestCdGroupBas.getCdGroupId())) {
            CdGroupBas saved = cdGroupBasRepository.save(requestCdGroupBas.toCodeGroup());
            cdGroupBasRepository.deleteById(cdGroupId);
            return saved;
        } else {
            return cdGroupBasRepository.save(requestCdGroupBas.toCodeGroup());
        }
    }

    @Transactional
    public void delete(String cdGroupId) {
        CdGroupBas cdGroupBas = getCodeGroupOrThrow(cdGroupId);
        cdGroupBasRepository.delete(cdGroupBas);
    }
}
