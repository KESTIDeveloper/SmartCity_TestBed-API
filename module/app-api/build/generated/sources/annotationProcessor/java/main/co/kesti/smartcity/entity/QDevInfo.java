package co.kesti.smartcity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDevInfo is a Querydsl query type for DevInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDevInfo extends EntityPathBase<DevInfo> {

    private static final long serialVersionUID = -576449836L;

    public static final QDevInfo devInfo = new QDevInfo("devInfo");

    public final QBaseAuditor _super = new QBaseAuditor(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> amdDt = _super.amdDt;

    public final StringPath amdrId = createString("amdrId");

    public final StringPath connStatus = createString("connStatus");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cretDt = _super.cretDt;

    public final StringPath cretrId = createString("cretrId");

    public final StringPath devId = createString("devId");

    public final StringPath devImgPath = createString("devImgPath");

    public final StringPath devName = createString("devName");

    public final StringPath devPassword = createString("devPassword");

    public final StringPath gatewayConnId = createString("gatewayConnId");

    public final NumberPath<Float> latitVal = createNumber("latitVal", Float.class);

    public final StringPath liveStatus = createString("liveStatus");

    public final NumberPath<Float> lngitVal = createNumber("lngitVal", Float.class);

    public final StringPath manufacturerId = createString("manufacturerId");

    public final StringPath manufacturerName = createString("manufacturerName");

    public final NumberPath<Integer> mbrSeq = createNumber("mbrSeq", Integer.class);

    public final StringPath protocolRule = createString("protocolRule");

    public final StringPath protocolType = createString("protocolType");

    public final BooleanPath testDevYn = createBoolean("testDevYn");

    public final StringPath userDefName = createString("userDefName");

    public QDevInfo(String variable) {
        super(DevInfo.class, forVariable(variable));
    }

    public QDevInfo(Path<? extends DevInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevInfo(PathMetadata metadata) {
        super(DevInfo.class, metadata);
    }

}

