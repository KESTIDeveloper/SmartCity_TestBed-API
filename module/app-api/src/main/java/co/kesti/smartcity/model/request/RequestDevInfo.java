package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.DevInfo;
import com.google.common.collect.Lists;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDevInfo {


	@NotBlank
	private String devId;

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

	private String prdtType;

	@Builder.Default
	private int page = 0;

	@Builder.Default
	private int size = 8;

	private String addedCompareDevices;

	public List<String> getCompareDevices() {
		return Arrays.asList(StringUtils.defaultString(addedCompareDevices).split(","));
	}
	public DevInfo toDevInfo() {
		return DevInfo.builder()
				.devId(devId)
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
				.cretrId(cretrId)
				.amdrId(amdrId)
				.prdtType(prdtType)
				.build();
	}
}
	