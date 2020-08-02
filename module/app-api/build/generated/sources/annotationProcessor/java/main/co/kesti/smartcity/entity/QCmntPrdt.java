package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCmntPrdt is a Querydsl query type for CmntPrdt
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCmntPrdt extends EntityPathBase<CmntPrdt> {

    private static final long serialVersionUID = 181971857L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCmntPrdt cmntPrdt = new QCmntPrdt("cmntPrdt");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> amdDt = _super.amdDt;

    public final StringPath amdrId = createString("amdrId");

    public final StringPath attachedFilePath = createString("attachedFilePath");

    public final QComMbr comMbr;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final StringPath delYn = createString("delYn");

    public final NumberPath<Integer> hitCnt = createNumber("hitCnt", Integer.class);

    public final StringPath obsItem = createString("obsItem");

    public final StringPath prdtContents = createString("prdtContents");

    public final StringPath prdtImgPath = createString("prdtImgPath");

    public final StringPath prdtName = createString("prdtName");

    public final NumberPath<Integer> prdtSeq = createNumber("prdtSeq", Integer.class);

    public final StringPath prdtType = createString("prdtType");

    public final NumberPath<Integer> recmdCnt = createNumber("recmdCnt", Integer.class);

    public QCmntPrdt(String variable) {
        this(CmntPrdt.class, forVariable(variable), INITS);
    }

    public QCmntPrdt(Path<? extends CmntPrdt> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCmntPrdt(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCmntPrdt(PathMetadata metadata, PathInits inits) {
        this(CmntPrdt.class, metadata, inits);
    }

    public QCmntPrdt(Class<? extends CmntPrdt> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comMbr = inits.isInitialized("comMbr") ? new QComMbr(forProperty("comMbr")) : null;
    }

}

