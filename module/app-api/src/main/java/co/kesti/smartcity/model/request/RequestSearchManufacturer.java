package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.DevInfo;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSearchManufacturer {


	@NotBlank
	private String keyword;

}
	