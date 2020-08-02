package co.kesti.smartcity.entity;


import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="testbedweb",
		name="dev_realtime_obs",
		uniqueConstraints = @UniqueConstraint(columnNames = { "devId", "obsItemId" ,"obsTime"}))
public class DevRealtimeObs {
	@EmbeddedId
	private DevRealtimeObsKey devRealtimeObsKey;

	private Float obsItemValue;

	private String qcStatus; //품질관리상태

	private LocalDateTime registeDt;

	public String getDevId() {
		return devRealtimeObsKey.getDevId();
	}

	public String getObsItemId() {
		return devRealtimeObsKey.getObsItemId();
	}



}
	