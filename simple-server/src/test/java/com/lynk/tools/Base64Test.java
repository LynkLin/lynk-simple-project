package com.lynk.tools;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) {
        byte[] bs = Base64.getDecoder().decode("OQ==");
        try {
            System.out.println(">>>" + new String(bs, "GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
