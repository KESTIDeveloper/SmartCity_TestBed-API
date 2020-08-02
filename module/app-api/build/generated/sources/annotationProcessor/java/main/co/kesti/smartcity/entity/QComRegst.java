package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComRegst is a Querydsl query type for ComRegst
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComRegst extends EntityPathBase<ComRegst> {

    private static final long serialVersionUID = 1897565859L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComRegst comRegst = new QComRegst("comRegst");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> amdDt = _super.amdDt;

    public final StringPath amdrId = createString("amdrId");

    public final QComMbr comMbr;

    public final StringPath companyName = createString("companyName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final DateTimePath<java.time.LocalDateTime> regstDt = createDateTime("regstDt", java.time.LocalDateTime.class);

    public final StringPath regstName = createString("regstName");

    public final NumberPath<Integer> regstSeq = createNumber("regstSeq", Integer.class);

    public final StringPath rEmail = createString("rEmail");

    public final StringPath rphonNo = createString("rphonNo");

    public final StringPath usePurpose = createString("usePurpose");

    public QComRegst(String variable) {
        this(ComRegst.class, forVariable(variable), INITS);
    }

    public QComRegst(Path<? extends ComRegst> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComRegst(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComRegst(PathMetadata metadata, PathInits inits) {
        this(ComRegst.class, metadata, inits);
    }

    public QComRegst(Class<? extends ComRegst> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comMbr = inits.isInitialized("comMbr") ? new QComMbr(forProperty("comMbr")) : null;
    }

}

