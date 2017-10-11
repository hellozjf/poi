package com.hellozjf.test.poi;

public class LastPointString {
    
    public static String getLastPointString(String key) {
        String[] ss = key.split("\\.");
        return ss[ss.length - 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "emxFramework.String.Hello";
        s = getLastPointString(s);
        System.out.println(s);
    }

}
