package com.hellozjf.test.poi;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    
    private List list = new ArrayList();
    
    public List getList() {
        return list;
    }

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        List list = listTest.getList();
        list.add(1);
        
        list = new ArrayList();
        list = listTest.getList();
        System.out.println(list.size());
    }

}
