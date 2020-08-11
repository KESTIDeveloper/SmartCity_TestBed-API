package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CmntPrdt;
import co.kesti.smartcity.entity.CmntPrdtComment;
import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.entity.custom.CmntPrdtCommentProjection;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.model.request.RequestCmntPrdt;
import co.kesti.smartcity.model.request.RequestCmntPrdtComment;
import co.kesti.smartcity.repository.CmntPrdtCommnetRepository;
import co.kesti.smartcity.repository.CmntPrdtRepository;
import co.kesti.smartcity.util.JsonUtils;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CmntPrdtService {

    private final CmntPrdtCommnetRepository cmntPrdtCommnetRepository;
    private final CmntPrdtRepository cmntPrdtRepository;
    private final CdDtlService cdDtlService;
    private final ComMbrService comMbrService;


    public List<CmntPrdt> getCommunityProductList() {
        return cmntPrdtRepository.findAll();
    }


    public List<CmntPrdt> getCmntPrdtListByPrdtTypeAndPrdtName(String type, String prdtName, PageRequest pageRequest) {
        List<CmntPrdt> products = Lists.newArrayList();
        if (type.equals("all")) {
            products = cmntPrdtRepository.findAllByPrdtNameContainingAndDelYnOrderByPrdtSeqDesc(prdtName, "N", pageRequest);
        } else {
            products = cmntPrdtRepository.findAllByPrdtTypeAndPrdtNameContainingAndDelYnOrderByPrdtSeqDesc(type, prdtName, "N", pageRequest);
        }

        Map<String, String> cdDtlMap = cdDtlService.getCodeGroupInfosMapByGroupId("OBS");
        Map<String, String> prdtTypMap = cdDtlService.getCodeGroupInfosMapByGroupId("OBSTYPE");

        return products.stream().map(product -> {
            String obsItemName = product.getObsItems().stream()
                    .map(obsItem -> cdDtlMap.getOrDefault(obsItem, ""))
                    .collect(Collectors.joining(", "));

            String prdtTypeName = prdtTypMap.getOrDefault(product.getPrdtType(), "");
            product.setPrdtTypeName(prdtTypeName);
            product.setObsItemName(obsItemName);
            return product;
        }).collect(Collectors.toList());
    }

    public CmntPrdt getCmntPrdtProjectionOrThrow(Integer productSeq) {
        CmntPrdt product =  cmntPrdtRepository.findById(productSeq)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "CommunityProduct not found: "+productSeq));
        Map<String, String> cdDtlMap = cdDtlService.getCodeGroupInfosMapByGroupId("OBS");
        Map<String, String> prdtTypMap = cdDtlService.getCodeGroupInfosMapByGroupId("OBSTYPE");

        String obsItemName = product.getObsItems().stream()
                .map(obsItem -> cdDtlMap.getOrDefault(obsItem, ""))
                .collect(Collectors.joining(", "));

        String prdtTypeName = prdtTypMap.getOrDefault(product.getPrdtType(), "");
        product.setPrdtTypeName(prdtTypeName);
        product.setObsItemName(obsItemName);

        log.info("USER: {}", JsonUtils.toPrettyString(product.getComMbr()));
        return product;
    }

    public CmntPrdt getCmntPrdtOrThrow(Integer productSeq) {
        return cmntPrdtRepository.findById(productSeq)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "CommunityProduct not found: "+productSeq));
    }

    //TODO 로그인한 정보 확인
    public CmntPrdt createCmntPrdt(RequestCmntPrdt request) {
        CmntPrdt cmntPrdt = request.toCmntPrdt();

        ComMbr comMbr = comMbrService.getMbrById(request.getCretrId());
        cmntPrdt.setComMbr(comMbr);
        if (cmntPrdt.getPrdtSeq() == null) {
            if (request.getObsItem().equals("all")) {
                List<CdDtl> obsItems = cdDtlService.getCodeGroupInfosByGroupId("OBS");
                String allObsItems = obsItems.stream().map(c -> c.getCdDtlKey().getDtlCd()).collect(Collectors.joining(","));
                cmntPrdt.setObsItem(allObsItems);
            }
            return cmntPrdtRepository.save(cmntPrdt);
        } else {
            return updateCmntPrdt(cmntPrdt.getPrdtSeq(), request);
        }

    }

    // TODO 첨부파일 기능
    public CmntPrdt updateCmntPrdt(Integer productSeq, RequestCmntPrdt request) {
        CmntPrdt cmntPrdt = getCmntPrdtOrThrow(productSeq);
        if (request.getObsItem().equals("all")) {
            List<CdDtl> obsItems = cdDtlService.getCodeGroupInfosByGroupId("OBS");
            String allObsItems = obsItems.stream().map(c -> c.getCdDtlKey().getDtlCd()).collect(Collectors.joining(","));
            cmntPrdt.setObsItem(allObsItems);
        } else {
            cmntPrdt.setObsItem(request.getObsItem());
        }

        cmntPrdt.setPrdtType(request.getPrdtType());
        cmntPrdt.setPrdtContents(request.getPrdtContents());
        cmntPrdt.setAttachedFilePath(request.getAttachedFilePath());
        cmntPrdt.setPrdtImgPath(request.getPrdtImgPath());
        cmntPrdt.setPrdtName(request.getPrdtName());

        log.debug("updateCommunityProduct: {}", JsonUtils.toPrettyString(cmntPrdt));
        return cmntPrdtRepository.save(cmntPrdt);
    }

    @Transactional
    public void delete(Integer productSeq) {
        CmntPrdt product = getCmntPrdtOrThrow(productSeq);
        product.setDelYn("Y");

        cmntPrdtRepository.save(product);
        cmntPrdtCommnetRepository.deleteAllByPrdtSeq(productSeq);

    }


    public CmntPrdtComment createCmntPrdtComment(RequestCmntPrdtComment request) {
        log.debug("createCmntPrdtComment: {}", JsonUtils.toString(request));
        return cmntPrdtCommnetRepository.save(request.toCmntPrdtComment());
    }

    public List<CmntPrdtCommentProjection> getCmntPrdtComments(Integer prdtSeq) {
        return cmntPrdtCommnetRepository.findAllByPrdtSeqOrderByCretDtAsc(prdtSeq);
    }

    @Transactional
    public void deleteComment(Integer prdtSeq, Integer prdtCommentSeq) {
        cmntPrdtCommnetRepository.deleteByPrdtSeqAndPrdtCommentSeq(prdtSeq, prdtCommentSeq);
    }

    @Transactional
    public CmntPrdtComment modifyCmntPrdtComment(RequestCmntPrdtComment request) {
        CmntPrdtComment cmntPrdtComment = cmntPrdtCommnetRepository.findById(request.getPrdtCommentSeq()).orElseThrow(() -> ApplicationException.builder()
                .code(ResponseCode.RESOURCE_NOT_FOUND)
                .build());

        cmntPrdtComment.setPrdtCommentContent(request.getPrdtCommentContent());

        log.debug("modifyCmntPrdtComment: {}", JsonUtils.toString(cmntPrdtComment));
        return cmntPrdtCommnetRepository.save(request.toCmntPrdtComment());
    }
}
