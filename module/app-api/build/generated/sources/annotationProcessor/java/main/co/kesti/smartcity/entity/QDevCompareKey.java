package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDevCompareKey is a Querydsl query type for DevCompareKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QDevCompareKey extends BeanPath<DevCompareKey> {

    private static final long serialVersionUID = -1542619936L;

    public static final QDevCompareKey devCompareKey = new QDevCompareKey("devCompareKey");

    public final StringPath compareDevId = createString("compareDevId");

    public final StringPath devId = createString("devId");

    public QDevCompareKey(String variable) {
        super(DevCompareKey.class, forVariable(variable));
    }

    public QDevCompareKey(Path<? extends DevCompareKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevCompareKey(PathMetadata metadata) {
        super(DevCompareKey.class, metadata);
    }

}

