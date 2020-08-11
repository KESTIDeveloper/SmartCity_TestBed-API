package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComMbr is a Querydsl query type for ComMbr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComMbr extends EntityPathBase<ComMbr> {

    private static final long serialVersionUID = -1562274389L;

    public static final QComMbr comMbr = new QComMbr("comMbr");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    public final DateTimePath<java.time.LocalDateTime> amdDt = createDateTime("amdDt", java.time.LocalDateTime.class);

    public final StringPath amdrId = createString("amdrId");

    public final DateTimePath<java.time.LocalDateTime> chgPwdDt = createDateTime("chgPwdDt", java.time.LocalDateTime.class);

    public final StringPath countryName = createString("countryName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final StringPath cretrId = createString("cretrId");

    public final StringPath delYn = createString("delYn");

    public final StringPath email = createString("email");

    public final StringPath emailRecptnYn = createString("emailRecptnYn");

    public final StringPath ipAddress = createString("ipAddress");

    public final NumberPath<Integer> loginFailTmscnt = createNumber("loginFailTmscnt", Integer.class);

    public final StringPath mbrClas = createString("mbrClas");

    public final StringPath mbrId = createString("mbrId");

    public final StringPath mbrPwd = createString("mbrPwd");

    public final StringPath mbrPwdNew = createString("mbrPwdNew");

    public final NumberPath<Integer> mbrSeq = createNumber("mbrSeq", Integer.class);

    public final StringPath mphonNo = createString("mphonNo");

    public final StringPath rmark = createString("rmark");

    public final StringPath smsRecptnYn = createString("smsRecptnYn");

    public final StringPath tmpPwdIssYn = createString("tmpPwdIssYn");

    public final StringPath userNm = createString("userNm");

    public final StringPath userTokn = createString("userTokn");

    public QComMbr(String variable) {
        super(ComMbr.class, forVariable(variable));
    }

    public QComMbr(Path<? extends ComMbr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComMbr(PathMetadata metadata) {
        super(ComMbr.class, metadata);
    }

}

