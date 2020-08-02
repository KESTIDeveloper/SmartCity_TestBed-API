package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.DevInfo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDevInfo {


	@NotBlank
	private String devName;

	private String devPassword;

	private String manufacturerId;

	private String manufacturerName;

	private String protocolType;

	private String protocolRule;

	private String devImgPath;

	private String userDefName;

	private Float latitVal;

	private Float lngitVal;

	private String connStatus;

	private String liveStatus;

	private String gatewayConnId;

	private Integer mbrSeq;

	private String cretrId;

	private String amdrId;

	@Builder.Default
	private int page = 0;

	@Builder.Default
	private int size = 8;


	public DevInfo toDevInfo() {
		return DevInfo.builder()
				.devName(devName)
				.devPassword(devPassword)
				.manufacturerId(manufacturerId)
				.manufacturerName(manufacturerName)
				.protocolType(protocolType)
				.protocolRule(protocolRule)
				.devImgPath(devImgPath)
				.userDefName(userDefName)
				.latitVal(latitVal)
				.lngitVal(lngitVal)
				.lngitVal(lngitVal)
				.connStatus(connStatus)
				.liveStatus(liveStatus)
				.gatewayConnId(gatewayConnId)
				.mbrSeq(mbrSeq)
				.amdrId(amdrId)
				.build();
	}
}
	