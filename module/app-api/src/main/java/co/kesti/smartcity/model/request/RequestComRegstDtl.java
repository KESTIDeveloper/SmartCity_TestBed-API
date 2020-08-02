package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.ComRegst;
import co.kesti.smartcity.entity.ComRegstDtl;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestComRegstDtl {


	private Integer regstSeq;

	private String cretrId;

	private String amdrId;

	private String revwOpn;

	@Builder.Default
	private String delYn = "N";

	@Builder.Default
	private int page = 0;

	@Builder.Default
	private int size = 10;


	public ComRegstDtl toComRegstDtl() {
		return ComRegstDtl.builder()
				.revwOpn(revwOpn)
				.delYn(delYn)
				.amdrId(amdrId)
				.build();
	}
}
	