package com.hellozjf.test.poi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    
    public static Map getMap(String[] args) {
        Map param = new HashMap();
        param.put("key1", "value1");
        param.put("key2", "value2");
        String[] value3 = new String[] {"value31", "value32", "value33"};
//        param.put("key3", value3);
        List value4 = Arrays.asList(value3);
        param.put("key4", value4);
        
        Map program = new HashMap();
        program.put("param", param);
        
        return program;
    }

    public static void main(String[] args) {
        Map program = getMap(args);
        System.out.println(program);
        
        Map param = (Map) program.get("param");
        String value1 = (String) param.get("key1");
        String value2 = (String) param.get("key2");
        List value4 = (List) param.get("key4");
        System.out.println(value1);
        System.out.println(value2);
        for (int i = 0; i < value4.size(); i++) {
            System.out.println(value4.get(i));
        }
    }
}
