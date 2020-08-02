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
		name="dev_obs_info",
		uniqueConstraints = @UniqueConstraint(columnNames = { "devId", "obsItemId"}))
public class DevObsInfo {
	@EmbeddedId
	private DevObsInfoKey devObsInfoKey;

	private String unitType; //단위 타입

	private LocalDateTime registeDt;

	public String getObsItemId() {
		return devObsInfoKey.getObsItemId();
	}

	public String getDevId() {
		return devObsInfoKey.getDevId();
	}

}
	