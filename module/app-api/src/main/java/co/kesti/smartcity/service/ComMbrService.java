package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.model.request.RequestComMbr;
import co.kesti.smartcity.repository.ComMbrRepository;
import co.kesti.smartcity.util.JsonUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ComMbrService {

    private final ComMbrRepository comMbrRepository;

    public ComMbrService(ComMbrRepository comMbrRepository) {
        this.comMbrRepository = comMbrRepository;
    }

    public List<ComMbr> getComMbrs() {
        return comMbrRepository.findAll();
    }

    public ComMbr getComMbrOrThrow(Integer mbrSeq) {
        return comMbrRepository.findById(mbrSeq)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "User not found: "+mbrSeq));
    }

    public ComMbr createComMbr(RequestComMbr requestComMbr) {
        ComMbr comMbr = requestComMbr.toComMbr();
        log.info("{}", JsonUtils.toPrettyString(comMbr));
        return comMbrRepository.save(comMbr);
    }

    public ComMbr updateComMbr(Integer mbrSeq, RequestComMbr requestComMbr) {
        getComMbrOrThrow(mbrSeq);
        ComMbr comMbr = requestComMbr.toComMbr();
        comMbr.setMbrSeq(mbrSeq);
        log.info("{}", JsonUtils.toPrettyString(comMbr));
        return comMbrRepository.save(comMbr);
    }

    public Map<String, String> selectMbrMapByClass(List<String> mbrClassList) {
        return comMbrRepository.findAllByMbrClasIn(mbrClassList).stream().collect(Collectors.toMap(ComMbr::getCretrId, ComMbr::getUserNm));
    }

    public Map<String, String> selectAdminMbrList() {
        return selectMbrMapByClass(Lists.newArrayList("0001", "0002"));
    }
    @Transactional
    public void delete(Integer mbrSeq) {
        ComMbr user = getComMbrOrThrow(mbrSeq);
        comMbrRepository.delete(user);
    }

    public ComMbr getMbrById(String cretrId) {
        return comMbrRepository.findByMbrId(cretrId).orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "User not found: "+cretrId));
    }
}
