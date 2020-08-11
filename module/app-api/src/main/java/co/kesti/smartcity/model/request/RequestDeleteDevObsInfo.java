package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.CdDtlKey;
import co.kesti.smartcity.entity.DevObsInfoKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDeleteDevObsInfo {

    private String devId;

    private String obsItemId;


    public DevObsInfoKey getDevObsInfoKey() {
        return DevObsInfoKey.builder().devId(devId).obsItemId(obsItemId).build();
    }

}
