package co.kesti.smartcity.entity;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="testbedweb", name="cd_dtl", uniqueConstraints = @UniqueConstraint(columnNames = { "cdGroupId", "dtlCd" ,"langCd"}))
public class CdDtl extends BaseAuditor {

	@EmbeddedId
	private CdDtlKey cdDtlKey;

	private String dtlCdNm;

	private String dtlCdDesc;

	private Integer indcOdrg;

	@Column(nullable = false)
	private String useYn;

	private String cretrId;

	private String delYn;


	public String getDtlCd() {
		return cdDtlKey.getDtlCd();
	}
}
	