package co.kesti.smartcity.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="testbedweb", name="com_mbr")
public class ComMbr extends BaseAuditor  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer mbrSeq;

	@Column(name = "mbr_id", nullable = false)
	private String mbrId;

	private String userNm;

	private String mbrPwd;

	private String email;

	private String mphonNo;

	private String emailRecptnYn;

	private String smsRecptnYn;

	private String mbrClas;

	private String userTokn;

	private String delYn;

	private String ipAddress;

	private String mbrPwdNew;

	private String cretrId;

	private String amdrId;

	private String countryName;

	private LocalDateTime amdDt;

	private LocalDateTime chgPwdDt;

	@Column(nullable = false)
	private String tmpPwdIssYn;

	private String rmark;

	@Column(nullable = false)
	private Integer loginFailTmscnt;

}
	