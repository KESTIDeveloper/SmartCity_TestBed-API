package co.kesti.smartcity.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DevCompareKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String devId;


    @Column(nullable = false)
    private String compareDevId;



}
