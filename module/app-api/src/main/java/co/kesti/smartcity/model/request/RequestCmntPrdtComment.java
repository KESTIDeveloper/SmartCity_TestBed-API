package co.kesti.smartcity.model.request;


import co.kesti.smartcity.entity.CmntPrdtComment;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCmntPrdtComment {


	private Integer prdtCommentSeq; // 제품 댓글 번호
	private Integer prdtSeq; // 제품 정보 일련번호
	private Integer prdtCommentParent; // 부모댓글
	private String prdtCommentContent; // 댓글내용
	private Integer likeCnt;
	private Integer dislikeCnt;
	private String ipAdress;
	private String cretrId;
	private String amdrId;
	private String delYn;// 삭제 여부


	// TODO IP 주소
	public CmntPrdtComment toCmntPrdtComment() {
		return CmntPrdtComment.builder()
				.prdtCommentSeq(prdtCommentSeq)
				.prdtSeq(prdtSeq)
				.prdtCommentParent(prdtCommentParent)
				.prdtCommentContent(prdtCommentContent)
				.likeCnt(0)
				.dislikeCnt(0)
				.ipAdress("ip")
				.cretrId(cretrId)
				.amdrId(amdrId)
				.delYn("N")
				.build();
	}
}
	