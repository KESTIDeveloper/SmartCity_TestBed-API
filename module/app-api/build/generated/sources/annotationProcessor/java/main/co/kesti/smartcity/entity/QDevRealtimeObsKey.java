package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDevRealtimeObsKey is a Querydsl query type for DevRealtimeObsKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QDevRealtimeObsKey extends BeanPath<DevRealtimeObsKey> {

    private static final long serialVersionUID = 1394322736L;

    public static final QDevRealtimeObsKey devRealtimeObsKey = new QDevRealtimeObsKey("devRealtimeObsKey");

    public final StringPath devId = createString("devId");

    public final StringPath obsItemId = createString("obsItemId");

    public final DateTimePath<java.time.LocalDateTime> obsTime = createDateTime("obsTime", java.time.LocalDateTime.class);

    public QDevRealtimeObsKey(String variable) {
        super(DevRealtimeObsKey.class, forVariable(variable));
    }

    public QDevRealtimeObsKey(Path<? extends DevRealtimeObsKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevRealtimeObsKey(PathMetadata metadata) {
        super(DevRealtimeObsKey.class, metadata);
    }

}

