package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseAuditor is a Querydsl query type for BaseAuditor
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBaseAuditor extends EntityPathBase<BaseAuditor> {

    private static final long serialVersionUID = -426657058L;

    public static final QBaseAuditor baseAuditor = new QBaseAuditor("baseAuditor");

    public final DateTimePath<java.time.LocalDateTime> amdDt = createDateTime("amdDt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> cretDt = createDateTime("cretDt", java.time.LocalDateTime.class);

    public QBaseAuditor(String variable) {
        super(BaseAuditor.class, forVariable(variable));
    }

    public QBaseAuditor(Path<? extends BaseAuditor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseAuditor(PathMetadata metadata) {
        super(BaseAuditor.class, metadata);
    }

}

