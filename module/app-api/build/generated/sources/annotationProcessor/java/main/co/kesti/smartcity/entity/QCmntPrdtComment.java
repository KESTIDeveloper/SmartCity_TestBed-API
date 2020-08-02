package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCmntPrdtComment is a Querydsl query type for CmntPrdtComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCmntPrdtComment extends EntityPathBase<CmntPrdtComment> {

    private static final long serialVersionUID = 1837753742L;

    public static final QCmntPrdtComment cmntPrdtComment = new QCmntPrdtComment("cmntPrdtComment");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> amdDt = _super.amdDt;

    public final StringPath amdrId = createString("amdrId");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final StringPath cretrId = createString("cretrId");

    public final StringPath delYn = createString("delYn");

    public final NumberPath<Integer> dislikeCnt = createNumber("dislikeCnt", Integer.class);

    public final StringPath ipAdress = createString("ipAdress");

    public final NumberPath<Integer> likeCnt = createNumber("likeCnt", Integer.class);

    public final StringPath prdtCommentContent = createString("prdtCommentContent");

    public final NumberPath<Integer> prdtCommentParent = createNumber("prdtCommentParent", Integer.class);

    public final NumberPath<Integer> prdtCommentSeq = createNumber("prdtCommentSeq", Integer.class);

    public final NumberPath<Integer> prdtSeq = createNumber("prdtSeq", Integer.class);

    public QCmntPrdtComment(String variable) {
        super(CmntPrdtComment.class, forVariable(variable));
    }

    public QCmntPrdtComment(Path<? extends CmntPrdtComment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCmntPrdtComment(PathMetadata metadata) {
        super(CmntPrdtComment.class, metadata);
    }

}

