package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CdDtlKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqeustCdDtl {

    @NotBlank
    private String cdGroupId;

    @NotBlank
    private String dtlCd;

    @NotBlank
    private String langCd;

    private String dtlCdNm;

    private String dtlCdDesc;

    private Integer indcOdrg;

    @NotBlank
    private String useYn;

    private String cretrId;

    private String delYn;

    @JsonIgnore
    public CdDtlKey getCdDtlKey() {
        return CdDtlKey.builder().cdGroupId(cdGroupId).dtlCd(dtlCd).langCd(langCd).build();
    }

    public CdDtl toCodeGroupInfo() {
        return CdDtl.builder()
                .cdDtlKey(getCdDtlKey())
                .dtlCdNm(dtlCdNm)
                .dtlCdDesc(dtlCdDesc)
                .indcOdrg(indcOdrg)
                .useYn(useYn)
                .cretrId(cretrId)
                .delYn(delYn)
                .build();
    }

}
