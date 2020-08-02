package co.kesti.smartcity.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CdDtlKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cdGroupId;

    @Column(nullable = false)
    private String dtlCd;

    @Column(nullable = false)
    private String langCd;


}
