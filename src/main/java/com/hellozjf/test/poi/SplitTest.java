package com.hellozjf.test.poi;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SplitTest {
    
    public static final Log LOG = LogFactory.getLog(SplitTest.class);
    
    public static String getRangeName(String select) {
        if (!select.contains("attribute")) {
            return "";
        }
        String[] s1 = select.split("\\[");
        if (s1.length != 2) {
            return "";
        }
        LOG.debug(Arrays.asList(s1));
        String[] s2 = s1[1].split("\\]");
        LOG.debug(Arrays.asList(s2));
        if (s2.length != 2) {
            return "";
        }
        LOG.debug(Arrays.asList(s2));
        return s2[0];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "attribute[Bmbim_contract_type]";
        String split = getRangeName(s);
        System.out.println(split);
    }

}
