package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.DevObsInfo;
import co.kesti.smartcity.entity.DevObsInfoKey;
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
public class RequestDevObsInfo {
	private String devId; // 디바이스 아이디

	private String obsItemId; // 측정항목 아이디

	private String unitType;

	@JsonIgnore
	public DevObsInfoKey getDevObsInfoKey() {
		return DevObsInfoKey.builder().devId(devId).obsItemId(obsItemId).build();
	}

	public DevObsInfo toDevObsInfo() {
		return DevObsInfo.builder()
				.devObsInfoKey(getDevObsInfoKey())
				.unitType(unitType)
				.registeDt(LocalDateTime.now())
				.build();
	}


}
	