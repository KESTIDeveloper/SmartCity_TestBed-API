package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCdGroupBas is a Querydsl query type for CdGroupBas
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCdGroupBas extends EntityPathBase<CdGroupBas> {

    private static final long serialVersionUID = 2028936837L;

    public static final QCdGroupBas cdGroupBas = new QCdGroupBas("cdGroupBas");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> amdDt = _super.amdDt;

    public final StringPath cdGroupDesc = createString("cdGroupDesc");

    public final StringPath cdGroupId = createString("cdGroupId");

    public final StringPath cdGroupNm = createString("cdGroupNm");

    public final StringPath cdGroupStdNm = createString("cdGroupStdNm");

    public final NumberPath<Integer> cdLen = createNumber("cdLen", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final StringPath cretrId = createString("cretrId");

    public final StringPath delYn = createString("delYn");

    public final StringPath upCdGroupId = createString("upCdGroupId");

    public final StringPath useYn = createString("useYn");

    public QCdGroupBas(String variable) {
        super(CdGroupBas.class, forVariable(variable));
    }

    public QCdGroupBas(Path<? extends CdGroupBas> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCdGroupBas(PathMetadata metadata) {
        super(CdGroupBas.class, metadata);
    }

}

