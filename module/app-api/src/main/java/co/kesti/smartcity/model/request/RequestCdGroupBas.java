package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.CdGroupBas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCdGroupBas {

    @NotBlank
    private String cdGroupId;

    @NotBlank
    private String cdGroupNm;

    private String cdGroupStdNm;

    private String cdGroupDesc;

    private Integer cdLen;

    @NotBlank
    private String useYn;

    private String upCdGroupId;

    private String cretrId;

    private String delYn;


    public CdGroupBas toCodeGroup() {
        return CdGroupBas.builder()
                .cdGroupId(cdGroupId)
                .cdGroupNm(cdGroupNm)
                .cdGroupStdNm(cdGroupStdNm)
                .cdGroupDesc(cdGroupDesc)
                .cdLen(cdLen)
                .useYn(useYn)
                .upCdGroupId(upCdGroupId)
                .delYn(delYn)
                .build();
    }

}
