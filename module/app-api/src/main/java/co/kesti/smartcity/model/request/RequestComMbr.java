package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.ComMbr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestComMbr {

	@NotBlank
	private Integer mbrSeq;

	@NotBlank
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
	
	private String mbrRoleVal;

	private String mbrPwdNew;

	private String cretrId;

	private String amdrId;

	private LocalDateTime chgPwdDt;

	private String tmpPwdIssYn;

	private String rmark;

	private Integer loginFailTmscnt;


	public ComMbr toComMbr() {
		return ComMbr.builder()
				.mbrSeq(mbrSeq)
				.mbrId(mbrId)
				.userNm(userNm)
				.mphonNo(mphonNo)
				.email(email)
				.emailRecptnYn(emailRecptnYn)
				.smsRecptnYn(smsRecptnYn)
				.userTokn(userTokn)
				.mbrPwd(mbrPwd)
				.delYn(delYn)
				.mbrClas(mbrClas)
				.mbrPwdNew(mbrPwdNew)
				.cretrId(cretrId)
				.amdrId(amdrId)
				.chgPwdDt(chgPwdDt)
				.tmpPwdIssYn(tmpPwdIssYn)
				.rmark(rmark)
				.loginFailTmscnt(loginFailTmscnt)
				.build();
	}
}
	