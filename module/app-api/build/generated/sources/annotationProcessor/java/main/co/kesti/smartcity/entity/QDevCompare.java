package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDevCompare is a Querydsl query type for DevCompare
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDevCompare extends EntityPathBase<DevCompare> {

    private static final long serialVersionUID = 1562318079L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDevCompare devCompare = new QDevCompare("devCompare");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> amdDt = _super.amdDt;

    public final StringPath amdrId = createString("amdrId");

    public final NumberPath<Integer> compareOrder = createNumber("compareOrder", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final StringPath cretrId = createString("cretrId");

    public final QDevCompareKey devCompareKey;

    public final StringPath useYn = createString("useYn");

    public QDevCompare(String variable) {
        this(DevCompare.class, forVariable(variable), INITS);
    }

    public QDevCompare(Path<? extends DevCompare> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDevCompare(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDevCompare(PathMetadata metadata, PathInits inits) {
        this(DevCompare.class, metadata, inits);
    }

    public QDevCompare(Class<? extends DevCompare> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.devCompareKey = inits.isInitialized("devCompareKey") ? new QDevCompareKey(forProperty("devCompareKey")) : null;
    }

}

