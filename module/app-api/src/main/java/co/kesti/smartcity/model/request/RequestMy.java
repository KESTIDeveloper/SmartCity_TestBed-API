package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.DevInfo;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestMy {


	private Integer mbrSeq;

	private String cretrId;
	private Boolean adminYn; // ROLE_ADMIN, ROLE_USER

}
	