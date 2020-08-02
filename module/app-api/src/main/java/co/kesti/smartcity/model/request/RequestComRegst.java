package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.entity.ComRegst;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestComRegst {

	@JsonFormat(pattern = "yyyy/MM/dd HH:mm")
	private LocalDateTime regstDt;

	private String regstName;

	private String rphonNo;

	private String email;

	private String companyName;

	private String usePurpose;

	private String cretrId;

	private String amdrId;

	@Builder.Default
	private int page = 0;

	@Builder.Default
	private int size = 10;


	public ComRegst toComRegst() {
		return ComRegst.builder()
				.regstDt(regstDt)
				.regstName(regstName)
				.rphonNo(rphonNo)
				.rEmail(email)
				.companyName(companyName)
				.usePurpose(usePurpose)
				.amdrId(amdrId)
				.build();
	}
}
	