package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCdDtl is a Querydsl query type for CdDtl
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCdDtl extends EntityPathBase<CdDtl> {

    private static final long serialVersionUID = -1436235156L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCdDtl cdDtl = new QCdDtl("cdDtl");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> amdDt = _super.amdDt;

    public final QCdDtlKey cdDtlKey;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final StringPath cretrId = createString("cretrId");

    public final StringPath delYn = createString("delYn");

    public final StringPath dtlCdDesc = createString("dtlCdDesc");

    public final StringPath dtlCdNm = createString("dtlCdNm");

    public final NumberPath<Integer> indcOdrg = createNumber("indcOdrg", Integer.class);

    public final StringPath useYn = createString("useYn");

    public QCdDtl(String variable) {
        this(CdDtl.class, forVariable(variable), INITS);
    }

    public QCdDtl(Path<? extends CdDtl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCdDtl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCdDtl(PathMetadata metadata, PathInits inits) {
        this(CdDtl.class, metadata, inits);
    }

    public QCdDtl(Class<? extends CdDtl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cdDtlKey = inits.isInitialized("cdDtlKey") ? new QCdDtlKey(forProperty("cdDtlKey")) : null;
    }

}

