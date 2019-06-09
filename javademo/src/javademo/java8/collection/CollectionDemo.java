package javademo.java8.collection;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * java8 collection demo
 */
public class CollectionDemo {

    @Test
    public void test1() {
        List<String> strings = new ArrayList<String>() {{
            add("aaa");
            add("bbb");
            add("ccc");
            add(null);
        }};

        // 分组
        Map<Integer, List<String>> listMap = strings.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(String::hashCode, Collectors.toList()));
        System.out.println(JSON.toJSONString(listMap));

        // 拼接
        String collect = strings.stream()
                .collect(Collectors.joining(","));
        System.out.println("collect:" + collect);

        String collectAndThen = strings.stream()
                .collect(Collectors.collectingAndThen(Collectors.joining("="), str -> str + "=collectingAndThen"));
        System.out.println("collectAndThen:" + collectAndThen);
    }

    @Test
    public void test2() {
        List<Integer> arrayList = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        Integer maxValue = arrayList.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(x -> x)), Optional::get));

        Integer minValue = arrayList.stream()
                .collect(Collectors.collectingAndThen(Collectors.minBy((x, y) -> x - y), Optional::get));

        Integer summingInt = arrayList.stream().mapToInt(item -> item).sum();

        Double averagingDouble = arrayList.stream()
                .collect(Collectors.averagingDouble(item -> item));

        Integer reducingValue = arrayList.stream().map(item -> 2 * item).reduce(1, (sum, funcValue) -> {
            sum = sum + funcValue;
            System.out.println("sum:" + sum + ",funcValue:" + funcValue);
            return sum;
        });
        System.out.println("reducingValue:" + reducingValue);

        System.out.printf("maxValue:%d\nminValue:%d\nsummingInt:%d\naveragingDouble:%s\n"
                , maxValue
                , minValue
                , summingInt
                , averagingDouble);
    }
}
