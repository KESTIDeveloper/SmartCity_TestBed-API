package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.entity.ComRegstDtl;
import co.kesti.smartcity.entity.ComRegstDtlKey;
import co.kesti.smartcity.model.request.RequestComRegstDtl;
import co.kesti.smartcity.repository.ComRegstDtlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ComRegstDtlService {

    private final ComRegstDtlRepository comRegstDtlRepository;
    private final ComMbrService comMbrService;


    public Page<ComRegstDtl> getComRegstDtlList(Integer regstSeq, Pageable pageable) {
        return comRegstDtlRepository.findAllByComRegstDtlKeyRegstSeqOrderByComRegstDtlKeySeqAsc(regstSeq, pageable);
    }

    public ComRegstDtl createComRegstDtl(RequestComRegstDtl request) {
        ComRegstDtl comRegstDtl = request.toComRegstDtl();

        ComMbr comMbr = comMbrService.getMbrById(request.getCretrId());
        comRegstDtl.setComMbr(comMbr);

        int nextSeq = comRegstDtlRepository.getNextSeqByregstSeq(request.getRegstSeq());
        comRegstDtl.setComRegstDtlKey(ComRegstDtlKey.builder()
                .regstSeq(request.getRegstSeq())
                .seq(nextSeq)
                .build());

        return comRegstDtlRepository.save(comRegstDtl);
    }

    @Transactional
    public void delete(Integer regstSeq, Integer seq) {
        comRegstDtlRepository.updateDelYnById(regstSeq, seq);
    }

}
