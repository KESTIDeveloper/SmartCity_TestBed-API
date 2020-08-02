package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComRegstDtlKey is a Querydsl query type for ComRegstDtlKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QComRegstDtlKey extends BeanPath<ComRegstDtlKey> {

    private static final long serialVersionUID = -1817299098L;

    public static final QComRegstDtlKey comRegstDtlKey = new QComRegstDtlKey("comRegstDtlKey");

    public final NumberPath<Integer> regstSeq = createNumber("regstSeq", Integer.class);

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public QComRegstDtlKey(String variable) {
        super(ComRegstDtlKey.class, forVariable(variable));
    }

    public QComRegstDtlKey(Path<? extends ComRegstDtlKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComRegstDtlKey(PathMetadata metadata) {
        super(ComRegstDtlKey.class, metadata);
    }

}

