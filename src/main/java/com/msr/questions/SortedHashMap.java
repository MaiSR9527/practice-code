package com.msr.questions;

import com.msr.entity.Person;

import java.util.*;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/13 15:28
 * @version: v1.0
 */

public class SortedHashMap {

    /**
     * 已知一个 HashMap<Integer，User>集合， User 有 name（String）和 age（int）属性。请写一个方法实现对
     * HashMap 的排序功能，该方法接收 HashMap<Integer，User>为形参，返回类型为 HashMap<Integer，User>，
     * 要求对 HashMap 中的 User 的 age 倒序进行排序。排序时 key=value 键值对不得拆散。
     */

    public static void main(String[] args) {
        HashMap<Integer, Person> hashMap = new HashMap<>();

        hashMap.put(1,new Person("1","张三",25));
        hashMap.put(3,new Person("3","李四",30));
        hashMap.put(2,new Person("2","王五",40));
        hashMap.put(4,new Person("4","王八",28));
        System.out.println(hashMap);
        HashMap<Integer, Person> map = sortedHashMap(hashMap);
        System.out.println(map);
    }

    private static HashMap<Integer,Person> sortedHashMap(HashMap<Integer,Person> map){
        //先拿到map的键值对组合
        Set<Map.Entry<Integer, Person>> entrySet = map.entrySet();

        //set集合转成list集合
        ArrayList<Map.Entry<Integer,Person>> list = new ArrayList<>(entrySet);
        list.sort((o1, o2) -> o2.getValue().getAge() - o1.getValue().getAge());

        //创建一个新的有序的HashMap集合
        LinkedHashMap<Integer, Person> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Person> entry : list) {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}
