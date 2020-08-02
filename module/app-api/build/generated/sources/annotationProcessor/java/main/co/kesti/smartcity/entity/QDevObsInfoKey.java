package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDevObsInfoKey is a Querydsl query type for DevObsInfoKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QDevObsInfoKey extends BeanPath<DevObsInfoKey> {

    private static final long serialVersionUID = 96706391L;

    public static final QDevObsInfoKey devObsInfoKey = new QDevObsInfoKey("devObsInfoKey");

    public final StringPath devId = createString("devId");

    public final StringPath obsItemId = createString("obsItemId");

    public QDevObsInfoKey(String variable) {
        super(DevObsInfoKey.class, forVariable(variable));
    }

    public QDevObsInfoKey(Path<? extends DevObsInfoKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevObsInfoKey(PathMetadata metadata) {
        super(DevObsInfoKey.class, metadata);
    }

}

