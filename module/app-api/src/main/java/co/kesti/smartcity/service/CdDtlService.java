package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CdDtlKey;
import co.kesti.smartcity.model.request.ReqeustCdDtl;
import co.kesti.smartcity.model.request.RequestSearchManufacturer;
import co.kesti.smartcity.repository.CdDtlRepository;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CdDtlService {

    private final CdDtlRepository cdDtlRepository;

    public CdDtlService(CdDtlRepository cdDtlRepository) {
        this.cdDtlRepository = cdDtlRepository;
    }

    public List<CdDtl> getCodeGroupInfos() {
        return cdDtlRepository.findAll();
    }

    public CdDtl getCodeGroupInfoOrThrow(CdDtlKey cdDtlKey) {
        return cdDtlRepository.findByCdDtlKey(cdDtlKey)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "CodeGroupInfo not found: "+JsonUtils.toString(cdDtlKey)));
    }

    public CdDtl createCodeGroupInfo(ReqeustCdDtl requestCodeGroup) {
        CdDtl cdDtl = requestCodeGroup.toCodeGroupInfo();
        log.info("{}", JsonUtils.toPrettyString(cdDtl));
        return cdDtlRepository.save(cdDtl);
    }

    public CdDtl updateCodeGroupInfo(ReqeustCdDtl reqeustCdDtl) {
        getCodeGroupInfoOrThrow(reqeustCdDtl.getCdDtlKey());
        CdDtl cdDtl = reqeustCdDtl.toCodeGroupInfo();
        cdDtl.setCdDtlKey(reqeustCdDtl.getCdDtlKey());
        log.info("{}", JsonUtils.toPrettyString(cdDtl));
        return cdDtlRepository.save(cdDtl);
    }

    @Transactional
    public void delete(CdDtlKey cdDtlKey) {
        CdDtl cdDtl = getCodeGroupInfoOrThrow(cdDtlKey);
        cdDtlRepository.delete(cdDtl);
    }


    public List<CdDtl> getCodeGroupInfosByGroupId(String cdGroupId) {
        return cdDtlRepository.findAllByCdDtlKeyCdGroupId(cdGroupId);
    }


    public Map<String, String> getCodeGroupInfosMapByGroupId(String cdGroupId) {
        return getCodeGroupInfosByGroupId(cdGroupId).stream().collect(Collectors.toMap(CdDtl::getDtlCd, CdDtl::getDtlCdNm));
    }

    public Map<String, String> getObsItemMap() {
        return getCodeGroupInfosMapByGroupId("OBS");
    }

    public Map<String, String> getObsTypeMap() {
        return getCodeGroupInfosMapByGroupId("OBSTYPE");
    }
    public Map<String, String> getObsItemUnitMap() {
        return getCodeGroupInfosMapByGroupId("OBSUNIT");
    }

    public Map<String, String> getProtocolRuleMap() {
        return getCodeGroupInfosMapByGroupId("PROTR");
    }
    public Map<String, String> get() {
        return getCodeGroupInfosMapByGroupId("PROTR");
    }

    public List<CdDtl> searchManufacturer(RequestSearchManufacturer request) {
        List<CdDtl> cdDtls = getCodeGroupInfosByGroupId("MANF");
        return cdDtls.stream().filter(cdDtl -> cdDtl.getDtlCdNm().contains(request.getKeyword())).collect(Collectors.toList());
    }
}
