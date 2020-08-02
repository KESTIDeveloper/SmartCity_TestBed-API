package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComRegstDtl is a Querydsl query type for ComRegstDtl
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComRegstDtl extends EntityPathBase<ComRegstDtl> {

    private static final long serialVersionUID = 25024569L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComRegstDtl comRegstDtl = new QComRegstDtl("comRegstDtl");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> amdDt = _super.amdDt;

    public final StringPath amdrId = createString("amdrId");

    public final QComMbr comMbr;

    public final QComRegstDtlKey comRegstDtlKey;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final StringPath delYn = createString("delYn");

    public final StringPath revwOpn = createString("revwOpn");

    public QComRegstDtl(String variable) {
        this(ComRegstDtl.class, forVariable(variable), INITS);
    }

    public QComRegstDtl(Path<? extends ComRegstDtl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComRegstDtl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComRegstDtl(PathMetadata metadata, PathInits inits) {
        this(ComRegstDtl.class, metadata, inits);
    }

    public QComRegstDtl(Class<? extends ComRegstDtl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comMbr = inits.isInitialized("comMbr") ? new QComMbr(forProperty("comMbr")) : null;
        this.comRegstDtlKey = inits.isInitialized("comRegstDtlKey") ? new QComRegstDtlKey(forProperty("comRegstDtlKey")) : null;
    }

}

