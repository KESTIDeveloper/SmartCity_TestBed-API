package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCdDtlKey is a Querydsl query type for CdDtlKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCdDtlKey extends BeanPath<CdDtlKey> {

    private static final long serialVersionUID = -417254317L;

    public static final QCdDtlKey cdDtlKey = new QCdDtlKey("cdDtlKey");

    public final StringPath cdGroupId = createString("cdGroupId");

    public final StringPath dtlCd = createString("dtlCd");

    public final StringPath langCd = createString("langCd");

    public QCdDtlKey(String variable) {
        super(CdDtlKey.class, forVariable(variable));
    }

    public QCdDtlKey(Path<? extends CdDtlKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCdDtlKey(PathMetadata metadata) {
        super(CdDtlKey.class, metadata);
    }

}

