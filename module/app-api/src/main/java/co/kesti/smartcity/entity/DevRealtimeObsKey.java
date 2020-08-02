package co.kesti.smartcity.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DevRealtimeObsKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String devId; // 디바이스 아이디

    @Column(nullable = false)
    private String obsItemId; // 측정항목 아이디

    @Column(nullable = false)
    private LocalDateTime obsTime; // 측정시간


}
