package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CdDtlKey;
import co.kesti.smartcity.entity.DevRealtimeObs;
import co.kesti.smartcity.entity.DevRealtimeObsKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDevRealtimeObs  {
	private String devId; // 디바이스 아이디

	private String obsItemId; // 측정항목 아이디

	private LocalDateTime obsTime; // 측정시간

	private Float obsItemValue;

	private String qcStatus; //품질관리상태

	private LocalDateTime registeDt;

	@JsonIgnore
	public DevRealtimeObsKey getDevRealtimeObsKey() {
		return DevRealtimeObsKey.builder().devId(devId).obsItemId(obsItemId).obsTime(obsTime).build();
	}

	public DevRealtimeObs toDevRealtimeObs() {
		return DevRealtimeObs.builder()
				.devRealtimeObsKey(getDevRealtimeObsKey())
				.obsItemValue(obsItemValue)
				.qcStatus(qcStatus)
				.registeDt(registeDt)
				.build();
	}


}
	