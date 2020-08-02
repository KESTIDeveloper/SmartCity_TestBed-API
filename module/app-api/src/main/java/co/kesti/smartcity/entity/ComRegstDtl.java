package co.kesti.smartcity.entity;


import co.kesti.smartcity.util.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="testbedweb", name="com_regst_dtl", uniqueConstraints = @UniqueConstraint(columnNames = { "regstSeq", "seq"}))
public class ComRegstDtl extends BaseAuditor {


	@EmbeddedId
	private ComRegstDtlKey comRegstDtlKey;

	private String revwOpn;

	private String amdrId;

	private String delYn;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cretr_id", referencedColumnName = "mbr_id")
	private ComMbr comMbr;



	public String getCretrId() {
		if (comMbr != null) {
			return comMbr.getCretrId();
		} else {
			return "";
		}

	}

	public String getUserNm() {
		if (comMbr != null) {
			return comMbr.getUserNm();
		} else {
			return "";
		}
	}




}
	