package co.kesti.smartcity.entity;

import co.kesti.smartcity.util.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@Getter
public class BaseAuditor {
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime cretDt;

    @LastModifiedDate
    private LocalDateTime amdDt;


//    @JsonIgnore
    public String getFormattedCretDt() {
        if (cretDt == null) {
            return StringUtils.EMPTY;
        }
        return DateTimeUtils.getDefaultFormat(cretDt);
    }

    @JsonIgnore
    public String getFormatModifiedTime() {
        if (amdDt == null) {
            return StringUtils.EMPTY;
        }
        return DateTimeUtils.getDefaultFormat(amdDt);
    }

}
