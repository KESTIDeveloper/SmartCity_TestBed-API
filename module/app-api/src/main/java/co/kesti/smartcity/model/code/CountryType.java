package co.kesti.smartcity.model.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum CountryType {
    KOREA("KOR", "korea"),
    USA("USA", "usa"),
    VIETNAM("VNM", "vietnam"),
    INDONESIA("IDN", "indonesia"),
    TAIWAN("TWN", "taiwan"),
    ETC("etc", "etc")
    ;

    private String code;
    private String desc;

    public static CountryType fromCode(String code) {
        return Arrays.stream(values()).filter(countryType -> code.contains(countryType.code)).findFirst().orElse(ETC);
    }
}
