package co.kesti.smartcity.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="testbedweb", name="dev_compare")
public class DevCompare extends BaseAuditor {


	@EmbeddedId
	private DevCompareKey devCompareKey;

	private Integer compareOrder;

	private String amdrId;

	private String cretrId;

	private String useYn;


}
	