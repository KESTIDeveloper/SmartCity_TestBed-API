package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDevObsInfo is a Querydsl query type for DevObsInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDevObsInfo extends EntityPathBase<DevObsInfo> {

    private static final long serialVersionUID = -1040327192L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDevObsInfo devObsInfo = new QDevObsInfo("devObsInfo");

    public final QDevObsInfoKey devObsInfoKey;

    public final DateTimePath<java.time.LocalDateTime> registeDt = createDateTime("registeDt", java.time.LocalDateTime.class);

    public final StringPath unitType = createString("unitType");

    public QDevObsInfo(String variable) {
        this(DevObsInfo.class, forVariable(variable), INITS);
    }

    public QDevObsInfo(Path<? extends DevObsInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDevObsInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDevObsInfo(PathMetadata metadata, PathInits inits) {
        this(DevObsInfo.class, metadata, inits);
    }

    public QDevObsInfo(Class<? extends DevObsInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.devObsInfoKey = inits.isInitialized("devObsInfoKey") ? new QDevObsInfoKey(forProperty("devObsInfoKey")) : null;
    }

}

