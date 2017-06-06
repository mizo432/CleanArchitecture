package jp.or.venuspj.utils;

import java.util.ArrayList;
import java.util.List;

public final class Lists2 {

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> List<T> newArrayList(T... args) {
        List<T> result = new ArrayList<>();
        for (T arg : args) {
            result.add(arg);
        }
        return result;
    }
}
