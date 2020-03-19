package com.ivan.sje.util;

import sun.nio.cs.UnicodeEncoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringUtil {

    public static String covertToIso(String str) throws UnsupportedEncodingException {
        char[] utfBytes = str.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(covertToIso("为了测试"));
        System.out.println(covertToIso("只是测试"));
    }
}
