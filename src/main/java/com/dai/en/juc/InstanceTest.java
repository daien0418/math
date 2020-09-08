package com.dai.en.juc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class InstanceTest<T> {

    private int a = 0;
    private Map<String, String> map = new HashMap<String, String>();

    {
        a = 2;
        for (String k : map.keySet()) {

        }
    }

    static {
        int[] a = new int[] {};
        Integer[] num = new Integer[] {};
        Object[] objects = num;
//        ConcurrentHashMap<K, V>
        // Objects.requireNonNull(null);
        // Objects.hashCode(o);
        // TreeMap<K, V>
        // HashSet<E>
    }

    public List<? extends Number> cal(List<? extends Number> list) {
        Number first = list.get(0);
        for (Number number : list) {
            System.out.println(number.toString());
        }
        return list;
    }

    public List<? super Integer> cal2(List<? super Integer> list) {
        list.add(1);
        for (Object object : list) {

        }
        return list;
    }

    public void testDouble() {
        double d = 123.456;
        System.out.println((long) d);
    }

    public void testZhengze(String input) {
        Pattern ACCOUNT_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{4,15}$");
        System.out.println(ACCOUNT_PATTERN.matcher(input).matches());
    }

    public static void main(String args[]) {
        System.out.println(UUID.randomUUID().toString().substring(0, 8));
//        InstanceTest<Object> instanceTest = new InstanceTest<Object>();
//        String input = "abcde12345678910";
//        instanceTest.testZhengze(input);
        // instanceTest.testDouble();
        // List<? extends Number> list = instanceTest.cal(null);
    }
}
