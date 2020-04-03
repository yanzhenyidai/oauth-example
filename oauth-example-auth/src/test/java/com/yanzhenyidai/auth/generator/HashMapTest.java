package com.yanzhenyidai.auth.generator;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author frank
 * @version 1.0
 * @date 2019-09-08 22:38
 */
public class HashMapTest {


    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(null, "1");
        System.out.println(map.toString());
        System.out.println("".hashCode());

        Map<Integer, String> table = new Hashtable<>();
        table.put(null, "");
        System.out.println(table.toString());
    }
}
