package co.kesti.smartcity.model.response;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMyPageComRegst {

    private LocalDateTime regstDt;

    private String regstName;

    private String rphonNo;

    private String email;

    private String companyName;

    private String usePurpose;

    private String cretrId;

    private String amdrId;
}
