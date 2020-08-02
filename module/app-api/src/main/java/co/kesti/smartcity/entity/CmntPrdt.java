package co.kesti.smartcity.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="testbedweb", name="cmnt_prdt")
public class CmntPrdt extends BaseAuditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer prdtSeq;

    @Column(nullable = false)
    private String prdtType; // 측정기 종류

    @Column(nullable = false)
    private String prdtName; // 제품이름

    @Column(nullable = false)
    private String obsItem; // 측정항목

    @Column(nullable = false)
    private String prdtContents; // 제품내용

    private String prdtImgPath; // 사진경로
    private String attachedFilePath; // 첨부파일

    private Integer hitCnt; // 조회수
    private Integer recmdCnt; // 추천수


    private String amdrId;

    private String delYn;// 삭제 여부

    @Transient
    private String obsItemName;

    @Transient
    private String prdtTypeName;



    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cretr_id", referencedColumnName = "mbr_id")
    private ComMbr comMbr;

    public String getCretrId() {
        if (comMbr != null) {
            return comMbr.getCretrId();
        } else {
            return "";
        }

    }

    public String getUserNm() {
        if (comMbr != null) {
            return comMbr.getUserNm();
        } else {
            return "";
        }
    }

    public Boolean getHasImage() {
        return StringUtils.isNotBlank(prdtImgPath);
    }

    public Boolean getHasFile() {
        return StringUtils.isNotBlank(attachedFilePath);
    }


    public List<String> getObsItems() {
        return Arrays.asList(StringUtils.split(obsItem, ","));
    }
}
