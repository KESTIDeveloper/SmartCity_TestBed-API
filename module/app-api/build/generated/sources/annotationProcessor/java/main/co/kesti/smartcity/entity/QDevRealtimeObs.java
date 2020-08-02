package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDevRealtimeObs is a Querydsl query type for DevRealtimeObs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDevRealtimeObs extends EntityPathBase<DevRealtimeObs> {

    private static final long serialVersionUID = 1470580399L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDevRealtimeObs devRealtimeObs = new QDevRealtimeObs("devRealtimeObs");

    public final QDevRealtimeObsKey devRealtimeObsKey;

    public final NumberPath<Float> obsItemValue = createNumber("obsItemValue", Float.class);

    public final StringPath qcStatus = createString("qcStatus");

    public final DateTimePath<java.time.LocalDateTime> registeDt = createDateTime("registeDt", java.time.LocalDateTime.class);

    public QDevRealtimeObs(String variable) {
        this(DevRealtimeObs.class, forVariable(variable), INITS);
    }

    public QDevRealtimeObs(Path<? extends DevRealtimeObs> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDevRealtimeObs(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDevRealtimeObs(PathMetadata metadata, PathInits inits) {
        this(DevRealtimeObs.class, metadata, inits);
    }

    public QDevRealtimeObs(Class<? extends DevRealtimeObs> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.devRealtimeObsKey = inits.isInitialized("devRealtimeObsKey") ? new QDevRealtimeObsKey(forProperty("devRealtimeObsKey")) : null;
    }

}

