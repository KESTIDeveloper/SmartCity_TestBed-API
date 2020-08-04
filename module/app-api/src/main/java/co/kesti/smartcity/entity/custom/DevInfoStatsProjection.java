package co.kesti.smartcity.entity.custom;

public interface DevInfoStatsProjection {

    String getPrdtType();
    Boolean getTestDevYn();
    Integer getCount();


    default String getPrdtCode() {
        switch (getPrdtType()) {
            case "OBSTYPE001":
                return "static";
            case "OBSTYPE002":
                return "move";
            default:
                return "port";
        }
    }
}
