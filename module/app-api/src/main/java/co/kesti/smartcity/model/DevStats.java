package co.kesti.smartcity.model;

import co.kesti.smartcity.entity.DevInfo;
import lombok.*;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevStats {

    private Map<String, Integer> device;
    private Map<String, Integer> testDevice;
    private Map<String, Long> country;

    public static class Stats {
        private Integer count;
        private String name;
        private String icon;
    }


}
