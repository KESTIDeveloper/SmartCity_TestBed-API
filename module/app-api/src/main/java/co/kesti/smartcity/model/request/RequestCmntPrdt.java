package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.CmntPrdt;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCmntPrdt {


	private Integer prdtSeq;
	private String prdtType; // 측정기 종류
	private String prdtName; // 제품이름
	private String obsItem; // 측정항목
	private String prdtContents; // 제품내용

	private String prdtImgPath; // 사진경로
	private String attachedFilePath; // 첨부파일
	private int hitCnt; // 조회수
	private int recmdCnt; // 추천수
	private String cretrId;
	private String amdrId;

	@Builder.Default
	private String delYn = "N";// 삭제 여부


	public CmntPrdt toCmntPrdt() {
		return CmntPrdt.builder()
				.prdtSeq(prdtSeq)
				.prdtType(prdtType)
				.prdtName(prdtName)
				.obsItem(obsItem)
				.prdtImgPath(prdtImgPath)
				.prdtContents(prdtContents)
				.attachedFilePath(attachedFilePath)
				.hitCnt(hitCnt)
				.recmdCnt(recmdCnt)
				.amdrId(amdrId)
				.delYn(delYn)
				.build();
	}
}
	