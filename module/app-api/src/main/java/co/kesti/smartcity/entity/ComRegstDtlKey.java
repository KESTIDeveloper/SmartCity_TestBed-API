package co.kesti.smartcity.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ComRegstDtlKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Integer regstSeq;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer seq;



}
