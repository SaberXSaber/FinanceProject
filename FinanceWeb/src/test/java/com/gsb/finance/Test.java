package com.gsb.finance;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/11/1
 * Time: 14:52
 * Description：
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map1 = new HashMap<String, String>();
        Map<String,String> map2 = new HashMap<String, String>();

        map1.put("a","11");
        map1.put("b","22");
        map1.put("c","33");
        map1.put("d","44");

        map2.put("a","11");
        map2.put("b","222");
        map2.put("a1","11");

        Map<String, String> res = getDifferenceSetByGuava(map1, map2);
        Set set = res.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            System.out.println("key: "+entry.getKey() +" value: "+entry.getValue());
        }



    }

    private static Map<String, String> getDifferenceSetByGuava(Map<String, String> bigMap, Map<String, String> smallMap) {
        Set<String> bigMapKey = bigMap.keySet();
        Set<String> smallMapKey = smallMap.keySet();
        Set<String> differenceSet = Sets.difference(bigMapKey, smallMapKey);
        Map<String, String> result = Maps.newHashMap();
        for (String key : differenceSet) {
            result.put(key, bigMap.get(key));
        }
        return result;
    }
}
