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
@Table(schema="testbedweb", name="com_regst")
public class ComRegst extends BaseAuditor{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer regstSeq;

	@Column(nullable = false)
	private LocalDateTime regstDt;

	@Column(nullable = false)
	private String regstName;

	@Column(nullable = false)
	private String rphonNo;

	@Column(nullable = false)
	private String rEmail;

	@Column(nullable = false)
	private String companyName;

	@Column(nullable = false)
	private String usePurpose;

	private String amdrId;

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


	public String getFormattedCretDt() {
		return DateTimeUtils.getDefaultFormat(getCretDt());
	}

	public String getFormattedRegstDt() {
		return DateTimeUtils.getDefaultFormat(getRegstDt());
	}


}
	