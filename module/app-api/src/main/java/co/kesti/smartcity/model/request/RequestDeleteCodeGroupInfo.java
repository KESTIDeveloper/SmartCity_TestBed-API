package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CdDtlKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDeleteCodeGroupInfo {

    @NotBlank
    private String cdGroupId;

    @NotBlank
    private String dtlCd;

    @NotBlank
    private String langCd;


    public CdDtlKey getCdDtlKey() {
        return CdDtlKey.builder().cdGroupId(cdGroupId).dtlCd(dtlCd).langCd(langCd).build();
    }


}
