package co.kesti.smartcity.util;

import java.util.List;
import java.util.Optional;

public class StreamUtil {
    public static <T> Optional<T> head(List<T> list) {
        return list.stream().findFirst();
    }
}
