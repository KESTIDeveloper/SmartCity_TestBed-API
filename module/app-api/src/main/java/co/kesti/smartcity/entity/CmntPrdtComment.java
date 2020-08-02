package co.kesti.smartcity.entity;


import co.kesti.smartcity.util.DateTimeUtils;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="testbedweb", name="cmnt_prdt_comment")
public class CmntPrdtComment extends BaseAuditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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

}
