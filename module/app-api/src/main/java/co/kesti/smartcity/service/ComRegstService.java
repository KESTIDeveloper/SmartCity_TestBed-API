package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.entity.ComRegst;
import co.kesti.smartcity.entity.custom.ComRegstProjection;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.model.request.RequestComRegst;
import co.kesti.smartcity.repository.ComMbrRepository;
import co.kesti.smartcity.repository.ComRegstRepository;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class ComRegstService {

    private final ComRegstRepository comRegstRepository;
    private final ComMbrService comMbrService;

    public ComRegstService(ComRegstRepository comRegstRepository, ComMbrService comMbrService) {
        this.comRegstRepository = comRegstRepository;
        this.comMbrService = comMbrService;
    }

    public List<ComRegst> getComRegsts() {
        return comRegstRepository.findAll();
    }

    public ComRegst getComRegst(Integer regstSeq) {
        return comRegstRepository.findById(regstSeq)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "User not found: "+ regstSeq));
    }

    public ComRegst createComRegst(RequestComRegst requestComRegst) {
        ComRegst comRegst = requestComRegst.toComRegst();

        ComMbr comMbr = comMbrService.getMbrById(requestComRegst.getCretrId());
        comRegst.setComMbr(comMbr);

        return comRegstRepository.save(comRegst);
    }

    public ComRegst updateComRegst(Integer regstSeq, RequestComRegst requestComRegst) {
        getComRegst(regstSeq);
        ComRegst comRegst = requestComRegst.toComRegst();
        comRegst.setRegstSeq(regstSeq);
        ComMbr comMbr = comMbrService.getMbrById(requestComRegst.getCretrId());
        comRegst.setComMbr(comMbr);
        return comRegstRepository.save(comRegst);
    }

    @Transactional
    public void delete(Integer regstSeq) {
        ComRegst comRegst = getComRegst(regstSeq);
        comRegstRepository.delete(comRegst);
    }

    public Page<ComRegst> getComRegstsByCretrId(String cretrId, Pageable pageable) {
        return comRegstRepository.findAllByComMbrCretrIdOrderByRegstDtDesc(cretrId, pageable);
    }
}
