package co.kesti.smartcity.entity;


import co.kesti.smartcity.model.RealtimeObsData;
import com.google.common.collect.Lists;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="testbedweb", name="dev_info")
public class DevInfo extends BaseAuditor {
	@Id
	@Column(nullable = false)
	private String devId;

	@Column(nullable = false)
	private String devName;

	private String devPassword;

	private String manufacturerId;

	private String manufacturerName;

	private String protocolType; // 프로토콜 구분

	private String protocolRule; // 프로토콜 유형

	private String devImgPath;

	private String userDefName;

	private Float latitVal; // 위도

	private Float lngitVal; // 경도

	private String connStatus; // 연결상태

	private String liveStatus; // 활성화여부

	private String gatewayConnId;

	private Integer mbrSeq; // 회원 기본 일련번호

	private String cretrId; // 성성자 아이디

	private String amdrId;// 수정자 아이디

	private Boolean testDevYn;

	private String prdtType;// 수정자 아이디


	@Transient
	private String protocolRuleName;

	@Transient
	private String address;


}
	